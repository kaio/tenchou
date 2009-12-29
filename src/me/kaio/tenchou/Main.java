package me.kaio.tenchou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity {

	// Views
	private Button calculateButton;
	private EditText grossProfitEditText, numOfItemsEditText,
			numOfCustomersEditText, grossProfitPerCustomerEditText,
			grossProfitPerItemEditText;

	// Listeners
	private OnClickListener calculateListener;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// EditTexts
		grossProfitEditText = (EditText) findViewById(R.id.grossProfitEditText);
		numOfItemsEditText = (EditText) findViewById(R.id.numOfItemsEditText);
		numOfCustomersEditText = (EditText) findViewById(R.id.numOfCustomersEditText);
		grossProfitPerCustomerEditText = (EditText) findViewById(R.id.grossProfitPerCustomerEditText);
		grossProfitPerItemEditText = (EditText) findViewById(R.id.grossProfitPerItemEditText);

		// calculate Button
		calculateButton = (Button) findViewById(R.id.calculateButton);
		calculateListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				calculate();
			}
		};
		calculateButton.setOnClickListener(calculateListener);
	}

	private void calculate() {
		
		// compute gross-profit-per-customer
		String grossProfitPerCustomerOutput, grossProfitPerItemOutput;
		try {
			double grossProfitPerCustomer = Double
					.parseDouble(grossProfitEditText.getText().toString())
					/ Double.parseDouble(numOfCustomersEditText.getText()
							.toString());
			grossProfitPerCustomerOutput = Double
					.toString(grossProfitPerCustomer);
		} catch (Exception e) {
			grossProfitPerCustomerOutput = "ERROR!!";
		}

		// compute gross-profit-per-item
		try {
			double grossProfitPerItem = Double.parseDouble(grossProfitEditText
					.getText().toString())
					/ Double.parseDouble(numOfItemsEditText.getText()
							.toString());
			grossProfitPerItemOutput = Double.toString(grossProfitPerItem);
		} catch (Exception e) {
			grossProfitPerItemOutput = "ERROR!!";
		}

		// output calculation results
		grossProfitPerCustomerEditText.setText(grossProfitPerCustomerOutput);
		grossProfitPerItemEditText.setText(grossProfitPerItemOutput);
	}
}
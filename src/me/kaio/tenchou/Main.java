package me.kaio.tenchou;

import java.text.Format;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity {

	private static final String TAG = "TenChou";

	private Button calculateButton;

	private EditText GrossProfitEditText, ItemsPurchasedEditText,
			CustomersEnteredEditText, GrossProfitPerCustomerEditText,
			GrossProfitPerPurchaseEditText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		GrossProfitEditText = (EditText) findViewById(R.id.GrossProfitEditText);
		ItemsPurchasedEditText = (EditText) findViewById(R.id.ItemsPurchasedEditText);
		CustomersEnteredEditText = (EditText) findViewById(R.id.CustomersEnteredEditText);
		GrossProfitPerCustomerEditText = (EditText) findViewById(R.id.GrossProfitPerCustomerEditText);
		GrossProfitPerPurchaseEditText = (EditText) findViewById(R.id.GrossProfitPerPurchaseEditText);

		calculateButton = (Button) findViewById(R.id.CalculateButton);

		try {
			calculateButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					if (v.getId() == R.id.CalculateButton)
						calculate();
				}
			});
		} catch (Exception e) {
			// skip
		}

	}

	private void calculate() {
		double GrossProfitPerCustomer = 	Double.parseDouble(GrossProfitEditText.getText().toString()) / Double.parseDouble(CustomersEnteredEditText.getText().toString());
		
		GrossProfitPerCustomerEditText.setText(Double.toString(GrossProfitPerCustomer));
	}
}
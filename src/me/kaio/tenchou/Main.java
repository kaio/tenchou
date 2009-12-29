package me.kaio.tenchou;

/*
 * tenchou - Mobile Data Mining Tools for Shop Managers.
 *
 * Copyright (c) 2009 Caius 'kaio' Chance <k at kaio.me>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

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
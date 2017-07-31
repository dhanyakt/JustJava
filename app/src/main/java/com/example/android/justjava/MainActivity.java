package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView quantityTextView;
    Button submitButton;
    int quantity = 2;
    boolean hasWhippedCream = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    /**
    * This method is called when the order button is clicked.
    */
    public void submitOrder(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.edit_name_text);
        String name = nameEditText.getText().toString();
        int price = calculatePrice(quantity);
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = chocolateCheckbox.isChecked();
        hasWhippedCream = whippedCreamCheckbox.isChecked();
        String priceMessage = createOrderSummary(price, name, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * Calculate the price
     *
     * @param quantity
     * @return total price
     */

    public int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    /**
     * @param price
     * @param name Read the name from the editText
     * @param addChocolate to check whether chocolate is added or not
     * @param addWhippedCream to check whether whipped cream is added or not
     * @return orderSummary
     */

    public String createOrderSummary(int price, String name, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name:" + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method is called when the order button is clicked.
     */

    private void displayQuantity(int i) {
        quantityTextView = (TextView) findViewById(R.id.quantity_txt_view);
        quantityTextView.setText("" + i);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTxtView = (TextView) findViewById(R.id.order_summary_txt_view);
        orderSummaryTxtView.setText(message);

    }

}

package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView quantityTextView;
    Button submitButton;
    int quantity = 2;


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
        int price = calculatePrice(quantity);
        //String priceMessage = "Total:$" + price;
        String priceMessage = createOrderSummary(price, "Dhanya");
        //priceMessage = priceMessage + "\nThank you!";
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
     * @param name
     * @return orderSummary
     */

    public String createOrderSummary(int price, String name) {
        String priceMessage = "Name:" + name + "\nQuantity:" + quantity + "\nTotal:$" + price + "\nThank you!";
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
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_txt_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView msgTextView = (TextView) findViewById(R.id.price_txt_view);
        msgTextView.setText(message);

    }

}

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
        display(quantity);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
    * This method is called when the order button is clicked.
    */
    public void submitOrder(View view) {
        int price = 5 * quantity;
        displayPrice(price);
        String priceMessage = "Total:$" + price;
        priceMessage = priceMessage + "\nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the order button is clicked.
     */

    private void display(int i) {
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

package com.example.kunal.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View v){
        TextView kj=(TextView)findViewById(R.id.quantity_textx_View);

        displayPrice(Integer.parseInt(kj.getText().toString()));
    }
    public void increment(View v){
        TextView kj=(TextView)findViewById(R.id.quantity_textx_View);

       kj.setText(""+(Integer.parseInt(kj.getText().toString())+1));
    }
    public void decrement(View v){
        TextView kj=(TextView)findViewById(R.id.quantity_textx_View);
        
        //kj.setText(Integer.parseInt(kj.getText().toString())-1);
        kj.setText(""+(Integer.parseInt(kj.getText().toString())-1));
    }

    public void displayPrice(int k){

        TextView kj=(TextView)findViewById(R.id.price_textx_View);
        kj.setText(NumberFormat.getCurrencyInstance().format(k));
    }
}

package com.example.kunal.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

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
        int qunat;
        TextView kj=(TextView)findViewById(R.id.quantity_textx_View);
        qunat=Integer.parseInt(kj.getText().toString());
        //kj.setText(Integer.parseInt(kj.getText().toString())-1);
        if (qunat<0||qunat==0){
            Toast.makeText(getApplicationContext(),"No. less than 0",Toast.LENGTH_LONG).show();
        }
        else
        kj.setText(""+(qunat-1));

    }

    public void displayPrice(int k){
        String crm="";

//        TextView kj=(TextView)findViewById(R.id.price_textx_View);

        CheckBox cbox=(CheckBox)findViewById(R.id.checkBox);
        if(cbox.isChecked()){
            crm="Whipped Cream added";
        }
        {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT,"JAva app subject" );
//            System.out.println("subject added");
            intent.putExtra(Intent.EXTRA_TEXT,"this is the body of the email\n\t"+NumberFormat.getCurrencyInstance().format(k)+"\n\t"+crm);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
//        kj.setText(NumberFormat.getCurrencyInstance().format(k)+"\n"+crm);
    }
}

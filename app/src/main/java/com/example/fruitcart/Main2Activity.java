package com.example.fruitcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tvt,tvt2;
    Button btn4;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvt=findViewById(R.id.tv1);
        tvt2=findViewById(R.id.tv2);
        btn4=findViewById(R.id.btn4);
        Intent callintent = getIntent();
        String print = callintent.getStringExtra("Banana") + "\n"+callintent.getStringExtra("Apple")+"\n"+callintent.getStringExtra("Mango");
        print=print+"\n"+callintent.getStringExtra("Strawberry");
        int flag = callintent.getIntExtra("Flag",0);
        if(flag == 3){
        String finalprint="Your Orders are as follows : \n"+print+"\n"+"Total Amount to be Paid (including delivery charges Rs 50/-) = Rs";
        double tp1 = callintent.getDoubleExtra("TotalPrice",0);
        tvt.setText(finalprint+tp1+" /-"+"\n"+"The Amount should to be pay at the time of delivery with your satisfaction!");
        tvt2.setText(R.string.thankvali);}
        if(flag == 1){
            String finalprint = "Oops :( \n Your cart seems to be empty. To buy something please enter the quantity.\n\n"+print+"\n The Amount to be paid = Rs";
            double tp1 = callintent.getDoubleExtra("TotalPrice",0);
            tvt.setText(finalprint+tp1+" /-"+"\n");
            tvt2.setText(" Thank you for visiting ! \n Hope you like our store so please order next time.");

        }
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonext();
            }
        });
        }
    public void gonext(){
        Intent intent = new Intent();
        intent.setClass(this,Main3Activity.class);
        startActivity(intent);
        finish();

    }
}

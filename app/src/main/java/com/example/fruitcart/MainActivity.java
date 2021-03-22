package com.example.fruitcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView etb,eta,etm,ets;
    Button btnbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etb=findViewById(R.id.et1);
        eta=findViewById(R.id.et2);
        etm=findViewById(R.id.et3);
        ets=findViewById(R.id.et4);
        btnbn=findViewById(R.id.btn1);
        btnbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eta.getText().toString().isEmpty() || etb.getText().toString().isEmpty() || etm.getText().toString().isEmpty() || ets.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter Quantity of all fruits if don't want to buy then enter 0",Toast.LENGTH_LONG).show();
                }
                else{
                  String bana = "Quantity of Banana : "+ etb.getText().toString()+" KG" ;
                  String mango = "Quantity of Mango : "+ etm.getText().toString()+" KG" ;
                  String stra = "Quantity of Strawberry : "+ ets.getText().toString()+" Boxes" ;
                  String apple = "Quantity of Apple : "+ eta.getText().toString()+" KG" ;
                  double bprice = Double.parseDouble(etb.getText().toString());
                  double aprice = Double.parseDouble(eta.getText().toString());
                  double mprice = Double.parseDouble(etm.getText().toString());
                  double sprice = Double.parseDouble(ets.getText().toString());
                  double tprice = (bprice*60)+(aprice*100)+(mprice*50)+(sprice*120);
                  int a =1;
                  if(tprice != 0){
                      tprice=tprice+50;
                      a+=2;
                  }
                   act(bana,apple,mango,stra,tprice,a);


                }
            }
        });
    }
    public void act(String a,String b ,String c,String d,double tp,int flag){
        Intent gointent = new Intent();
        gointent.setClass(this,Main2Activity.class);
        gointent.putExtra("Banana",a);
        gointent.putExtra("Apple",b);
        gointent.putExtra("Mango",c);
        gointent.putExtra("Strawberry",d);
        gointent.putExtra("TotalPrice",tp);
        gointent.putExtra("Flag",flag);
        startActivity(gointent);
        finish();
    }
}

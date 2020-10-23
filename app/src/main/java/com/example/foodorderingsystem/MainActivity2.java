package com.example.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    String R1;
    int amount;
    TextView result1, result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        result1 = (TextView)findViewById(R.id.result1);
        result2 = (TextView)findViewById(R.id.result2);

        Intent intent=getIntent();
        R1 = intent.getStringExtra("Result");
        amount = intent.getIntExtra("Total", 0);

        result1.setText(R1);

        Button convert = (Button) findViewById(R.id.button_convert);
        convert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result2.setText(String.format("%.2f $", amount/84.8));
            }
        });

        Button check = (Button) findViewById(R.id.button_checkout);
        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = "Thank you.";
                Toast.makeText(getApplicationContext(), message.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
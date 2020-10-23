package com.example.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    RadioButton mexican, indian, korean, continental;
    Button placeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mexican = (RadioButton) findViewById(R.id.MEXICAN);
        indian = (RadioButton) findViewById(R.id.INDIAN);
        korean = (RadioButton) findViewById(R.id.KOREAN);
        continental = (RadioButton) findViewById(R.id.CONTINENTAL);

        placeOrder = (Button)findViewById(R.id.button_PlaceOrder);

        placeOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int amount = 0;
                StringBuilder result=new StringBuilder();

                if (mexican.isChecked()) {
                    result.append("MEXICAN = 200tk");
                    amount += 200;
                }

                if (indian.isChecked()) {
                    result.append("\nINDIAN = 100tk");
                    amount += 100;
                }

                if (korean.isChecked()) {
                    result.append("\nKOREAN = 150tk");
                    amount += 150;
                }

                if (continental.isChecked()) {
                    result.append("\nCONTINENTAL = 300tk");
                    amount += 300;
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Result", (Serializable) result);
                intent.putExtra("Total", amount);
                startActivity(intent);
            }
        });
    }
}

package com.example.bmiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the layout of the activity
        setContentView(R.layout.activity_main);

        // initialize UI elements
        EditText weight,feet,inch;
        Button calculate;
        TextView result;
        LinearLayout liMain;

        // find views by their IDs
        weight = findViewById(R.id.weight);
        feet = findViewById(R.id.feet);
        inch = findViewById(R.id.inch);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        liMain = findViewById(R.id.liMain);

        // set click listener for the calculate button
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get user input values and convert them to appropriate data types
                int wt = Integer.parseInt(weight.getText().toString());
                int ft = Integer.parseInt(feet.getText().toString());
                int in = Integer.parseInt(inch.getText().toString());

                // convert height values to total inches
                int totalIn = ft*12 + in;

                // convert total inches to total centimeters
                double totalCm = totalIn*2.53;

                // convert total centimeters to total meters
                double totalM = totalCm / 100;

                // calculate BMI
                double bmi = wt/Math.pow(totalM,2);

                // set the result and background color based on BMI value
                if (bmi > 25){
                    result.setText("You are OverWeight");
                    liMain.setBackgroundColor(getResources().getColor(R.color.overwt));
                } else if (bmi < 18) {
                    result.setText("You are Underweight");
                    liMain.setBackgroundColor(getResources().getColor(R.color.underwt));
                }else {
                    result.setText("You are Healthy");
                    liMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });

    }
}

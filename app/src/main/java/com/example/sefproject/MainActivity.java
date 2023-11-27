package com.example.sefproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void derive(View v) {
        TextView Output = (TextView) findViewById(R.id.resultOutput);
        TextView Output2 = (TextView) findViewById(R.id.polynomialOutput);


        EditText inputCoefficient1 = (EditText) findViewById(R.id.firstCoefficientInput);
        EditText inputCoefficient2 = (EditText) findViewById(R.id.secondCoefficientInput);
        EditText inputCoefficient3 = (EditText) findViewById(R.id.thirdCoefficientInput);

        EditText inputPower1 = (EditText) findViewById(R.id.firstPowerInput);
        EditText inputPower2 = (EditText) findViewById(R.id.secondPowerInput);
        EditText inputPower3 = (EditText) findViewById(R.id.thirdPowerInput);

        EditText inputXPoint = (EditText) findViewById(R.id.xPointInput);

        if (TextUtils.isEmpty(inputCoefficient1.getText().toString()) || TextUtils.isEmpty(inputCoefficient2.getText().toString()) ||
                TextUtils.isEmpty(inputCoefficient3.getText().toString()) || TextUtils.isEmpty(inputPower1.getText().toString()) ||
                TextUtils.isEmpty(inputPower2.getText().toString()) || TextUtils.isEmpty(inputPower3.getText().toString()) || TextUtils.isEmpty(inputXPoint.getText().toString())) {
            Toast.makeText(MainActivity.this, "No empty fields allowed, please enter 0 if you don't have another value.", Toast.LENGTH_LONG).show();
        } else {

            double firstCoefficient = Double.valueOf(inputCoefficient1.getText().toString());
            double secondCoefficient = Double.valueOf(inputCoefficient2.getText().toString());
            double thirdCoefficient = Double.valueOf(inputCoefficient3.getText().toString());


            double firstPower = Double.valueOf(inputPower1.getText().toString());
            double secondPower = Double.valueOf(inputPower2.getText().toString());
            double thirdPower = Double.valueOf(inputPower3.getText().toString());

            double x = Double.valueOf(inputXPoint.getText().toString());
            double result = (firstPower * firstCoefficient * Math.pow(x, (firstPower - 1))) + (secondPower * secondCoefficient * Math.pow(x, (secondPower - 1))) + (thirdPower * thirdCoefficient * Math.pow(x, (thirdPower - 1)));

            Output.setText("Result: " + result);


            String polynomialTerm1 = firstCoefficient * firstPower + "x^" + (firstPower - 1);
            String polynomialTerm2 = secondCoefficient * secondPower + "x^" + (secondPower - 1);
            String polynomialTerm3 = thirdCoefficient * thirdPower + "x^" + (thirdPower - 1);
            if (secondCoefficient * secondPower > 0)
                polynomialTerm2 = "+ ".concat(secondCoefficient * secondPower + "x^" + (secondPower - 1));
            if (thirdCoefficient * thirdPower > 0)
                polynomialTerm3 = "+ ".concat(thirdCoefficient * thirdPower + "x^" + (thirdPower - 1));

            Output2.setText("Polynomial Derived: " + "\n" + polynomialTerm1 + " " + polynomialTerm2 + " " + polynomialTerm3);

            System.out.println(firstCoefficient);
            System.out.println(firstPower);
            System.out.println(secondCoefficient);
            System.out.println(secondPower);
            System.out.println(thirdCoefficient);
            System.out.println(thirdPower);
            System.out.println(x);
            System.out.println(result);


        }
    }
}
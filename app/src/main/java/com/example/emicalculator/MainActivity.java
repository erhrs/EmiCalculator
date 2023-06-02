package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    private TextView Emi;
    private EditText LoanAmt, Years, Rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoanAmt = findViewById(R.id.editTextLoanAmt);
        Years = findViewById(R.id.editTextYears);
        Rate = findViewById(R.id.editTextRate);
        Emi = findViewById(R.id.textEmi);

    }
    @SuppressLint("SetTextI18n")
    public void calEmi(View view){

            String amt = LoanAmt.getText().toString();
            String years = Years.getText().toString();
            String rate = Rate.getText().toString();

            Double p = Double.parseDouble(amt);
            Double n = (Double.parseDouble(years)) * 12;
            Double r = ((Double.parseDouble(rate)) / 12) / 100;
            Double y = 1 + r;
            Double x = Math.pow(y, n);

            Double emi = (p * r) * (x / (x - 1));

            Emi.setText("Monthly EMI : Rs." + Math.round(emi));
    }

}

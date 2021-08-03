package com.example.basic_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText varOneBox;
    private EditText varTwoBox;
    private Button plusButton;
    private Button minusButton;
    private Button divideButton;
    private Button multiplyButton;
    private TextView resultBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        varOneBox = (EditText) findViewById(R.id.varOne);
        varTwoBox = (EditText) findViewById(R.id.varTwo);

        plusButton = (Button) findViewById(R.id.plus_Button);

        resultBox = (TextView) findViewById(R.id.resultsView);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double var1 = Double.parseDouble(varOneBox.getText().toString());
                double var2 = Double.parseDouble(varTwoBox.getText().toString());
                double sum = var1 + var2;
                resultBox.setText(Double.toString(sum));
            }
        });
    }

}
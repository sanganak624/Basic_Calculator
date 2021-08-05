package com.example.basic_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText varOneBox;
    private EditText varTwoBox;
    private Button plusButton;
    private Button minusButton;
    private Button divideButton;
    private Button multiplyButton;
    private TextView resultBox;
    private double var1=0;
    private double var2=0;
    private double result;
    private boolean fail1=false;
    private boolean fail2=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        varOneBox = (EditText) findViewById(R.id.varOne);
        varTwoBox = (EditText) findViewById(R.id.varTwo);

        plusButton = (Button) findViewById(R.id.plus_Button);
        minusButton = (Button) findViewById(R.id.minus_Button);
        divideButton = (Button) findViewById(R.id.divide_Button);
        multiplyButton = (Button) findViewById(R.id.multiply_Button);

        resultBox = (TextView) findViewById(R.id.resultsView);


        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getVarTwo();
                getVarOne();
                result = var1+var2;
                printResult();
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getVarTwo();
                getVarOne();
                result = var1-var2;
                printResult();
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getVarTwo();
                getVarOne();
                result = var1*var2;
                printResult();
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getVarTwo();
                getVarOne();
                if(var2!=0)
                {
                    result = var1 / var2;
                    printResult();
                }
                else if (!fail2)
                {
                    Toast.makeText(MainActivity.this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    resultBox.setText("Error");
                }
                else
                {
                    printResult();
                }
            }
        });
    }

    private void getVarTwo()
    {
        try
        {
            var2 = Double.parseDouble(varTwoBox.getText().toString());
            fail2=false;
        }
        catch (Exception e)
        {
            fail2=true;
        }
    }

    private void getVarOne()
    {
        try
        {
            var1 = Double.parseDouble(varOneBox.getText().toString());
            fail1=false;
        }
        catch (Exception e)
        {
            fail1=true;
        }
    }

    private void printResult()
    {
        if(!fail1&&!fail2)
        {
            resultBox.setText(Double.toString(result));
        }
        else if(fail1&&!fail2)
        {
            Toast.makeText(MainActivity.this, "Invalid Input 1", Toast.LENGTH_SHORT).show();
            resultBox.setText("Error");
        }
        else if(!fail1&&fail2)
        {
            Toast.makeText(MainActivity.this, "Invalid Input 2", Toast.LENGTH_SHORT).show();
            resultBox.setText("Error");
        }
        else
        {
            Toast.makeText(MainActivity.this, "Invalid Input 1 and Input 2", Toast.LENGTH_SHORT).show();
            resultBox.setText("Error");
        }
    }
}
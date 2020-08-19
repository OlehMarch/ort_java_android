package ghh0stex.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {

    EditText result;
    EditText firstOperand;
    EditText secondOperand;
    EditText operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        result = (EditText)findViewById(R.id.et_result);
        firstOperand = (EditText)findViewById(R.id.et_firstOperand);
        secondOperand = (EditText)findViewById(R.id.et_secondOperand);
        operation = (EditText)findViewById(R.id.et_operation);
    }

    protected void buttonCalculate_Click(View v){
        result.setText(Calculation.Calculate(
                firstOperand.getText().toString(),
                secondOperand.getText().toString(),
                operation.getText().toString()
        ));
    }
}

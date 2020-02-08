package com.example.sachincalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sachindevatar.mylibrary.Logic;

public class MainActivity extends AppCompatActivity {

    TextView input, signBox;

    String sign, specialFunction;
    String value1, value2;
    Double num1, num2, result;
    boolean hasDot, isSpecialFunctionOn;
    Logic logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logic = new Logic();

        input = (TextView) findViewById(R.id.input);
        signBox = (TextView) findViewById(R.id.sign);

        hasDot = false;
        isSpecialFunctionOn = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_0(View view) {
        input.setText(input.getText() + "0");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_1(View view) {
        input.setText(input.getText() + "1");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_2(View view) {
        input.setText(input.getText() + "2");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_3(View view) {
        input.setText(input.getText() + "3");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_4(View view) {
        input.setText(input.getText() + "4");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_5(View view) {
        input.setText(input.getText() + "5");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_6(View view) {
        input.setText(input.getText() + "6");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_7(View view) {
        input.setText(input.getText() + "7");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_8(View view) {
        input.setText(input.getText() + "8");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_9(View view) {
        input.setText(input.getText() + "9");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_dot(View view) {
        if (!hasDot) {
            if (input.getText().equals("")) {
                input.setText("0.");
            } else {
                input.setText(input.getText() + ".");
            }
            hasDot = true;
        }
    }

    public void btnClick_delete(View view) {

        if (input.getText().equals("")) {
            input.setText(null);

        } else {
            int len = input.getText().length();
            String s = input.getText().toString();
            if (s.charAt(len - 1) == '.') {
                hasDot = false;
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            } else {
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            }
        }

    }

    public void btnClick_clear(View view) {
        input.setText(null);
        signBox.setText(null);
        value1 = null;
        value1 = null;
        hasDot = false;
    }

    public void btnClick_add(View view) {
        sign = "+";
        value1 = input.getText().toString();
        input.setText(null);
        hasDot = false;
        signBox.setText("+");
    }

    public void btnClick_subtract(View view) {
        sign = "-";
        value1 = input.getText().toString();
        input.setText(null);
        hasDot = false;
        signBox.setText("-");
    }

    public void btnClick_multiply(View view) {
        sign = "*";
        value1 = input.getText().toString();
        input.setText(null);
        hasDot = false;
        signBox.setText("×");
    }

    public void btnClick_divide(View view) {
        sign = "/";
        value1 = input.getText().toString();
        input.setText(null);
        hasDot = false;
        signBox.setText("÷");
    }

    public void btnClick_sin(View view) {
        isSpecialFunctionOn = true;
        specialFunction = "sin";
        input.setText(null);
        hasDot = false;
        signBox.setText("sin");
    }

    public void btnClick_cos(View view) {
        isSpecialFunctionOn = true;
        specialFunction = "cos";
        input.setText(null);
        hasDot = false;
        signBox.setText("cos");
    }

    public void btnClick_tan(View view) {
        isSpecialFunctionOn = true;
        specialFunction = "tan";
        input.setText(null);
        hasDot = false;
        signBox.setText("tan");
    }



    public void btnClick_equal(View view) {
        if ((specialFunction == null && sign == null) || (input.getText().equals(""))) {
            signBox.setText("Error");
        } else if (specialFunction != null) {

            switch (specialFunction) {
                default:
                    break;
                case "sin":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(logic.sineFunction(num1)+"");
                    specialFunction = null;
                    isSpecialFunctionOn = false;
                    signBox.setText(null);
                    break;
                case "cos":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(logic.cosFunction(num1) + "");
                    specialFunction = null;
                    signBox.setText(null);
                    break;
                case "tan":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(logic.tanFunction(num1) + "");
                    specialFunction = null;
                    isSpecialFunctionOn = false;
                    signBox.setText(null);
                    break;
            }
        } else if (sign != null) {
            value2 = input.getText().toString();

            num1 = Double.parseDouble(value1);
            num2 = Double.parseDouble(value2);
            input.setText(null);

            switch (sign) {
                default:
                    break;
                case "+":
                    result = num1 + num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "-":
                    result = num1 - num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "*":
                    result = num1 * num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "/":
                    result = num1 / num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
            }
        } else signBox.setText("Error");
    }


}

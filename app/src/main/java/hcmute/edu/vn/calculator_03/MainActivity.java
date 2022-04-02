package hcmute.edu.vn.calculator_03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    String textOnCalculator = "0";
    private TextView expration_text;
    private TextView number_text;
    private double number1;
    private double number2;
    private String znak;
    private boolean last_znak;
    private DecimalFormat df = new DecimalFormat("#.####");

    String currentString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_text = findViewById(R.id.txt_number);
        expration_text = findViewById(R.id.txt_sub_number);

        last_znak = false;

        if (savedInstanceState != null) {
            expration_text.setText((savedInstanceState.getString("expration")));
            number_text.setText((savedInstanceState.getString("number")));
            znak = savedInstanceState.getString("znak");
            number1 = savedInstanceState.getDouble("number1");
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("expration", expration_text.getText().toString());
        outState.putString("number", number_text.getText().toString());
        outState.putString("znak", znak);
        outState.putDouble("number1", number1);
    }


    public void Click(View view) {
        Button button = (Button) view;
        textOnCalculator = number_text.getText().toString();
        if (!textOnCalculator.equals("0")) {
            String textOnButton = textOnCalculator + button.getText().toString();
            number_text.setText(textOnButton);
        } else {
            String textOnButton = button.getText().toString();
            number_text.setText(textOnButton);
        }

    }

    public void Division(View view) {
        if (last_znak == true) {
            String e_text = expration_text.getText().toString();
            String res = e_text.substring(0, e_text.length() - 1) + "/";
            expration_text.setText(res);
            number_text.setText("0");
            last_znak = true;
            znak = "/";
            return;
        }
        last_znak = true;
        String e_text = expration_text.getText().toString();
        String n_text = number_text.getText().toString();
        number2 = Double.parseDouble(n_text);
        if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error")) {
            number1 = Double.parseDouble(n_text);
            znak = "/";
            String res = n_text + "/";
            expration_text.setText(res);
            number_text.setText("0");
            return;
        }

        if (e_text.endsWith("=")) {
            String res = n_text + "/";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "/";
            return;
        }

        double r = calculate();

        if (expration_text.getText().equals("Error"))
            return;

        String res = String.valueOf(r) + "/";
        expration_text.setText(res);
        number_text.setText("0");
        znak = "/";
        number1 = r;
        return;
    }

    public void Multiplication(View view) {
        if (last_znak == true) {
            String e_text = expration_text.getText().toString();
            String res = e_text.substring(0, e_text.length() - 1) + "*";
            expration_text.setText(res);
            number_text.setText("0");
            last_znak = true;
            znak = "*";
            return;
        }
        last_znak = true;
        String e_text = expration_text.getText().toString();
        String n_text = number_text.getText().toString();
        number2 = Double.parseDouble(n_text);
        if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error")) {
            number1 = Double.parseDouble(n_text);
            znak = "*";
            String res = n_text + "*";
            expration_text.setText(res);
            number_text.setText("0");
            return;
        }

        if (e_text.endsWith("=")) {
            String res = n_text + "*";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "*";
            return;
        }

        double r = calculate();

        if (expration_text.getText().equals("Error"))
            return;

        String res = String.valueOf(r) + "*";
        expration_text.setText(res);
        number_text.setText("0");
        znak = "*";
        number1 = r;
        return;
    }

    public void Subtract(View view) {
        if (last_znak == true) {
            String e_text = expration_text.getText().toString();
            String res = e_text.substring(0, e_text.length() - 1) + "-";
            expration_text.setText(res);
            number_text.setText("0");
            last_znak = true;
            znak = "-";
            return;
        }
        last_znak = true;
        String e_text = expration_text.getText().toString();
        String n_text = number_text.getText().toString();
        number2 = Double.parseDouble(n_text);
        if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error")) {
            number1 = Double.parseDouble(n_text);
            znak = "-";
            String res = n_text + "-";
            expration_text.setText(res);
            number_text.setText("0");
            return;
        }

        if (e_text.endsWith("=")) {
            String res = n_text + "-";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "-";
            return;
        }

        double r = calculate();

        if (expration_text.getText().equals("Error"))
            return;

        String res = String.valueOf(r) + "-";
        expration_text.setText(res);
        number_text.setText("0");
        znak = "-";
        number1 = r;
        return;
    }

    public void Addition(View view) {
        if (last_znak == true) {
            String e_text = expration_text.getText().toString();
            String res = e_text.substring(0, e_text.length() - 1) + "+";
            expration_text.setText(res);
            number_text.setText("0");
            last_znak = true;
            znak = "+";
            return;
        }
        last_znak = true;
        String e_text = expration_text.getText().toString();
        String n_text = number_text.getText().toString();
        number2 = Double.parseDouble(n_text);
        if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error")) {
            number1 = Double.parseDouble(n_text);
            znak = "+";
            String res = n_text + "+";
            expration_text.setText(res);
            number_text.setText("0");
            return;
        }

        if (e_text.endsWith("=")) {
            String res = n_text + "+";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "+";
            return;
        }

        double r = calculate();

        if (expration_text.getText().equals("Error"))
            return;

        String res = String.valueOf(r) + "+";
        expration_text.setText(res);
        number_text.setText("0");
        znak = "+";
        number1 = r;
        return;
    }

    public void Equal(View view) {
        String e_text = expration_text.getText().toString(); // sub number
        String n_text = number_text.getText().toString();   // number
        Object result;


        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = engine.eval(n_text);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid equation", Toast.LENGTH_SHORT).show();
            return;
        }

        number_text.setText(result.toString());
        expration_text.setText(n_text + "=");

    }


    public void RemoveText(View view) {
        textOnCalculator = number_text.getText().toString();
        StringBuffer sb = new StringBuffer(textOnCalculator);
        if (sb.length() > 0) {
            number_text.setText(sb.deleteCharAt(sb.length() - 1));
        }

    }

    public void ClearClick(View view) {
        Button button = (Button) view;
        number_text.setText("0");
        expration_text.setText("");
    }

    public double calculate() {
        double r = 0;
        System.out.println(number1);
        System.out.println(znak);
        System.out.println(number2);
        switch (znak) {
            case "+":
                r = number1 + number2;
                break;
            case "-":
                r = number1 - number2;
                break;
            case "*":
                r = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    expration_text.setText("Error");
                    number_text.setText("0");
                    return 0;
                }
                r = number1 / number2;
                break;
        }
        System.out.println(r);
        last_znak = false;
        return r;
    }
}
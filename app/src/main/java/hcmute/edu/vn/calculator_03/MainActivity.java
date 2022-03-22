package hcmute.edu.vn.calculator_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String textOnCalculator = "0";
    TextView textViewOnCalculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOnCalculator = findViewById(R.id.txt_number);
    }

    public void Click(View view) {
        Button button = (Button) view;
        textOnCalculator = textViewOnCalculator.getText().toString();
        if (!textOnCalculator.equals("0")) {
            String textOnButton = textOnCalculator + button.getText().toString();
            textViewOnCalculator.setText(textOnButton);
        } else {
            String textOnButton = button.getText().toString();
            textViewOnCalculator.setText(textOnButton);
        }
    }

    public void ClearClick(View view)
    {
        Button button = (Button) view;
        textViewOnCalculator.setText("0");
    }


}
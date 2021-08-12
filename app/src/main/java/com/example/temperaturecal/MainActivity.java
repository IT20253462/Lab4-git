package com.example.temperaturecal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;
    RadioButton rb_bttn_C;
    RadioButton rb_bttn_F;
    Button bttn_enter;
    TextView tv_answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        rb_bttn_C = findViewById(R.id.rb_bttn_C);
        rb_bttn_F = findViewById(R.id.rb_bttn_F);
        bttn_enter = findViewById(R.id.bttn_enter);
        tv_answer = findViewById(R.id.tv_answer);
    }

    @Override
    protected void onResume() {
        super.onResume();
         bttn_enter.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                    calculateAnswer();
             }
         });
    }

    public void calculateAnswer(){

        calculation calClass = new calculation();
        String value = et_temp.getText().toString();

        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the temperature", Toast.LENGTH_SHORT).show();

        }else{
            Float temperature = Float.parseFloat(value);

            if(rb_bttn_C.isChecked()){
                temperature = calClass.convertCelciusToFahrenheit(temperature);
            }
            else if(rb_bttn_F.isChecked()){
                temperature = calClass.convertFahrenheitToCelcius(temperature);
            }
            else{
                Toast.makeText(this, "Please select Celcius or Fahrenheit", Toast.LENGTH_SHORT).show();
                temperature = 0.0f;
            }

            tv_answer.setText(new Float(temperature).toString());
        }
    }
}
package com.ran.temperaturechecker;

//Temperature Checker
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText firstnum;
    private TextView result;
    private TextView result2;
     Button btnsearch;
     Button reset;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstnum = findViewById(R.id.firstnum);
        result = findViewById(R.id.result);
        result2 = findViewById(R.id.result2);
        btnsearch = findViewById(R.id.btnsearch);
        reset = findViewById(R.id.reset);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = firstnum.getText().toString();



                if(!input.isEmpty()){
  try {
      double num = Double.parseDouble(input);
      double farenheit = (num* 9/5) + 32;
      double celsius = (num - 32) * 5/9;

      result.setText(String.format("Farenheit is : %.2f °F",farenheit));

      result2.setText(String.format("Celsius is : %.2f °C",celsius));
  }

  catch (NumberFormatException e){

      result.setText("Invalid input, Try again.");
      result2.setText("");
  }




                }
                else {
                    result.setText("Please input a number.");
                    result2.setText("");

                }




            }
        });
reset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        firstnum.setText("");
        result2.setText("");
        result.setText("");
    }
});


    }
}

package pl.emb.firsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText field1 = findViewById(R.id.editText);
                EditText field2 = findViewById(R.id.editText2);
                EditText field3 = findViewById(R.id.editText3);

                try {
                    double a = Double.parseDouble(field1.getText().toString());
                    double b = Double.parseDouble(field2.getText().toString());
                    double c = Double.parseDouble(field3.getText().toString());

                    CalculationsManager calcManager = new CalculationsManager();
                    TextView result = findViewById(R.id.result);
                    result.setText(String.valueOf(calcManager.solve(a, b, c)));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,
                            "Empty field" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
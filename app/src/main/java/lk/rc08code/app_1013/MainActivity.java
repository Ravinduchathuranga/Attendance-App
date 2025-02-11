package lk.rc08code.app_1013;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

import lk.rc08code.app_1013.model.Attendance;

public class MainActivity extends AppCompatActivity {
    public static Attendance attendance = new Attendance();

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

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayList<String> days = new ArrayList<>();
        days.add("monday");
        days.add("tuesday");
        days.add("wednesday");
        days.add("thursday");
        days.add("friday");
        days.add("saturday");
        days.add("sunday");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this
                , R.layout.custom_drop_down, days);

        spinner.setAdapter(arrayAdapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textView = findViewById(R.id.editTextText);

                if (textView.toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter number of attendace", Toast.LENGTH_SHORT).show();
                } else {

                    int count = Integer.parseInt(textView.getText().toString());

                    String editTextDate = spinner.getSelectedItem().toString();

                    if (editTextDate.equals("monday")) {
                        attendance.setMonday(count);
                    } else if (editTextDate.equals("tuesday")) {
                        attendance.setTuesday(count);

                    } else if (editTextDate.equals("wednesday")) {
                        attendance.setWednesday(count);

                    } else if (editTextDate.equals("thursday")) {
                        attendance.setThursday(count);

                    } else if (editTextDate.equals("friday")) {
                        attendance.setFriday(count);

                    } else if (editTextDate.equals("saturday")) {
                        attendance.setSaturday(count);

                    } else if (editTextDate.equals("sunday")) {
                        attendance.setSunday(count);
                    }
                    Toast.makeText(MainActivity.this, "Saved Successfully!", Toast.LENGTH_SHORT).show();
                    textView.setText("");
                }
            }
        });

        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this
                        , CharActivity.class);
                startActivity(intent);
            }
        });


    }
}
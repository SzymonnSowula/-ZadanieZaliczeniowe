package com.example.a05122025szymonsowula;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        EditText editImie = findViewById(R.id.editImie);
        EditText editNazwisko = findViewById(R.id.editNazwisko);
        Spinner spinnerBtn = findViewById(R.id.spinner);
        CheckBox checkLowerUpperCase = findViewById(R.id.lowerAndUpperCase);
        CheckBox checkNumbers = findViewById(R.id.numbers);
        CheckBox checkSpecialCharacters = findViewById(R.id.specialCharacters);
        Button generateBtn = findViewById(R.id.generatePassword);
        Button confirmBtn = findViewById(R.id.confirmbutton);

    }
}
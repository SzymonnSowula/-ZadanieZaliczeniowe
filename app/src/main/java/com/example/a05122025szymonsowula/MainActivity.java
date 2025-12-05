package com.example.a05122025szymonsowula;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

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
        EditText ileZnakow = findViewById(R.id.iloscZnakow);


        String[] options = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                options
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerBtn.setAdapter(spinnerAdapter);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ileStr = ileZnakow.getText().toString();
                if (ileStr.isEmpty())
                    return;

                int dlugosc = Integer.parseInt(ileStr);

                String maleLitery = "abcdefghijklmnoprstuwyxz";
                String wielkieLitery = "ABCDEFGHIJKLMNOPRSTUWYXZ";
                String cyfry = "0123456789";
                String znakiSpecjalne = "!@#$%^&*()_+";
                StringBuilder haslo = new StringBuilder();
                Random random = new Random();
                StringBuilder hasloBuild = new StringBuilder();


                if (checkLowerUpperCase.isChecked()) {
                    haslo.append(maleLitery);
                }

                if(checkNumbers.isChecked()) {
                    haslo.append(cyfry);
                }
                if (checkSpecialCharacters.isChecked()){
                    haslo.append(znakiSpecjalne);
                }


                for(int i = 0; i < dlugosc; i++) {
                    int index = random.nextInt(haslo.length());
                    char wylosowanyZnak = haslo.charAt(index);

                    hasloBuild.append(wylosowanyZnak);
                }


                String wygenerowaneHaslo = hasloBuild.toString();


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("wygenerowane haslo");
                builder.setMessage("haslo:");

            }

        });



        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imie = editImie.getText().toString();
                String nazwisko = editNazwisko.getText().toString();

            }
        });


    }
}

package com.example.walusiak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity10 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodaj_notatke);
    }

    public void dodajNotatke(View view) {
        MainActivity4 plik = new MainActivity4();
        EditText  et = (EditText)findViewById(R.id.editTextTextPersonName);
        plik.stworzPlik("notatka",et.getText().toString());
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}

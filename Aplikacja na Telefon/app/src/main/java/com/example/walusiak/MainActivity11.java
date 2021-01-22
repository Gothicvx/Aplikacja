package com.example.walusiak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity11 extends AppCompatActivity {
    MainActivity4 plik;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usun_notatke);
        plik = new MainActivity4();
    }

    public void powrot(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void usunNotke(View view) {
        File file;
        file = new File(plik.path,GlobalClass.data+"-"+"notatka"+"-"+".txt");
        boolean deleted = file.delete();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}

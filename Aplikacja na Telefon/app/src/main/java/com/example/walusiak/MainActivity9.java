package com.example.walusiak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity9 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuwanie_task);
    }

    public void wrocTask(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

    public void usuwanie(View view) {
        GlobalClass.czyUsunacTask = true;
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
}

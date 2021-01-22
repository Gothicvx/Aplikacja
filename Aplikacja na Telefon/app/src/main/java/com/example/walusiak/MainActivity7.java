package com.example.walusiak;

import android.content.Intent;
import android.media.TimedText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;

public class MainActivity7 extends AppCompatActivity {
    EditText tt;
    Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_text);
        tt = (EditText) findViewById(R.id.editTextTime2);
        btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(walidacja()){
                    GlobalClass.hour = tt.getText().toString();
                    bactToAlarm();
                }else
                    Toast.makeText(getApplicationContext(), "Niepoprawny format godziny.00:00 - 23:59", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean walidacja() {
        String godzina = tt.getText().toString();
        String[] godzinaCut = godzina.split(":");
        if(godzinaCut.length==2){
        if((Integer.valueOf(godzinaCut[0])>=0 && Integer.valueOf(godzinaCut[0])<24) && (Integer.valueOf(godzinaCut[1])>=0 && Integer.valueOf(godzinaCut[1])<60))
            return true;
        return false;
        }
        return false;
    }

    private void bactToAlarm() {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
}

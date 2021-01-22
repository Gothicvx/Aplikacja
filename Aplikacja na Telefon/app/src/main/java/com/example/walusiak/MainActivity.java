package com.example.walusiak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Switch sw;
    MainActivity4 plik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn =  (Button) findViewById(R.id.button4);
        sw = (Switch)findViewById(R.id.switch6);
        plik = new MainActivity4();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        checkSwitch();

    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void checkSwitch(){
        if(sw.isChecked())
            GlobalClass.switchCheck=true;
        else if(GlobalClass.switchCheck)
            sw.setChecked(true);
    }

    public void checkSwitch(View view) {
        checkSwitch();
        sendNotifi();
    }
    public void sendNotifi(){
        String[] data;
        String currentDate = new SimpleDateFormat("dd_MM_yyyy", Locale.getDefault()).format(new Date());
        data=currentDate.split("_");
        if(Integer.valueOf(data[1])>0 && Integer.valueOf(data[1])<10){
            data[1]=data[1].replace("0","");
        }
        currentDate = data[0]+"."+data[1]+"."+data[2];
        //Log.d("akt",currentDate);
        currentDate.replaceAll(" ","");
        GlobalClass.data = currentDate;
        if(plik.fileExist(plik.path+"/"+currentDate+"-"+"notatka"+"-.txt")){
            NotificationCompat.Builder mbuilder  = (NotificationCompat.Builder)
                    new NotificationCompat.Builder(getApplicationContext())
                    .setSmallIcon(R.drawable.logopom)
                    .setContentTitle("Notatka")
                    .setContentText(plik.fileRead("notatka "));
            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(0,mbuilder.build());
        }
    }
}
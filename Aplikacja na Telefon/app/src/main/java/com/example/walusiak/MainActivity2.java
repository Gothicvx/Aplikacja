package com.example.walusiak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    CalendarView cv = null;
    String data;
    GlobalClass gb = null;
    TextView tv;
    MainActivity4 plik;
    String[] temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Slidr.attach(this);
        plik = new MainActivity4();
        /*
        final int[] d = new int[1];
        final int[] m = new int[1];
        final int[] y = new int[1];

         */
        tv = (TextView)findViewById(R.id.textView2);


        cv = (CalendarView)findViewById(R.id.calendarView);
        TextView text = (TextView)findViewById(R.id.textView26);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String c = dayOfMonth+"-"+month+"-"+year;
                text.setText("Wybrana data :" + dayOfMonth +"_" + (month+1) + "_" + year);
                saveDate(text.getText().toString());
                text.setText("Wybrana data : " + dayOfMonth +"." + (month+1) + "." + year);
                refresh();
            }
        });
        checkNote();
        if(GlobalClass.data!=null)
            text.setText("Wybrana data : " + GlobalClass.data.replace("_","."));

    }
    public void checkNote(){
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"notatka"+"-.txt"))
            tv.setText(plik.fileRead("notatka"));
        else
            tv.setText("Kliknij \"+\" aby dodać notatkę.");
    }
    public void refresh(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void saveDate(String date){
        data=date;
        //Log.d("akt",data);
        gb= new GlobalClass(data);
        //Log.d("akt2",gb.zwrocDate());

    }
    /*public void showToast(String data){
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setText(data);
        toast.show();
       }*/
    public void zapiszDate(){
        data = null;

    }
    public void openBlue(View view){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    public void openOrange(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void openYellow(View view){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
    public void openRed(View view){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void dodajNotke(View view) {
        Intent intent = new Intent(this, MainActivity10.class);
        startActivity(intent);
    }

    public void odpalUsuwanie(View view) {
        Intent intent = new Intent(this, MainActivity11.class);
        startActivity(intent);
    }
}
package com.example.walusiak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class MainActivity3 extends AppCompatActivity {
    private SlidrInterface slidr;
    private TextView ttv1,ttv2,ttv3,ttv4,ttp1,ttp2,ttp3,ttp4;
    private ImageView iiv1,iiv2;
    private ProgressBar ppb1,ppb2,ppb3,ppb4;
    private String[] dane;
    private MainActivity4 plik = new MainActivity4();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest);
        slidr = Slidr.attach(this);
        ttv1=(TextView)findViewById(R.id.tv1);
        ttv2=(TextView)findViewById(R.id.textView7);
        ttv3=(TextView)findViewById(R.id.textView8);
        ttv4=(TextView)findViewById(R.id.textView9);
        ttp1=(TextView)findViewById(R.id.tp1);
        ttp2=(TextView)findViewById(R.id.tp2);
        ttp3=(TextView)findViewById(R.id.tp3);
        ttp4=(TextView)findViewById(R.id.tp4);
        iiv1 = (ImageView)findViewById(R.id.iv1);
        iiv2 = (ImageView)findViewById(R.id.iv2);
        ppb1 = (ProgressBar)findViewById(R.id.pb1);
        ppb2 = (ProgressBar)findViewById(R.id.pb2);
        ppb3 = (ProgressBar)findViewById(R.id.pb3);
        ppb4 = (ProgressBar)findViewById(R.id.pb4);
        checkDate();
        setProgressBar();
    }

    private void checkDate() {
        sprawdzPlik();
        if(!(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"quest"+"-.txt"))){
            ttv2.setText("0/2000ml");
            ttv3.setText("0/2000kcal");
            ttv4.setText("0/2000");
            ttp1.setText("0/260 g");
            ttp2.setText("0/0 g");
            ttp3.setText("0/50 g");
            ttp4.setText("0/70 g");
        }

        if(GlobalClass.data!=null){
            String[] temp;
            //Log.d("akt",temp[0].toString());
            temp = GlobalClass.data.split("_");
            // Log.d("akt",temp.toString());
            ttv1.setText(temp[0]+"."+temp[1]+"."+temp[2]);
        }
        else
            ttv1.setText("Nie wybrano daty");
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

    public void nextDay(View view) {
        if(ttv1.getText().equals("Nie wybrano daty"))
            Toast.makeText(getApplicationContext(), "Wybierz najpierw datę!", Toast.LENGTH_SHORT).show();
        else {
            int day;
            String[] data = GlobalClass.data.split("_");
            day = Integer.parseInt(data[0]) + 1;
            GlobalClass.data = String.valueOf(day) + "_" + data[1] + "_" + data[2];
            checkDate();
            setProgressBar();
        }
    }

    public void pDay(View view) {
        if(ttv1.getText().equals("Nie wybrano daty"))
            Toast.makeText(getApplicationContext(), "Wybierz najpierw datę!", Toast.LENGTH_SHORT).show();
        else {
            int day;
            String[] data = GlobalClass.data.split("_");
            day = Integer.parseInt(data[0]) - 1;
            GlobalClass.data = String.valueOf(day) + "_" + data[1] + "_" + data[2];
            checkDate();
            setProgressBar();
        }
    }

    public void openeEdit(View view) {
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
    }
    private void sprawdzPlik(){
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"quest"+"-.txt")){
            dane = plik.fileRead("quest").split(";");
            if(!(dane[0].equals("")))
            ttv2.setText(dane[0]+"/2000ml");
            else
                ttv2.setText("0/2000ml");
            if(!(dane[1].equals("")))
             ttv3.setText(dane[1]+"/2000kcal");
            else
                ttv3.setText("0/2000kcal");
            if(!(dane[2].equals("")))
            ttv4.setText(dane[2]+"/2000");
            else
                ttv4.setText("0/2000");
            if(!(dane[3].equals("")))
            ttp1.setText(dane[3]+"/260 g");
            else
                ttp1.setText("0/260 g");
            if(!(dane[4].equals("")))
            ttp2.setText(dane[4]+"/0 g");
            else
                ttp2.setText("0/0 g");
            if(!(dane[5].equals("")))
            ttp3.setText(dane[5]+"/50 g");
            else
                ttp3.setText("0/50 g");
            if(!(dane[6].equals("")))
            ttp4.setText(dane[6]+"/70 g");
            else
                ttp4.setText("0/70 g");
        }
    }

    public void odpalUsuwanieA(View view) {
        Intent intent = new Intent(this, MainActivity12.class);
        startActivity(intent);
    }
    public void setProgressBar(){
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"quest"+"-.txt")){
            int coal,kcal,prot,fat=0;
            String tmp = plik.fileRead("quest");
            String[] text = tmp.split(";");
            coal = Integer.parseInt(text[3]);
            kcal = Integer.parseInt(text[4]);
            prot = Integer.parseInt(text[5]);
            fat = Integer.parseInt(text[6]);
            coal = Math.round(((float)coal/260*100));
            kcal = Math.round(((float)kcal/1*100));
            prot = Math.round(((float)prot/50*100));
            fat = Math.round(((float)fat/70*100));
            ppb1.setProgress(coal);
            ppb2.setProgress(kcal);
            ppb3.setProgress(prot);
            ppb4.setProgress(fat);
        }else{
            ppb1.setProgress(0);
            ppb2.setProgress(0);
            ppb3.setProgress(0);
            ppb4.setProgress(0);
        }
    }
}
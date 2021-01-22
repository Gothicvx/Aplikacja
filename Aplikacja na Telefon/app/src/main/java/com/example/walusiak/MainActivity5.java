package com.example.walusiak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.io.File;

public class MainActivity5 extends AppCompatActivity {
    View bb1,bb2,bb3,bb4,bb5,bb6,bb7;
    TextView tt1,tt2,tt3,tt4,tt5,tt6,tt7;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    CheckBox b1,b2,b3,b4,b5,b6,b7;
    Button btn;
    //private String path = Environment.getExternalStorageDirectory().toString()+"/plikiAlarm";
    private SlidrInterface slidr;
    private final int MEMORY_ACCES = 5;
    MainActivity4 plik = new MainActivity4();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        slidr = Slidr.attach(this);
        b1 = (CheckBox)findViewById(R.id.cb1);
        b2 = (CheckBox)findViewById(R.id.cb2);
        b3 = (CheckBox)findViewById(R.id.cb3);
        b4 = (CheckBox)findViewById(R.id.cb4);
        b5 = (CheckBox)findViewById(R.id.cb5);
        b6 = (CheckBox)findViewById(R.id.cb6);
        b7 = (CheckBox)findViewById(R.id.cb7);
        btn = (Button)findViewById(R.id.btn);
        bb1 = (View)findViewById(R.id.b1);
        bb2 = (View)findViewById(R.id.b2);
        bb3 = (View)findViewById(R.id.b3);
        bb4 = (View)findViewById(R.id.b4);
        bb5 = (View)findViewById(R.id.b5);
        bb6 = (View)findViewById(R.id.b6);
        bb7 = (View)findViewById(R.id.b7);
        tt1 = (TextView)findViewById(R.id.t1);
        tt2 = (TextView)findViewById(R.id.t2);
        tt3 = (TextView)findViewById(R.id.t3);
        tt4 = (TextView)findViewById(R.id.t4);
        tt5 = (TextView)findViewById(R.id.t5);
        tt6 = (TextView)findViewById(R.id.t6);
        tt7 = (TextView)findViewById(R.id.t7);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity5.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){}
        else
            ActivityCompat.requestPermissions(MainActivity5.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},5);
        ukryjAlarm();
        sprawdzPliki();
        if(GlobalClass.hour!=null){
            String godzinaId;
            godzinaId = dodajAlarm();
            plik.stworzPlik(godzinaId,GlobalClass.hour);
            GlobalClass.hour=null;
        }

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

    public void stworzAlarm(View view) {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
        /*
        if(bb7.getVisibility()== View.VISIBLE)
            Toast.makeText(getApplicationContext(), "Nie można więcej dodać", Toast.LENGTH_LONG).show();
        else {
            Intent intent = new Intent(this, MainActivity7.class);
            startActivity(intent);
        }*/
    }
    private void ukryjAlarm(){
        bb1.setVisibility(View.GONE);
        bb2.setVisibility(View.GONE);
        bb3.setVisibility(View.GONE);
        bb4.setVisibility(View.GONE);
        bb5.setVisibility(View.GONE);
        bb6.setVisibility(View.GONE);
        bb7.setVisibility(View.GONE);
        tt1.setVisibility(View.GONE);
        tt2.setVisibility(View.GONE);
        tt3.setVisibility(View.GONE);
        tt4.setVisibility(View.GONE);
        tt5.setVisibility(View.GONE);
        tt6.setVisibility(View.GONE);
        tt7.setVisibility(View.GONE);
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        btn6.setVisibility(View.GONE);
        btn7.setVisibility(View.GONE);
    }
    private void sprawdzPliki(){
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"bb1"+"-"+".txt")){
            bb1.setVisibility(View.VISIBLE);
            tt1.setVisibility(View.VISIBLE);
            btn1.setVisibility(View.VISIBLE);
            tt1.setText(plik.fileRead("bb1"));
        }else{}
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"bb2"+"-"+".txt")){
            bb2.setVisibility(View.VISIBLE);
            tt2.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            tt2.setText(plik.fileRead("bb2"));
        }else{}
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"bb3"+"-"+".txt")){
            bb3.setVisibility(View.VISIBLE);
            tt3.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            tt3.setText(plik.fileRead("bb3"));
        }else{}
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"bb4"+"-"+".txt")){
            bb4.setVisibility(View.VISIBLE);
            tt4.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
            tt4.setText(plik.fileRead("bb4"));
        }else{}
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"bb5"+"-"+".txt")){
            bb5.setVisibility(View.VISIBLE);
            tt5.setVisibility(View.VISIBLE);
            btn5.setVisibility(View.VISIBLE);
            tt5.setText(plik.fileRead("bb5"));
        }else{}
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"bb6"+"-"+".txt")){
            bb6.setVisibility(View.VISIBLE);
            tt6.setVisibility(View.VISIBLE);
            btn6.setVisibility(View.VISIBLE);
            tt6.setText(plik.fileRead("bb6"));
        }else{}
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"bb7"+"-"+".txt")){
            bb7.setVisibility(View.VISIBLE);
            tt7.setVisibility(View.VISIBLE);
            btn7.setVisibility(View.VISIBLE);
            tt7.setText(plik.fileRead("bb7"));
        }else{}
    }
    private String dodajAlarm(){
        if(bb1.getVisibility()==View.GONE){
            bb1.setVisibility(View.VISIBLE);
            tt1.setVisibility(View.VISIBLE);
            btn1.setVisibility(View.VISIBLE);
            tt1.setText(GlobalClass.hour);
            return "bb1";
        }else if(bb2.getVisibility()==View.GONE){
            bb2.setVisibility(View.VISIBLE);
            tt2.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            tt2.setText(GlobalClass.hour);
            return "bb2";
        }else if(bb3.getVisibility()==View.GONE){
            bb3.setVisibility(View.VISIBLE);
            tt3.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            tt3.setText(GlobalClass.hour);
            return "bb3";
        }else if(bb4.getVisibility()==View.GONE){
            bb4.setVisibility(View.VISIBLE);
            tt4.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
            tt4.setText(GlobalClass.hour);
            return "bb4";
        }else if(bb5.getVisibility()==View.GONE){
            bb5.setVisibility(View.VISIBLE);
            tt5.setVisibility(View.VISIBLE);
            btn5.setVisibility(View.VISIBLE);
            tt5.setText(GlobalClass.hour);
            return "bb5";
        }else if(bb6.getVisibility()==View.GONE){
            bb6.setVisibility(View.VISIBLE);
            tt6.setVisibility(View.VISIBLE);
            btn6.setVisibility(View.VISIBLE);
            tt6.setText(GlobalClass.hour);
            return "bb6";
        }else if(bb7.getVisibility()==View.GONE){
            bb7.setVisibility(View.VISIBLE);
            tt7.setVisibility(View.VISIBLE);
            btn7.setVisibility(View.VISIBLE);
            tt7.setText(GlobalClass.hour);
            return "bb7";
        }else{
            Toast.makeText(getApplicationContext(), "Nie można więcej dodać", Toast.LENGTH_LONG).show();
            return null;
        }
    }
    public void setAlarm(String czas){
        String[] czasDwa = czas.split(":");
        while(czasDwa[1].length()>2) {
                czasDwa[1] = Character.toString(czasDwa[1].charAt(0)) + (czasDwa[1].charAt(1));
        }
        /*if (Integer.parseInt(czasDwa[1])<10)
            czasDwa[1]="0"+(czasDwa[1].charAt(1));
        if(Integer.parseInt(czasDwa[0])<10)
            czasDwa[0]="0"+(czasDwa[0].charAt(1));
         */
        int minuta = Integer.parseInt(czasDwa[1]);
        int godzina = Integer.parseInt(czasDwa[0]);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR,godzina);
        intent.putExtra(AlarmClock.EXTRA_MINUTES,minuta);
        startActivity(intent);
    }
    public void buttonOne(View view) {
        setAlarm(tt1.getText().toString());
    }

    public void buttonDwa(View view) {
        setAlarm(tt2.getText().toString());
    }

    public void buttonTrzy(View view) {
        setAlarm(tt3.getText().toString());
    }

    public void buttonFour(View view) {
        setAlarm(tt4.getText().toString());
    }

    public void buttonPiec(View view) {
        setAlarm(tt5.getText().toString());
    }

    public void buttonSix(View view) {
        setAlarm(tt6.getText().toString());
    }

    public void buttonSeven(View view) {
        setAlarm(tt7.getText().toString());
    }

    public void sprawdzCzyUsunac(){
        File file;
        if(GlobalClass.delAlarm1){
            bb1.setVisibility(View.GONE);
            tt1.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            file = new File(plik.path,GlobalClass.data+"-"+"bb1"+"-"+".txt");
            boolean deleted = file.delete();
        }
        if(GlobalClass.delAlarm2){
            bb2.setVisibility(View.GONE);
            tt2.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            file = new File(plik.path,GlobalClass.data+"-"+"bb2"+"-"+".txt");
            boolean deleted = file.delete();
        }
        if(GlobalClass.delAlarm3){
            bb3.setVisibility(View.GONE);
            tt3.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            file = new File(plik.path,GlobalClass.data+"-"+"bb3"+"-"+".txt");
            boolean deleted = file.delete();
        }
        if(GlobalClass.delAlarm4){
            bb4.setVisibility(View.GONE);
            tt4.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            file = new File(plik.path,GlobalClass.data+"-"+"bb4"+"-"+".txt");
            boolean deleted = file.delete();
        }
        if(GlobalClass.delAlarm5){
            bb5.setVisibility(View.GONE);
            tt5.setVisibility(View.GONE);
            btn5.setVisibility(View.GONE);
            file = new File(plik.path,GlobalClass.data+"-"+"bb5"+"-"+".txt");
            boolean deleted = file.delete();
        }
        if(GlobalClass.delAlarm6){
            bb6.setVisibility(View.GONE);
            tt6.setVisibility(View.GONE);
            btn6.setVisibility(View.GONE);
            file = new File(plik.path,GlobalClass.data+"-"+"bb6"+"-"+".txt");
            boolean deleted = file.delete();

        }
        if(GlobalClass.delAlarm7){
            bb7.setVisibility(View.GONE);
            tt7.setVisibility(View.GONE);
            btn7.setVisibility(View.GONE);
            file = new File(plik.path,GlobalClass.data+"-"+"bb7"+"-"+".txt");
            boolean deleted = file.delete();
        }
        GlobalClass.delAlarm1=false;
        GlobalClass.delAlarm2=false;
        GlobalClass.delAlarm3=false;
        GlobalClass.delAlarm4=false;
        GlobalClass.delAlarm5=false;
        GlobalClass.delAlarm6=false;
        GlobalClass.delAlarm7=false;
    }

    public void pokazUsun(View view) {
        if(GlobalClass.czyPanelUsun) {
            b1.setVisibility(View.VISIBLE);
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            b4.setVisibility(View.VISIBLE);
            b5.setVisibility(View.VISIBLE);
            b6.setVisibility(View.VISIBLE);
            b7.setVisibility(View.VISIBLE);
            btn.setVisibility(View.VISIBLE);
            if(bb7.getVisibility()==View.GONE){ b7.setVisibility(View.GONE); }
            if(bb6.getVisibility()==View.GONE){ b6.setVisibility(View.GONE); }
            if(bb5.getVisibility()==View.GONE){ b5.setVisibility(View.GONE); }
            if(bb4.getVisibility()==View.GONE){ b4.setVisibility(View.GONE); }
            if(bb3.getVisibility()==View.GONE){ b3.setVisibility(View.GONE); }
            if(bb2.getVisibility()==View.GONE){ b2.setVisibility(View.GONE); }
            if(bb1.getVisibility()==View.GONE){ b1.setVisibility(View.GONE); }
            GlobalClass.czyPanelUsun = false;
        }else{
            b1.setVisibility(View.GONE);
            b2.setVisibility(View.GONE);
            b3.setVisibility(View.GONE);
            b4.setVisibility(View.GONE);
            b5.setVisibility(View.GONE);
            b6.setVisibility(View.GONE);
            b7.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
            GlobalClass.czyPanelUsun=true;
        }
    }
    public void usunAlarm(View view) {
        if(b1.isChecked()){
            GlobalClass.delAlarm1=true;
            b1.setChecked(false);
        }
        if(b2.isChecked()){
            GlobalClass.delAlarm2=true;
            b2.setChecked(false);
        }
        if(b3.isChecked()){
            GlobalClass.delAlarm3=true;
            b3.setChecked(false);
        }
        if(b4.isChecked()){
            GlobalClass.delAlarm4=true;
            b4.setChecked(false);
        }
        if(b5.isChecked()){
            GlobalClass.delAlarm5=true;
            b5.setChecked(false);
        }
        if(b6.isChecked()){
            GlobalClass.delAlarm6=true;
            b6.setChecked(false);
        }
        if(b7.isChecked()){
            GlobalClass.delAlarm7=true;
            b7.setChecked(false);
        }
        sprawdzCzyUsunac();
        sortujAlarm();
        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
        b7.setVisibility(View.GONE);
        btn.setVisibility(View.GONE);
    }
    public void sortujAlarm(){

    }
}
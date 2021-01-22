package com.example.walusiak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity4 extends AppCompatActivity {
    private SlidrInterface slidr;
    View bbox2,bbox3,bbox4,bbox5,bbox6,bbox7,bbox8,bbox9,bbox10;
    TextView ttextView11,ttextView15,ttextView16,ttextView27,ttextView28,ttextView29,ttextView30,ttextView31,ttextView32;
    SwitchMaterial sswitch1,sswitch2,sswitch3,sswitch4,sswitch5,sswitch9,sswitch10,sswitch11,sswitch12;
    String data = GlobalClass.data;
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath().toString()+"/pliki";
    private final int MEMORY_ACCES = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);
        slidr = Slidr.attach(this);
        //((View) findViewById(R.id.box3)).setVisibility(View.GONE);
        bbox2 = (View)findViewById(R.id.b1);
        bbox3 = (View)findViewById(R.id.box3);
        bbox4 = (View)findViewById(R.id.box4);
        bbox5 = (View)findViewById(R.id.box5);
        bbox6 = (View)findViewById(R.id.box6);
        bbox7 = (View)findViewById(R.id.box7);
        bbox8 = (View)findViewById(R.id.box8);
        bbox9 = (View)findViewById(R.id.box9);
        bbox10 = (View)findViewById(R.id.b2);
        ttextView11 = (TextView)findViewById(R.id.textView11);
        ttextView15 = (TextView)findViewById(R.id.textView15);
        ttextView16 = (TextView)findViewById(R.id.textView16);
        ttextView27 = (TextView)findViewById(R.id.textView27);
        ttextView28 = (TextView)findViewById(R.id.textView28);
        ttextView29 = (TextView)findViewById(R.id.textView29);
        ttextView30 = (TextView)findViewById(R.id.textView30);
        ttextView31 = (TextView)findViewById(R.id.textView31);
        ttextView32 = (TextView)findViewById(R.id.textView32);
        sswitch1 = (SwitchMaterial)findViewById(R.id.switch1);
        sswitch2 = (SwitchMaterial)findViewById(R.id.switch2);
        sswitch3 = (SwitchMaterial)findViewById(R.id.switch3);
        sswitch4 = (SwitchMaterial) findViewById(R.id.switch4);
        sswitch5 = (SwitchMaterial)findViewById(R.id.switch5);
        sswitch9 = (SwitchMaterial)findViewById(R.id.switch9);
        sswitch10 = (SwitchMaterial)findViewById(R.id.switch10);
        sswitch11 = (SwitchMaterial)findViewById(R.id.switch11);
        sswitch12 = (SwitchMaterial)findViewById(R.id.switch12);

        if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity4.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){}
            else
                ActivityCompat.requestPermissions(MainActivity4.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MEMORY_ACCES);
        schowajZadania();
        sprawdzPliki();
        if(GlobalClass.msg!=null){
            String[] id;
            id = dodajTask(GlobalClass.msg);
            stworzPlik(id[0],GlobalClass.msg);
            GlobalClass.msg=null;
        }
        if(GlobalClass.czyUsunacTask){
            usunTaska();
            GlobalClass.czyUsunacTask = false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case MEMORY_ACCES:
                if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED) { }
                else
                    Toast.makeText(getApplicationContext(),"BRAK POZWOLENIA",Toast.LENGTH_LONG).show();
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

    private void sprawdzPliki() {

        if(fileExist(path+"/"+data+"-"+"bbox2"+"-.txt")){
            bbox2.setVisibility(View.VISIBLE);
            ttextView11.setVisibility(View.VISIBLE);
            sswitch1.setVisibility(View.VISIBLE);
            ttextView11.setText(fileRead("bbox2"));
        }else {}
        if(fileExist(path+"/"+data+"-"+"bbox3"+"-.txt")){
            bbox3.setVisibility(View.VISIBLE);
            ttextView15.setVisibility(View.VISIBLE);
            sswitch2.setVisibility(View.VISIBLE);
            ttextView15.setText(fileRead("bbox3"));
        }else {}
        if(fileExist(path+"/"+data+"-"+"bbox4"+"-.txt")){
            bbox4.setVisibility(View.VISIBLE);
            ttextView16.setVisibility(View.VISIBLE);
            ttextView16.setText(fileRead("bbox4"));
            sswitch3.setVisibility(View.VISIBLE);
        }else {}
        if(fileExist(path+"/"+data+"-"+"bbox5"+"-.txt")){
            bbox5.setVisibility(View.VISIBLE);
            ttextView27.setVisibility(View.VISIBLE);
            ttextView27.setText(fileRead("bbox5"));
            sswitch4.setVisibility(View.VISIBLE);
        }else {}
        if(fileExist(path+"/"+data+"-"+"bbox6"+"-.txt")){
            bbox6.setVisibility(View.VISIBLE);
            ttextView28.setVisibility(View.VISIBLE);
            ttextView28.setText(fileRead("bbox6"));
            sswitch5.setVisibility(View.VISIBLE);
        }else {}
        if(fileExist(path+"/"+data+"-"+"bbox7"+"-.txt")){
            bbox7.setVisibility(View.VISIBLE);
            ttextView29.setVisibility(View.VISIBLE);
            ttextView29.setText(fileRead("bbox7"));
            sswitch9.setVisibility(View.VISIBLE);
        }else {}
        if(fileExist(path+"/"+data+"-"+"bbox8"+"-.txt")){
            bbox8.setVisibility(View.VISIBLE);
            ttextView30.setVisibility(View.VISIBLE);
            ttextView30.setText(fileRead("bbox8"));
            sswitch10.setVisibility(View.VISIBLE);
        }else {}
        if(fileExist(path+"/"+data+"-"+"bbox9"+"-.txt")){
            bbox9.setVisibility(View.VISIBLE);
            ttextView31.setVisibility(View.VISIBLE);
            ttextView31.setText(fileRead("bbox9"));
            sswitch11.setVisibility(View.VISIBLE);
        }else {}
        if(fileExist(path+"/"+data+"-"+"bbox10"+"-.txt")){
            bbox10.setVisibility(View.VISIBLE);
            ttextView32.setVisibility(View.VISIBLE);
            ttextView32.setText(fileRead("bbox10"));
            sswitch12.setVisibility(View.VISIBLE);
        }else {}

    }

    public String fileRead(String pathName) {
        File file = new File(path+"/"+data+"-"+pathName+"-.txt");
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) { }
        return text.toString();

    }
    public boolean fileExist(String fileName){
        File file = new File(fileName);
        if(file.exists())
            return true;
        return false;
    }
    public void stworzTask(View view) {
        if(bbox10.getVisibility()== View.VISIBLE)
            Toast.makeText(getApplicationContext(), "Nie można więcej dodać", Toast.LENGTH_LONG).show();
        else {
            Intent intent = new Intent(this, MainActivity6.class);
            startActivity(intent);
        }
        /*
        setContentView(R.layout.text);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText)findViewById(R.id.editText);
                msg[0] =et.getText().toString();
                setContentView(R.layout.task);
            }
        });
         *//*

        schowajZadania();
        sprawdzPliki();
        String[] id;
        id = dodajTask(GlobalClass.msg);
        stworzPlik(GlobalClass.msg,id[0]);
        */
    }
    public void stworzPlik(String fileName, String msg){
        File folder = new File(path);
        if(!folder.exists()){
            try{
                folder.mkdirs();
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
            }
        }
        File file = new File(path+"/"+data+"-"+fileName+"-.txt");
        FileOutputStream fOut;
        OutputStreamWriter outWriter;
        try{
            fOut = new FileOutputStream(file);
            outWriter = new OutputStreamWriter(fOut);
            outWriter.append(msg);
            outWriter.close();
            fOut.close();

        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
        }

    }
    private void schowajZadania(){
            bbox2.setVisibility(View.GONE);
            ttextView11.setVisibility(View.GONE);
            bbox3.setVisibility(View.GONE);
            ttextView15.setVisibility(View.GONE);
            bbox4.setVisibility(View.GONE);
            ttextView16.setVisibility(View.GONE);
            bbox5.setVisibility(View.GONE);
            ttextView27.setVisibility(View.GONE);
            bbox6.setVisibility(View.GONE);
            ttextView28.setVisibility(View.GONE);
            bbox7.setVisibility(View.GONE);
            ttextView29.setVisibility(View.GONE);
            bbox8.setVisibility(View.GONE);
            ttextView30.setVisibility(View.GONE);
            bbox9.setVisibility(View.GONE);
            ttextView31.setVisibility(View.GONE);
            bbox10.setVisibility(View.GONE);
            ttextView32.setVisibility(View.GONE);
            sswitch1.setVisibility(View.GONE);
            sswitch2.setVisibility(View.GONE);
            sswitch3.setVisibility(View.GONE);
            sswitch4.setVisibility(View.GONE);
            sswitch5.setVisibility(View.GONE);
            sswitch9.setVisibility(View.GONE);
            sswitch10.setVisibility(View.GONE);
            sswitch11.setVisibility(View.GONE);
            sswitch12.setVisibility(View.GONE);
    }
    public String[] dodajTask(String msg){
        if(bbox2.getVisibility() == View.GONE){
            bbox2.setVisibility(View.VISIBLE);
            ttextView11.setVisibility(View.VISIBLE);
            sswitch1.setVisibility(View.VISIBLE);
            ttextView11.setText(msg);
            return new String[]{"bbox2", "ttextView11"};
        }else if(bbox3.getVisibility() == View.GONE){
            bbox3.setVisibility(View.VISIBLE);
            ttextView15.setVisibility(View.VISIBLE);
            sswitch2.setVisibility(View.VISIBLE);
            ttextView15.setText(msg);
            return new String[]{"bbox3", "ttextView15"};
        }else if(bbox4.getVisibility() == View.GONE){
            bbox4.setVisibility(View.VISIBLE);
            ttextView16.setVisibility(View.VISIBLE);
            sswitch3.setVisibility(View.VISIBLE);
            ttextView16.setText(msg);
            return new String[]{"bbox4", "ttextView16"};
        }else if(bbox5.getVisibility() == View.GONE){
            bbox5.setVisibility(View.VISIBLE);
            ttextView27.setVisibility(View.VISIBLE);
            sswitch4.setVisibility(View.VISIBLE);
            ttextView27.setText(msg);
            return new String[]{"bbox5", "ttextView27"};
        }else if(bbox6.getVisibility() == View.GONE){
            bbox6.setVisibility(View.VISIBLE);
            ttextView28.setVisibility(View.VISIBLE);
            sswitch5.setVisibility(View.VISIBLE);
            ttextView28.setText(msg);
            return new String[]{"bbox6", "ttextView28"};
        }else if(bbox7.getVisibility() == View.GONE){
            bbox7.setVisibility(View.VISIBLE);
            ttextView29.setVisibility(View.VISIBLE);
            sswitch9.setVisibility(View.VISIBLE);
            ttextView29.setText(msg);
            return new String[]{"bbox7", "ttextView29"};
        }else if(bbox8.getVisibility() == View.GONE){
            bbox8.setVisibility(View.VISIBLE);
            ttextView30.setVisibility(View.VISIBLE);
            sswitch10.setVisibility(View.VISIBLE);
            ttextView30.setText(msg);
            return new String[]{"bbox8", "ttextView30"};
        }else if(bbox9.getVisibility() == View.GONE){
            bbox9.setVisibility(View.VISIBLE);
            ttextView31.setVisibility(View.VISIBLE);
            sswitch11.setVisibility(View.VISIBLE);
            ttextView31.setText(msg);
            return new String[]{"bbox9", "ttextView31"};
        }else if(bbox10.getVisibility() == View.GONE){
            bbox10.setVisibility(View.VISIBLE);
            ttextView32.setVisibility(View.VISIBLE);
            sswitch12.setVisibility(View.VISIBLE);
            ttextView32.setText(msg);
            return new String[]{"bbox10", "ttextView32"};
        }else {
            Toast.makeText(getApplicationContext(), "Nie można więcej dodać", Toast.LENGTH_LONG).show();

            return null;
        }
    }

    public void usunZaznaczone(View view) {
        if(sswitch1.isChecked()){GlobalClass.s1=true;}
        if(sswitch2.isChecked()){GlobalClass.s2=true;}
        if(sswitch3.isChecked()){GlobalClass.s3=true;}
        if(sswitch4.isChecked()){GlobalClass.s4=true;}
        if(sswitch5.isChecked()){GlobalClass.s5=true;}
        if(sswitch9.isChecked()){GlobalClass.s6=true;}
        if(sswitch10.isChecked()){GlobalClass.s7=true;}
        if(sswitch11.isChecked()){GlobalClass.s8=true;}
        if(sswitch12.isChecked()){GlobalClass.s9=true;}
        Intent intent = new Intent(this, MainActivity9.class);
        startActivity(intent);
    }
    public void usunTaska(){
        File file;
        if(GlobalClass.s1){
            bbox2.setVisibility(View.GONE);
            ttextView11.setVisibility(View.GONE);
            sswitch1.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox2"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s1=false;
        }
        if(GlobalClass.s2){
            bbox3.setVisibility(View.GONE);
            ttextView15.setVisibility(View.GONE);
            sswitch2.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox3"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s2=false;
        }if(GlobalClass.s3){
            bbox4.setVisibility(View.GONE);
            ttextView16.setVisibility(View.GONE);
            sswitch3.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox4"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s3=false;
        }if(GlobalClass.s4){
            bbox5.setVisibility(View.GONE);
            ttextView27.setVisibility(View.GONE);
            sswitch4.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox5"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s4=false;
        }if(GlobalClass.s5){
            bbox6.setVisibility(View.GONE);
            ttextView28.setVisibility(View.GONE);
            sswitch5.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox6"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s5=false;
        }if(GlobalClass.s6){
            bbox7.setVisibility(View.GONE);
            ttextView29.setVisibility(View.GONE);
            sswitch9.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox7"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s6=false;
        }if(GlobalClass.s7){
            bbox8.setVisibility(View.GONE);
            ttextView30.setVisibility(View.GONE);
            sswitch10.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox8"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s7=false;
        }if(GlobalClass.s8){
            bbox9.setVisibility(View.GONE);
            ttextView31.setVisibility(View.GONE);
            sswitch11.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox9"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s8=false;
        }if(GlobalClass.s9){
            bbox10.setVisibility(View.GONE);
            ttextView32.setVisibility(View.GONE);
            sswitch12.setVisibility(View.GONE);
            file = new File(path,GlobalClass.data+"-"+"bbox10"+"-"+".txt");
            boolean deleted = file.delete();
            GlobalClass.s9=false;
        }
    }

    /*
    box2 textView11 switch1
    box3 textView15 switch2
    box4 textView16 switch3
    box5 textView27 switch4
    box6 textView28 switch5
    box7 textView29 switch9
    box8 textView30 switch10
    box9 textView31 switch11
    box10 textView32 switch12
     */

}
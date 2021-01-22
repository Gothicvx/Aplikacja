package com.example.walusiak;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8 extends AppCompatActivity {
    EditText woda,kcal,kroki,coal,circleKcal,protein,fat;
    MainActivity4 plik = new MainActivity4();
    private String[] dane;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_quest);
        woda = (EditText)findViewById(R.id.woda);
        kcal = (EditText)findViewById(R.id.kcal);
        kroki = (EditText)findViewById(R.id.kroki);
        coal = (EditText)findViewById(R.id.coal);
        circleKcal = (EditText)findViewById(R.id.circleKcal);
        protein = (EditText)findViewById(R.id.protein);
        fat = (EditText)findViewById(R.id.fat);
        if(plik.fileExist(plik.path+"/"+GlobalClass.data+"-"+"quest"+"-.txt")){
            dane = plik.fileRead("quest").split(";");
            if(!(dane[0].equals("")))
                GlobalClass.woda=dane[0];
            if(!(dane[1].equals("")))
                GlobalClass.kcal=dane[1];
            if(!(dane[2].equals("")))
                GlobalClass.kroki=dane[2];
            if(!(dane[3].equals("")))
                GlobalClass.coal=dane[3];
            if(!(dane[4].equals("")))
                GlobalClass.circleKcal=dane[4];
            if(!(dane[5].equals("")))
                GlobalClass.protein=dane[5];
            if(!(dane[6].equals("")))
                GlobalClass.fat=dane[6];
        }
        woda.setText(GlobalClass.woda);
        kcal.setText(GlobalClass.kcal);
        kroki.setText(GlobalClass.kroki);
        coal.setText(GlobalClass.coal);
        circleKcal.setText(GlobalClass.circleKcal);
        protein.setText(GlobalClass.protein);
        fat.setText(GlobalClass.fat);

    }

    public void openQuest(View view) {
        if(woda!=null)GlobalClass.woda=woda.getText().toString();
        if(kcal!=null)GlobalClass.kcal=kcal.getText().toString();
        if(kroki!=null)GlobalClass.kroki=kroki.getText().toString();
        if(coal!=null)GlobalClass.coal=coal.getText().toString();
        if(circleKcal!=null)GlobalClass.circleKcal=circleKcal.getText().toString();
        if(protein!=null)GlobalClass.protein=protein.getText().toString();
        if(fat!=null)GlobalClass.fat=fat.getText().toString();
        //plik.stworzPlik("quest",  woda.getText().toString()+";"+kcal.getText().toString()+";"+kroki.getText().toString()+";"+coal.getText().toString()+";"+circleKcal.getText().toString()+";"+protein.getText().toString()+";"+fat.getText().toString()+";");
        plik.stworzPlik("quest",   GlobalClass.woda.toString()+";"+ GlobalClass.kcal.toString()+";"+ GlobalClass.kroki.toString()+";"+GlobalClass.coal.toString()+";"+ GlobalClass.circleKcal.toString()+";"+GlobalClass.protein.toString()+";"+GlobalClass.fat.toString()+";");
        GlobalClass.woda=GlobalClass.kcal=GlobalClass.kroki=GlobalClass.coal=GlobalClass.circleKcal=GlobalClass.protein=GlobalClass.fat=null;
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}

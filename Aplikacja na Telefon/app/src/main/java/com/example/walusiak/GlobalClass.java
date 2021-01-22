package com.example.walusiak;

import android.app.Application;
import android.util.Log;
 public class GlobalClass extends Application {
        static String msg = null;
        static String data = null;
        static String hour = null;
        static String day = null;
        static String[] quest = null;
        static String woda = null;
        static String kcal = null;
        static String kroki = null;
        static String coal = null;
        static String circleKcal = null;
        static String protein = null;
        static String fat = null;
        static boolean delAlarm1,delAlarm2,delAlarm3,delAlarm4,delAlarm5,delAlarm6,delAlarm7 = false;
        static boolean czyPanelUsun = true;
        static boolean czyUsunacTask = false;
        static boolean s1,s2,s3,s4,s5,s6,s7,s8,s9=false;
        static boolean switchCheck = false;

        public GlobalClass(String s){
            String[] dziel;
            dziel = s.split(":");
            data = dziel[1];
        }
    public static String zwrocDate(){
        return data;
    }
}

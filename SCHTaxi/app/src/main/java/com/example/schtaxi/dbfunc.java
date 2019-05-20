package com.example.schtaxi;

import android.support.v7.app.AppCompatActivity;

public class dbfunc extends AppCompatActivity {

    public String LoginUser(dbobject user){
        String Name = user.getName();
        String PH = user.getPH();

        String resault = "Login.php?Name="+Name+"&PH="+PH;

        return resault;
    }

    public String SelUser(dbobject user){
        String Name = user.getName();
        String PH = user.getPH();
        int is_party = user.getis_party();

        String resault = "Select.php?Name="+Name+"&PH="+PH+"&is_party="+is_party;

        return resault;
    }

    public String SelIndex(String Table, String Dest, int IDX){
        String resault;
        if(IDX!=0){
            resault = "Select.php?Name=''&PH=''&is_party=''&IDX="+IDX;
            return resault;
        }
        if(Dest==null)
            resault = "Select.php?Name=''&PH=''&is_party=''&Table_name="+Table;
        else
            resault = "Select.php?Name=''&PH=''&is_party=''&Table_name="+Table+"&Dest="+Dest;

        return resault;
    }

    public String CreateIndex(dbobject user, String Table){
        String Name = user.getName();
        String PH = user.getPH();
        String Start = user.getStart();
        String Dest = user.getDest();
        String Enter_Time = user.getEnter_Time();
        String Invi_Time = user.getInvi_Time();
        int Entire_P = user.getEntire_P();
        String Table_Name = Table;

        String resault = "Insert.php?Name="+Name+"&PH="+PH+"&Dest="+Dest+"&Start="+Start+"&Enter_Time='"+Enter_Time+"'&Invi_Time='"+Invi_Time+"'&Entire_P="+Entire_P+"&Table_Name="+Table_Name;

        return resault;
    }

    public String DelUser(dbobject user, String Table){
        String Name = user.getName();
        String PH = user.getPH();
        String Table_name = Table;

        String resault = "Delete.php?Name="+Name+"&PH="+PH;
        if(Table_name != null) resault += "&Table_name"+Table_name;

        return resault;
    }

    public String DelIndex(int IDX){
        int _IDX = IDX;

        String resault = "Delete.php?IDX="+_IDX;

        return resault;
    }

    public String Update(dbobject user, String Table, String value, String New){
        String Name = user.getName();
        String PH = user.getPH();
        String Table_name = Table;
        String Value=value;
        String New_V=New;

        String resault = "Update.php?Name="+Name+"&PH="+PH+"&Value="+Value+"&New_V="+New_V;
        if(Table_name != null) resault += "&Table_name"+Table_name;

        return resault;
    }
}
package com.example.schtaxi;

import java.io.IOException;
import java.util.List;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.ListAdapter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;


public class dbfunc extends AppCompatActivity {
    public String AddUser(dbobject user){
        String Name = user.getName();
        String PH = user.getPH();

        String resault = "Login.php?Name="+Name+"&PH="+PH;

        return resault;
    }

    public String SelUser(dbobject user, String Table){
        String Name = user.getName();
        String PH = user.getPH();
        int is_party = user.getis_party();
        String Table_name = Table;
        String Dest = user.getDest();

        String resault = "Select.php?Name="+Name+"&PH="+PH+"&is_party="+is_party;
        if(Table_name != null) resault += "&Table_name="+Table_name;
        if(Dest != null) resault += "&Dest="+Dest;

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
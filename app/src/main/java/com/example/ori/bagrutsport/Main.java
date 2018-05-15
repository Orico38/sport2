package com.example.ori.bagrutsport;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ServiceConfigurationError;
import java.util.zip.CheckedOutputStream;

public class Main extends AppCompatActivity {

    private static final String FILENAME = "";
    EditText ET;
    String name3;
    FileOutputStream fos;
    OutputStreamWriter osw;
    AlertDialog.Builder adb;
    InputStream is;
    InputStreamReader tmp;
    BufferedReader reader;
    String str;
    StringBuffer buffer;
    BufferedWriter bw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET=(EditText) findViewById(R.id.name1);
        adb=new AlertDialog.Builder(this);
        adb.setTitle("שגיאה");
        adb.setMessage("לא הכנסת את שמך");
        adb.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


    }


    public void next1(View view) {
        name3 = ET.getText().toString();
        if (name3.equals("")) {
            AlertDialog ad = adb.create();
            ad.show();

        } else {
            try {
                fos = openFileOutput(name3, Context.MODE_PRIVATE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            try {
                bw.write(name3);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Intent t= new Intent(this, Secmain.class);
            startActivity(t);
        }


        try {
            is = openFileInput(name3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        tmp = new InputStreamReader(is);
        reader = new BufferedReader(tmp);
        buffer = new StringBuffer();
        try {
            while ((str = reader.readLine()) != null) {
                buffer.append(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent t= new Intent(this, Secmain.class);
        String str=new String(buffer);
        t.putExtra("name",str);
        startActivity(t);



    }
    }


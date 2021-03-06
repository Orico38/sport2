package com.example.ori.bagrutsport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class Secmain extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    int i=10;
    String str;
    TextView tv;
    String[]arry=new String [4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secmain);

        tv=(TextView) findViewById(R.id.hi);
        Intent t=getIntent();
        str=t.getStringExtra("name");


        tv.setText("שלום "+ str+" על מה תרצה לעבוד היום");


        spinner = (Spinner) (findViewById(R.id.spinner));
        arry[0]="כפיפות בטן1";
        arry[1]="שכיבות סמיכה";
        arry[2]="מתח";
        arry[3]="מרפקים";

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arry);
        adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adp);
        spinner.setOnItemSelectedListener(this);
    }
    public boolean onCreateOptionsMenu (android.view.Menu menu){

        getMenuInflater().inflate(R.menu.main , menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        String st=item.getTitle().toString();
        if(st.equals("קרדיטים")){
            Intent credits= new Intent(this, Credits.class);
            startActivity(credits);
        }
        return true;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:i=0;break;
            case 1:i=1;break;
            case 2:i=2;break;
            case 3:i=3;break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void next(View view) {
        Intent t=new Intent(this, Exs.class);
        t.putExtra("ex",i);
        startActivity(t);
    }
}

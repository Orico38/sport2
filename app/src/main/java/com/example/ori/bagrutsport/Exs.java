package com.example.ori.bagrutsport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;


public class Exs extends AppCompatActivity {
WebView webv;
    int ex;
    TextView op;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exs);

        op=(TextView) findViewById(R.id.op);
        webv=(WebView)findViewById(R.id.web1);
        webv.getSettings().setJavaScriptEnabled(true);
        Intent gi=getIntent();
        ex=gi.getIntExtra( "ex" ,0);
        if (ex==0) {
            url="https://youtu.be/Xyd_fa5zoEU";

        }
        if (ex==1) {
            op.setText("בחרת לעבוד על שכיבות סמיכה לפניך סרטון שמדגים כיצד לעשות שכיבות סמיכה בצורה הטובה ביותר");
            url="https://youtu.be/IODxDxX7oi4";
        }
        if(ex==2) {
            op.setText("בחרת לעבוד על מתח לפניך סרטון שמדגים כיצד לעשות מתח בצורה הטובה ביותר");
            url="https://youtu.be/eGo4IYlbE5g";

        }
        if (ex==3) {
            op.setText("בחרת לעבוד על מרפקים לפניך סרטון שמדגים כיצד לעשות מרפקים בצורה הטובה ביותר");
            url="https://youtu.be/5Xi5WvhSxAs?t=10";
        }

        webv.loadUrl(url);
        webv.setWebViewClient(new MyWebViewClient());
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

    public void back(View view) {
        finish();
    }
}

package com.example.jokefactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView textview = (TextView) findViewById(R.id.joke_text);
        String joke = null;
        joke = getIntent().getStringExtra("result");
        if (joke != null) {
            textview.setText(joke);
        } else {
            textview.setText("this is a joke");
        }
    }
}

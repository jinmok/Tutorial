package com.example.administrator.tutorial;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class act2 extends ActionBarActivity implements View.OnClickListener{

    TextView what_ya_send;
    Button GoBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act2);

        what_ya_send = findViewById(R.id.what_ya_send);
        Intent intent = this.getIntent();

        String a = intent.getStringExtra("testing");

        person b = (person) intent.getSerializableExtra("person");

        GoBack = (Button) findViewById(R.id.GoBack);
        GoBack.setOnClickListener(this);


        what_ya_send.setText(a);
    }


    @Override
    public void onClick(View v) {
        getIntent().putExtra("go back", "yay");
        setResult(1);

        finish();
    }
}

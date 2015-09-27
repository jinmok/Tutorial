package com.example.administrator.tutorial;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button AddPerson;
    Button GoOn;

    EditText iNameOfPerson;
    EditText iStat1OfPerson;

    TextView oNameOfPerson;
    TextView oStat1OfPerson;

    Spinner PersonSlinner;

    ArrayList<String> course;

    HashMap<String, person> holder;
    person p1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1 = new person();
        p1.name = "Hi there";
        p1.stat1 = "-1";

        holder = new HashMap<String, person>();
        holder.put("Hi there", p1);

        course = new ArrayList<String>();
        course.add("Hi There");

        AddPerson = (Button) findViewById(R.id.AddPerson);
        AddPerson.setOnClickListener(this);

        GoOn = (Button) findViewById(R.id.Goon);
        GoOn.setOnClickListener(this);

        iNameOfPerson = (EditText) findViewById(R.id.iNameOfPerson);
        iStat1OfPerson = (EditText) findViewById(R.id.iStat1OfPerson);

        oNameOfPerson = (TextView) findViewById(R.id.oNameOfPerson);
        oStat1OfPerson = (TextView) findViewById(R.id.oStat1OfPerson);

        PersonSlinner =  (Spinner) findViewById(R.id.PersonSlinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course);
        PersonSlinner.setAdapter(adapter);
        PersonSlinner.setOnItemSelectedListener(this);

        course.add("bob");


    }

    @Override
    public void onClick(View v) {

        if(v == AddPerson)
        {
            iNameOfPerson.getText();
            iStat1OfPerson.getText();

            person pTemp = new person();
            pTemp.name = iNameOfPerson.getText().toString();
            pTemp.stat1 = iStat1OfPerson.getText().toString();

            holder.put( iNameOfPerson.getText().toString(),pTemp);

            course.add(iNameOfPerson.getText().toString());

        }
        if (v == GoOn)
        {
            Intent intent = new Intent(this, act2.class);
            intent.putExtra("testing", "This is my String");

            intent.putExtra("person", p1);

            intent.putExtra("table", holder);

            startActivityForResult(intent, 100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == 100)
        {
            if(resultCode == 1)
            {
                String a = data.getStringExtra("goback");
                oNameOfPerson.setText(a);
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(view == PersonSlinner)
        {
            person pTemp = holder.get(PersonSlinner.getSelectedItem().toString());
            oNameOfPerson.setText(pTemp.name);
            oStat1OfPerson.setText(pTemp.stat1);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}




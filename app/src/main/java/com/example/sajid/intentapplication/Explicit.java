package com.example.sajid.intentapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Explicit extends AppCompatActivity {

    Intent intent;
    TextView etName,etId;
    String name,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        etName= (TextView) findViewById(R.id.etName);
        etId= (TextView) findViewById(R.id.etId);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        name = extras.getString("name");
        id=extras.getString("id");
        if (name != null) {
           etName.setText(name);
            etId.setText(id);
        }

    }
}

package com.example.sajid.intentapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    EditText etName,etId;
    Button btSend;
    Intent intent;
    ImageButton ibtSms,ibtView,ibtCall,ibtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName= (EditText) findViewById(R.id.etName);
        etId= (EditText) findViewById(R.id.etId);
        btSend= (Button) findViewById(R.id.btSend);
        ibtCall= (ImageButton) findViewById(R.id.ibtCall);
        ibtEmail= (ImageButton) findViewById(R.id.ibtEmail);
        ibtSms= (ImageButton) findViewById(R.id.ibtSms);
        ibtView= (ImageButton) findViewById(R.id.ibtView);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,Explicit.class);
                intent.putExtra("name", etName.getText().toString());
                intent.putExtra("id", etId.getText().toString());
                setResult(RESULT_OK,intent);
                startActivity(intent);
            }
        });

        ibtCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(Intent.ACTION_CALL, Uri.parse("tel:01617575353"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }
}

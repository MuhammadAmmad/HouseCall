package com.example.stephen.housecall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    public LoginActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_login);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),PatientMain.class);
                startActivity(next);
            }
        });

        Button doctorButton = (Button) findViewById(R.id.doctor_login_button);
        doctorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),DoctorLogin.class);
                startActivity(next);
            }
        });




    }



}

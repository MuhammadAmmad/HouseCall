package com.example.stephen.housecall;

/**
 * Created by Tom on 7/11/2016.
 */
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorLogin extends AppCompatActivity {

    public DoctorLogin(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_login);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),DoctorMain.class);
                startActivity(next);
            }
        });

        Button patientButton = (Button) findViewById(R.id.patient_login_button);
        patientButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(next);
            }
        });



    }



}

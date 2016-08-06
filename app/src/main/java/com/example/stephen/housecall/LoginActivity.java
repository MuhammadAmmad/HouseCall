package com.example.stephen.housecall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cloudant.sync.datastore.ConflictException;

public class LoginActivity extends AppCompatActivity {

    private static PatientModel pModel;

    public LoginActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_login);

        if(pModel == null){
            this.pModel = new PatientModel(this.getApplicationContext());
        }

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Patient targetPatient = null;
                Boolean successfulAuth = false;
                EditText username =  (EditText)findViewById(R.id.USERNAME);
                EditText password_et = (EditText)findViewById(R.id.PASSWORD);
                int p_len = password_et.length();
                char[] password_char = new char[p_len];
                String pass_hash = null;

                if(username != null && password_et != null){
                    try {
                        targetPatient = pModel.findDocument(username.getText().toString());
                    } catch (ConflictException e) {
                        e.printStackTrace();
                    }
                }
                if(targetPatient != null){
                    pass_hash = targetPatient.getPASSWORD();

                }

                //stores password input as char array to avoid leaving immutable strings in memory dump
                password_et.getText().getChars(0, p_len, password_char, 0);




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

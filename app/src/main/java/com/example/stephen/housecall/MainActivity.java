package com.example.stephen.housecall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.net.URISyntaxException;


public class MainActivity extends AppCompatActivity {

    private static PatientModel pModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(pModel == null){
            this.pModel = new PatientModel(this.getApplicationContext());
        }

        Button activityButton = (Button) findViewById(R.id.create_patient);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Patient p = new Patient("1","2","3","4","5","6","7", "8", "9");
                pModel.createDocument(p);
                try {
                    pModel.pushReplication();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

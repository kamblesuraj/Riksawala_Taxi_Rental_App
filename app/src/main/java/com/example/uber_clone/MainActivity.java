package com.example.uber_clone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button cust_btn;
    Button driver_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cust_btn = findViewById(R.id.customer_btn);
        driver_btn = findViewById(R.id.driver_btn);

        driver_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_new_activity();
            }
        });





    }

    void open_new_activity()
    {
        Intent intent = new Intent(getApplicationContext(),DriverLogin.class);
        startActivity(intent);

    }
}

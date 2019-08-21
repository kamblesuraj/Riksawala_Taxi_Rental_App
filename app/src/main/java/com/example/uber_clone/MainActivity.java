package com.example.uber_clone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button cust_btn;
    Button driver_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cust_btn = findViewById(R.id.customer_btn);
        driver_btn = findViewById(R.id.driver_btn);
        mAuth = FirebaseAuth.getInstance();

        driver_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               open_driver_screen();
            }
        });



        cust_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_customer_screen();
            }
        });

        

    }

    void open_driver_screen()
    {
        Intent intent = new Intent(getApplicationContext(),DriverLogin.class);
        startActivity(intent);

    }
    void open_customer_screen()
    {
        Intent intent = new Intent(getApplicationContext(),customer_login.class);
        startActivity(intent);

    }

}

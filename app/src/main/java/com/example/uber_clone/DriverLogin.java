package com.example.uber_clone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DriverLogin extends AppCompatActivity {

    EditText driver_email;
    EditText driver_pass;
    Button login_btn;
    Button signup_btn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
        if (mAuth.getCurrentUser() != null) {
            // User is logged in
            Intent intent = new Intent(DriverLogin.this,Map_Driver.class);
            startActivity(intent);
            finish();
        }

        driver_email = findViewById(R.id.driver_email);
        driver_pass = findViewById(R.id.driver_pass);
        login_btn = findViewById(R.id.Login_btn);
        signup_btn = findViewById(R.id.signup_btn);

       //firebase authentication code
        mAuth = FirebaseAuth.getInstance();




        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(driver_email) || isEmpty(driver_pass)){
                    Toast.makeText(DriverLogin.this, "Email and password cannot be left  blank",Toast.LENGTH_SHORT).show();
                }


            }
        });



    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();

        return TextUtils.isEmpty(str);
    }


    }

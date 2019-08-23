package com.example.uber_clone;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.Driver;

public class DriverLogin extends AppCompatActivity {

    EditText driver_email;
    EditText driver_pass;
    Button login_btn;
    Button signup_btn;
    private FirebaseAuth mAuth;


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            Toast.makeText(DriverLogin.this, "Already LoggedIn as" + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DriverLogin.this, Map_Driver.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        driver_email = findViewById(R.id.driver_email);
        driver_pass = findViewById(R.id.driver_pass);
        login_btn = findViewById(R.id.Login_btn);
        signup_btn = findViewById(R.id.signup_btn);



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Login_Driver();

            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp_New_User();
            }
        });



    }

    private void Login_Driver() {
        if(isEmpty(driver_email) || isEmpty(driver_pass)){
            Toast.makeText(DriverLogin.this, "Email and password cannot be left  blank",Toast.LENGTH_SHORT).show();

        }
        final String dmail = driver_email.getText().toString().trim();
        final String dpass = driver_pass.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(dmail, dpass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();

                                Toast.makeText(DriverLogin.this, "Succesfully logged in" + user.getEmail(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DriverLogin.this, Map_Driver.class);
                                startActivity(intent);



                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(DriverLogin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }

    private void SignUp_New_User() {


        if(isEmpty(driver_email) || isEmpty(driver_pass)){
            Toast.makeText(DriverLogin.this, "Email and password cannot be left  blank",Toast.LENGTH_SHORT).show();
        }
        final String dmail = driver_email.getText().toString().trim();
        final String dpass = driver_pass.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(dmail, dpass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(DriverLogin.this,"Succesfully logged in"+user.getEmail(),Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(DriverLogin.this,Map_Driver.class);
                            startActivity(intent);


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(DriverLogin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();

        return TextUtils.isEmpty(str);
    }


}

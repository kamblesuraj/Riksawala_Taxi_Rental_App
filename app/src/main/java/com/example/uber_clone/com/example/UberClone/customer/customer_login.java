package com.example.uber_clone.com.example.UberClone.customer;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uber_clone.R;
import com.example.uber_clone.com.example.UberClone.driver.Map_Driver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class customer_login extends AppCompatActivity {

    private   EditText cust_email;
    private  EditText cust_pass;
    private   Button login_btn;
    private   Button signup_btn;
    private FirebaseAuth mAuth;


    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            Toast.makeText(customer_login.this, "Already LoggedIn as" + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(customer_login.this, Map_Driver.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(customer_login.this, Map_Driver.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };


        cust_email = findViewById(R.id.customer_email);
        cust_pass = findViewById(R.id.cust_pass);
        login_btn = findViewById(R.id.Login_btn);
        signup_btn = findViewById(R.id.signup_btn);



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(check() == true){
                    Toast.makeText(customer_login.this, "Enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    Login_Driver();
                }
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check() == true){
                    Toast.makeText(customer_login.this, "Enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    SignUp_New_User();
                }

            }
        });



    }

    private void Login_Driver() {
        final String dmail = cust_email.getText().toString().trim();
        final String dpass = cust_email.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(dmail, dpass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(customer_login.this, "Successfully logged in " + user.getEmail(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(customer_login.this, Map_Driver.class);
                            startActivity(intent);
                            finish();
                            return;

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(customer_login.this, "Incorrect Email or Password.",
                                    Toast.LENGTH_SHORT).show();


                        }

                    }
                });
    }

    private void SignUp_New_User() {
        final String dmail = cust_email.getText().toString().trim();
        final String dpass = cust_pass.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(dmail, dpass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("users").child("customer").child(user_id);
                            current_user_db.setValue(true);

                            Toast.makeText(customer_login.this,"Succesfully logged in"+user.getEmail(),Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(customer_login.this,Map_Driver.class);
                            startActivity(intent);
                            finish();



                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(customer_login.this, "Please enter Valid Email and Password.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    private boolean check(){
        String pass = cust_pass.getText().toString();
        String mail = cust_email.getText().toString();

        if(pass.length() == 0 || mail.length() == 0)
        {
            return  true;
        }else{
            return  false;
        }
    }

}

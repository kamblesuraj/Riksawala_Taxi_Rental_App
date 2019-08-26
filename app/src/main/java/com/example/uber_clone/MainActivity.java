package com.example.uber_clone;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private Button cust_btn;
  private   Button driver_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cust_btn = findViewById(R.id.customer_btn);
        driver_btn = findViewById(R.id.driver_btn);


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

   private  void open_driver_screen()
    {
        Intent intent = new Intent(MainActivity.this,DriverLogin.class);
        startActivity(intent);

    }
    private void open_customer_screen()
    {
        Intent intent = new Intent(MainActivity.this,customer_login.class);
        startActivity(intent);

    }

}

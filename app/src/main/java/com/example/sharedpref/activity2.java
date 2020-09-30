package com.example.sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity2 extends AppCompatActivity {
    public static final String DEFAULT="Nothing found";
    private TextView username,passwords;
    private Button load,previous;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_layout);

        username=(TextView)findViewById(R.id.username2);
        passwords=(TextView)findViewById(R.id.password2);
        load=(Button)findViewById(R.id.load);
        previous=(Button)findViewById(R.id.previous);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("information", Context.MODE_PRIVATE);
                String name = sharedPreferences.getString("name", DEFAULT);
                String password = sharedPreferences.getString("password", DEFAULT);

                if (name.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Data not found", Toast.LENGTH_LONG).show();
                } else
                {
                    Toast.makeText(getApplicationContext(),"Information succesfully loaded",Toast.LENGTH_LONG).show();
                    username.setText(name);
                    passwords.setText(password);

                }

            }
        });
    }
}

package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name,pass;
    private Button save,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.username);
        pass=(EditText)findViewById(R.id.password);
        save=(Button)findViewById(R.id.save);
        next=(Button)findViewById(R.id.next);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity2.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Username=name.getText().toString();
                String password=pass.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences("information", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",Username);
                editor.putString("password",password);
                editor.commit();
                Toast.makeText(getApplicationContext(),"You have succesfully saved",Toast.LENGTH_LONG).show();
            }
        });
    }
}
package com.example.swaahar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitClick(View view)
    {
        EditText un=(EditText)findViewById(R.id.username_text);
        EditText pwd=(EditText)findViewById(R.id.password_text);
        SharedPreferences sp;
        sp=getSharedPreferences("Login",MODE_PRIVATE);
        if(sp.getBoolean("LoggedIn",false))
        {
            startActivity(new Intent(this,MainActivity.class));
        }
        if(un.getText().toString().equalsIgnoreCase("Chandu") && pwd.getText().toString().equals("123")){
            Toast.makeText(this,"Login Success!",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,SecondActivity.class));
            sp.edit().putBoolean("LoggedIn",true).apply();
        }
        else{
            Toast.makeText(this, "Login Failed Please Try Again", Toast.LENGTH_LONG).show();
            un.setText("");
            pwd.setText("");
        }
    }

    public void registerClick(View view)
    {
        startActivity(new Intent(this,RegisterActivity.class));
        finish();
    }
}
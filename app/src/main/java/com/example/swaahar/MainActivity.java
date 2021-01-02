package com.example.swaahar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitClick(View view)
    {
        FirebaseAuth fauth;
        EditText un=(EditText)findViewById(R.id.username_text);
        EditText pwd=(EditText)findViewById(R.id.password_text);
        String username=un.getText().toString().trim();
        String pass_word=pwd.getText().toString().trim();
        fauth=FirebaseAuth.getInstance();
//        if(fauth.getCurrentUser()!= null)
//        {
//            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
//            finish();
//        }
//        fauth.createUserWithEmailAndPassword(username,pass_word).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task){
//                if(task.isSuccessful())
//                {
//                    Toast.makeText(MainActivity.this,"Login Succeeded!",Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
//                    finish();
//                }
//                else
//                {
//                    Toast.makeText(MainActivity.this,"Login Failed!!! Please Try Again",Toast.LENGTH_LONG).show();
//                    un.setText("");
//                    pwd.setText("");
//                }
//            }
//        });
//        else
        if(un.getText().toString().equalsIgnoreCase("Chandu") && pwd.getText().toString().equals("123")){
            Toast.makeText(this,"Login Success!",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }
    }

    public void registerClick(View view)
    {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    public void resetClick(View view)
    {
        EditText un=(EditText)findViewById(R.id.username_text);
        EditText pwd=(EditText)findViewById(R.id.password_text);
        if(un.getText().length()>0 || pwd.getText().length()>0)
        {
            un.setText("");
            pwd.setText("");
        }
        else
            Toast.makeText(this,"Fields Are Already Empty",Toast.LENGTH_SHORT).show();
    }
}
package com.example.arpit.sharebear;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        textView3=findViewById(R.id.textView3);
    }

    @SuppressLint("ShowToast")
    public void saveinfo(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",user.getText().toString());
        editor.putString("password",pass.getText().toString());
        editor.apply();

         Toast.makeText(this, "Saved!", Toast.LENGTH_LONG);

    }

    @SuppressLint("SetTextI18n")
    public void displayinfo(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("username","");
        String pw=sharedPreferences.getString("password","");

        textView3.setText(name + " " + pw);
    }
}

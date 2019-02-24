package com.example.rishad.myloginpagedemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signInButton,signUpButton;
    private EditText userNameEditText, passwordEditText;

    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton =(Button) findViewById(R.id.signInButtonId);
        signUpButton = (Button) findViewById(R.id.signUpButtonId);
        userNameEditText =(EditText) findViewById(R.id.usernameEditTextId);
        passwordEditText=(EditText) findViewById(R.id.passwordEditTextId);

        myDatabaseHelper = new MyDatabaseHelper(this);
       SQLiteDatabase sqLiteDatabase= myDatabaseHelper.getWritableDatabase();

       signUpButton.setOnClickListener(this);
       signInButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(v.getId()== R.id.signInButtonId){
            Boolean result = myDatabaseHelper.findPassword(username , password);

            if(result==true){
                Intent intent = new Intent(MainActivity.this,LoginSuccessfulActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),"User Name & Password didn't match.",Toast.LENGTH_SHORT).show();
            }



        }else if(v.getId()== R.id.signUpButtonId){

            Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
    }
}

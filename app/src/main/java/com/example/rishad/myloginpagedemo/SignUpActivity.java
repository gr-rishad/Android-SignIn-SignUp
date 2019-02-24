package com.example.rishad.myloginpagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText,emailEditText,usernameEditText,passwordEditText;
    private Button signUpButton;

    UserDetails userDetails;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = (EditText) findViewById(R.id.signUpNameEditTextId);
        emailEditText =(EditText) findViewById(R.id.signUpEmailEditTextId);
        usernameEditText =(EditText) findViewById(R.id.signUpUserNameEditTextId);
        passwordEditText =(EditText) findViewById(R.id.signUpPasswordEditTextId);
        signUpButton =(Button) findViewById(R.id.idSignUpButton);
        myDatabaseHelper = new MyDatabaseHelper(this);

        signUpButton.setOnClickListener(this);
        userDetails =new UserDetails();


    }

    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // set the data
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);


       long rowId= myDatabaseHelper.insertData(userDetails);

        if(rowId>0){
            Toast.makeText(getApplicationContext(),"Sign Up Successfully",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Sign up failed",Toast.LENGTH_SHORT).show();
        }
    }
}

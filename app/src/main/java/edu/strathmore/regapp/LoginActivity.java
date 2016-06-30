package edu.strathmore.regapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = (EditText) findViewById(R.id.edit_username);
        editPassword = (EditText) findViewById(R.id.edit_password);
    }

    public void clickListener(View view){
        int id = view.getId();
        switch (id){
            case R.id.bt_login:
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
//                if(username == null || username.equals("")){

                }
//                Toast.makeText(loginActivity.this, "Hello", Toast.LENGTH_SHORT).show();
        }

    public void login(View view){
        if (editUsername.getText().toString().equals("admin") && editPassword.getText().toString().equals("admin")){
//            Logic for correct password
            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, Home.class);
            startActivity(intent);
        } else {
//            Logic for incorrect passowrd
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(){

    }
}

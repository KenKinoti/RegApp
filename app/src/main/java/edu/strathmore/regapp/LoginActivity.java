package edu.strathmore.regapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsername, editPassword;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = (EditText) findViewById(R.id.edit_username);
        editPassword = (EditText) findViewById(R.id.edit_password);
        bt_login = (Button) findViewById(R.id.bt_login);
    }

    public void login(View view){
        int id = view.getId();
        switch (id){
            case R.id.tv_register:
//                Do something
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
                break;

            case R.id.bt_login:
                if (editUsername.getText().toString().equals("admin") && editPassword.getText().toString().equals("admin")){
//            Logic for correct password
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(LoginActivity.this, Home.class);
                    startActivity(homeIntent);
                } else {
//            Logic for incorrect passowrd
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
        }
    }

}

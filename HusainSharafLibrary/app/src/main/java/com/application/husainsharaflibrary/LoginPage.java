package com.application.husainsharaflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);
        Button reset = findViewById(R.id.reset);
        Button register = findViewById(R.id.register);

        final String myName = "Husain";
        final String myPass = "123";

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                if (myName.equals(name) && myPass.equals(pass)){
                    Toast.makeText(LoginPage.this,"Hello " + name,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginPage.this,"Wrong Username or Password",Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setText("");
                password.setText("");
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginPage.this,"Not Ready",Toast.LENGTH_LONG).show();
            }
        });

    }
}
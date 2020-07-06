package com.application.husainsharaflibrary.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.effect.Effect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.application.husainsharaflibrary.MainActivity;
import com.application.husainsharaflibrary.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private EditText mEmail_editText;
    private EditText mPassword_editText;

    private Button mSignIn_btn;
    private Button mRegister_btn;
    private Button mBack;

    private ProgressBar mProgress_bar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        mEmail_editText = findViewById(R.id.email_editText);
        mPassword_editText = findViewById(R.id.password_editText);

        mSignIn_btn = findViewById(R.id.signin_btn);
        mRegister_btn = findViewById(R.id.register_btn);
        mBack = findViewById(R.id.back_btn);

        mProgress_bar = findViewById(R.id.loading_progressBar);

        mSignIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty()){
                    return;
                }

                inProgress(true);

                mAuth.signInWithEmailAndPassword(mEmail_editText.getText().toString(),mPassword_editText.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(SignInActivity.this,"Sign in Done", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                                return;
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        inProgress(false);
                        Toast.makeText(SignInActivity.this,"Sign in Failed", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        mRegister_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty()){
                    return;
                }

                inProgress(true);

                mAuth.createUserWithEmailAndPassword(mEmail_editText.getText().toString(),mPassword_editText.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(SignInActivity.this,"Registration Done", Toast.LENGTH_LONG).show();
                                inProgress(false);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        inProgress(false);
                        Toast.makeText(SignInActivity.this,"Registration Failed", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                return;
            }
        });

    }

    private void inProgress(boolean x){
        if (x){
            mProgress_bar.setVisibility(View.VISIBLE);
            mSignIn_btn.setEnabled(false);
            mRegister_btn.setEnabled(false);
            mBack.setEnabled(false);
        }else{
            mProgress_bar.setVisibility(View.GONE);
            mSignIn_btn.setEnabled(true);
            mRegister_btn.setEnabled(true);
            mBack.setEnabled(true);
        }
    }

    private boolean isEmpty(){
        if (TextUtils.isEmpty(mEmail_editText.getText().toString())){
            mEmail_editText.setError("Required!");
            return true;
        }
        if (TextUtils.isEmpty(mPassword_editText.getText().toString())){
            mPassword_editText.setError("Required!");
            return true;
        }
        return false;
    }
}
package com.application.husainsharaflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ShowToast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_toast);

        // This line of code will show a pop up message using Toast
        Toast.makeText(ShowToast.this, "Toast Activity", Toast.LENGTH_LONG).show();
    }
}
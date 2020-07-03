package com.application.husainsharaflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this button will move u to the toast page
        Button showToast = findViewById(R.id.toast);
        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ShowToast.class);
                startActivity(i);
            }
        });

        final Button segmentControl = findViewById(R.id.segmentControl);
        segmentControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SegmentControl.class);
                i.putExtra("page",segmentControl.getText().toString());
                startActivity(i);
            }
        });

        Button loginPage = findViewById(R.id.loginPage);
        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginPage.class);
                startActivity(i);
            }
        });

        Button generatingPDF = findViewById(R.id.generatingPDF);
        generatingPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GeneratingPDF.class);
                startActivity(i);
            }
        });

        Button createHTML = findViewById(R.id.createHTML);
        createHTML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CreateHTML.class);
                startActivity(i);
            }
        });

        Button convertHTMLtoPDF = findViewById(R.id.convertHTMLtoPDF);
        convertHTMLtoPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConvertHTMLToPDF.class);
                startActivity(i);
            }
        });

        Button switcher = findViewById(R.id.switcher);
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Switcher.class);
                startActivity(i);
            }
        });

        Button roundImageView = findViewById(R.id.roundImageView);
        roundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RoundImageView.class);
                startActivity(i);
            }
        });

    }
}
package com.application.husainsharaflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bitvale.switcher.SwitcherC;
import com.bitvale.switcher.SwitcherX;

public class Switcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switcher);

        SwitcherC circle = findViewById(R.id.switcher_circle);
        SwitcherX square = findViewById(R.id.switcher_square);

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Switcher.this, "Old circle = " + circle.isChecked(), Toast.LENGTH_SHORT).show();
                circle.setChecked(!circle.isChecked(),true);
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Switcher.this, "Old square = " + square.isChecked(), Toast.LENGTH_SHORT).show();
                square.setChecked(!square.isChecked(),true);
            }
        });

    }
}
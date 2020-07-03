package com.application.husainsharaflibrary.Done;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.application.husainsharaflibrary.R;

public class SegmentControl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segment_control);

        Bundle bundle = getIntent().getExtras();
        String pageName = bundle.getString("page");

        Toast.makeText(SegmentControl.this, pageName, Toast.LENGTH_LONG).show();
    }
}
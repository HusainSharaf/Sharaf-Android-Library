package com.application.husainsharaflibrary.Done;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.application.husainsharaflibrary.R;

public class CreateHTML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_h_t_m_l);

        Button insert = findViewById(R.id.insertHTML);
        final WebView html = findViewById(R.id.html);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String htmlDocument = "<html><body><h1>HTML Created</h1><p>Testing, " +
                        "testing, testing...</p></body></html>";
                html.loadDataWithBaseURL(null, htmlDocument, "text/HTML", "UTF-8", null);
            }
        });

    }
}
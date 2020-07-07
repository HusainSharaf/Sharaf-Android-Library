package com.application.husainsharaflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ArrayOfImages extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_of_images);

        final ImageView imageView = findViewById(R.id.imageView);
        imageView.setClickable(false);

        final int[] pictures = {R.drawable.back,R.drawable.buo,R.drawable.devil,R.drawable.eveil};

        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(pictures[i]);
                i++;
                if (i==4)
                    i = 0;
            }
        });

    }
}
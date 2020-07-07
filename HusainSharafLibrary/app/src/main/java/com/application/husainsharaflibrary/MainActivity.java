package com.application.husainsharaflibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.husainsharaflibrary.Done.CreateHTML;
import com.application.husainsharaflibrary.Done.GeneratingPDF;
import com.application.husainsharaflibrary.Done.LoginPage;
import com.application.husainsharaflibrary.Done.RoundImageView;
import com.application.husainsharaflibrary.Done.RoundedCornerImageView;
import com.application.husainsharaflibrary.Done.SegmentControl;
import com.application.husainsharaflibrary.Done.ShowToast;
import com.application.husainsharaflibrary.Done.Switcher;
import com.application.husainsharaflibrary.Firebase.BookListAcitvity;
import com.application.husainsharaflibrary.Firebase.NewBookActivity;
import com.application.husainsharaflibrary.Firebase.RecyclerView_Config;
import com.application.husainsharaflibrary.Firebase.SignInActivity;
import com.application.husainsharaflibrary.UnderTesting.ConvertHTMLToPDF;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        RecyclerView_Config.logout();

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

        Button roundedCornerImageView = findViewById(R.id.roundedCornersImageView);
        roundedCornerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RoundedCornerImageView.class);
                startActivity(i);
            }
        });

        Button firebase = findViewById(R.id.firebase);
        firebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BookListAcitvity.class);
                startActivity(i);
            }
        });

        Button arrayOfImages = findViewById(R.id.arrayOfImages);
        arrayOfImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ArrayOfImages.class);
                startActivity(i);            }
        });

        Button firebaseAddBook = findViewById(R.id.firebase_add_book);
        firebaseAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewBookActivity.class);
                startActivity(i);
            }
        });

        Button login = findViewById(R.id.firebaseLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(i);
            }
        });

        Button logout = findViewById(R.id.firebaseLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                RecyclerView_Config.logout();

                FirebaseUser user = mAuth.getCurrentUser();

                if (user != null){
                    firebaseAddBook.setVisibility(View.VISIBLE);
                    logout.setVisibility(View.VISIBLE);
                }else {
                    firebaseAddBook.setVisibility(View.GONE);
                    logout.setVisibility(View.GONE);
                }
            }
        });

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null){
            firebaseAddBook.setVisibility(View.VISIBLE);
            logout.setVisibility(View.VISIBLE);
        }else {
            firebaseAddBook.setVisibility(View.GONE);
            logout.setVisibility(View.GONE);
        }

    }
}
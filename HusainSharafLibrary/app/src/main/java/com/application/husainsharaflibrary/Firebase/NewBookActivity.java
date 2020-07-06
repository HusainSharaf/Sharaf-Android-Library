package com.application.husainsharaflibrary.Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.application.husainsharaflibrary.R;

import java.util.List;

public class NewBookActivity extends AppCompatActivity {

    private EditText mAuthor_editText;
    private EditText mTitle_editText;
    private EditText mISBN_editText;
    private Spinner mBook_categories_spinner;
    private Button mAdd_btn;
    private Button mBack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);

        mAuthor_editText = findViewById(R.id.author_editText);
        mTitle_editText = findViewById(R.id.title_editText);
        mISBN_editText = findViewById(R.id.isbn_editText);

        mBook_categories_spinner = findViewById(R.id.category_list_spinner);

        mAdd_btn = findViewById(R.id.add_btn);
        mBack_btn = findViewById(R.id.back_btn);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setTitle(mTitle_editText.getText().toString());
                book.setAuthor(mAuthor_editText.getText().toString());
                book.setIsbn(mISBN_editText.getText().toString());
                book.setCategory_name(mBook_categories_spinner.getSelectedItem().toString());

                new FirebaseDatabaseHelper().addBook(book, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Book> books, List<String> keys) {
                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewBookActivity.this, "Book inserted",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

            }
        });

        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                return;
            }
        });


    }
}
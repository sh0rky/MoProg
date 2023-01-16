package com.example.projectnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText  book_title , author ,publish_year, book_rating;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        book_title = findViewById(R.id.book_title);
        author = findViewById(R.id.author);
        publish_year = findViewById(R.id.publish_year);
        add_button = findViewById(R.id.add_button);
        book_rating = findViewById(R.id.book_rating);

        add_button.setOnClickListener(view -> {
            MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
            myDB.addBook(book_title.getText().toString().trim(),
                        author.getText().toString().trim(),
                        Integer.valueOf(publish_year.getText().toString().trim()),
                        Integer.valueOf(book_rating.getText().toString().trim()));

        });
    }
}
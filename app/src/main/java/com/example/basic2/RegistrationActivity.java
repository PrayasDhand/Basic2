package com.example.basic2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

private final DatabaseHelper dbHelper = new DatabaseHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_page);


        EditText nameEditText = findViewById(R.id.edText1);
        EditText emailEditText = findViewById(R.id.editText2);
        EditText passwordEditText = findViewById(R.id.editText3);
        EditText contactEditText = findViewById(R.id.editText4);


        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String contact = contactEditText.getText().toString();



        Driver driver = new Driver(0,name,email,password,contact);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name",driver.getName());
        values.put("email",driver.getEmail());
        values.put("password",driver.getPassword());
        values.put("contact",driver.getContact());
        db.insert("Drivers",null,values);
        db.close();
    }
}

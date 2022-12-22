package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn1;
    EditText nama, univnama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = new Database(this);
        nama = findViewById(R.id.nama);
        univnama = findViewById(R.id.univ);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into mahasiswa(nama, kampus) values('" +
                        nama.getText().toString() + "', '" +
                        univnama.getText().toString() + "')");
                Toast.makeText(CreateActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}
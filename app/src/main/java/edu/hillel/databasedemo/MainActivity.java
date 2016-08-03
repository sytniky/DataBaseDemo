package edu.hillel.databasedemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etAdress;
    private Button btnRead, btnWrite;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.tvName);
        etAdress = (EditText) findViewById(R.id.tvAdress);

        btnRead = (Button) findViewById(R.id.btnReadDB);
        btnWrite = (Button) findViewById(R.id.btnWriteDB);

        dbHelper = new DatabaseHelper(this);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeData();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData();
            }
        });
    }

    private void writeData() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBContract.Customer.COLUMN_NAME, etName.getText().toString());
        cv.put(DBContract.Customer.COLUMN_AGE, (int) (Math.random() * 90 + 18));
        cv.put(DBContract.Customer.COLUMN_ADRESS, etAdress.getText().toString());
        db.insert(DBContract.Customer.TABLE_NAME, null, cv);
        db.close();
//        etName.setText("");
//        etAdress.setText("");
        etName.setSelection(0, etName.getText().length());
    }

    private void readData() {
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor c = db.query("customer", new String[]{"_id", "name", "adress"}, null, null, null, null, null);
//        while (c.moveToNext()) {
//            long id = c.getLong(c.getColumnIndex("_id"));
//            String name = c.getString(c.getColumnIndex("name"));
//            String adress = c.getString(c.getColumnIndex("adress"));
//            Log.d("database", id + " " + name + " " + adress);
//        }

        startActivity(new Intent(this, CustomersActivity.class));
    }
}

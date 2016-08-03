package edu.hillel.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yuriy on 27.07.16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, DBContract.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + DBContract.Customer.TABLE_NAME + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DBContract.Customer.COLUMN_NAME + " TEXT,"
                + DBContract.Customer.COLUMN_AGE + " INTEGER,"
                + DBContract.Customer.COLUMN_ADRESS + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

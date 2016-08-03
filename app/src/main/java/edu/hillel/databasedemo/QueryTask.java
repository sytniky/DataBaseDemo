package edu.hillel.databasedemo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

/**
 * Created by yuriy on 03.08.16.
 */
public class QueryTask extends AsyncTask<Void, Void, Cursor> {

    private Activity mParentActivity;

    public QueryTask(Activity parent) {
        mParentActivity = parent;
    }

    @Override
    protected Cursor doInBackground(Void... voids) {

        DatabaseHelper mDbHelper = new DatabaseHelper(mParentActivity);
        SQLiteDatabase mDb = mDbHelper.getReadableDatabase();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mDb.query(DBContract.Customer.TABLE_NAME,
                DBContract.Customer.DEFAULT_PROJECTION,
                DBContract.Customer.COLUMN_AGE + " BETWEEN ? AND ?",
                new String[] {"30", "60"},
                null,
                null,
                null);
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
        if (mParentActivity instanceof CustomersActivity) {
            ((CustomersActivity) mParentActivity).setCursor(cursor);
        }
    }
}

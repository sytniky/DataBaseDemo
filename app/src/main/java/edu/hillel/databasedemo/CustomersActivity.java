package edu.hillel.databasedemo;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by yuriy on 31.07.16.
 */
public class CustomersActivity extends ListActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private MyCursorAdapter mAdapter;
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDbHelper = new DatabaseHelper(this);
        mDb = mDbHelper.getReadableDatabase();
        Cursor cursor = getData();

        mAdapter = new MyCursorAdapter(this, cursor, false);
        setListAdapter(mAdapter);
        getListView().setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        int n = db.delete(DBContract.Customer.TABLE_NAME, DBContract.Customer._ID + " = " + id, null);
        Log.d("CustomersActivity", "delate rows: " + n);
        mAdapter.changeCursor(getData());
        mAdapter.notifyDataSetChanged();
        return true;
    }

    private Cursor getData() {
        return  mDb.query(DBContract.Customer.TABLE_NAME, DBContract.Customer.DEFAULT_PROJECTION, null, null, null, null, null);
    }
}

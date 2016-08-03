package edu.hillel.databasedemo;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;

/**
 * Created by yuriy on 31.07.16.
 */
public class CustomersActivity extends ListActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private MyCursorAdapter mAdapter;
    private SimpleCursorAdapter mSimpleCursorAdapter;
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    private ProgressBar mProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customers);

        mProgressBar = (ProgressBar) findViewById(R.id.pbProgress);

        mDbHelper = new DatabaseHelper(this);
        mDb = mDbHelper.getReadableDatabase();
        mSimpleCursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                null,
                new String[]{DBContract.Customer.COLUMN_NAME, DBContract.Customer.COLUMN_AGE},
                new int[]{android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_AUTO_REQUERY);

        new QueryTask(this).execute();

//        Cursor cursor = getData();
//        mAdapter = new MyCursorAdapter(this, cursor, false);
        setListAdapter(mSimpleCursorAdapter);
        getListView().setOnItemLongClickListener(this);
    }

    public void setCursor(Cursor cursor) {
        mSimpleCursorAdapter.changeCursor(cursor);
        mProgressBar.setVisibility(View.GONE);
        getListView().setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {

//        SQLiteDatabase db = mDbHelper.getReadableDatabase();
//        int n = db.delete(DBContract.Customer.TABLE_NAME, DBContract.Customer._ID + " = " + id, null);
//        Log.d("CustomersActivity", "delete rows: " + n);
////        mAdapter.changeCursor(getData());
////        mAdapter.notifyDataSetChanged();
//        mSimpleCursorAdapter.changeCursor(getData());
//        mSimpleCursorAdapter.notifyDataSetChanged();
        return true;
    }

//    private Cursor getData() {
//        return mDb.query(DBContract.Customer.TABLE_NAME,
//                DBContract.Customer.DEFAULT_PROJECTION,
//                DBContract.Customer.COLUMN_AGE + " BETWEEN ? AND ?",
//                new String[] {"30", "60"},
//                null,
//                null,
//                null);
//    }
}

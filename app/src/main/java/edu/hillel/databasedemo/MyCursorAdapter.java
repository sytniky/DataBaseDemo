package edu.hillel.databasedemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by yuriy on 31.07.16.
 */
public class MyCursorAdapter extends CursorAdapter {

    private LayoutInflater mInflater;

    public MyCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = mInflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        String customerName = cursor.getString(cursor.getColumnIndex("name"));
        TextView tv = (TextView) v.findViewById(android.R.id.text1);
        tv.setText(customerName);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String customerName = cursor.getString(cursor.getColumnIndex("name"));
        TextView tv = (TextView) view.findViewById(android.R.id.text1);
        tv.setText(customerName);
    }
}

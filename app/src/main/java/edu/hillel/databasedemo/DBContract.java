package edu.hillel.databasedemo;

import android.provider.BaseColumns;

/**
 * Created by yuriy on 31.07.16.
 */
public final class DBContract {

    public static final String DB_NAME = "MyDatabase";

    public static final class Customer implements BaseColumns {

        public static final String TABLE_NAME = "customer";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ADRESS = "adress";

        public static final String[] DEFAULT_PROJECTION = {_ID, COLUMN_NAME, COLUMN_ADRESS};
    }
}

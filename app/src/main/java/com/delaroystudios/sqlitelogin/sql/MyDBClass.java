package com.delaroystudios.sqlitelogin.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDBClass extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "queuedatabase";

    // Table Name
    public static final String TABLE_Q = "vegetabledisease";
    //column ID


    public MyDBClass (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_Q + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                ",name TEXT," +
                "phone TEXT," +
                "date TEXT,"+
                "category TEXT,"+
                "time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Q);
        // Re Create on method  onCreate
        onCreate(db);
    }



    // Show All Data
    public ArrayList<HashMap<String, String>> SelectAllData() {

        try {

            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_Q;
            Cursor cursor = db.rawQuery(strSQL, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        map = new HashMap<String, String>();
                        map.put("id", cursor.getString(0));
                        map.put("name", cursor.getString(1));
                        map.put("phone", cursor.getString(2));
                        map.put("date", cursor.getString(3));
                        map.put("category", cursor.getString(4));
                        map.put("time", cursor.getString(5));

                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;

        } catch (Exception e) {
            return null;
        }

    }

    // Update Data
    public long UpdateData(String strVegdisID, String strVegdisName, String strVegdisArea,String strVegdisType) {

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data

            ContentValues Val = new ContentValues();
            Val.put("vegdis_name", strVegdisName);
            Val.put("vegdis_area", strVegdisArea);
            Val.put("vegdis_type", strVegdisType);


            long rows = db.update(TABLE_Q, Val, " vegdis_id = ?",
                    new String[]{String.valueOf(strVegdisID)});

            db.close();
            return rows; // return rows updated.

        } catch (Exception e) {
            return -1;
        }

    }

    // Delete Data
    public long DeleteData(String strVegdisID) {
        // TODO Auto-generated method stub

        try {

            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data


            long rows = db.delete(TABLE_Q, "vegdis_id = ?",
                    new String[]{String.valueOf(strVegdisID)});

            db.close();
            return rows; // return rows deleted.

        } catch (Exception e) {
            return -1;
        }

    }


    public long InsertData(String Name, String phone, String date, String category, String time) {


        try {


            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data


            ContentValues Val = new ContentValues();
            Val.put("name", Name);
            Val.put("phone", phone);
            Val.put("date", date);
            Val.put("category", category);
            Val.put("time", time);


            long rows = db.insert(TABLE_Q, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }
    public String[] SelectData(String strVegdisID) {
        try {
            String arrData[] = null;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            Cursor cursor = db.query(TABLE_Q, new String[]{"*"},
                    "id=?",
                    new String[]{String.valueOf(strVegdisID)}, null, null, null, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        arrData = new String[cursor.getColumnCount()];
                        /***
                         *  0 = vegdis_id
                         *  1 = vegdis_name
                         *  2 = vegdis_area
                         *  3 = vegdis_type
                         *  4 = vegdis_cause
                         *  5 = vegdis_syndrome
                         *  6 = vegdis_syndrome2
                         *  7 = vegdis_remedy
                         */
                        arrData[0] = cursor.getString(0);
                        arrData[1] = cursor.getString(1);
                        arrData[2] = cursor.getString(2);
                        arrData[3] = cursor.getString(3);
                        arrData[4] = cursor.getString(4);
                        arrData[5] = cursor.getString(5);
                        arrData[6] = cursor.getString(6);
                        arrData[7] = cursor.getString(7);
                    } while (cursor.moveToNext());
                }
            }

            cursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }




    }



}


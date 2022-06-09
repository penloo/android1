package com.example.smash;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    static  final String DATABASE_NAME = "test.db";

    public DBHelper(Context context, int version){
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Person(name TEXT, Age INT, ADDR TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Person");
        onCreate(db);
    }

    public void Insert(String School, String Name, String PassWord){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Person VALUES('"+ School + "', " + Name + ", '"+ PassWord + "')");
        db.close();
    }

    public void Update(String School, String Name, String PassWord){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Person SET School = " + School + ", PassWord = '" + PassWord + "'" + " WHERE NAME = '" + Name + "'");
    }

    public void Delete(String Name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE Person WHERE NAME = '" + Name + "'");
        db.close();
    }

    public String getResult(){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM Person", null);
        while(cursor.moveToNext()){
            result += "학교 : " + cursor.getString(0)
                    + ", 이름 : "
                    + cursor.getString(1)
                    + ", 비밀번호 : "
                    + cursor.getString(2)
                    +"\n";
        }
        return result;
    }

}

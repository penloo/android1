package com.example.smash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Login) {
        Login.execSQL("create Table users(school TEXT, user TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Login, int oldVersion, int newVersion) {
        Login.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String school, String user, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("school", school);
        contentValues.put("user", user);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkusernamepassword(String school, String user, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where school = ? and user = ? and password = ?", new String[]{school, user, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
/*
    public static final String DBNAME = "Login.db";

    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(school TEXT, user TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String school, String user, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("school", school);
        contentValues.put("user", user);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String school, String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where school = ? and user = ? and password = ?", new String[] {school,user,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }*/

/*
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
*/

}

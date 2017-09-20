package com.example.sqlite_demo.contract;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 29-06-2017.
 */

public class MovieContract {

    private final Helper helper;
    Context context;

    public MovieContract(Context context){
        this.context=context;
        helper=new Helper(context);

    }
    public long add(String name,int year,double rating,String studio){

        SQLiteDatabase db=helper.getWritableDatabase();

        //content values is telling that COL_MOVIE me movie ka name jaega etc.
        ContentValues values=new ContentValues();
        values.put(Constants.COL_MOVIE,name);
        values.put(Constants.COL_YEAR,year);
        values.put(Constants.COL_RATING,rating);
        values.put(Constants.COL_STUDIO,studio);

        return  db.insert(Constants.TBL_MOVIES,null,values);
        //first tell table name,then in nullcolumn always pass null,then the values

    }

    public Cursor list(){

        SQLiteDatabase db=helper.getReadableDatabase();
        return db.query(Constants.TBL_MOVIES,null,null,null,null,null,null);
    }

    public int deleteById(String id){

        SQLiteDatabase db=helper.getWritableDatabase();
        String where=Constants.COL_ID+"=?"; //"_id=?"
        String[] whereArgs=new String[]{id};
        return db.delete(Constants.TBL_MOVIES,where,whereArgs);
    }

    public int updateById(String whuchId,String name,int year,double rating,String studio){
        SQLiteDatabase db=helper.getWritableDatabase();
        String where=Constants.COL_ID+"=?";
        String[] whereArgs=new String[]{whuchId};
        ContentValues values=new ContentValues();
        values.put(Constants.COL_MOVIE,name);
        values.put(Constants.COL_YEAR,year);
        values.put(Constants.COL_RATING,rating);
        values.put(Constants.COL_STUDIO,studio);

        return db.update(Constants.TBL_MOVIES,values,where,whereArgs);


    }
    //inner class
    class Helper extends SQLiteOpenHelper{

        public Helper(Context context) {
            super(context, Constants.DB_NAME,null, Constants.DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String creationQueryMovies="CREATE TABLE movies("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"movie VARCHAR(255),year INTEGER, rating DOUBLE,studio VARCHAR(50)"+")";

            db.execSQL(creationQueryMovies);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            String dropQueryMovies="DROP TABLE IF EXISTS movies";
            db.execSQL(dropQueryMovies);
            onCreate(db);

        }
    }



   public interface Constants{
        public static final String TBL_MOVIES="movies";
        public static final String COL_ID="_id";
        public static final String COL_MOVIE="movie";
        public static final String COL_YEAR="year";
        public static final String COL_RATING="rating";
        public static final String COL_STUDIO="studio";
        public static final String DB_NAME="mydb";
        public static final int DB_VERSION=2;
    }
}

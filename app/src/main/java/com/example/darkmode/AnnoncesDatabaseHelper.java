package com.example.darkmode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AnnoncesDatabaseHelper extends SQLiteOpenHelper {
    // Database Info
    private static final String DATABASE_NAME = "dbAnnonces";
    private static final int DATABASE_VERSION = 2;

    // Table Names
    private static final String TABLE_ANNONCES = "annonces";

    // Post Table Columns
    //private static final int KEY_ANNONCES_ID = "id";
//    private static final String KEY_ANNONCES_TITLE = "title";
//    private static final int KEY_ANNONCES_PRICE = "price";
//    private static final String KEY_ANNONCES_DESCRIPTION = "description";
//    private static final String KEY_ANNONCES_DATE_PUBLICATION = "datePublication";
//    private static final String KEY_ANNONCES_DATE_FIN_PUBLICATION = "dateFinPublication";
//    private static final String KEY_ANNONCES_DATE_CREATION = "dateCreation";
//    private static final String KEY_ANNONCES_MODIFICATION = "dateModification";

    public AnnoncesDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANNONCES);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ANNNONCES_TABLE = " CREATE TABLE " + TABLE_ANNONCES +
                "(" +
                "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," + // Define a primary key
                "title" + " TEXT," +
                "price" + " INT," +
                "description" + " TEXT," +
                "date_publication" + " DATE," +
                "date_fin_publication" + " DATE," +
                "date_creation" + " DATE," +
                "date_modification" + " DATE" +
                ")";

        db.execSQL(CREATE_ANNNONCES_TABLE);
    }

    //public void addNewAnnonce(String title, Integer price, String description, String datePublication) {

        //SQLiteDatabase db = this.getWritableDatabase();
        //ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        //values.put(KEY_ANNONCES_TITLE, title);
        //values.put(KEY_ANNONCES_PRICE, price);
        //values.put(KEY_ANNONCES_DESCRIPTION, description);
        //values.put(KEY_ANNONCES_DATE_PUBLICATION, datePublication);
        //values.put(KEY_ANNONCES_DATE_FIN_PUBLICATION, dateFinPublication);

        // after adding all values we are passing
        // content values to our table.
        //db.insert(TABLE_ANNONCES, null, values);

        // at last we are closing our
        // database after adding database.
      //  db.close();
    //}

    public boolean addNewAnnonce(Annonces annonce){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        long res;
        // on below line we are passing all values
        // along with its key and value pair.
        values.put("title", annonce.getTitle());
        values.put("price", annonce.getPrice());
        values.put("description", annonce.getDescription());
        values.put("date_publication", annonce.getDatePublication());
        values.put("date_fin_publication", annonce.getDateFinPublication());

        res = db.insert(TABLE_ANNONCES, null, values);
        if(res > -1 ) {
            return true;
        }else{
            return false;
        }
    }

    // we have created a new method for reading all the courses.
    public ArrayList<Annonces> readCourses()
    {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database.
        Cursor cursorAnnonces
                = db.rawQuery("SELECT * FROM " + TABLE_ANNONCES, null);

        // on below line we are creating a new array list.
        ArrayList<Annonces> AnnoncesArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorAnnonces.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                AnnoncesArrayList.add(new Annonces(
                        cursorAnnonces.getString(1),
                        cursorAnnonces.getInt(2),
                        cursorAnnonces.getString(3),
                        cursorAnnonces.getString(4),
                        cursorAnnonces.getString(5)));
            } while (cursorAnnonces.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorAnnonces.close();
        return AnnoncesArrayList;
    }
}

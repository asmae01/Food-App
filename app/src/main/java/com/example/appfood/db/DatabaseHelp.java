package com.example.appfood.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appfood.model.Recettes;

import java.io.FileInputStream;
import java.util.ArrayList;

public class DatabaseHelp extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelp";

    private Context context;

    public static final String databaseName = "Database.db";
    public static final int databaseVersion = 1;

    public DatabaseHelp(@Nullable Context context) {
        super(context, databaseName, null, databaseVersion);
        this.context = context;
    }

    public DatabaseHelp(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //creation de table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists Recettes (id integer primary key autoincrement," +
                "name text not null, descrition text, type text, image Integer, calorie Integer, temps_de_preparation integer, nombre_d_ingrediant integer, fav integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Recettes");
        onCreate(sqLiteDatabase);
    }

    public void AddRecettes(Recettes data) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("name",data.getName());
        contentValues.put("descrition",data.getDescrition());
        contentValues.put("type",data.getType());
        contentValues.put("image",data.getImage());
        contentValues.put("calorie",data.getCalorie());
        contentValues.put("temps_de_preparation",data.getTemps_de_preparation());
        contentValues.put("nombre_d_ingrediant",data.getNombre_d_ingrediant());
        contentValues.put("fav",data.getFav());

        long table = sqLiteDatabase.insert("Recettes", null, contentValues);
        Log.e(TAG,"insertion des donnes: " +table);

    }

    public ArrayList<Recettes> readAllRecettes(){
        ArrayList<Recettes> result = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c;
        c = sqLiteDatabase.rawQuery("select * from Recettes",null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            result.add(getModel(c));
            c.moveToNext();
        }
        return result;
    }
    /*public void deleteAllResReceipe(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL("delete from reservations");

    }
    public void deleteBook(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int isDeleted = sqLiteDatabase.delete("books", "id=?", new String[]{Integer.toString(id)});
        if (isDeleted==-1) Log.e(TAG,"Failed to delete book with id "+id);
        else Log.e(TAG,"Book with id "+id+" Succefully deleted");
    }*/



    public ArrayList<Recettes> readFavoritesRecettes(){
        ArrayList<Recettes> result = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c;
        c = sqLiteDatabase.rawQuery("select * from Recettes where fav = 1",null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            result.add(getModel(c));
            c.moveToNext();
        }
        return result;
    }

    public Recettes getRecettesi(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("select * from Recettes where id="+id,null);
        if (c!=null) c.moveToFirst();
        return getModel(c);
    }

    @NonNull
    private Recettes getModel(Cursor c) {
        Recettes recettes = new Recettes();
        recettes.setId(c.getInt(0));
        recettes.setName(c.getString(1));
        recettes.setDescrition(c.getString(2));
        recettes.setType(c.getString(3));
        recettes.setImage(c.getInt(4));
        recettes.setCalorie(c.getInt(5));
        recettes.setTemps_de_preparation(c.getInt(6));
        recettes.setNombre_d_ingrediant(c.getInt(7));
        recettes.setFav((c.getInt(8)==0? false:true));

        return recettes;
    }


    public void addToFavorites(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Recettes recettes = getRecettesi(id);
        contentValues.put("fav",1);
        int updatedRow = sqLiteDatabase.update("Recettes", contentValues, "id=?", new String[]{Integer.toString(id)});
        if (updatedRow==-1) Log.e(TAG,"Failed to update Recettes with id "+id);
        else Log.e(TAG,"Recetts with id "+id+" Succefully updated");
    }
    public void removeFromFavorites(int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Recettes recettes = getRecettesi(id);
        contentValues.put("fav",0);
        int updatedRow = sqLiteDatabase.update("Recettes", contentValues, "id=?", new String[]{Integer.toString(id)});
        if (updatedRow==-1) Log.e(TAG,"Failed to update Recettes with id "+id);
        else Log.e(TAG,"Recettes with id "+id+" Succefully updated");
    }

/*    public ArrayList<Recettes> getSearch(String search){
        String searchText = "'%"+search +"%'";
        ArrayList<Recettes> searchResult = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "select * from books where title like "+searchText+" or author like "+searchText+" " +
                "or category like "+searchText+" or description like "+searchText+" ;";
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            searchResult.add(getModel(c));
            c.moveToNext();
        }
        return searchResult;
    }*/

    public Boolean insertImage(String fileLoc){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileLoc);
            byte[] imgbyte = new byte[fileInputStream.available()];
            ContentValues contentValues = new ContentValues();
            contentValues.put("title","titre");
            contentValues.put("author","auteur");
            contentValues.put("category","caegorie");
            contentValues.put("description","description");
            contentValues.put("price","prix");
            contentValues.put("favorite",0);
            contentValues.put("image",imgbyte);
            sqLiteDatabase.insert("books",null,contentValues);
            fileInputStream.close();
            Log.e(TAG,"insertion d'image : ");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            Log.e(TAG,"insertion d'image failed");
            return false;
        }
    }


}
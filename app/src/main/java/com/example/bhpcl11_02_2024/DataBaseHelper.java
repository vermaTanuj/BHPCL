package com.example.bhpcl11_02_2024;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {
        super(context, "tanujdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_Table_Query="create table productTable(id INTEGER primary key autoincrement not null unique,p_name text not null unique ,unit_cost  text not null check(unit_cost>0),quantity  text not null  check(quantity>0))";


        db.execSQL(create_Table_Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists productTable");
        onCreate(db);
    }

    ///////////////////////////////////////////////////
    //adding products in product table:-
    public boolean addProductHelper(String product_name, String unit_cost,String quantity){

        //Values insertion in database:-
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        //values in one pair:-
        ContentValues cuntentValues=new ContentValues();
        cuntentValues.put("p_name",product_name);
        cuntentValues.put("unit_cost",unit_cost);
        cuntentValues.put("quantity",quantity);
        long l= sqLiteDatabase.insert("productTable",null,cuntentValues);

        sqLiteDatabase.close();


        if(l>0){
            return true;
        }else{
            return false;}

    }


    //to display in recycle view:-
    public Cursor getdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from productTable",null);
        return cursor;
//here we returned the entire table throwgh cursor:-
    }






//Find in data base{
    public boolean findInDataBase(String p_name){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String que="select * from productTable where p_name='"+p_name+"'";

        Cursor c=sqLiteDatabase.rawQuery(que,null);
        if(c.moveToFirst()){
           return true;
        }
        else {
            return false;
        }
    }




    //Delete from data base:-
    public boolean deleteFromDataBase(String p_name){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
       int i= sqLiteDatabase.delete("productTable","p_name=?",new String[]{p_name});

        if (i > 0) {
            return true;
        } else {
            return false;
        }

    }

///////////////////////////////////
   // Update profilee
public boolean updateProfile(String product_name,String  unit_cost,String quontity){
    SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();


    ContentValues cv=new ContentValues();
    cv.put("p_name",product_name);
    cv.put("unit_cost",unit_cost);
    cv.put("quantity",quontity);

    int i=  sqLiteDatabase.update("productTable",cv,"p_name=?",new String[]{product_name});
    if(i>0){
        return true;
    }
    else{
        return false;
    }
}
}

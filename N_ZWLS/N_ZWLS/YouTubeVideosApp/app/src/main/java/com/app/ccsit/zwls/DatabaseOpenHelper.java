package com.app.ccsit.zwls;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {

    public DatabaseOpenHelper(Context context){

        super (context, "ZWLS.db",null,null,1);

    }
}

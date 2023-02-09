package com.app.ccsit.zwls;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Addpage extends AppCompatActivity {

    Button add;
    private DatabaseOpenHelper dbHelper;
    private SQLiteDatabase database;
    private int originalQuantity;
    private EditText editText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);
        editText = findViewById(R.id.quantity);

        add = findViewById(R.id.Ok);

        Intent i = getIntent();

        final String title = i.getStringExtra("title");

        ImageView image = findViewById(R.id.imageView);

        int resourceId = getApplicationContext().getResources().getIdentifier(title, "drawable",
                getApplicationContext().getPackageName());

        Drawable drawable = getApplicationContext().getResources().getDrawable(resourceId);

        image.setImageDrawable(drawable);

        dbHelper = new DatabaseOpenHelper(this);
        database = dbHelper.getWritableDatabase();


        Cursor cursor = database.rawQuery("select quantity from Recycle where title = ?",
                new String[] {title});
        cursor.moveToFirst();

        originalQuantity = cursor.getInt(0);

        editText.setHint(originalQuantity+"");


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int enteredQuantity;
                String entered = editText.getText().toString();
                if(entered.equals("")){
                    enteredQuantity = 0;
                }else{

                    enteredQuantity = Integer.parseInt(editText.getText().toString());
                }
                int newQuantity = originalQuantity + enteredQuantity;

                // Add to database
                // Create the database and store the values in the events table
                ContentValues contentValues = new ContentValues();
                contentValues.put("quantity", newQuantity);
                System.out.println("Safa "+newQuantity);
                database.update("Recycle",contentValues, "title = ?",new String[]{title});

                Intent i = new Intent(getApplicationContext(), ChartActivity.class);
                startActivity(i);
            }
        });



    }
}

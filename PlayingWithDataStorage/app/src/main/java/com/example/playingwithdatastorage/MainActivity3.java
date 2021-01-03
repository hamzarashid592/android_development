package com.example.playingwithdatastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {


    EditText username, password, selection,update;
    Button submit;
    Button showAll, showSelection, deleteSelection,updateSelection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        selection=findViewById(R.id.selection);
        selection=findViewById(R.id.selection);
        update=findViewById(R.id.update);

        submit=findViewById(R.id.submit);
        showAll=findViewById(R.id.showAll);
        showSelection=findViewById(R.id.showSelection);
        deleteSelection=findViewById(R.id.deleteSelection);
        updateSelection=findViewById(R.id.updateSelection);


        dbHelper helper= new dbHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase(); //Database is created here..! onCreate called on this.
        //We are converting the schema defined in the dbHelper class to a physical database.


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues= new ContentValues();
                contentValues.put(helper.NAME,username.getText().toString());
                contentValues.put(helper.PASSWORD,password.getText().toString());
                long ret=db.insert(helper.TABLE_NAME,null,contentValues);
                Log.d("hamza","Added row "+ret);

            }
        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String columns[]={helper.UID,helper.NAME,helper.PASSWORD};

                Cursor cursor= db.query(helper.TABLE_NAME,columns,null,null,null,null,null,null);
                while (cursor.moveToNext()){ //Iterating each row of the returned data.
                    Log.d("hamza","UID "+cursor.getInt(cursor.getColumnIndex(helper.UID))+" NAME "+
                            cursor.getString(cursor.getColumnIndex(helper.NAME))+
                            " PASSWORD "+cursor.getString(cursor.getColumnIndex(helper.PASSWORD)));
                }
            }
        });
        showSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String columns[]={helper.UID,helper.NAME,helper.PASSWORD};

                Cursor cursor= db.query(helper.TABLE_NAME,columns,helper.NAME+"=?",new String[]{selection.getText().toString()},
                        null,null,null,null);

                while (cursor.moveToNext()){ //Iterating each row of the returned data.
                    Log.d("hamza","UID "+cursor.getInt(cursor.getColumnIndex(helper.UID))+" NAME "+
                            cursor.getString(cursor.getColumnIndex(helper.NAME))+
                            " PASSWORD "+cursor.getString(cursor.getColumnIndex(helper.PASSWORD)));
                }
            }
        });

        deleteSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ret=db.delete(helper.TABLE_NAME,helper.NAME+"=?",new String[]{selection.getText().toString()});// the delete query.
                Log.d("hamza",ret+" Rows affected.");
            }
        });

        updateSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues= new ContentValues();
                contentValues.put(helper.NAME,update.getText().toString()); //To tell which column to update.
                int ret=db.update(helper.TABLE_NAME,contentValues,helper.NAME+"=?",new String[]{selection.getText().toString()});
                Log.d("hamza",ret+" Rows affected."); //The update query.
            }
        });
    }
}
package com.example.playingwithdatastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    Button saveInternalCache, saveExternalCache, saveExternalStorage, savePublicExternalStorage;
    Button loadInternalCache, loadExternalCache, loadExternalStorage, loadPublicExternalStorage;
    EditText saveText, loadText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        saveInternalCache=findViewById(R.id.saveInternalCache);
        saveExternalCache=findViewById(R.id.saveExternalCache);
        saveExternalStorage=findViewById(R.id.saveExternalStorage);
        savePublicExternalStorage=findViewById(R.id.savePublicExternalStorage);

        loadInternalCache=findViewById(R.id.loadInternalCache);
        loadExternalCache=findViewById(R.id.loadExternalCache);
        loadExternalStorage=findViewById(R.id.loadExternalStorage);
        loadPublicExternalStorage=findViewById(R.id.loadPublicExternalStorage);

        saveText=findViewById(R.id.saveText);
        loadText=findViewById(R.id.loadText);

        saveInternalCache.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String inputText=saveText.getText().toString();
                File folder= getCacheDir();

                Log.d("hamza","saved the file at "+folder);

                File myFile= new File(folder,"internalCacheFile.txt");
                try {
                    writeToFile(myFile,inputText);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        saveExternalCache.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String inputText=saveText.getText().toString();
                File folder= getExternalCacheDir();
                File myFile= new File(folder,"externalCacheFile.txt");
                try {
                    writeToFile(myFile,inputText);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        saveExternalStorage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String inputText=saveText.getText().toString();
                File folder= getExternalFilesDir("Storage App");
                File myFile= new File(folder,"externalStorageFile.txt");
                try {
                    writeToFile(myFile,inputText);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        savePublicExternalStorage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String inputText=saveText.getText().toString();
                File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File myFile= new File(folder,"externalPublicStorageFile.txt");
                try {
                    writeToFile(myFile,inputText);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        loadInternalCache.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                File folder= getCacheDir();
                File myFile= new File(folder,"internalCacheFile.txt");
                String text=readFromFile(myFile);
                loadText.setText(text);
            }
        });

        loadExternalCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File folder= getExternalCacheDir();
                File myFile= new File(folder,"externalCacheFile.txt");
                String text=readFromFile(myFile);
                loadText.setText(text);
            }
        });

        loadExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File folder= getExternalFilesDir("Storage App");
                File myFile= new File(folder,"externalStorageFile.txt");
                String text=readFromFile(myFile);
                loadText.setText(text);
            }
        });

        loadPublicExternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File myFile= new File(folder,"externalPublicStorageFile.txt");
                String text=readFromFile(myFile);
                loadText.setText(text);
            }
        });

    }

    void writeToFile(File myFile, String text) throws IOException {
        FileOutputStream fileOutputStream= new FileOutputStream(myFile);
        fileOutputStream.write(text.getBytes());
        fileOutputStream.close();
    }

    String readFromFile(File file){
        FileInputStream fileInputStream=null;
        try{
            fileInputStream=new FileInputStream(file);

            StringBuffer Buffer=new StringBuffer();

            int temp=0;

            while((temp=fileInputStream.read())!=-1){
                Buffer.append((char)temp);
            }
            fileInputStream.close();
            return Buffer.toString();

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
            if (fileInputStream!=null)
                fileInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
package com.example.stajproje;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    Uri text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    FileInputStream iStream;
    FileOutputStream oStream;

    public void dosyaolustur(View view){
        Intent intent = new Intent(Main2Activity.this,Dosyaolusturma.class);
        startActivity(intent);
    }
    public void dosyaduzenle(View view){
        Intent intent = new Intent(Main2Activity.this,Dosyaduzenle.class);
        startActivity(intent);
        finish();
    }
    public void dosyagoruntule(View view){
        Intent intent = new Intent(Main2Activity.this,Dosyagoruntule.class);
        startActivity(intent);
        finish();
    }
    public void kelimedegis(View view){
        Intent intent = new Intent(Main2Activity.this,kelimedegistirme.class);
        startActivity(intent);
        finish();
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2 && resultCode==RESULT_OK){
            text = data.getData();
            //img =(ImageView)findViewById(R.id.imageView);
           // img.setImageURI(image);
        }
        else if (requestCode==2){
            Toast.makeText(this, "İşlem Başarısız", Toast.LENGTH_SHORT).show();
        }
    }

    public void dosya(View view){
        Intent i=new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("text/*");
        startActivityForResult(i,1);
    }*/
}

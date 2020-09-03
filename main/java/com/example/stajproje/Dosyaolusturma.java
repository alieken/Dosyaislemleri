package com.example.stajproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dosyaolusturma extends AppCompatActivity {
    MultiAutoCompleteTextView multi;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosyaolusturma);
        et=findViewById(R.id.editText);
        multi=findViewById(R.id.multiAutoCompleteTextView);
    }
    public void onaylandı(View view) throws IOException {
        String path = Environment.getExternalStorageDirectory().getPath()+ File.separator+et.getText().toString()+".txt";
        File file = new File(path);
        FileWriter fileWriter;
        fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(multi.getText().toString());
        bufferedWriter.close();
        Toast.makeText(this, "İşlem Tamamlandı", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Dosyaolusturma.this,Main2Activity.class);
        startActivity(intent);
        finish();
       /* try{
            oStream = openFileOutput("dosya.txt", Context.MODE_PRIVATE);
            oStream.write("selam".getBytes());
            oStream.close();
        }catch (Exception e){

        }*/
    }
}

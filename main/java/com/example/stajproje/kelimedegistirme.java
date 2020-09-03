package com.example.stajproje;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class kelimedegistirme extends AppCompatActivity {
    Uri text;
    InputStream iStream;
    MultiAutoCompleteTextView multi;
    EditText eski;
    EditText yeni;
    EditText dosyaismi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimedegistirme);
        multi=findViewById(R.id.multiAutoCompleteTextView4);
        eski=findViewById(R.id.editText5);
        yeni=findViewById(R.id.editText6);
        dosyaismi=findViewById(R.id.editText7);
    }
    public void kaydettim(View view){
        Intent i=new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("text/*");
        startActivityForResult(i,2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2 && resultCode==RESULT_OK){
            text = data.getData();
            String content="";
            try {
                //iStream = openFileInput(text.toString()+".txt");
                iStream = getContentResolver().openInputStream(text);
                BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
                StringBuilder total = new StringBuilder();
                for (String line; (  line=br.readLine() ) != null;) {
                    total.append(line).append('\n');

                }
                 content = total.toString();
            } catch (Exception e) {
                Toast.makeText(this, "Dosya Bulunamadı", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            //img =(ImageView)findViewById(R.id.imageView);
            //img.setImageURI(image);
            String duzenlendi=content;

            multi.setText(content.replace("tübitak","bilgem"));

        }
        else if (requestCode==2){
            Toast.makeText(this, "İşlem Başarısız", Toast.LENGTH_SHORT).show();
        }
    }
    public void kaydetartik(View view) throws IOException {
        String path = Environment.getExternalStorageDirectory().getPath()+ File.separator+dosyaismi.getText().toString()+".txt";
        File file = new File(path);
        FileWriter fileWriter;
        fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(multi.getText().toString());
        bufferedWriter.close();
        Toast.makeText(this, "İşlem Tamamlandı", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(kelimedegistirme.this,Main2Activity.class);
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
package com.example.stajproje;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.PathUtils;

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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Dosyaduzenle extends AppCompatActivity {
    MultiAutoCompleteTextView multi;
    Uri text;
    InputStream iStream;
    OutputStream oStream;
    EditText yenisim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosyaduzenle);
        multi = findViewById(R.id.multiAutoCompleteTextView2);
        yenisim = findViewById(R.id.editText2);
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

            try {

                //iStream = openFileInput(text.toString()+".txt");
                iStream = getContentResolver().openInputStream(text);
                BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
                StringBuilder total = new StringBuilder();
                for (String line; (  line=br.readLine() ) != null;) {
                    total.append(line).append('\n');
                    System.out.println("+++++++++++++++++++++++++++++++++++");
                    System.out.println(total.toString());
                }
                String content = total.toString();
                multi.setText(content);
            } catch (Exception e) {
                Toast.makeText(this, "Dosya Bulunamadı", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            //img =(ImageView)findViewById(R.id.imageView);
            // img.setImageURI(image);
        }
        else if (requestCode==2){
            Toast.makeText(this, "İşlem Başarısız", Toast.LENGTH_SHORT).show();
        }
    }

    public void duzenlendi(View view) throws IOException {

        String path = Environment.getExternalStorageDirectory().getPath()+ File.separator+yenisim.getText().toString()+".txt";
        File file = new File(path);
        FileWriter fileWriter;
        fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(multi.getText().toString());
        bufferedWriter.close();
        Toast.makeText(this, "İşlem Tamamlandı", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Dosyaduzenle.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }
}

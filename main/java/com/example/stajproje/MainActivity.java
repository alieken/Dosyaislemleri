package com.example.stajproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.editText3);
        password=findViewById(R.id.editText4);
    }
    public void tikla(View view){
        if(username.getText().toString().equalsIgnoreCase("ali") && password.getText().toString().equalsIgnoreCase("eken")){
            Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "Kullanıcı adı veya şifre yanlış", Toast.LENGTH_SHORT).show();
        }
    }
}

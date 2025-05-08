package com.example.finals_exer2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText etPlayer;
    EditText etScore;
    TextView tvNotes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvNotes=findViewById(R.id.textView2);
        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.meowtivation));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()){
            sb.append(scanner.nextLine());
            sb.append("\n");
        }
        tvNotes.setText(sb.toString());


    }



    public void DoNext(View view){
        Intent i = new Intent(this, NextActivity.class);
        startActivity(i);
    }
}
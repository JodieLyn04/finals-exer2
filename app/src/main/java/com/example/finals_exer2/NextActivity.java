package com.example.finals_exer2;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NextActivity extends AppCompatActivity {
    EditText etFile;
    EditText etContent;
    File openFile;
    File saveFile;
    String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        state= Environment.getExternalStorageState();
        setContentView(R.layout.activity_next);
        etFile=findViewById(R.id.editFile);
        etContent=findViewById(R.id.editContent);
    }

    public void OpenFile(View view){
        if (state.equals(Environment.MEDIA_MOUNTED)){
            openFile = new File(getExternalFilesDir(null),etFile.getEditableText().toString());
            try {
                Scanner scanner = new Scanner(openFile);
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNext()){
                    sb.append(scanner.nextLine());
                    sb.append("\n");
                }
                etContent.setText(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this,"Error on Storage", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveFile(View view){
        if (state.equals(Environment.MEDIA_MOUNTED)){
            saveFile= new File(getExternalFilesDir(null), etFile.getEditableText().toString());
            try {
                FileWriter fileWriter = new FileWriter(saveFile);
                fileWriter.write(etContent.getEditableText().toString());
                fileWriter.flush();
                fileWriter.close();
                Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this,"Error on Storage", Toast.LENGTH_SHORT).show();
        }
    }
}
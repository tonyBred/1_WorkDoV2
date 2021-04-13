package com.example.workdo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class DisplayDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        TextView judul = findViewById(R.id.topikDisplayText);
        TextView matkul = findViewById(R.id.matkulDisplayText);
        TextView deadline = findViewById(R.id.deadlineDisplayText);
        TextView desc = findViewById(R.id.descDisplayText);

        judul.setText(bundle.getString("Judul"));
        matkul.setText(bundle.getString("Matkul"));
        deadline.setText(bundle.getString("Deadline"));
        desc.setText(bundle.getString("Desc"));

        ImageButton button = findViewById(R.id.buttonBack);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent in = new Intent(view.getContext(), MainActivity.class);
                startActivity(in);
            }
        });

    }
}
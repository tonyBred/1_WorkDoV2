package com.example.workdo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    }
}
package com.example.kkr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class bucket extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    EditText number;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bucket);

        ListView listView = (ListView) findViewById(R.id.list);
        number = findViewById(R.id.txt_number);
        add = findViewById(R.id.btn_add);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item,arrayList);
        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(number.getText().toString());
                adapter.notifyDataSetChanged();
                number.setText("");
            }
        });
    }
}
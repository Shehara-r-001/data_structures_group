package com.example.kkr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class bucket extends AppCompatActivity {
    ArrayList<Editable> arrayList = new ArrayList<android.text.Editable>();
    ArrayAdapter<Editable> adapter;
    EditText number;
    Button add;
    Integer new_array[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.bucket);

        ListView listView = (ListView) findViewById(R.id.list);
        number = findViewById(R.id.txt_number);
        add = findViewById(R.id.btn_add);

        adapter = new ArrayAdapter<Editable>(this, R.layout.list_item,arrayList);
        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(number.getText());
                adapter.notifyDataSetChanged();
                number.setText("");

              // new_array = (Integer[]) arrayList.toArray();

               Toast.makeText(getApplicationContext(), arrayList.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
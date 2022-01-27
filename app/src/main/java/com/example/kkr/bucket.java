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
import java.util.Arrays;

// Java program to sort an array
// using bucket sort
import java.util.*;
import java.util.Collections;

public class bucket extends AppCompatActivity {
    ArrayList<Editable> arrayList = new ArrayList<android.text.Editable>();
    ArrayAdapter<Editable> adapter;
    EditText number;
    Button add , sort;
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
        sort=findViewById(R.id.btn_save);

        adapter = new ArrayAdapter<Editable>(this, R.layout.list_item,arrayList);
        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(number.getText());
                adapter.notifyDataSetChanged();
                number.setText("");



               Toast.makeText(getApplicationContext(), arrayList.toString(), Toast.LENGTH_LONG).show();
            }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //new_array = (Integer[]) arrayList.toArray();
                Object array[] = arrayList.toArray();
                String sArray = Arrays.toString(array);
                Toast.makeText(getApplicationContext(), sArray, Toast.LENGTH_SHORT).show();
//                bucketSort();
//                for(Object o : array) {
//                    int s = (int) o;
//
//
//                    System.out.println(s);
//
            }

        });

    }
    static void bucketSort(float arr[], int n)
    {
        if (n <= 0)
            return;

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<Float>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            float idx = arr[i] * n;
            buckets[(int)idx].add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
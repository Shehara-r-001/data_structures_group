package com.example.kkr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// Java program to sort an array
// using bucket sort
import java.util.*;
import java.util.Collections;

public class bucket extends AppCompatActivity {
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayAdapter<Integer> adapter;
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

        adapter = new ArrayAdapter<Integer>(this, R.layout.list_item,arrayList);
        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(Integer.parseInt(number.getText().toString()));
                adapter.notifyDataSetChanged();
                number.setText("");



               Toast.makeText(getApplicationContext(), arrayList.toString(), Toast.LENGTH_LONG).show();
            }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                if(Integer.parseInt(arrayList.get(0).toString())>arrayList.get(1))
//                {
//                }


                //new_array = (Integer[]) arrayList.toArray();
                Object[] array =  arrayList.toArray();
//                Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();

                int length = array.length;
                int intArray[] = new int[length];
                for(int i=0; i<length; i++) {
                    intArray[i] = (int) array[i];
                }
                bucketSort(intArray);
                Toast.makeText(getApplicationContext(), intArray.toString(), Toast.LENGTH_SHORT).show();

            }

        });

    }

    public void bucketSort(int[] arr){
        int n = arr.length;
        if(n <= 0) return;
        int min = arr[0];
        int max = min;
        for(int i = 1; i < n; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }

        /* put element into bucket*/
        int bucket[] = new int[max - min + 1];
        for(int i = 0; i < n; i++){
            bucket[arr[i] -min]++;
        }

        int i = 0;
        for(int b = 0, len = bucket.length; b < len; b++){
            for(int j = 0; j < bucket[b]; j++)
                arr[i++] = b + min;
        }
        Toast.makeText(getApplicationContext(), arr.toString(), Toast.LENGTH_SHORT).show();

    }








}
package com.example.kkr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
    ArrayList<Float> arrayList = new ArrayList<>();
    List<Float> arrayList2 = new ArrayList<>();

    ArrayAdapter<Float> adapter,adapter2;
    EditText number;
    Button add , sort, confirm;
    Float [] newArray;
    int i,s,array_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.bucket);

        ListView listView = (ListView) findViewById(R.id.list);
        ListView listView2 = (ListView) findViewById(R.id.list2);

        number = findViewById(R.id.txt_number);
        add = findViewById(R.id.btn_add);
        sort=findViewById(R.id.btn_save);
        confirm=findViewById(R.id.btn_confirm);

        adapter = new ArrayAdapter<Float>(this, R.layout.list_item,arrayList);
        adapter2 = new ArrayAdapter<Float>(this, R.layout.list_item2,arrayList2);

        listView.setAdapter(adapter);
        listView2.setAdapter(adapter2);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(Float.parseFloat(number.getText().toString()));
                adapter.notifyDataSetChanged();
                number.setText("");

               Toast.makeText(getApplicationContext(), arrayList.toString(), Toast.LENGTH_LONG).show();
                s = arrayList.size();
//                for( i = 0; i<s;i++){
//                    newArray = new Float[s+1];
//                    newArray[i] = arrayList.get(i);
//
//                    Log.d("eeeeeeeeeeeeeeeeeeeeeee", String.valueOf(newArray[i]));
                   Log.d("eeeeeeeeeeeeeeeeeeeeeee", String.valueOf(s));
//
//                }

            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                array_size = s;
                for( i = 0; i<s;i++){
                    newArray = new Float[s];
                    newArray[i] = arrayList.get(i);

                    Log.d("eeeeeeeeeeeeeeeeeeeeeee", String.valueOf(newArray[i]));

               }

            }
        });

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //int s = arrayList.size();
                bucketSort(newArray);
                arrayList2 = Arrays.asList(newArray);
                adapter2.notifyDataSetChanged();
                }




//
//                Object[] array =  arrayList.toArray();
//
//
//                int length = array.length;
//                int intArray[] = new int[length];
//                for(int i=0; i<length; i++) {
//                    intArray[i] = (int) array[i];
//                }
//                Toast.makeText(getApplicationContext(), intArray.toString(), Toast.LENGTH_SHORT).show();
        });

    }

    public void bucketSort(Float[] arr){
        int n = arr.length;
        if(n <= 0) return;
        Float min = arr[0];
        Float max = min;
        for(int i = 1; i < n; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }

        /* put element into bucket*/
        Float bucket[] = new Float[(int) (max - min + 1)];
        for(int i = 0; i < n; i++){
            bucket[(int) (arr[i] -min)]++;
        }

        int i = 0;
        for(int b = 0, len = bucket.length; b < len; b++){
            for(int j = 0; j < bucket[b]; j++)
                arr[i++] = b + min;
        }
        Toast.makeText(getApplicationContext(), arr.toString(), Toast.LENGTH_SHORT).show();

    }








}
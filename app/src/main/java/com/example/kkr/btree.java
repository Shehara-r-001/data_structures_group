package com.example.kkr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class btree extends AppCompatActivity {
    ArrayList<Float> arrayList = new ArrayList<>();
    List<Float> arrayList2 = new ArrayList<>();
    ArrayList<String> n= new ArrayList<String>();


    ArrayAdapter<Float> adapter,adapter2;
    EditText EnterNum1,EnterNum2;
    TextView show;
    Button BtnAdd,BtnAdd2 , sort, Search;
    Float [] newArray;
    Float[] array;
    int i,s,array_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_btree );

     //   ListView listView = (ListView) findViewById(R.id.list);
    //    ListView listView2 = (ListView) findViewById(R.id.list2);

        EnterNum1 = findViewById(R.id.txt_number);
        EnterNum2 = findViewById(R.id.txt_number2);
        show = findViewById( R.id.textView2);
        BtnAdd = findViewById(R.id.btn_add1);
        Search=findViewById(R.id.btn_search);

       // adapter = new ArrayAdapter<Float>(this, R.layout.list_item,arrayList);
       // adapter2 = new ArrayAdapter<Float>(this, R.layout.list_item2,arrayList2);

      //  listView.setAdapter(adapter);
      //  listView2.setAdapter(adapter2);


        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EnterNum1!=null) {
                    arrayList.add(Float.parseFloat(EnterNum1.getText().toString()));
                    //array[]=EnterNum1.getText().toString();
                    n.add(EnterNum1.getText().toString());
                    EnterNum1.setText("");

                    Toast.makeText(getApplicationContext(), arrayList.toString(), Toast.LENGTH_LONG).show();
                    show.setText(arrayList.toString());
                    s = arrayList.size();

                    Log.d("eeeeeeeeeeeeeeeeeeeeeee", String.valueOf(s));
                }else{
                    Toast.makeText(getApplicationContext(), "Enter number before click Add button", Toast.LENGTH_LONG).show();
                }
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(EnterNum1!=null) {
                    if (arrayList.contains(Float.parseFloat(EnterNum2.getText().toString()))) {
                        Toast.makeText(getApplicationContext(), "Number Found", Toast.LENGTH_LONG).show();
                        EnterNum2.setText("");
                    }else{
                        Toast.makeText(getApplicationContext(), "Number Not Found", Toast.LENGTH_LONG).show();
                        EnterNum2.setText("");
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Enter number before click Search button", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
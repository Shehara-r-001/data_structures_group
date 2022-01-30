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
    private int T;

    public class Node {
        int n;
        int key[] = new int[2 * T - 1];
        Node child[] = new Node[2 * T];
        boolean leaf = true;

        public int Find(int k) {
            for (int i = 0; i < this.n; i++) {
                if (this.key[i] == k) {
                    return i;
                }
            }
            return -1;
        };
    }

    public btree(int t) {
        T = t;
        root = new Node();
        root.n = 0;
        root.leaf = true;
    }

    private Node root;


    private void Split(Node x, int pos, Node y) {
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = T - 1;
        for (int j = 0; j < T - 1; j++) {
            z.key[j] = y.key[j + T];
        }
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.child[j] = y.child[j + T];
            }
        }
        y.n = T - 1;
        for (int j = x.n; j >= pos + 1; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[pos + 1] = z;

        for (int j = x.n - 1; j >= pos; j--) {
            x.key[j + 1] = x.key[j];
        }
        x.key[pos] = y.key[T - 1];
        x.n = x.n + 1;
    }


    public void Insert(final int key) {
        Node r = root;
        if (r.n == 2 * T - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            Split(s, 0, r);
            insertValue(s, key);
        } else {
            insertValue(r, key);
        }
    }


    final private void insertValue(Node x, int k) {

        if (x.leaf) {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
                x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
            }
            ;
            i++;
            Node tmp = x.child[i];
            if (tmp.n == 2 * T - 1) {
                Split(x, i, tmp);
                if (k > x.key[i]) {
                    i++;
                }
            }
            insertValue(x.child[i], k);
        }

    }

}
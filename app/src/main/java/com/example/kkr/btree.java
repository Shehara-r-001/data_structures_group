package com.example.kkr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class btree extends AppCompatActivity {
    ArrayList<Float> arrayList2 = new ArrayList<>();

    TextView root,node_1,node_2,node_3,input_array;
    EditText number_array;
    Button add2, show, clear2, refresh2;
    float[] root_arr,node_1_arr,node_2_arr,node_3_arr,z,z1,z2;
    int i,m, array_size,s;
    float a,b,c,d,e,f, searchNum;
    boolean search = false;
    RadioGroup radioGroup;
    RadioButton radioButton;

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.btree);

        tabLayout= findViewById(R.id.tablelayout);
        viewPager2= findViewById(R.id.viewPager2);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm,getLifecycle());
        viewPager2.setAdapter(adapter);

//        tabLayout.addTab(tabLayout.newTab().setText("Number Input"));
//        tabLayout.addTab(tabLayout.newTab().setText("Array Input"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

//        number_array = findViewById(R.id.txt_btree_num);
//        add2 = findViewById(R.id.btn_btree_add);
//        show = findViewById(R.id.btn_show);
//        refresh2 = findViewById(R.id.btn_btree_refresh);
//        clear2 = findViewById(R.id.btn_btree_clear);
//        input_array = findViewById(R.id.array_btree_input);
//
//        root = findViewById(R.id.root);
//        node_1 = findViewById(R.id.node_1);
//        node_2 = findViewById(R.id.node_2);
//        node_3 = findViewById(R.id.node_3);


//        add2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                   add();
//                }
//        });
//
//        clear2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                   remove();
//                }
//        });
//
//        //-------------------------------------------------show_btn-------------------------------------------------------------
//
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final float[] arr_1 = new float[arrayList2.size()];
//                int index = 0;
//                for (final Float value: arrayList2) {
//                    arr_1[index++] = value;
//                }
//                //******************Step 01****************
//                a= arr_1[0];
//                b= arr_1[1];
//
//                root_arr = new float[2];
//                node_1_arr = new float[2];
//                node_2_arr = new float[2];
//                node_3_arr = new float[2];
//
//                root_arr[0] = a;
//                root_arr[1] = b;
//                Arrays.sort(root_arr);
//
//
//                //****************Step 02*****************
//                c = arr_1[2];
//                z = new float[root_arr.length];
//                for (int i = 0; i < root_arr.length; i++) {
//                    z[i] = root_arr[i];
//                }
//
//                z = addElement(z,c);
//                Arrays.sort(z);
//
//                root_arr = removeTheElement(root_arr,1);
//                root_arr[0] = z[1];
//                node_1_arr[0] = z[0];
//                node_3_arr[0] = z[2];
//
//                //***************Step 03******************
//                d= arr_1[3];
//                if(d<root_arr[0]){
//                    addElement(node_1_arr, d);
//                    Arrays.sort(node_1_arr);
//                }else {
//                    addElement(node_3_arr, d);
//                    Arrays.sort(node_3_arr);
//                }
//
//                //****************Step 04*****************
//                e = arr_1[4];
//                if(e<root_arr[0]) {
//                    z1 = new float[node_1_arr.length];
//                    for (int i = 0; i < node_1_arr.length; i++) {
//                        z1[i] = node_1_arr[i];
//                    }
//                    z1 = addElement(z1, e);
//                    Arrays.sort(z1);
//
//                    if (z1.length == 2) {
//                        node_1_arr = z1;
//                        Arrays.sort(node_1_arr);
//                    } else {
//                        root_arr = addElement(root_arr, z1[1]);
//                        Arrays.sort(root_arr);
//                        node_1_arr = removeTheElement(node_1_arr,1);
//                        node_1_arr[0] = z1[0];
//                        node_2_arr[0] = z1[2];
//                    }
//                }else {
//                    z1 = new float[node_3_arr.length];
//                    for (int i = 0; i < node_3_arr.length; i++) {
//                        z1[i] = node_3_arr[i];
//                    }
//                    z1 = addElement(z1, e);
//                    Arrays.sort(z1);
//
//                    if (z1.length == 2) {
//                        node_3_arr = new float[z1.length];
//                        for (int i = 0; i < z1.length; i++) {
//                            node_3_arr[i] = z1[i];
//                        }
//                        Arrays.sort(node_3_arr);
//                    } else {
//                        root_arr = addElement(root_arr, z1[1]);
//                        Arrays.sort(root_arr);
//                        node_3_arr = removeTheElement(node_3_arr,1);
//                        node_2_arr[0] = z1[0];
//                        node_3_arr[0] = z1[2];
//                    }
//                }
//
//                //*****************Step 05******************
//                f = arr_1[5];
//                if(f<root_arr[0]) {
//                    z2 = new float[node_1_arr.length];
//                    for (int i = 0; i < node_1_arr.length; i++) {
//                        z2[i] = node_1_arr[i];
//                    }
//                    z2 = addElement(z2, f);
//                    Arrays.sort(z2);
//
//                    if (z2.length == 2) {
//                        node_1_arr = z2;
//                        Arrays.sort(node_1_arr);
//                    } else {
//                        root_arr = addElement(root_arr, z2[1]);
//                        Arrays.sort(root_arr);
//                        node_1_arr = removeTheElement(node_1_arr,1);
//                        node_1_arr[0] = z2[0];
//                        node_2_arr[0] = z2[2];
//                    }
//                }else {
//                    z2 = new float[node_3_arr.length];
//                    for (int i = 0; i < node_3_arr.length; i++) {
//                        z2[i] = node_3_arr[i];
//                    }
//                    z2 = addElement(z2, f);
//                    Arrays.sort(z2);
//
//                    if (z2.length == 2) {
//                        node_3_arr = new float[z2.length];
//                        for (int i = 0; i < z2.length; i++) {
//                            node_3_arr[i] = z2[i];
//                        }
//                        Arrays.sort(node_3_arr);
//                    } else {
//                        root_arr = addElement(root_arr, z2[1]);
//                        Arrays.sort(root_arr);
//                        node_3_arr = removeTheElement(node_3_arr,1);
//                        node_2_arr[0] = z2[0];
//                        node_3_arr[0] = z2[2];
//                    }
//                }
//                root.setText(Arrays.toString(root_arr));
//                node_1.setText(Arrays.toString(node_1_arr));
//                node_2.setText(Arrays.toString(node_2_arr));
//                node_3.setText(Arrays.toString(node_3_arr));
//
//                root.setBackgroundResource(R.color.light_blue);
//                node_1.setBackgroundResource(R.color.light_blue);
//                node_2.setBackgroundResource(R.color.light_blue);
//                node_3.setBackgroundResource(R.color.light_blue);
//
//                searchFunction();
//            }
//        });
//
//        //--------------------------------------------------refresh_btn---------------------------------------------------------
//
//        refresh2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!search){
//                    add2.setText("add");
//                    refresh();
//                    add2.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            add();
//                        }
//                    });
//                    clear2.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            remove();
//                        }
//                    });
//                }
//                refresh();
//            }
//        });
//
   }
//
//
//
//
//    //-----------------------------------------------start of methods-----------------------------------------------------------
//
//    public void searchFunction(){
//        search = true;
//        if(search) {
//            add2.setText("Search");
//            add2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(number_array!=null) {
//                        searchNum = Float.parseFloat(number_array.getText().toString());
//                        for (int h = 0; h < arrayList2.size(); h++) {
//                            if (searchNum == arrayList2.get(h)) {
//                                numSearch(root_arr, root);
//                                numSearch(node_1_arr, node_1);
//                                numSearch(node_2_arr, node_2);
//                                numSearch(node_3_arr, node_3);
//                            }else{
//                                Toast.makeText(getApplicationContext(), searchNum+" "+"was not in B-Tree", Toast.LENGTH_LONG).show();
//                            }
//                        }
//                    }else {
//                        Toast.makeText(getApplicationContext(), "Enter number before click Add button", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
//            clear2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    number_array.setText("");
//                    root.setBackgroundResource(R.color.light_blue);
//                    node_1.setBackgroundResource(R.color.light_blue);
//                    node_2.setBackgroundResource(R.color.light_blue);
//                    node_3.setBackgroundResource(R.color.light_blue);
//                }
//            });
//        }
//        search = false;
//    }
//
//    //------------------------------------------------------------------------------------------------------------------------
//
//    public void remove(){
//        if (number_array != null) {
//            arrayList2.remove(Float.parseFloat(number_array.getText().toString()));
//            input_array.setText(arrayList2.toString());
//            // adapter.notifyDataSetChanged();
//            number_array.setText("");
//
//            Toast.makeText(getApplicationContext(), arrayList2.toString(), Toast.LENGTH_LONG).show();
//            s = arrayList2.size();
//
//            Log.d("eeeeeeertrtreeeeeeeeeee", String.valueOf(s));
//        } else {
//            Toast.makeText(getApplicationContext(), "Enter number before click Remove button", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    //-------------------------------------------------------------add_btn-------------------------------------------------------------
//
//    public  void  add(){
//        if (number_array != null) {
//            arrayList2.add(Float.parseFloat(number_array.getText().toString()));
//            input_array.setText(arrayList2.toString());
//            // adapter.notifyDataSetChanged();
//            number_array.setText("");
//
//            Toast.makeText(getApplicationContext(), arrayList2.toString(), Toast.LENGTH_LONG).show();
//            //m = arrayList2.size();
//
//            //Log.d("eeeeeeeeeeeeeeeeeeeeeee", String.valueOf(m));
//        } else {
//            Toast.makeText(getApplicationContext(), "Enter number before click Add button", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    //-------------------------------------------------------------------------------------------------------------------------
//
//    public void refresh(){
//        input_array.setText("");
//        arrayList2.clear();
//        root.setText("");
//        node_1.setText("");
//        node_2.setText("");
//        node_3.setText("");
//        root.setBackgroundResource(R.color.white);
//        node_1.setBackgroundResource(R.color.white);
//        node_2.setBackgroundResource(R.color.white);
//        node_3.setBackgroundResource(R.color.white);
//    }
//
//    //------------------------------------------------------------------------------------------------------------------------
//
//    public void numSearch(float[] arr, TextView textView){
//             for (int l = 0; l < arr.length; l++) {
//                 if (searchNum == arr[l]) {
//                     textView.setBackgroundResource(R.color.red);
//                     Toast.makeText(getApplicationContext(), searchNum + " " + "was found in B-Tree", Toast.LENGTH_LONG).show();
//                 }
//             }
//    }
//
//    //------------------------------------------------------------------------------------------------------------------------
//
//    public static float[] removeTheElement(float[] arr, int index)
//    {
//        if (arr == null || index < 0
//                || index >= arr.length) {
//            return arr;
//        }
//        float[] anotherArray = new float[arr.length - 1];
//
//        for (int i = 0, k = 0; i < arr.length; i++) {
//            if (i == index) {
//                continue;
//            }
//            anotherArray[k++] = (int) arr[i];
//        }
//        return anotherArray;
//    }
//
//    //-----------------------------------------------------------------------------------------------------------------------
//
//    public static float[] addElement(float[] arr, float value){
//
//        for(int k=0; k< arr.length; k++) {
//            if (arr[k] == 0.0f) {
//                arr[k] = value;
//                return arr;
//            }
//        }
//        int n = arr.length;
//        float[] new_arr = new float[n + 1];
//
//        for(int p=0; p< n; p++){
//            new_arr[p] = arr[p];
//        }
//        new_arr[n] = value;
//
//        return new_arr;
//    }
}

//-------------------------------------------------------end of methods---------------------------------------------------------
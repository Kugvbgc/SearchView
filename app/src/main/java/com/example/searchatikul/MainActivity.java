package com.example.searchatikul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();
    ListView listView;
    MyAdapter myAdapter = new MyAdapter(arrayList);

    // =====================
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);

        details();
        listView.setAdapter(myAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });


    } // OnCreate Method End Here ===============

    public class MyAdapter extends BaseAdapter {

        ArrayList<HashMap<String, String>> MyArrayList;

        public MyAdapter(ArrayList<HashMap<String, String>> arrayList) {
            this.MyArrayList = arrayList;
        }

        public void setFilteredList(ArrayList<HashMap<String, String>> filteredList) {
            this.MyArrayList = filteredList;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return MyArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View MyView = layoutInflater.inflate(R.layout.item_layout, viewGroup, false);

            TextView name = MyView.findViewById(R.id.name);
            TextView age = MyView.findViewById(R.id.age);
            TextView mobile = MyView.findViewById(R.id.mobile);

            HashMap<String, String> myHashMap = MyArrayList.get(i);
            name.setText(myHashMap.get("name"));
            age.setText(myHashMap.get("age"));
            mobile.setText(myHashMap.get("mobile"));

            return MyView;
        }


    } // MyAdapter End Here ==============


    private void fileList(String newText) {
        ArrayList<HashMap<String, String>> arrayList1 = new ArrayList<>();
        for (HashMap<String, String> detailsItem : arrayList) {
            if (detailsItem.get("name").toLowerCase().contains(newText.toLowerCase())) {
                arrayList1.add(detailsItem);
            }
        }
        if (arrayList1.isEmpty()) {
            Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            myAdapter.setFilteredList(arrayList1);
        }
    }


    private void details() {
        hashMap = new HashMap<>();
        hashMap.put("name", "Jubayer Hossain");
        hashMap.put("age", "25");
        hashMap.put("mobile", "017000000000");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Rukon Sorkar");
        hashMap.put("age", "21");
        hashMap.put("mobile", "017000000000");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "MD Yeamin");
        hashMap.put("age", "19");
        hashMap.put("mobile", "017000000000");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Md Atikul Islam");
        hashMap.put("age", "19");
        hashMap.put("mobile", "017000000000");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Md Humayon Kabir");
        hashMap.put("age", "22");
        hashMap.put("mobile", "017000000000");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Hasib Ali");
        hashMap.put("age", "19");
        hashMap.put("mobile", "017000000000");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Nur Alom Mollik");
        hashMap.put("age", "20");
        hashMap.put("mobile", "017000000000");
        arrayList.add(hashMap);


    } // details Close Here ==========


} // Public Class End Here =======================
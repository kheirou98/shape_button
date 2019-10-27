package com.example.shape_bouton;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class produits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(new MyCustomAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txt=(TextView) view.findViewById(R.id.textView3);
                Toast.makeText(getApplicationContext(),txt.getText(),Toast.LENGTH_LONG).show();
            }
        });

    }
    class MyCustomAdapter extends BaseAdapter {
         Context context;
        ArrayList<String> tab;
        MyCustomAdapter(Context context){
            this.context=context;
            tab= new ArrayList<>();
            tab.add("kheirou");
            tab.add("Ouerdia");
            tab.add("Layeche");
            tab.add("Mohamed Anis");
            tab.add("Khalid");
            tab.add("Tahar");
        }

        public int getCount(){
            return tab.size();
        }
        public String getItem (int position) {
            return tab.get(position);
        }
        public long getItemId (int position){
            return position;
        }
        public View getView(int i, View view, ViewGroup viewGroup){
            LayoutInflater layoutInflater=getLayoutInflater();
            View view1=layoutInflater.inflate(R.layout.menu,null);
            TextView txt =view1.findViewById(R.id.textView3);
            txt.setText(tab.get(i));
            return view1;
        }

    }
}

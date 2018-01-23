package com.example.namgiwon.android_recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ListviewVO> items;
    private Button adder;
//    private static final int LAYOUT = R.layout.activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adder = (Button) findViewById(R.id.adder);
        adder.setOnClickListener(bListener);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        items = new ArrayList<ListviewVO>();
        ListviewVO a = new ListviewVO();
        a.setName("nam");
        a.setSno("0");
        a.setImgPath("http://117.17.142.134:8080/img/0.jpg");
        ListviewVO b = new ListviewVO();
        b.setName("choi");
        b.setSno("1");
        b.setImgPath("http://117.17.142.134:8080/img/1.jpg");
        items.add(a);
        items.add(b);

        setRecyclerView();


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),String.valueOf(position)+"아이템 클릭",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),String.valueOf(position)+"아이템 롱클릭",Toast.LENGTH_LONG).show();
            }
        }));
    }

    private void setRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,layoutManager.getOrientation()));
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(getApplicationContext(),items);
        recyclerView.setAdapter(adapter);
    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.adder:
                    Log.d("asdf","asdfasdf");
                    ListviewVO c = new ListviewVO();
                    c.setName("kim");
                    c.setSno(String.valueOf(items.size()));
                    c.setImgPath("http://117.17.142.134:8080/img/"+c.getSno()+".jpg");
//                    items.add(c);
                    Log.d("asdf",String.valueOf(items.size()));
                    adapter.add(c);
                    recyclerView.smoothScrollToPosition(items.size()-1);
                    break;
            }
        }
    };


}

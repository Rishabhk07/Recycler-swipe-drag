package me.rishabhkhanna.recyclerviewswipedrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

import me.rishabhkhanna.recyclerswipedrag.RecyclerHelper;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> dataArrayList = new ArrayList<>();
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(dataArrayList,this);
        recyclerView.setAdapter(recyclerAdapter);
        ItemTouchHelper.Callback touchHelper = new RecyclerHelper(recyclerAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        dataArrayList.addAll(getData());
        recyclerAdapter.notifyDataSetChanged();
    }

    public static ArrayList<String> getData(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Iron Man");
        arrayList.add("Batman");
        arrayList.add("Super Man");
        arrayList.add("Captain America");
        arrayList.add("Thor : God of Thunder");
        arrayList.add("Hulk");
        arrayList.add("Wonder Woman");
        return arrayList;
    }
}

package me.rishabhkhanna.recyclerviewswipedrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> dataArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        dataArrayList = getData();
        recyclerView.setAdapter(new RecyclerAdapter(dataArrayList,this));
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

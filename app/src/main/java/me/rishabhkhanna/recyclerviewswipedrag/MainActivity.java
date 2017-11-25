package me.rishabhkhanna.recyclerviewswipedrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import java.util.ArrayList;

import me.rishabhkhanna.recyclerswipedrag.OnDragListener;
import me.rishabhkhanna.recyclerswipedrag.OnSwipeListener;
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
        dataArrayList = getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(dataArrayList, this);
        recyclerView.setAdapter(recyclerAdapter);

//      Library addition from here
        RecyclerHelper touchHelper = new RecyclerHelper<String>(dataArrayList, (RecyclerView.Adapter) recyclerAdapter);
        touchHelper.setRecyclerItemDragEnabled(true).setOnDragItemListener(new OnDragListener() {
            @Override
            public void onDragItemListener(int fromPosition, int toPosition) {
                Log.d(TAG, "onDragItemListener: callback after dragging recycler view item");
            }
        });
        touchHelper.setRecyclerItemSwipeEnabled(true).setOnSwipeItemListener(new OnSwipeListener() {
            @Override
            public void onSwipeItemListener() {
                Log.d(TAG, "onSwipeItemListener: callback after swiping recycler view item");
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public static ArrayList<String> getData() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1.");
        arrayList.add("2.");
        arrayList.add("3.");
        arrayList.add("4.");
        arrayList.add("5.");
        arrayList.add("6.");
        arrayList.add("7.");
        return arrayList;
    }
}

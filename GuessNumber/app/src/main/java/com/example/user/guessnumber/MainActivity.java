package com.example.user.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by B10409038 on 2017/4/5.
 */

public class MainActivity extends AppCompatActivity {
    private int NUM_LIST_ITEMS;
    private EditText mEdtTxt;
    private RecyclerView mNumbersList;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "New Round !", Toast.LENGTH_SHORT).show();
        mEdtTxt = (EditText) findViewById(R.id.edtTxt);
        NUM_LIST_ITEMS = Integer.parseInt(mEdtTxt.getText().toString());
        mNumbersList = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mAdapter = new Adapter(NUM_LIST_ITEMS);
        mNumbersList.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_refresh:
                NUM_LIST_ITEMS = Integer.parseInt(mEdtTxt.getText().toString());
                Toast.makeText(this, "New Round !", Toast.LENGTH_SHORT).show();
                mAdapter = new Adapter(NUM_LIST_ITEMS);
                mNumbersList.setAdapter(mAdapter);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.user.list;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
private TextView mTxtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtResult=(TextView)findViewById(R.id.txtResult);
        ArrayAdapter<CharSequence>ArrAdapWeekday=
                ArrayAdapter.createFromResource(
                        this,R.array.weekday,
                        android.R.layout.simple_list_item_1);
                setListAdapter(ArrAdapWeekday);
        ListView listview=getListView();
        listview.setOnItemClickListener(listViewOnItemClick);
    }
private AdapterView.OnItemClickListener listViewOnItemClick=new AdapterView.OnItemClickListener(){
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        mTxtResult.setText(((TextView) view).getText());
    }
};
}

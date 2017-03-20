package com.example.user.activity_switch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
   Intent intent=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.goto2:
               intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                MainActivity.this.finish();
                return true;
            case R.id.goto3:
                intent.setClass(MainActivity.this,Main3Activity.class);
                startActivity(intent);
                MainActivity.this.finish();
                return true;
            case R.id.finish:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

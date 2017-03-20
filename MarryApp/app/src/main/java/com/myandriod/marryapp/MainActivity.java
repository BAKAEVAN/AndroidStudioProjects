package com.myandriod.marryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtSex,mEdtAge;
    private Button mBtnOK;
    private TextView mTxtR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtSex=(EditText)findViewById(R.id.edtSex);
        mEdtAge=(EditText)findViewById(R.id.edtAge);
        mBtnOK=(Button)findViewById(R.id.btn_OK);
        mTxtR=(TextView)findViewById(R.id.txtR);
        mBtnOK.setOnClickListener(btnOKOnCilck);
    }
    private View.OnClickListener btnOKOnCilck=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           String StrSex=mEdtSex.getText().toString();
            int iAge=Integer.parseInt(mEdtAge.getText().toString());

            String StrSug=getString(R.string.suggestion);
            if(StrSex.equals(getString(R.string.sex_male)))
                if(iAge<28)
                    StrSug+=getString(R.string.sug_not_hurry);
                else if(iAge>33)
                    StrSug+=getString(R.string.sug_get_married);
                else
                    StrSug+=getString(R.string.sug_find_couple);
            else
                if(iAge<25)
                    StrSug+=getString(R.string.sug_not_hurry);
                else if(iAge>30)
                    StrSug+=getString(R.string.sug_get_married);
                else
                    StrSug+=getString(R.string.sug_find_couple);

            mTxtR.setText(StrSug);
        }
    };
}

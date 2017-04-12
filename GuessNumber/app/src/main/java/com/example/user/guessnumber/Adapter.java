package com.example.user.guessnumber;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by B10409038 on 2017/4/5.
 */

public class Adapter extends
        RecyclerView.Adapter<Adapter.ViewHolder> {
    private int mNumberItems;
    private int min, max, answer;
    private String[] status;

    public Adapter(int numberOfItems) {
        mNumberItems = numberOfItems;
        min = 0;
        max = numberOfItems - 1;
        answer = (int) (Math.random() * numberOfItems);
        status = new String[mNumberItems];
        for (int i = 0;i <=numberOfItems -1; i++)
            status[i] = "White";
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public TextView mTxt;
        public RelativeLayout mrelative;

        public ViewHolder(View view) {
            super(view);
            mrelative = (RelativeLayout) itemView.findViewById(R.id.relative);
            mTxt = (TextView) itemView.findViewById(R.id.item_number);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (game(getPosition())) {
                Toast.makeText(v.getContext().getApplicationContext(), "The answer is " + (answer + 1) + " ! ", Toast.LENGTH_SHORT).show();
            }
            notifyDataSetChanged();
        }
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.number_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mTxt.setText(String.valueOf(position + 1));
        if (status[position].equals("White")) {
            holder.mrelative.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else if (status[position] .equals("Gray")) {
            holder.mrelative.setBackgroundColor(Color.parseColor("#b4b4b4"));
        } else if (status[position] .equals("Red")) {
            holder.mrelative.setBackgroundColor(Color.parseColor("#ff4747"));
        }
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public boolean game(int position) {
        if (position > answer) {
            for (int i = position; i <= max; i++)
                status[i] = "Gray";
            max = position;
        } else if (position < answer) {
            for (int i = min; i <= position; i++)
                status[i] = "Gray";
            min = position;
        } else if (position == answer) {
            status[position] = "Red";
            return true;
        }
        return false;
    }

}

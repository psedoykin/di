package com.example.pavel.diexample.ui.weather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pavel.diexample.R;
import com.example.pavel.diexample.data.Day;
import com.example.pavel.diexample.ui.base.BaseRecycleAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DayAdapter extends BaseRecycleAdapter<Day> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DayViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.day_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Day day = mList.get(position);
        DayViewHolder viewHolder = (DayViewHolder) holder;
        viewHolder.mDayDate.setText(day.mDate);
        viewHolder.mTemperature.setText(day.mTemp);
    }

    public class DayViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.day_date) TextView mDayDate;
        @BindView(R.id.day_temperature) TextView mTemperature;

        public DayViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick(view, getLayoutPosition());
                    }
                }
            });
        }
    }
}

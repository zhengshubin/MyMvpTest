package com.gdqt.mymvptest.common;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdqt.mymvptest.R;

import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Map<String,Object>> list;
    public  MyAdapter(List<Map<String,Object>> list){
        this.list=list;


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(),R.layout.item_realdata,parent);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Map map=list.get(position);
        holder.tv_ffm_name.setText(map.get("FFM_NAME").toString());
        holder.tv_pipe_pressure.setText(map.get("PIPE_PRESSURE").toString());
        holder.tv_freeze_date.setText(map.get("FREEZE_DATE").toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_ffm_name;
        private TextView tv_pipe_pressure;
        private TextView tv_freeze_date;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_ffm_name=itemView.findViewById(R.id.tv_item_ffm_name);
            tv_pipe_pressure=itemView.findViewById(R.id.tv_item_pipe_pressure);
            tv_freeze_date=itemView.findViewById(R.id.tv_item_freeze_date);
        }
    }
}

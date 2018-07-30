package com.gdqt.mymvptest.common;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gdqt.mymvptest.R;
import com.gdqt.mymvptest.ui.login.LoginActivity;
import com.gdqt.mymvptest.ui.realdata.RealDataActivity;
import com.gdqt.mymvptest.utils.FormatUtils;
import com.gdqt.mymvptest.utils.LogUtils;
import org.greenrobot.eventbus.EventBus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {
    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    private static final  int TYPE_HEADER=0;
    private static  final int TYPE_NORMAL=1;
    private static final int TYPE_FOOTOR=2;
    private List<Map<String,Object>> list;
    private OnItemClickListener itemClickListener;

    public  MyAdapter(List<Map<String,Object>> list){
        this.list=list;



    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_HEADER;
        }
        return TYPE_NORMAL;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view=null;
        if (viewType==TYPE_HEADER){
           view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_realdata_hearder,parent,false);
        }else {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_realdata,parent,false);
        }
        final ViewHolder viewHolder=new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getLayoutPosition();
                    Log.d("MyAdapter", "onClick: " + position);
                    if (position != 0) {
                        itemClickListener.onItemClick(position);
                    }
                }
            });



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
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

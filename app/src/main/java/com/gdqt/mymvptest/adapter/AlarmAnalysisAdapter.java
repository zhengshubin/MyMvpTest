package com.gdqt.mymvptest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gdqt.mymvptest.R;

import java.util.List;
import java.util.Map;

public class AlarmAnalysisAdapter extends RecyclerView.Adapter<AlarmAnalysisAdapter.ViewHolder> {
    private static final  int TYPE_HEADER=0;
    private static  final int TYPE_NORMAL=1;
    private List<Map<String,Object>> list;

    public  AlarmAnalysisAdapter(List<Map<String,Object>> list){
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
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarmanalysis_header,parent,false);
        }else {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm_analysis,parent,false);
        }
        final ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Map map=list.get(position);
        holder.tv_ffm_name.setText(map.get("FFM_NAME").toString());
        holder.tv_pressure_limit.setText(map.get("PRESSURE_LIMIT").toString());
        holder.tv_pressure_alarm.setText(map.get("PRESSURE_ALARM").toString());
        holder.tv_reason.setText(map.get("REASON").toString());
        holder.tv_create_date.setText(map.get("CREATE_DATE").toString());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_ffm_name;
        private TextView tv_pressure_limit;
        private TextView tv_pressure_alarm;
        private  TextView tv_reason;
        private TextView tv_create_date;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_ffm_name=itemView.findViewById(R.id.tv_aa_item_FFM_NAME);
            tv_pressure_limit=itemView.findViewById(R.id.tv_aa_item_PRESSURE_LIMIT);
            tv_pressure_alarm=itemView.findViewById(R.id.tv_aa_item_PRESSURE_ALARM);
            tv_reason=itemView.findViewById(R.id.tv_aa_item_REASON);

            tv_create_date=itemView.findViewById(R.id.tv_aa_item_CREATE_DATE);
        }
    }
}

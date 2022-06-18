package com.example.smash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    ArrayList<InfoListData> list = new ArrayList<InfoListData>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.info, viewGroup,false);
        }

        TextView infoName = (TextView) view.findViewById(R.id.infoName);
        TextView infoDepartment = (TextView) view.findViewById(R.id.infoDepartment);
        TextView infoGrade = (TextView) view.findViewById(R.id.infoGrade);
        TextView infoInterest = (TextView) view.findViewById(R.id.infoInterest);
        TextView infoTime = (TextView) view.findViewById(R.id.infoTime);
        TextView infoPlace = (TextView) view.findViewById(R.id.infoPlace);

        InfoListData listData = list.get(i);

        infoName.setText(listData.getName());
        infoDepartment.setText(listData.getDepartment());
        infoGrade.setText(listData.getGrade());
        infoInterest.setText(listData.getInterest());
        infoTime.setText(listData.getTime());
        infoPlace.setText(listData.getPlace());

        return view;
    }

}

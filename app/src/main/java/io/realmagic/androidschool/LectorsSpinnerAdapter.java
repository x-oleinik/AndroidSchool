package io.realmagic.androidschool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class LectorsSpinnerAdapter extends BaseAdapter {

    private List<String> mLectors;

    @Override
    public int getCount() {
        return mLectors == null ? 0 : mLectors.size();
    }

    @Override
    public String getItem(int i) {
        return mLectors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view ==null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_dropdown_item_1line, viewGroup, false);

        ViewHolder vh = new ViewHolder(view);
        view.setTag(vh);
       }

        ViewHolder holder = (ViewHolder) view.getTag();
        String lector = mLectors.get(i);
        holder.mLectorName.setText(lector);

        return view;
    }

    public void setmLectors(List<String> mLectors) {
        this.mLectors = mLectors;
    }

    private static class ViewHolder{
        private final TextView mLectorName;

        private ViewHolder(@NonNull View root){
            mLectorName = root.findViewById(android.R.id.text1);
        }
    }
}

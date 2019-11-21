package io.realmagic.androidschool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LecturesAdapter extends RecyclerView.Adapter<LecturesAdapter.LecturesViewHolder> {

    private List<Lecture> mLectures;

    public void setmLectures(List<Lecture> lectures){
        mLectures = new ArrayList<>(lectures);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LecturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lecture, parent, false);
        return new LecturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LecturesViewHolder holder, int position) {
        Lecture lecture = mLectures.get(position);
        holder.mNumber.setText("#"+ String.valueOf(lecture.getmNumber()));
        holder.mData.setText(lecture.getmData());
        holder.mTheme.setText(lecture.getmTheme());
        holder.mLector.setText(lecture.getmLector());

    }

    @Override
    public int getItemCount() {
        return mLectures == null ? 0 : mLectures.size();
    }

    static class LecturesViewHolder extends RecyclerView.ViewHolder {

        public TextView mNumber;
        public TextView mData;
        public TextView mTheme;
        public TextView mLector;

        public LecturesViewHolder(@NonNull View itemView){
            super(itemView);
            mNumber = itemView.findViewById(R.id.number);
            mData = itemView.findViewById(R.id.date);
            mTheme = itemView.findViewById(R.id.theme);
            mLector = itemView.findViewById(R.id.lector);


        }
    }
}

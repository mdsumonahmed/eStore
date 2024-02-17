package com.graphai.estore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopQuestionAdapter extends RecyclerView.Adapter<TopQuestionAdapter.ViewHolder> {

    private Context mContext;
    private List<TopQuestion> mData;

    public TopQuestionAdapter(Context mContext, List<TopQuestion> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final TopQuestion topQuestionObj = mData.get(position);

        holder.questionId.setText(topQuestionObj.getQestionId());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView questionId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            questionId = itemView.findViewById(R.id.text_question_id);
        }
    }
}


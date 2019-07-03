package com.kunminx.basicfacttesting.test_animator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kunminx.basicfacttesting.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by KunMinX at 19/6/27
 */
public class AnimatorAdapter extends RecyclerView.Adapter<AnimatorAdapter.AnimatorViewHolder> {

    private List<AnimatorItem> mItems = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener itemClickListener;

    public void refreshList(List<AnimatorItem> items) {
        if (items != null) {
            mItems.clear();
            mItems.addAll(items);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public AnimatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_animator, parent, false);
        return new AnimatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AnimatorViewHolder holder, int position) {
        String title = mItems.get(holder.getAdapterPosition()).getTitle();
        String url = mItems.get(holder.getAdapterPosition()).getUrl();
        holder.tv.setText(title);
        Glide.with(holder.iv.getContext()).load(url).into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(holder, mItems.get(holder.getAdapterPosition()));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class AnimatorViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView iv;
        TextView tv;

        public AnimatorViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_detail);
            tv = itemView.findViewById(R.id.tv_title);
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(AnimatorViewHolder holder, AnimatorItem item);
    }
}

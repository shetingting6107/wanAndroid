package com.example.wanandroidtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wanandroidtest.model.FirstModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * FirstActivity列表适配器
 */
public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder> {

    private List<FirstModel> mFirstList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public FirstAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public List<FirstModel> getmFirstList() {
        return mFirstList;
    }

    public void setmFirstList(List<FirstModel> mFirstList) {
        this.mFirstList = mFirstList;
    }

    @NonNull
    @Override
    public FirstViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FirstViewHolder(mLayoutInflater.inflate(R.layout.activity_first_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FirstViewHolder holder, int position) {
        FirstModel firstModel = mFirstList.get(position);
        holder.mIvPic.setImageResource(firstModel.getPic());
        holder.mTvText.setText(firstModel.getText());

    }

    @Override
    public int getItemCount() {
        return mFirstList == null ? 0 : mFirstList.size();
    }

    class FirstViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_pic)
        ImageView mIvPic;
        @BindView(R.id.tv_text)
        TextView mTvText;

        public FirstViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

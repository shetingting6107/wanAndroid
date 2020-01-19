package com.example.wanandroidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.wanandroidtest.model.FirstModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.btn_clean)
    Button mBtnClean;
    @BindView(R.id.btn_remove)
    Button mBtnRemove;
    @BindView(R.id.rv_fixed_list)
    RecyclerView mRvFixedList;

    private FirstAdapter mFirstAdapter;

    private List<FirstModel> mFirstList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        initList();
        initView();
        initData();
    }

    private void initView() {
        mBtnAdd.setText(getResources().getString(R.string.btn_add));
        mBtnAdd.setTextColor(getColor(R.color.colorTitleTextColor));
        mBtnClean.setText(getResources().getString(R.string.btn_clean));
        mBtnClean.setTextColor(getColor(R.color.colorTitleTextColor));
        mBtnRemove.setText(getResources().getString(R.string.btn_remove));
        mBtnRemove.setTextColor(getColor(R.color.colorTitleTextColor));

    }

    private void initData() {
        mRvFixedList.setLayoutManager(new LinearLayoutManager(this));
        mFirstAdapter = new FirstAdapter(this);
        mRvFixedList.setAdapter(mFirstAdapter);
        mFirstAdapter.setmFirstList(mFirstList);
        mFirstAdapter.notifyDataSetChanged();
    }

    private void initList() {
        mFirstList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            String text = getString(R.string.text_fixed) + i;
            FirstModel firstModel = new FirstModel();
            firstModel.setPic(R.drawable.android_item);
            firstModel.setText(text);
            mFirstList.add(firstModel);
        }
    }

    @OnClick(R.id.btn_add)
    public void addList() {
        if (mFirstList != null && mFirstList.size() > 0) {

        } else {
            mFirstList = new ArrayList<>();
        }
        FirstModel first = new FirstModel();
        first.setText(getString(R.string.text_add));
        first.setPic(R.drawable.android_item);
        mFirstList.add(first);
        mFirstAdapter.setmFirstList(mFirstList);
        mFirstAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_remove)
    public void removeLastItem() {
        if (mFirstList != null && mFirstList.size() > 0) {
            int size = mFirstList.size();
            mFirstList.remove(size - 1);
            mFirstAdapter.setmFirstList(mFirstList);
            mFirstAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, R.string.toast_no_item_to_remove, Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.btn_clean)
    public void cleanAllItem() {
        if (mFirstList != null && mFirstList.size() > 0) {
            mFirstList.clear();
            mFirstAdapter.setmFirstList(mFirstList);
            mFirstAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, R.string.toast_no_item_to_remove, Toast.LENGTH_SHORT).show();
        }
    }
}

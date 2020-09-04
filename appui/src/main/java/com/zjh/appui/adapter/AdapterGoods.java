package com.zjh.appui.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zjh.appui.beans.GoodsBean;

import java.util.List;

public class AdapterGoods extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {

    public AdapterGoods(int layoutResId, @Nullable List<GoodsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBean item) {

    }
}

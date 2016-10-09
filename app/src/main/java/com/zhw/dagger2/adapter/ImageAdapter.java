package com.zhw.dagger2.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhw.dagger2.R;

import java.util.List;

/**
 * Created by zhonghanwen on 2016/10/9.
 */

public class ImageAdapter extends BaseQuickAdapter<String> {

    public ImageAdapter(List<String> data) {
        super(R.layout.item_image, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        SimpleDraweeView drawable = (SimpleDraweeView) baseViewHolder
                .convertView.findViewById(R.id.iv_img);
        drawable.setImageURI(s);
    }
}

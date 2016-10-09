package com.zhw.dagger2.di.modules;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.zhw.dagger2.adapter.ImageAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhonghanwen on 2016/10/9.
 */

@Module
public class MainModule {

    private Context mContext;

    public MainModule(Context context) {
        mContext = context;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(){
        LinearLayoutManager ll = new LinearLayoutManager(mContext);
        ll.setOrientation(LinearLayoutManager.HORIZONTAL);
        return ll;
    }

    @Provides
    ImageAdapter provideImageAdapter(){
        return new ImageAdapter(new ArrayList<String>());
    }
}

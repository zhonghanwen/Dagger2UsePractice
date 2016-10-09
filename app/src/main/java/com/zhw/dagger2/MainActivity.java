package com.zhw.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhw.dagger2.adapter.ImageAdapter;
import com.zhw.dagger2.di.components.DaggerMainComponents;
import com.zhw.dagger2.di.modules.MainModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    LinearLayoutManager mMll;

    @Inject
    ImageAdapter mImageAdapter;

    @Inject
    ImageAdapter mMmAdapter;


    private RecyclerView mRvMm;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        initMMRecyclerView();
        initRecyclerView();
    }

    private void initComponents() {
        DaggerMainComponents daggerMainComponents = (DaggerMainComponents) DaggerMainComponents
                .builder()
                .mainModule(new MainModule(this))
                .build();
        daggerMainComponents.inject(this);
    }


    private void initMMRecyclerView() {
        mRvMm = (RecyclerView) findViewById(R.id.rv_mm);

//        LinearLayoutManager ll = new LinearLayoutManager(this);
//        ll.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvMm.setLayoutManager(mMll);
        mRvMm.setItemAnimator(new DefaultItemAnimator());

//        List<String> datas = new ArrayList<>();
//        ImageAdapter adapter = new ImageAdapter(datas);

        mRvMm.setAdapter(mMmAdapter);

        mMmAdapter.addData(mockData());

    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

//        LinearLayoutManager ll = new LinearLayoutManager(this);
//        ll.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

//        List<String> datas = new ArrayList<>();
//        ImageAdapter adapter = new ImageAdapter(datas);

        mRecyclerView.setAdapter(mImageAdapter);

        mImageAdapter.addData(mockData());
    }


    /**
     * test data
     * @return
     */
    private List<String> mockData(){
        List<String> datas = new ArrayList<>();
        datas.add("http://ww1.sinaimg.cn/large/610dc034jw1f8kmud15q1j20u011hdjg.jpg");
        datas.add("http://ww4.sinaimg.cn/large/610dc034jw1f8lox7c1pbj20u011h12x.jpg");
        datas.add("http://ww1.sinaimg.cn/large/610dc034jw1f867mvc6qjj20u00u0wh7.jpg");
        datas.add("http://ww3.sinaimg.cn/large/610dc034jw1f837uocox8j20f00mggoo.jpg");
        datas.add("http://ww4.sinaimg.cn/large/610dc034jw1f820oxtdzzj20hs0hsdhl.jpg");
        datas.add("http://ww3.sinaimg.cn/large/610dc034jw1f80uxtwgxrj20u011hdhq.jpg");
        datas.add("http://ww4.sinaimg.cn/large/610dc034jw1f7z9uxopq0j20u011hju5.jpg");
        datas.add("http://ww4.sinaimg.cn/large/610dc034jw1f8lox7c1pbj20u011h12x.jpg");
        datas.add("http://ww1.sinaimg.cn/large/610dc034jw1f867mvc6qjj20u00u0wh7.jpg");
        datas.add("http://ww3.sinaimg.cn/large/610dc034jw1f837uocox8j20f00mggoo.jpg");
        datas.add("http://ww4.sinaimg.cn/large/610dc034jw1f820oxtdzzj20hs0hsdhl.jpg");
        datas.add("http://ww3.sinaimg.cn/large/610dc034jw1f80uxtwgxrj20u011hdhq.jpg");
        return datas;
    }
}

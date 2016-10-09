package com.zhw.dagger2.di.components;

import com.zhw.dagger2.MainActivity;
import com.zhw.dagger2.di.modules.MainModule;

import dagger.Component;

/**
 * Created by zhonghanwen on 2016/10/9.
 */
@Component(modules = MainModule.class)
public interface MainComponents{

    void inject(MainActivity activity);

}

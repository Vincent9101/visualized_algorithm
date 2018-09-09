package com.github.com.vincent9101.visualized_algorithm.controller;

import com.github.com.vincent9101.visualized_algorithm.frame_view.AlgoFrame;
import java.awt.*;


/**
 * 相当于controller
 */
public abstract class AlgoVisualizer {


    private Object[] data;
    protected AlgoFrame frame;
    protected  String title;
    protected  int sceneHeight,sceneWidth;



    /**
     * 初始化数据
     */
    protected abstract Object[] initData();

    protected abstract void initFrame();

    //动画逻辑
    protected abstract void run();

    //界面显示
    protected void show() {
        data = initData();
        EventQueue.invokeLater(() -> {
            initFrame();
            frame.render(data);
            frame.pack();
            new Thread(() -> {
                run();
            }).start();
        });
    }

    public AlgoVisualizer() {
    }


}

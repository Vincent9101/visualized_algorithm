package com.github.com.vincent9101.visualized_algorithm.course_2_money;

import com.github.com.vincent9101.visualized_algorithm.controller.AlgoVisualizer;
import com.github.com.vincent9101.visualized_algorithm.util.AlgoFrameHelper;

import java.util.Arrays;

public class MoneyAlgoVisualizer extends AlgoVisualizer {
    private Integer[] money;

    public MoneyAlgoVisualizer(String title, int sceneWidth, int sceneHeight) {
        super();
        this.title=title;
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;
        show();
    }

    @Override
    protected Object[] initData() {
        money = new Integer[10];
        Arrays.fill(money, 100);
        System.out.println(Arrays.asList(money));
        return money;
    }

    @Override
    protected void initFrame() {
        frame = new MoneyAlgoFrame(title,sceneHeight,sceneWidth);
    }

    @Override
    protected void run() {
        while (true) {
            //绘制数据
            frame.render(money);
            AlgoFrameHelper.pause(10);
            //更新数据

        }

    }
}

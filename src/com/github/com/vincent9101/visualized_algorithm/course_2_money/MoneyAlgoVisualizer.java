package com.github.com.vincent9101.visualized_algorithm.course_2_money;

import com.github.com.vincent9101.visualized_algorithm.controller.AlgoVisualizer;
import com.github.com.vincent9101.visualized_algorithm.util.AlgoFrameHelper;

import java.util.Arrays;
import java.util.Collections;


/**
 *
 */
public class MoneyAlgoVisualizer extends AlgoVisualizer {
    private Integer[] money;

    public MoneyAlgoVisualizer(String title, int sceneWidth, int sceneHeight) {
        super();
        this.title = title;
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;
        show();
    }

    @Override
    protected Object[] initData() {
        money = new Integer[100];
        Arrays.fill(money, 100);
//        System.out.println(Arrays.asList(money));
        return money;
    }

    @Override
    protected void initFrame() {
        frame = new MoneyAlgoFrame(title, sceneHeight, sceneWidth);
    }

    @Override
    protected void run() {
        while (true) {
            //绘制数据
            Arrays.sort(money);
            frame.render(money);
            AlgoFrameHelper.pause(2);
            //更新数据
            for (int i = 0; i < money.length; i++) {
                int j = (int) (Math.random() * money.length);
                money[i]--;
                money[j]++;

            }

        }

    }
}

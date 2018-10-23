package com.github.com.vincent9101.visualized_algorithm.course_3.montecarlo;

import com.github.com.vincent9101.visualized_algorithm.controller.AlgoFrame;
import com.github.com.vincent9101.visualized_algorithm.controller.AlgoVisualizer;
import com.github.com.vincent9101.visualized_algorithm.course_2_money.MoneyAlgoFrame;

public class MonteCarloAlgoVisualizer  extends AlgoVisualizer {
    @Override
    protected Object[] initData() {
        return new Object[0];
    }

    @Override
    protected void initFrame() {

        frame = new MonteCarloAlgoFrame(title, sceneHeight, sceneWidth);


    }

    @Override
    protected void run() {

    }

}

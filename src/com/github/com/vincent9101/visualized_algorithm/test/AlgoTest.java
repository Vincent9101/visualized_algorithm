package com.github.com.vincent9101.visualized_algorithm.test;

import com.github.com.vincent9101.visualized_algorithm.controller.AlgoVisualizer;
import com.github.com.vincent9101.visualized_algorithm.course_1_circle.CircleAlgoVisualizer;
import com.github.com.vincent9101.visualized_algorithm.course_2_money.MoneyAlgoVisualizer;

/**
 * 由于使用JUnit 会导致创建的JFrame立马消失 （其最终原因不详）因此创建该类进行测试
 */
public class AlgoTest {

    {
        System.out.println("AlgoTest");
        InnerClass s = new InnerClass();
    }

    public AlgoTest() {
        System.out.println("AlgoTest=======");
    }

    public static void main(String args[]) {
        AlgoVisualizer algoVisualizer =algoFrameFactory("money");

    }

    public static AlgoVisualizer algoFrameFactory(String name) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int n = 20, radius = 50;
        AlgoVisualizer algoVisualizer = null;
        switch (name) {
            case "circle":
                algoVisualizer = new CircleAlgoVisualizer(name, sceneWidth, sceneHeight, n, radius);
                break;
            case "money":
               algoVisualizer = new MoneyAlgoVisualizer(name, sceneWidth, sceneHeight);
                break;
        }


        return algoVisualizer;

    }

    private class InnerClass {
        {
            System.out.println("INNERCLASS");

        }
    }

}

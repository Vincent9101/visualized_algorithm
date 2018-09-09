package com.github.com.vincent9101.visualized_algorithm.test;

import com.github.com.vincent9101.visualized_algorithm.controller.AlgoVisualizer;
import com.github.com.vincent9101.visualized_algorithm.course_1_circle.CircleAlgoVisualizer;

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
        algoFrameTest();

    }

    public static void algoFrameTest() {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int n = 20, radius = 50;
        AlgoVisualizer algoVisualizer = new CircleAlgoVisualizer("TestLLLLLL",sceneWidth, sceneHeight, n, radius);
//        AlgoVisualizer algoVisualizer = new MoneyAlgoVisualizer("TestLLLLLL",sceneWidth, sceneHeight);


    }

    private class InnerClass {
        {
            System.out.println("INNERCLASS");
        }
    }

}

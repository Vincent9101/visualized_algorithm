package com.github.com.vincent9101.visualized_algorithm.course_1_circle;

import com.github.com.vincent9101.visualized_algorithm.frame_view.AlgoFrame;
import com.github.com.vincent9101.visualized_algorithm.util.AlgoFrameHelper;

import java.awt.*;

public class CircleAlgoFrame extends AlgoFrame {

    private Circle[] circles;

    public CircleAlgoFrame(String title, int canvasHeight, int canvasWidth) {
        super(title, canvasHeight, canvasWidth);
        //TODO:设置canvas 这个函数最好利用传参的方式传递给AlgoFrame
        //为什么不能直接重构AlgoFrame构造函数呢？
        //由于我要设置的JPanel canvas 是在AlgoFrame子类中的声明的
        // 如果作为传参给父类初始化会报错
        // 传递的子类canvas只能在当前类加载后并且使用其继承的内部AlgoCanvas类 才能使用
        //所以如果将其传递给AlgoFrame 中是不能访问到子类中的内部类的 ，因为加载类初始化类的顺序都是有父类到子类的

        //那要怎样解决呢？
        //把AlgoCanvas作为单独的一个类就可以实现（同理：其AlgoFrame子类中的AlgoCanvas子类也应该独立的实现出来）
        // 但是这样AlgoCanvas与AlgoFrame的关系就不能明显地体现出来
        canvas = new CircleAlgoCanvas();
        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setContentPane(canvas);
        //pack 函数很重要 一定不能忘记
        // 自动调整大小 对内部进行整理
        pack();
    }

    @Override
    public void render(Object[] data) {
        this.circles = (Circle[]) data;
        this.repaint();
    }


    private class CircleAlgoCanvas extends AlgoCanvas {
        /**
         * 绘制圆形
         *
         * @param graphics2D
         */
        @Override
        protected void paintData(Graphics2D graphics2D) {
            for (Circle circle : circles) {
                if (!circle.isFilled)
                    AlgoFrameHelper.stokenCircle(graphics2D, circle.x, circle.y, circle.getR());
                else
                    AlgoFrameHelper.fillCircle(graphics2D, circle.x, circle.y, circle.getR());
            }
        }


        @Override
        protected void setGraphics2D(Graphics2D graphics2D) {
            AlgoFrameHelper.setRenderingHints(graphics2D);
            AlgoFrameHelper.setStrokenWidth(graphics2D, 1);
            AlgoFrameHelper.setGraphicColor(graphics2D, Color.RED);
        }
    }


}

package com.github.com.vincent9101.visualized_algorithm.course_2_money;

import com.github.com.vincent9101.visualized_algorithm.controller.AlgoFrame;

import com.github.com.vincent9101.visualized_algorithm.util.AlgoFrameHelper;

import java.awt.*;

public class MoneyAlgoFrame extends AlgoFrame {

    private Integer[] money;

    public MoneyAlgoFrame(String title, int canvasHeight, int canvasWidth) {
        super(title, canvasHeight, canvasWidth);
        canvas = new MoneyAlgoCanvas();
        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setContentPane(canvas);
        //pack 函数很重要 一定不能忘记
        // 自动调整大小 对内部进行整理
        pack();


    }

    @Override
    public void render(Object[] data) {
        this.money = (Integer[]) data;
        this.repaint();
    }

    private class MoneyAlgoCanvas extends AlgoCanvas {

        @Override
        protected void paintData(Graphics2D graphics2D) {
            //绘制那个长方形直方图
            int recWidth = getCanvasWidth() / money.length;
            for (int i = 0; i < money.length; i++) {
                if (money[i].intValue() > 0) {
                    AlgoFrameHelper.setGraphicColor(graphics2D, AlgoFrameHelper.Red);
                    AlgoFrameHelper.fillRectangle(graphics2D, i * recWidth + 1, getCanvasHeight() / 2 - money[i], recWidth - 1, money[i]);
                } else if (money[i].intValue() < 0) {
                    AlgoFrameHelper.setGraphicColor(graphics2D, AlgoFrameHelper.LightBlue);
                    AlgoFrameHelper.fillRectangle(graphics2D, i * recWidth + 1, getCanvasHeight() / 2, recWidth - 1, -money[i]);
                }
            }

        }

        @Override
        protected void setGraphics2D(Graphics2D graphics2D) {
            AlgoFrameHelper.setRenderingHints(graphics2D);
            AlgoFrameHelper.setStrokenWidth(graphics2D, 5);
            AlgoFrameHelper.setGraphicColor(graphics2D, Color.RED);
        }
    }
}

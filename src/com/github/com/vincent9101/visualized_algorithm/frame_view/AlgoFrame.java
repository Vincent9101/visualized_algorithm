package com.github.com.vincent9101.visualized_algorithm.frame_view;

import javax.swing.*;
import java.awt.*;

/**
 * View 部分
 */
public abstract class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;
    protected JPanel canvas;
    //    private Circle[] circles;
    private int[] money;

    public AlgoFrame(String title, int canvasHeight, int canvasWidth) {
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        pack(); //自动调整大小 对内部进行整理


        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //数据赋值
    public abstract void render(Object[] data);





    public int getCanvasWidth() {
        return canvasWidth;
    }
    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }
    public int getCanvasHeight() {
        return canvasHeight;
    }
    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    protected abstract class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            super(true);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            //设置画笔颜色
            setGraphics2D(g2d);
            //具体数据绘制
            paintData(g2d);


        }
        protected abstract void paintData(Graphics2D graphics2D);

        protected abstract void setGraphics2D(Graphics2D graphics2D);

        /**
         * 绘制money
         *
         * @param graphics2D
         */
        private void paintMoney(Graphics2D graphics2D) {


        }

    }

}


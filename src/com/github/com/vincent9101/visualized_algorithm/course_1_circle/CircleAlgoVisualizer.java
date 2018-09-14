package com.github.com.vincent9101.visualized_algorithm.course_1_circle;

import com.github.com.vincent9101.visualized_algorithm.controller.AlgoVisualizer;
import com.github.com.vincent9101.visualized_algorithm.util.AlgoFrameHelper;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleAlgoVisualizer extends AlgoVisualizer {


    private Circle[] circles;
    private boolean isAnimated;
    private int  circleNumber, circleRadius;

    public CircleAlgoVisualizer(String title,int sceneWidth, int sceneHeight, int circleNumber, int circleRadius) {
        super();
        this.title=title;
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;
        this.circleNumber = circleNumber;
        this.circleRadius = circleRadius;
        show();

    }

    @Override
    protected Object[] initData() {
        circles = new Circle[circleNumber];
        for (int i = 0; i < circleNumber; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * circleRadius)) + circleRadius;
            int y = (int) (Math.random() * (sceneWidth - 2 * circleRadius)) + circleRadius;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, circleRadius, vx, vy);
        }
        return circles;
    }

    @Override
    protected void initFrame() {
        frame = new CircleAlgoFrame(title, sceneHeight, sceneWidth);
        frame.addKeyListener(new CircleAlgoKeyListener());
        frame.addMouseListener(new CircleAlgoMouseListener());
        isAnimated = true;

    }

    //动画逻辑
    protected void run() {
        while (true) {
            //绘制数据
            frame.render(circles);
            AlgoFrameHelper.pause(10);
            //更新数据
            if (isAnimated)
                for (Circle circle : circles) {
                    circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
                }

        }
    }


    private class CircleAlgoMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            e.translatePoint(0, -(frame.getBounds().height - frame.getCanvasHeight()));
            System.out.println(e.getPoint());

            for (Circle circle : circles) {
                if (circle.contain(e.getPoint())) {
                    circle.isFilled = !circle.isFilled;

                }
            }
        }
    }

    private class CircleAlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            switch (e.getKeyChar()) {
                case ' ':
                    isAnimated = !isAnimated;
                    break;
            }
        }
    }


}

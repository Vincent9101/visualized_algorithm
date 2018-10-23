package com.github.com.vincent9101.visualized_algorithm.course_3.montecarlo;

import com.github.com.vincent9101.visualized_algorithm.controller.AlgoFrame;
import com.github.com.vincent9101.visualized_algorithm.util.AlgoFrameHelper;
import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.awt.*;
import java.util.LinkedList;

public class MonteCarloAlgoFrame extends AlgoFrame {


    private Circle circle;
    private LinkedList<Point>points;

    public MonteCarloAlgoFrame(String title, int canvasHeight, int canvasWidth) {
        super(title, canvasHeight, canvasWidth);
        circle=new Circle(canvasWidth/2,canvasHeight/2,canvasWidth/2);
        points=new LinkedList<Point>();
    }


    @Override
    public void render(Object[] data) {
        render();
    }
    private  void render(){
        repaint();
    }
    private class MonteCarloAlgoCanvas extends AlgoCanvas{

        @Override
        protected void paintData(Graphics2D graphics2D) {
            AlgoFrameHelper.setRenderingHints(graphics2D);
            AlgoFrameHelper.setGraphicColor(graphics2D,AlgoFrameHelper.LightBlue);
            AlgoFrameHelper.strokenCircle(graphics2D,circle.getX(),circle.getY(),circle.getR());

            for(int i=0 ;i<points.size();i++){
             Point p=points.get(i);
             if(circle.IsContained(p)){
                 AlgoFrameHelper.setGraphicColor(graphics2D,AlgoFrameHelper.DeepOrange);
             }
             else
                 AlgoFrameHelper.setGraphicColor(graphics2D,AlgoFrameHelper.Green);

             AlgoFrameHelper.fillCircle(graphics2D,p.x,p.y,3);
            }

         }

        @Override
        protected void setGraphics2D(Graphics2D graphics2D) {

        }
    }
}

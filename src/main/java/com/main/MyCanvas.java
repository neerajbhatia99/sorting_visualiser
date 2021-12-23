package com.main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyCanvas extends JLabel {

    private static int width = 1000;
    private static int height = (width*9)/16;
    private static int rectWidth = 5;
    private int arr[];
    private int col[];
    private int n = width/rectWidth;
    private static long sleep = 2000_000;
    private boolean high = false;

    public MyCanvas(){
        setPreferredSize(new Dimension(width, height));
        setOpaque(true);
        setBackground(Color.DARK_GRAY);
        arr = new int[n];
        col = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            col[i] = 0;
        }
        randinit();
    }
    public void randinit(){
        var random = new Random();
        for(int i=0; i<n; ++i){
            arr[i] = random.nextInt(height-10);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        g2d.setColor(Color.WHITE);
        int w = 0;
        for(int i=0; i<n;++i){
            int h = height - arr[i];
            int val = col[i] * 2;
            if(high==true){
                g2d.setColor(new Color(255-val, 255 , 255 - val));
            }
            else{
                g2d.setColor(new Color(255, 255 - val, 255 - val));
            }
            g2d.fillRect(w, h , rectWidth, arr[i]);
            if (col[i] > 0) {
                col[i]-= 20;
            }
            w = w+rectWidth;
        }
    }
    public void highlight() {
        high = true;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i];
            col[i] = 100;
            repaint();
            sleepFor(sleep);
        }
        high = false;
    }
    public void reset() {
        for (int i = 0; i < n; i++) {
            col[i] = 0;
        }
        repaint();
    }
    public void sleepFor(long time){
        long curTime =  System.nanoTime();
        int elapsed;
        do{
            elapsed = (int) (System.nanoTime() - curTime);
        }
        while(elapsed<time);
    }
    public void bubbleSort(){
        for(int i=0; i<n; ++i){
            for(int j=0; j<n-i-1; ++j){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1] ;
                    arr[j+1] =arr[j];
                    arr[j]=temp;
                    col[j+1] = 100;
                    col[j] = 100;
                    sleepFor(sleep);
                    repaint();
                }
            }
        }
    }

}

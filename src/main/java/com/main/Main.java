package com.main;

public class Main {
    public static void main(String[] args) {
        MyCanvas canvas = new MyCanvas();
        MyFrame frame = new MyFrame(canvas);
        canvas.bubbleSort();
        canvas.reset();
        canvas.highlight();
        canvas.reset();
    }
}


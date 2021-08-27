package com.example.demo.claculation;

public class DistanceMatrix extends Calculation{

    @Override
    public String calculate(double[] a,double[] b) {
        double x1 = a[0];
        double y1 = a[1];
        double x2 = b[0];
        double y2 = b[1];
        double v = (6371 * Math.hypot(x2 - x1, y2 - y1)) / 90;
        return v + "";
    }
}

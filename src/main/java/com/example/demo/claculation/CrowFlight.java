package com.example.demo.claculation;

public class CrowFlight extends  Calculation{
    @Override
    public String calculate(double[] a, double[] b) {
        double x1 = Math.toRadians(a[0]);
        double y1 = Math.toRadians(a[1]);
        double x2 = Math.toRadians(b[0]);
        double y2 = Math.toRadians(b[1]);
        double v = Math.acos(Math.sin(x1) * Math.sin(x2)
                + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2)) * 6371;
        return v + "";
    }
}

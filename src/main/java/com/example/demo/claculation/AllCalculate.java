package com.example.demo.claculation;

public class AllCalculate extends Calculation{

    @Override
    public String calculate(double[] a, double[] b) {
        Calculation calc1 = new CrowFlight();
        Calculation calc2 = new DistanceMatrix();
        return  calc1.calculate(a, b) + "\n" + calc2.calculate(a, b);
    }
}

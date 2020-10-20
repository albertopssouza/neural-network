/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.neuralnetwork;

/**
 *
 * @author alber
 */
public class NeuralNetwork {
    
    private double[] weights;
    private double bias;
    
    private double[][] training_sets;
    private int iterations;

    public NeuralNetwork(double[][] training_sets, int iterations) {
        this.training_sets = training_sets;
        this.iterations = iterations;
        this.weights = new double[training_sets[0].length];
        this.initWeights();
    }
    
    private void initWeights() {
        for (int i = 0; i < this.weights.length; i++) {
            this.weights[i] = Math.random();
            
            //System.out.println("w: " + this.weights[i]);
        }
        
        this.bias = Math.random();
        //System.out.println("b: " + this.bias);
    }
    
    public double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
    
    public double run(double[] inputs) {
        double sum = 0.0;
        
        for (int i = 0; i < this.weights.length; i++) {
            sum += (inputs[i] * this.weights[i]);
        }
        
        sum += this.bias;
        System.out.println("sum: " + sum);
        
        return this.sigmoid(sum);
    }
    
    public boolean train(double[] desired) {
        int count = 0;
        
        do {
            System.out.println("Época: " + (count + 1));
            for (int i = 0; i < this.training_sets.length; i++) {
                double y = this.run(this.training_sets[i]);
                
                // correção dos pesos
                for (int j = 0; j < this.weights.length; j++) {
                    this.weights[j] += (desired[i] - y) * this.training_sets[i][j];
                }
                
                this.bias += (desired[i] - y);
                String valueFormated1 = formatNumber(this.run(this.training_sets[i]));
                String valueFormated2 = formatNumber(desired[i]);
                
                //System.out.println("y: " + valueFormated1 + " -> desired: " + valueFormated2);
            }
            count++;
        } while(count < this.iterations);
        
        return true;
    }
    
    private String formatNumber(double value) {
        return String.format("%.10f", value);
    }
    
}

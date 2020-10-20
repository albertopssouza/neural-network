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
public class Rodar {
    
    public static void main(String[] args) {
        double[][] inputs = {
            new double[]{0, 0},
            new double[]{0, 1},
            new double[]{1, 0},
            new double[]{1, 1}
        };
        
        double[] desired = {0, 0, 0, 1};
        
//        double[][] inputs = {
//            new double[]{3, 0, 3, 4, 3, 4, 3},
//            new double[]{7, 6, 5, 4, 3, 2, 1},
//            new double[]{6, 5, 4, 3, 2, 1, 0},
//            new double[]{5, 4, 3, 2, 1, 0, 9}
//        };
//        
//        double[] desired = {1, 0, 0, 0};
    
        
        NeuralNetwork net = new NeuralNetwork(inputs, 1000);
        net.train(desired);
        
        System.out.println("====== TEST OR LOGIC ======");

        for(int i = 0; i < inputs.length; i++) {
            
            double value = net.run(inputs[i]);
//            String valueFormated = String.format("%.10f", value);
//            System.out.println("Value: " + valueFormated);
            String output = (value < 0.5)? "FALSE" : "TRUE";

            System.out.println(output);

        }
//        String valueFormated = String.format("%.10f", net.run(inputs[0]));
        //System.out.println("" + net.run(inputs[0]));
//        System.out.println(valueFormated);
    }
    
    
}

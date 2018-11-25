package com.company;

public class Main {

    public static void main( String[] args ){
        System.out.println();
        Polynomial example_1  = new Polynomial().add(new Term(4,5)).add(new Term(2,4));
        Polynomial example_2 = new Polynomial().add(new Term(3,0)).add(new Term(1,5));
        Polynomial result = example_1.multiply(example_2);
        System.out.println("1-st example: "+example_1);
        System.out.println("2-nd example:  = "+example_2);
        System.out.println("Result of multiply = "+result);

    }

}
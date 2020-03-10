package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("What sided die would you like to roll?");
        int die_num_sides = Integer.parseInt(TextIO.getlnString()) ;

        int result = roll_die(die_num_sides);

        System.out.println("you rolled a " + die_num_sides + " sided die");
        System.out.println("your result is: " + result);
    }

    // Find a random number from 1 to the number of sides
    public static int roll_die(int die_num_sides) {
        // First multiply the random value from 0 to 1 by one less than the number of sides to keep the value in range
        // Then add 1 to make it from 1 to the number of sides of the die
        return (int) (Math.random() * (die_num_sides - 1)) + 1;
    }
}

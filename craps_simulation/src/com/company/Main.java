package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("How many games would you like to simulate?");
        int num_games = Integer.parseInt(TextIO.getlnString());
        int games_won = 0;
        int games_lost = 0;

        // Iterate for number of games chosen by user
        for(int i=0;i<num_games;i++){
            // Roll the two dice once, this number becomes "the point" if is not a 7, 11, 2, 3, or 12
            int the_point = craps_roll();

            if (the_point == 7 || the_point == 11){  // Automatic come out victory
                games_won = games_won + 1;
            } else if(the_point == 2 || the_point == 3 || the_point == 12){  // Automatic come out loss
                games_lost = games_lost + 1;
            } else{  // The case where the number rolled becomes "the point"
                boolean keep_rolling = true;
                // Keep rolling dice until "the point" or a 7 is rolled
                while(keep_rolling){
                    // Roll the two dice
                    int dice_roll = craps_roll();

                    // Check here to see if the roll was a 7 or "the point"
                    if(dice_roll == the_point){
                        games_won = games_won + 1;
                        keep_rolling = false;
                    } else if(dice_roll == 7){
                        games_lost = games_lost + 1;
                        keep_rolling = false;
                    }
                }
            }
        }
        // Calculate the win rate and multiply by 100 to make it a percentage
        double win_percentage = (float)games_won / (games_won + games_lost) * 100;
        System.out.println("The simulation win percentage is: " + win_percentage);
    }

    // Find a random number from 1 to the number of sides
    public static int roll_die(int die_num_sides) {
        return (int) (Math.random() * (die_num_sides)) + 1;
    }

    // Find a random number from rolling two dice
    public static int craps_roll() {
        int die_one_result = roll_die(6);
        int die_two_result = roll_die(6);
        return die_one_result + die_two_result;
    }

}

package com.company;

public class Main {
    public static String VOWELS = "AEIOUYaeiouy";  // Class variable that contains all the legal vowels


    public static void main(String[] args) {
        // Init variables
        String phrase;
        String translated_phrase = "";
        String response;

        boolean keep_translating = true;  // Flow control for program loop
	    // Take in the phrase and split it into an array of strings
        while(keep_translating){
			System.out.println("Type a phrase to be translated to pig latin");
			phrase = TextIO.getln();
			String[] split_phrase = phrase.split(" ");

	    // Loop over the array(phrase) translating the words one at a time
	    for(String word : split_phrase) {
		    translated_phrase = translated_phrase.concat(translate_word_to_pig_latin(word) + " ");
            }

            // Print output to the user
            System.out.println(translated_phrase);

            // Check to see if user wants to translate a new phrase
            System.out.println("Would you like to translate another phrase? (Yy/Nn)");
            response = TextIO.getlnString();
            if(response.equals("N")|response.equals("n")){
                keep_translating = false;
            } else{
                translated_phrase = "";
            }

        }
    }

    // Given a word, translate the word to pig latin
    public static String translate_word_to_pig_latin(String word) {
        String new_word = word;
        int vowel_index = index_of_first_vowel(word);
        // Put starting consonant(s), if any, at the end of the word
        if(vowel_index > 0){
            new_word = word.substring(vowel_index) + word.substring(0, vowel_index);
        }

        // Add the ay to the end of all words
        new_word = new_word.concat("ay");
        return new_word;
    }

    // Given a word return the index of the first vowel
    public static int index_of_first_vowel(String word) {
        // Iterate over each letter of the word from the start
        for (int i = 0; i < word.length(); i++) {
            // True when the index i of the string is a vowel
            if(Main.VOWELS.indexOf(word.charAt(i)) > -1){
                return i;
            }
        }

        return -1;  // Condition when the word contains no vowels, program will just add ay to the end in this case
    }

}

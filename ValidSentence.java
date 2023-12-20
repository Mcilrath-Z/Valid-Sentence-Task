import java.util.Scanner;

public class ValidSentence {


    public static boolean isValidSentence(String sentence){

        //checks if the string is empty
         if (sentence.isEmpty()) {
            return false;
        }


        //checks if the string begins with a capital letter
        if(Character.isLowerCase(sentence.charAt(0))){
            return false;
        }


        //checks if the string has an even number of quotation marks
        int numberOfQuotationMarks = 0;

        for(int i = 0; i <sentence.length(); i++){
            if(sentence.charAt(i) == '\"'){
                numberOfQuotationMarks++;
            }
        }

        if(numberOfQuotationMarks % 2 != 0){
            return false;
        }


        //checks if the string ends with atleast one termination character
        char lastCharacter = sentence.charAt(sentence.length() -1);

        if(lastCharacter != '.' && lastCharacter != '?' && lastCharacter != '!'){
            return false;
        }


        //checks if the string has no period characters other than the last character
        String sentenceSubString = sentence.substring(0, sentence.length() - 1);
            if (sentenceSubString.contains(".")){
                return false;
            }


        //sets a named constant number to represent 13
        final int minimum_spell_out_number = 13; 


        //checks if the numbers before the constant number are spelled out
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (isNumeric(word) && Integer.parseInt(word) < minimum_spell_out_number) {
                return false;
            }
        }

        return true;
    }


    private static boolean isNumeric(String str) {
        //attempts to parse the string as an integer or a decimal number
        try {
            //attempts to convert the string to an integer
            Integer.parseInt(str);
            //if successful, the string is numeric
            return true;
        } catch (NumberFormatException ex1) {
            try {
                //attempts to convert the string to a decimal number
                Double.parseDouble(str);
                //if successful, the string is numeric
                return true;
            } catch (NumberFormatException ex2) {
                //if both attempts fail, the string is not numeric
                return false;
            }
        }
    }


    public static void main(String[] args) throws Exception {



        Scanner scanner = new Scanner(System.in);

        System.out.println("This program checks the validity of a sentence based on the criteria below:");
        System.out.println("> The sentence should not be empty.");
        System.out.println("> It should begin with a capital letter.");
        System.out.println("> The number of quotation marks should be even.");
        System.out.println("> It should end with at least one of the following: '.', '?', '!'");
        System.out.println("> There should be no period characters ('.') within the sentence, except for the last character.");
        System.out.println("> If there are numeric values, numbers below 13 should be spelled out.");
        System.out.println("Enter a sentence, and the program will determine if it meets these criteria.");

        String userSentence = scanner.nextLine();

        boolean isValid = isValidSentence(userSentence);

        System.out.println("Is the sentence valid? " + isValid);

        scanner.close();
    }
}

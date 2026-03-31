package com.compro.model;

import java.util.Scanner;


public class bekkelman {


    private static final Scanner consoleInput = new Scanner(System.in);
   
    // Leaderboard ng game
    private static final int LEADERBOARD_CAPACITY = 100;
    private static String[] playerNames = new String[LEADERBOARD_CAPACITY];
    private static int[] playerHighScores = new int[LEADERBOARD_CAPACITY];
    private static int recordsCount = 0;


    // mga possible words
    private static final String[] MASTER_WORD_LIST = {
        "airport", "balloon", "capture", "caution", "diamond", "dynamic", "edition",
        "feature", "federal", "gallery", "gateway", "habitat", "harbor", "healthy",
        "husband", "include", "justice", "kingdom", "laundry", "liberty", "machine",
        "maximum", "message", "million", "mineral", "mission", "musical", "mystery",
        "network", "opinion", "partner", "pattern", "penguin", "picture", "plastic",
        "quality", "quarter", "rainbow", "receipt", "silence", "storage", "subject",
        "teacher", "traffic", "unknown", "variety", "version", "victory", "volcano",
        "weekend"
    };


    public static void main(String[] args) {
        System.out.println("COMPRO PINAKA MAHIRAP!");
        startSystemLoop();
        consoleInput.close();
    }


    // main na loop
    public static void startSystemLoop() {
        String command;
       
        do {
            System.out.print("\n>>> Enter your PLayer Name: ");
            String currentUser = consoleInput.nextLine().trim();




            int sessionScore = runGameSession(currentUser);


            updateLeaderboard(currentUser, sessionScore);
            showLeaderboard();


            // print kung lalro pa
            System.out.println("\n-------------------------------------------");
            System.out.print("Play another round? (type 'no' to quit, any key to continue): ");
            command = consoleInput.next();
            consoleInput.nextLine();


        } while (!command.equalsIgnoreCase("no"));


        System.out.println("\nSystem Shutdown. Final Standings:");
        showLeaderboard();
        System.out.println("Goodbye, " + System.getProperty("user.name") + ".");
    }


    // pinaka main code ng game
    public static int runGameSession(String playerName) {
       
       
        //mag ggenerate ng random word galing sa master word list
        int randomIndex = (int) (Math.random() * MASTER_WORD_LIST.length);
        String targetWord = MASTER_WORD_LIST[randomIndex];
        // -----------------------------------------
       
        char[] hiddenState = new char[targetWord.length()];
       
        // yung mga blanko
        
        


        


        int livesLeft = 5;
        int currentScore = 100;
        boolean isVictorious = false;


        System.out.println("\nHoy start na: " + playerName);
        System.out.println("Goal: Guess the secret word.");


        // tutuloy yung game hangang 0 nalng life
        while (livesLeft > 0) {
            // UI Render
           
            displayLetters(hiddenState);
            System.out.println(" | Lives: " + livesLeft);


            // Input ng letter
            System.out.print("Guess a letter: ");
            String input = consoleInput.next().toLowerCase();
           
            // taga chech in input mo
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println(">> Invalid input. Please type a single letter.");
                continue;
            }


            char guess = input.charAt(0);
           
            // iccheck kung nag hulaan mo na yung letter
            if (isAlreadyRevealed(guess, hiddenState)) {
                System.out.println(">> meron na '" + guess + "'!");
                continue;
            }


            //ipprint yung hula mo kung tama
            if (checkGuess(targetWord, guess)) {
                System.out.println(">> Good job! '" + guess + "' is correct.");
                revealLetters(targetWord, hiddenState, guess);
               
                // iccheck if na guess na yung letter
                if (isWordSolved(hiddenState)) {
                    isVictorious = true;
                    break;
                }
            } else {
                System.out.println(">> Ngi, '" + guess + "' mali.");
                livesLeft--;
                // mag babawas ng 10 every mali
                if(currentScore > 10) currentScore -= 10;
            }
        }


        // mag pprint ng over all result
        if (isVictorious) {
            System.out.println("\n*** VICTORY! ***");
            System.out.println("The word was: " + targetWord.toUpperCase());
            return currentScore;
        } else {
            System.out.println("\n*** GAME OVER ***");
            System.out.println("The word was: " + targetWord.toUpperCase());
            return 0;
        }
    }


    // ilalagay nya yung letter kung tama
    public static void revealLetters(String fullWord, char[] displayArr, char letter) {
        for (int i = 0; i < fullWord.length(); i++) {
            if (fullWord.charAt(i) == letter) {
                displayArr[i] = letter;
            }
        }
    }


    // iccheck kung meron yung letter sa word
    public static boolean checkGuess(String word, char guess) {
        return word.indexOf(guess) >= 0;
    }


    // taga check if nasa tamang place na yung letter na hinulaan
    public static boolean isAlreadyRevealed(char guess, char[] currentBoard) {
        for (char c : currentBoard) {
            if (c == guess) return true;
        }
        return false;
    }


    // check if panalo ka
    public static boolean isWordSolved(char[] board) {
        for (char c : board) {
            if (c == '_') return false;
        }
        return true;
    }


    // mag print ng spacing
    public static void displayLetters(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }


    public static void updateLeaderboard(String name, int score) {
        if (recordsCount < LEADERBOARD_CAPACITY) {
            playerNames[recordsCount] = name;
            playerHighScores[recordsCount] = score;
            recordsCount++;
        } else {
            // mag sset ng limit ng players
            if (score > playerHighScores[LEADERBOARD_CAPACITY - 1]) {
                playerHighScores[LEADERBOARD_CAPACITY - 1] = score;
                playerNames[LEADERBOARD_CAPACITY - 1] = name;
            }
        }
        sortLeaderboard();
    }


    public static void sortLeaderboard() {
        // taga ayos ng score from highst to lowest
        for (int i = 0; i < recordsCount - 1; i++) {
            for (int j = 0; j < recordsCount - i - 1; j++) {
                if (playerHighScores[j] < playerHighScores[j + 1]) {
                    // swap score if mas mataas score
                    int tempScore = playerHighScores[j];
                    playerHighScores[j] = playerHighScores[j + 1];
                    playerHighScores[j + 1] = tempScore;


                    // swap name if new player
                    String tempName = playerNames[j];
                    playerNames[j] = playerNames[j + 1];
                    playerNames[j + 1] = tempName;
                }
            }
        }
    }


    // leader board
    public static void showLeaderboard() {
   
        if (recordsCount == 0) {
            System.out.println("    No Records Found.");
        } else {
            System.out.printf("%-20s | %s%n", "PLAYER", "SCORE");
            System.out.println("----------------------------------");
            for (int i = 0; i < recordsCount; i++) {
                System.out.printf("%-20s | %d%n", playerNames[i], playerHighScores[i]);
            }
        }
       
    }
}

package Main;

// PROGRAMMED BY KARL ANGELO T. GABAES

import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class BJ {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        // MANUAL DICTIONARY
        List<String> manualDictionary5w = new ArrayList<>();

        // OPENS THE TEXT FILE AND ADDS EACH WORD INTO THE VARIABLE MANUAL DICTIONARY
        try (Scanner fileScanner = new Scanner(new File("src/5-letter-words"))) {
            while (fileScanner.hasNextLine()) {
                manualDictionary5w.add(fileScanner.nextLine().trim().toUpperCase());
            }
        } catch (Exception dictionaryNotFound) {
            JOptionPane.showMessageDialog(null, "Dictionary file not found!");
        }

        // ACCOUNT SETUP
        int n = 100;
        int totalAcc = 0;

        // ARRAY OF ACCOUNT INFO: (0) USERNAME, (1) PASSWORD -> FOR STORING
        String[][] accounts = new String[n][2];

        // ARRAY OF STATS INFO: (0) TOTAL GAMES, (1) WINS, (2) AVERAGE, (3) TOTAL SCORE, (4) WIN RATE, (5) HIGHEST SCORE -> FOR STORING
        double[][] stats = new double[n][6];

        // CURRENT USER INITIALIZATION
        String currentUser = null;
        int currentUserIndex = -1;

        // MAJOR GAME HANDLERS
        boolean on = true;
        boolean menu = true;
        boolean signingIn = true;

        // GAMEPLAY VARIABLES
        boolean playing; // PLAY MODE HANDLER
        boolean playingCg; // CUSTOM GAME HANDLER
        int attempts, maxAttempts, attemptsUsed, playAgainChoice;
        double score = 0;
        String userGuess, correctWord, formattedScore;

        // CUSTOM GAME VARIABLES
        int cgChoice, p2Attempts, cgPlayAgainChoice;
        String p1word, p2guess;

        // ACCOUNT SETTINGS VARIABLES
        int signInChoice, userMenuChoice, editAcc, accStatusChoice;
        String name, pass, newName, userName;
        boolean accFound;

        // PROGRAM RUNNING
        while (on) {

            //SIGN IN PROCESS/ACCOUNT SETTINGS
            while (signingIn) {

                System.out.println("""
                            ---------------------------------
                            |           Sign In             |
                            ---------------------------------
                            """);

                System.out.println("[1] Create account\n[2] Log in\n[3] Quit\n");
                System.out.print("[_] Enter choice: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("\n[!] Choose properly!");
                    scanner.nextLine();
                    continue;
                }

                signInChoice = scanner.nextInt();
                scanner.nextLine();

                switch (signInChoice) {

                    // SIGN UP
                    case 1:
                        accFound = false;

                        System.out.println("[..] Signing up\n");

                        name = JOptionPane.showInputDialog("Enter user name");
                        if (name == null || name.trim().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }
                        name = name.trim();

                        for (int i = 0; i < totalAcc; i++){
                            if (accounts[i][0] != null && accounts[i][0].equals(name)) {
                                accFound = true;
                                break;
                            }
                        }

                        if (accFound) {
                            System.out.println("[!] Username already exists.");
                            continue;
                        }

                        pass = JOptionPane.showInputDialog("Enter password: ");
                        if (pass == null || pass.trim().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }
                        pass = pass.trim();

                        currentUserIndex = totalAcc;
                        accounts [currentUserIndex][0] = name;
                        accounts [currentUserIndex][1] = pass;

                        //initialize stats
                        Arrays.fill(stats[currentUserIndex],0);

                        totalAcc++;

                        currentUser = name;
                        signingIn = false;
                        menu = true;

                        System.out.println("\n\n[+] Account created! Logged in as " + currentUser);
                        break;

                        // LOGIN TO EXISTING ACCOUNT
                    case 2:
                        System.out.println("[..] Logging in\n");
                        accFound = false;

                        userName = JOptionPane.showInputDialog("Enter username");
                        if (userName == null || userName.trim().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }

                        pass = JOptionPane.showInputDialog("Enter password: ");
                        if (pass == null || pass.trim().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }
                        pass = pass.trim();

                        for (int i = 0; i < totalAcc; i++){
                            if (accounts[i][0] != null && accounts[i][0].equals(userName)
                                    && accounts[i][1] != null && accounts[i][1].equals(pass)) {
                                currentUserIndex = i;
                                currentUser = accounts [i][0];
                                accFound = true;
                                break;
                            }
                        }

                        if (!accFound) {
                            System.out.println("[!] Account does not exist.");
                            continue;
                        }

                        System.out.println("[> <] Logged in as " + currentUser + "!");
                        signingIn = false;
                        menu = true;
                        break;
                    case 3:
                        System.out.println("[' - '] Bye!");
                        return;
                    default:
                        System.out.println("\n[!] Enter a valid option.\n");
                }
            }


            while (menu) {

                System.out.println();
                System.out.println("""
                            =======================================
                            |           WELCOME TO BJ!            |
                            =======================================
                            """);
                System.out.println("""
                        [1] Play
                        [2] Custom Game
                        [3] View Stats
                        [4] Tutorial
                        [5] Account Settings
                        [6] Credits
                        [7] Exit
                        """
                );
                System.out.print("[_] Enter choice: ");

                try {
                    userMenuChoice = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("\nEnter a valid integer!");
                    scanner.nextLine();
                    continue;
                }

                switch (userMenuChoice) {

                        // PLAY MODE
                    case 1:
                        playing = true;
                        while (playing) {
                            attempts = 9;
                            maxAttempts = 9;
                            correctWord = manualDictionary5w.get(random.nextInt(manualDictionary5w.size()));
                            attemptsUsed = 0;
                            System.out.println("""
                                    
                                    ---------------------------------------
                                    |            ENJOY YOUR BJ!           |
                                    ---------------------------------------
                                    """);

                            System.out.println("\n[!] Just enter 1 to end current game\n");
                            System.out.println("""
                                    
                                    ---------------------------------------
                                    |             GOOD LUCK!              |
                                    ---------------------------------------
                                    
                                    """);

                            while (attempts > 0) {

                                System.out.println("[" + attempts + "] Attempts");

                                System.out.print("Enter a 5-letter-word: ");

                                userGuess = scanner.nextLine().trim().toUpperCase();

                                if (userGuess.equals("1")) {
                                    playing = false;
                                    score = 0;
                                    break;
                                }

                                if (userGuess.length() != 5 || !userGuess.matches("[A-Za-z]+") || !manualDictionary5w.contains(userGuess)) {
                                    System.out.println("[!] Invalid input.");
                                    continue;
                                }

                                String feedback = systemFeedback(correctWord, userGuess);
                                System.out.println("Guess:  " + userGuess);
                                System.out.println("Result: " + feedback);
                                System.out.println();

                                attemptsUsed++;

                                if (userGuess.equals(correctWord)) {
                                    stats[currentUserIndex][0]++;
                                    score = 75 + 25 * (1 - Math.pow((attemptsUsed / (double) maxAttempts), 2));
                                    DecimalFormat df = new DecimalFormat("#.##");
                                    formattedScore = df.format(score);
                                    stats[currentUserIndex][1]++;

                                    // CHECK FOR HIGHEST SCORE
                                    if (score > stats[currentUserIndex][5]) {
                                        stats[currentUserIndex][5] = score;
                                    }

                                    playAgainChoice = JOptionPane.showConfirmDialog(null,
                                            "Correct! The word was: " + correctWord + "\nAttempts used: "
                                                    + attemptsUsed + "/" + maxAttempts + "\nScore: " + formattedScore +
                                                    "\nPlay again?", "Winner!",
                                            JOptionPane.YES_NO_OPTION);

                                    playing = (playAgainChoice == JOptionPane.YES_OPTION);
                                    break;
                                } else {
                                    score = 74;
                                }
                                attempts--;
                            }

                            if (attempts == 0) {
                                stats[currentUserIndex][0]++;

                                playAgainChoice = JOptionPane.showConfirmDialog(null, "You lost! :(\n" +
                                        "The word was: " + correctWord + "\nPlay again?", "Result", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                playing = (playAgainChoice == JOptionPane.YES_OPTION);
                            }

                            stats[currentUserIndex][3] += score;

                            if (stats[currentUserIndex][0] > 0) {
                                stats[currentUserIndex][2] = stats[currentUserIndex][3] / stats[currentUserIndex][0]; // avg
                                stats[currentUserIndex][4] = (stats[currentUserIndex][1] / stats[currentUserIndex][0]) * 100; // winrate
                            }
                        }
                        break;

                        // CUSTOM MODE
                    case 2:

                        System.out.println("""
                                
                                ---------------------------------------
                                |            CUSTOM GAME              |
                                ---------------------------------------
                                
                                For this mode, 2 players are needed.
                                
                                Player 1:
                                - Create a VALID 5-letter word
                                   (to make guessing possible)
                                - Set Player 2's attempts
                                
                                Player 2:
                                - Guess Player 1's word
                                - Twist:
                                        Player 2 can enter any 5
                                        characters as long as it is
                                        5 letters
                                
                                ---------------------------------------
                                """);
                        System.out.println("[1] Understood\n[2] Back");
                        System.out.print("\nEnter choice: ");


                        if (!scanner.hasNextInt()) {
                            System.out.println("[!] Invalid.");
                            scanner.nextLine();
                            continue;
                        }
                        cgChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (cgChoice == 2) break;

                        playingCg = true;

                        while (playingCg) {

                            System.out.println();
                            System.out.print("[P1] Enter a 5-letter-word: ");
                            p1word = scanner.nextLine().trim().toUpperCase();

                            if (p1word.length() != 5) {
                                System.out.println("[!] Must be 5 letters.");
                                continue;
                            }

                            if (!p1word.matches("[A-Za-z]+") || p1word.contains(" ")) {
                                System.out.println("[!] Make sure you typed in letters.");
                                continue;
                            }

                            manualDictionary5w.add(p1word);

                            while (true) {

                                System.out.print("\n[P1] How many attempts will P2 get?: ");

                                if (!scanner.hasNextInt()) {
                                    System.out.println("[!] Invalid.");
                                    scanner.nextLine();
                                    continue;
                                }
                                p2Attempts = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            }

                            for (int i = 0; i < 30; i++) System.out.println();

                            System.out.println("""
                                    
                                    ---------------------------------------
                                    |         GOOD LUCK PLAYER 2!         |
                                    ---------------------------------------
                                    """);


                            while (p2Attempts > 0) {
                                System.out.println("[" + p2Attempts + "] Attempts");
                                System.out.print("[P2] Guess the word: ");
                                p2guess = scanner.nextLine().trim().toUpperCase();

                                if (p2guess.equals("1")) {
                                    playingCg = false;
                                    break;
                                }
                                if (p2guess.length() != 5) {
                                    System.out.println("[!] Must be 5 letters; No integers\n");
                                    continue;
                                }
                                if (!p2guess.matches("[A-Za-z]+") || p2guess.contains(" ")) {
                                    System.out.println("[!] Make sure you typed in letters.");
                                    continue;
                                }

                                String feedbackCG = systemFeedback(p1word, p2guess);
                                System.out.println();
                                System.out.println("Guess:  " + p2guess);
                                System.out.println("Result: " + feedbackCG);
                                System.out.println();

                                if (p2guess.equals(p1word)) {
                                    JOptionPane.showMessageDialog(null, "Congrats! You guessed the word!", "Win!", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }

                                p2Attempts--;
                            }
                            if (p2Attempts == 0) {
                                JOptionPane.showMessageDialog(null, "Not bad! The word was " + p1word, "Lost!", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }

                            System.out.println("\n[?] Play again?");
                            System.out.println("\n[1] Yes\n[2] No, thanks");
                            System.out.print("Enter choice: ");

                            try {
                                cgPlayAgainChoice = scanner.nextInt();
                                scanner.nextLine();
                                if (cgPlayAgainChoice == 2) {
                                    playingCg = false;
                                }
                            } catch (Exception choiceError) {
                                System.out.println("Enter a valid choice.");

                            }
                        }
                        break;

                        // STATS
                    case 3:
                        System.out.println("""
                                
                                ---------------------------------------
                                |             USER STATS              |
                                ---------------------------------------
                                
                                """);

                        System.out.println("User: " + currentUser);
                        System.out.println("Games Played: " + (int) stats[currentUserIndex][0]);
                        System.out.println("Wins: " + (int) stats[currentUserIndex][1]);
                        System.out.printf("Win rate: %.2f", stats [currentUserIndex][4]);
                        System.out.printf("\nHighest score: %.2f", stats [currentUserIndex][5]);
                        if (stats[currentUserIndex][0] == 0) {
                            System.out.println("\nAverage Score: 0");
                        } else {
                            System.out.printf("\nAverage Score: %.2f", stats [currentUserIndex][2]);
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println();
                        break;

                        // TUTORIAL
                    case 4:
                        JOptionPane.showMessageDialog(null, """
                                [ ! ] The game has a built-in dictionary
                                A random 5-letter word is generated every time you start a game.
                                
                                You must guess the correct word by typing your own 5-letter guesses.
                                
                                Symbol meanings:
                                x  = letter does NOT exist in the correct word
                                ~  = letter exists but is in the WRONG position
                                !  = letter exists and is in the CORRECT position
                                
                                --------------------------------------------
                                Example 1 - 5 LETTER WORD
                                --------------------------------------------
                                Correct word: Y E A R N
                                Your guess:    B R A  I N
                                
                                Result:
                                        Guess:  B R A  I  N
                                        Result:  X  ~ !  x  !
                                
                                --------------------------------------------
                                Example 2 - 6 LETTER WORD
                                --------------------------------------------
                                Correct Word: L  I  K E L Y
                                Your guess:    L O N E L Y
                                
                                Result:
                                        Guess:  L O N E L Y
                                        Result:  !  X  x  !  !  !
                                """, "--------------------- HERE'S HOW TO PLAY BJ! ---------------------", JOptionPane.INFORMATION_MESSAGE);
                        break;

                        // ACCOUNT SETTINGS
                    case 5:
                        System.out.println("""
                                
                                ---------------------------------------
                                |          ACCOUNT SETTINGS           |
                                ---------------------------------------
                                """);
                        System.out.println("[1] Rename account\n[2] Switch account\n[3] Delete account\n[4] Back");
                        System.out.print("\nEnter choice: ");
                        editAcc = scanner.nextInt();
                        scanner.nextLine();

                            switch (editAcc) {

                                case 1: // RENAME ACCOUNT
                                    newName = JOptionPane.showInputDialog(null, "Enter new name for " + currentUser);

                                    if (newName == null || newName.isEmpty() || newName.contains(" ")) {
                                        System.out.println("[!] Invalid name.");
                                        continue;
                                    }

                                    if (newName.equals(currentUser)) {
                                        System.out.println("\n[!] Name is the same. Try again.");
                                        continue;
                                    }

                                    boolean accExist = false;
                                    for (int i = 0; i < totalAcc; i++) {
                                        if (accounts[i][0] != null && accounts[i][0].equals(newName)) {
                                            System.out.println("[!] Name already exist");
                                            accExist = true;
                                        }
                                    }

                                    if (accExist){
                                        continue;
                                    }

                                    accounts[currentUserIndex][0] = newName;
                                    currentUser = newName;

                                    JOptionPane.showMessageDialog(null, "Account renamed to → " + currentUser);
                                    break;

                                case 2: // SWITCH ACCOUNT (REDIRECTS THE USER TO THE SIGN IN MENU)
                                    menu = false;
                                    signingIn = true;
                                    currentUserIndex = -1;
                                    currentUser = null;
                                    break;

                                case 3: // DELETE ACCOUNT

                                    String deletionPass = JOptionPane.showInputDialog(null,
                                            "Enter password to continue", "Deletion", JOptionPane.WARNING_MESSAGE);

                                    if (deletionPass.equals(accounts[currentUserIndex][1])) {

                                        System.out.println("\nDelete account \"" + currentUser + "\"?");
                                        System.out.println("[1] Confirm\n[2] Cancel");
                                        System.out.print("Enter choice: ");
                                        accStatusChoice = scanner.nextInt();


                                        if (accStatusChoice == 1) {

                                            // ERASE ACCOUNT
                                            accounts[currentUserIndex][0] = null;
                                            accounts[currentUserIndex][1] = null;

                                            // ERASE ALL STATS
                                            stats[currentUserIndex][0] = 0;
                                            stats[currentUserIndex][1] = 0;
                                            stats[currentUserIndex][2] = 0;
                                            stats[currentUserIndex][3] = 0;
                                            stats[currentUserIndex][4] = 0;
                                            stats[currentUserIndex][5] = 0;

                                            JOptionPane.showMessageDialog(null,
                                                    "Account deleted successfully.");

                                            // SHIFT VALUES UP
                                            for (int i = currentUserIndex; i < totalAcc - 1; i++) {
                                                accounts[i] = accounts[i + 1];
                                                stats[i] = stats[i + 1];
                                            }

                                            // CLEAR LAST VALUE WHICH IS DUPLICATED
                                            accounts[totalAcc - 1] = new String[2];
                                            stats[totalAcc - 1] = new double[6];
                                            totalAcc--;

                                            // FORCE LOGOUT
                                            currentUser = null;
                                            currentUserIndex = -1;
                                            menu = false;
                                            signingIn =  true;
                                        }
                                        else  {
                                            System.out.println("[!] Cancelled.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Password incorrect!");
                                    }
                                    break;
                            }
                            break;

                        // CREDITS
                    case 6:
                        System.out.println("""
                                
                                ------------------------------------------------------------------------------
                                |                                   CREDITS                                  |
                                ------------------------------------------------------------------------------
                                
                                Project Creator                                   Game Design
                                [+] Karl Angelo Gabaes                            [+] Karl Angelo Gabaes
                                [+] Marc Lorenz Estrella                          [+] Marc Lorenz Estrella
                                [+] John Cloyd Cabayao
                                [+] Leonard Mantalaba
                                
                                Lead Developer                                    UI/UX Designer
                                [+] Karl Angelo Gabaes                            [+] Karl Angelo Gabaes
                                
                                Programming                                       Dictionary
                                [+] Karl Angelo Gabaes                            [+] Karl Angelo Gabaes
                                [+] John Cloyd Cabayao                            [+] Marc Lorenz Estrella
                                                                                  [+] John Cloyd Cabayao
                                                                                  [+] Leonard Mantalaba
                                
                                Quality Assurance (QA)                            Testers
                                [+] Karl Angelo Gabaes                            [+] Karl Angelo Gabaes
                                [+] John CLoyd Cabayao
                                
                                Document
                                [+] Karl Angelo Gabaes
                                [+] John Cloyd Cabayao
                                [+] Marc Lorenz Estrella
                                [+] Leonard Mantalaba
                                
                                Special Thanks
                                [+] Everyone
                                
                                Tools
                                • Java
                                • IntelliJ IDEA / NetBeans
                                
                                ------------------------------------------------------------------------------
                                |                       THANKS FOR PLAYING THE GAME!!                        |
                                ------------------------------------------------------------------------------
                                """);
                        break;

                        // EXIT
                    case 7:
                        int exitConfirm = (JOptionPane.showConfirmDialog(null, "Confirm exit?", "Exit program", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE));
                        if (exitConfirm == JOptionPane.YES_OPTION) {
                            System.out.println("""
                                    ------------------------------------------------------------------------------
                                    |                       THANKS FOR PLAYING THE GAME!!                        |
                                    ------------------------------------------------------------------------------
                                    """);
                            menu = false;
                            on = false;
                        } else if (exitConfirm == JOptionPane.NO_OPTION || exitConfirm == JOptionPane.CANCEL_OPTION) {
                            continue;
                        }
                        break;
                    default:
                        System.out.println("\nEnter a valid choice.");
                }
            }
        }
        scanner.close();
    }
    
    // SYSTEM FEEDBACK
    public static String systemFeedback (String correctWord, String userGuess) {
        char[] result = new char[5];

        for (int i = 0; i < 5; i++) {
            if (userGuess.charAt(i) == correctWord.charAt(i)) {
                result[i] = '!';
            } else if (correctWord.indexOf(userGuess.charAt(i)) != -1) {
                result[i] = '~';
            } else {
                result[i] = 'x';
            }
        }
        return new String(result);
    }

}

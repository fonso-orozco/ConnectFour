package connectfour;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Board board = new Board();
        String selection = "";
        

        // getting some input
        Scanner input = new Scanner(System.in);
        print_menu();
        selection = input.nextLine();

        switch (Integer.valueOf(selection)) {
            case 1: new_game(input, board);
                    break;
            case 2: board.showBoard();
                    break;
            default: break;
        }
        
        input.close();

    }
    // start menu
    public static void print_menu() {
        System.out.println("\nWelcome to ConnectFour!\n");
        System.out.println("Choose from the following options:\n");
        System.out.println("1 - New Game");
        System.out.println("2 - Show Board");
        System.out.println("3 - Exit\n");
    }

    public static void new_game(Scanner input, Board board) {
        String first_player = "";
        String second_player = "";
        boolean exit = false;
        int move = 0;

        // creates both players and assigns color

        System.out.println("Enter player 1's name: ");
        first_player = input.nextLine();
        System.out.println("Enter player 2's name: ");
        second_player = input.nextLine();
        Player player_1 = new Player(first_player, "red");
        Player player_2 = new Player(second_player, "yellow");
        
        while (exit != true){
            System.out.println(player_1.get_player_name() + "'s turn. Choose column 1 - 7 or -1 to quit");
            move = input.nextInt();
            board.setpieceOnSpace(player_1, move - 1);
            exit = board.checkWin(player_1);
            if (exit == true) {
                break;
            }
            System.out.println(player_2.get_player_name() + "'s turn. Choose column 1 - 7 or -1 to quit");
            move = input.nextInt();
            board.setpieceOnSpace(player_2, move - 1);
        }
    }
    }

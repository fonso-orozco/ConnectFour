package connectfour;

public class Board {

    public String[][] board = new String[6][7];

    public Board() {
        //constructor, fills board with empty cirlces
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = "🔘" ;
            }
        }
    }

    public void showBoard() {
        //prints the board 
        for (int i = 0; i < 6; i++) {
            for (int x = 0; x < 7; x++) {
                System.out.print(board[i][x] + " ");
            }
            System.out.print("\n"); // new line
        }
        System.out.println();
    }

    public void setpieceOnSpace(Player player, int column) {
        //drops a piece into the lowest unoccupied space on column selected
        for (int row = 5; row > 0; row--) {
            if (board[row][column] == "🔘") {
                board[row][column] = player.get_piece_color();
                System.out.println(player.get_player_name() + "'s " + player.get_piece_color() + " move: \n");
                showBoard();
                // checkWin(player);
                break;
            }
        }
    }

    // the following block of code checks for a player win
    // i may move this to another class entirely

    public boolean checkWin(Player player) {
        // checks horizontal win
        for (int j = 0; j<7-3 ; j++ ){
            for (int i = 0; i<6; i++){
                if (this.board[i][j] == player.piece_color && this.board[i][j+1] == player.piece_color && this.board[i][j+2] == player.piece_color && this.board[i][j+3] == player.piece_color){
                    System.out.println(player.get_player_name() + "'s a Winner!");
                    return true;
                }           
            }
        }
        // checks vertical win
        for (int i = 0; i<6-3 ; i++ ){
            for (int j = 0; j<7; j++){
                if (this.board[i][j] == player.piece_color && this.board[i+1][j] == player.piece_color && this.board[i+2][j] == player.piece_color && this.board[i+3][j] == player.piece_color){
                    System.out.println(player.get_player_name() + "'s a Winner!");
                    return true;
                }           
            }
        }
        // checks ascending diagonal win 
        for (int i=3; i<6; i++){
            for (int j=0; j<7-3; j++){
                if (this.board[i][j] == player.piece_color && this.board[i-1][j+1] == player.piece_color && this.board[i-2][j+2] == player.piece_color && this.board[i-3][j+3] == player.piece_color) {
                    System.out.println(player.get_player_name() + "'s a Winner!");
                    return true;
                }
            }
        }
        // checks descending diagonal win - need to work on this still
        // for (int i=3; i<6; i++){
        //     for (int j=3; j<7; j++){
        //         if (this.board[i][j] == player.piece_color && this.board[i-1][j-1] == player.piece_color && this.board[i-2][j-2] == player.piece_color && this.board[i-3][j-3] == player.piece_color)
        //             System.out.println(player.get_player_name() + "'s a Winner!");
        //             
        //     }
        // }
        return false;
    }

    // clears board
    public void clearBoard(int x, int y) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = "🔘" ;
            }
        }
    }
}

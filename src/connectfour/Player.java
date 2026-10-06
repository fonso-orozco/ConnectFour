package connectfour;

public class Player {
    // player attribtues
    String player_name;
    String piece_color;
    
    // sets and gets player name
    public void set_player_name(String player_name) {
        this.player_name = player_name;
    }
    public String get_player_name() {
        return player_name;
    }
    
    // sets and gets player piece color
    public String get_piece_color() {
        return piece_color;
    }
    public void set_piece_color(String piece_color) {
        if (piece_color == "red") {
            piece_color = "🔴";
        } else {
            piece_color = "🟡";
        }
        this.piece_color = piece_color;
    }

    // Player constructor 
    public Player (String player_name, String piece_color) {
        if (piece_color == "red") {
            piece_color = "🔴";
        } else {
            piece_color = "🟡";
        }
        this.piece_color = piece_color;
        this.player_name = player_name;
    }
}

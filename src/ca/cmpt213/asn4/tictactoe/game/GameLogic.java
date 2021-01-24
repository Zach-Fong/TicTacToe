package ca.cmpt213.asn4.tictactoe.game;

//checks if a game wins or is tied
public class GameLogic {

    public static int checkWin(int[][] values){
        boolean check = true;

        //row
        for(int a=0; a<4; a++){
            check = true;
            for(int b=0; b<3; b++){
                if(values[a][b] != values[a][b+1]){
                    check = false;
                }
                else if(values[a][b] ==0 ){
                    check = false;
                }
            }
            if(check){
                return values[a][0];
            }
        }

        //col
        for(int a=0; a<4; a++){
            check = true;
            for(int b=0; b<3; b++){
                if(values[b][a] != values[b+1][a]){
                    check = false;
                }
                else if(values[b][a] ==0 ){
                    check = false;
                }
            }
            if(check){
                return values[0][a];
            }
        }

        //diagonal top to bottom
        check = true;
        for(int a=0; a<3; a++){
            if(values[a][a] != values[a+1][a+1]){
                check = false;
            }
            else if(values[a][a] == 0 ){
                check = false;
            }
        }
        if(check){
            return values[0][0];
        }

        //diagonal bottom to top
        check = true;
        for(int a=0; a<3; a++){
            if(values[a][3-a] != values[a+1][2-a]){
                check = false;
            }
            else if(values[a][3-a] == 0){
                check = false;
            }
        }
        if(check){
            return values[0][3];
        }

        return 0;
    }

    public static boolean checkEnd(int[][] values){
        boolean check = true;
        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                if(values[a][b] == 0){
                    check = false;
                }
            }
        }
        return check;
    }
}

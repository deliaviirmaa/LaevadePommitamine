import java.util.Scanner;

/**
 * Created by Delia on 22.12.2015.
 */
public class Game {


    /**
     * See meetod paneb mängu käima.
     */
    private static String username;

    public void runGame() {
        introduction();
        BoardForUser boardForUser = new BoardForUser();
        boardForUser.printBattleBoardForUser();
        guessIsValid(getUserGuess());
        Board emptyBoard = new Board();
        emptyBoard.buildBattleBoard();
        emptyBoard.printBattleBoard();
    }

    public String getUsername() {
        return username;

    }

    public void setUsername(String username) {
        this.username = username;
    }


    private String introduction() {
        System.out.println("Tere tulemast mängu laevade pommitamine. Sinu ülesandeks on leida üles kõik peidetud laevad. " +
                "Laevade leidmiseks paku ükshaaval asukohti nt A5. Toredat mängu!");
        System.out.println("Sisesta oma nimi.");
        Scanner scanner = new Scanner(System.in);
        username = scanner.nextLine();
        setUsername(username);
        return username;
    }

    private char[] getUserGuess() {
        String userInserted;
        char[] userGuess;
        System.out.println(username + ", tee oma pakkumine!");
        Scanner scanner = new Scanner(System.in);
        userInserted = scanner.nextLine();
        userInserted = userInserted.toUpperCase();
        userGuess = userInserted.toCharArray();
        return userGuess;
    }

    private boolean guessIsValid(char[] userGuess) {
        //if ( firstIsLetter(userGuess)&& secondIsNumber(userGuess)) {
          //  return true;
        //}
        while (!firstIsLetter(userGuess)&& !secondIsNumber(userGuess)) {
            System.out.println("Midagi läks valesti. Sisestus peab olema kujul nt. A5.");
            getUserGuess();
        }
        return true;
    }
    private boolean firstIsLetter(char [] userGuess){
        if (userGuess[0]=='A' || userGuess[0]=='B'|| userGuess[0]=='C' || userGuess[0]=='D' || userGuess[0]=='E' ||
                userGuess[0]=='F'|| userGuess[0]=='G'|| userGuess[0]=='H'|| userGuess[0]=='I'|| userGuess[0]=='J'){
            return true;
        }
        return false;
    }
    private boolean secondIsNumber(char[]userGuess){
        if(userGuess.length==2 && (userGuess[1]=='1'||userGuess[1]=='2'|| userGuess[1]=='3' || userGuess[1]=='4' ||
                userGuess[1]=='5' || userGuess[1]=='6' || userGuess[1]=='7' || userGuess[1]=='8' || userGuess[1]=='9')){
            return true;
        } else if (userGuess.length==3 && userGuess[1]=='1'&& userGuess[2]=='0'){
            return true;
        }

        return false;
    }
    /*'while (!guessIsValid(){
    System.out.println("Midagi läks valesti. Sisestus peab olema kujul nt. A5.");

    getUserGuess();
    }
    */

    // check lehght
    //koht 0 on täht (kuni j)
    // koht2 on 0 kui on size 3
    //koht 1 on number (kuni 9)


}

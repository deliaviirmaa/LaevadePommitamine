import java.util.Scanner;

/**
 * Created by Delia on 22.12.2015.
 */
public class Game {


    private static String username;
    private char[] userGuess;

    /**
     * See meetod paneb mängu käima.
     */
    public void runGame() {
        introduction();
        BoardForUser boardForUser = new BoardForUser();
        boardForUser.printBattleBoardForUser();
        getValidUserGuess();
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

    /**
     * See meetod näitab kasutajale sissejuhatust ja küsib kasutajanime
     * @return
     */
    private String introduction() {
        System.out.println("Tere tulemast mängu laevade pommitamine. Sinu ülesandeks on leida üles kõik peidetud laevad. " +
                "Laevade leidmiseks paku ükshaaval asukohti nt A5. Toredat mängu!");
        System.out.println("Sisesta oma nimi.");
        Scanner scanner = new Scanner(System.in);
        username = scanner.nextLine();
        setUsername(username);
        return username;
    }

    /**
     * See meetod tagastab korrektselt sisestatud kasutaja pakkumise
     * @return
     */
    private char[] getValidUserGuess() {

        do {
            getUserGuess();
        }
        while (!guessIsValid(userGuess));
        return userGuess;
    }

    /**
     * See meetod küsib kasutajalt pakkumist
     * @return
     */
    private char[] getUserGuess() {
        String userInserted;
        System.out.println(username + ", tee oma pakkumine!");
        Scanner scanner = new Scanner(System.in);
        userInserted = scanner.nextLine();
        userInserted = userInserted.toUpperCase();
        userGuess = userInserted.toCharArray();
        return userGuess;
    }

    /**
     * See meetod kontrollib, kas sisestus oli õige või on vaja uuesti küsida kasutajalt sisestust
     * @param userGuess
     * @return
     */
    private boolean guessIsValid(char[] userGuess) {

        if (firstIsLetter(userGuess) && secondIsNumber(userGuess)) {
            return true;
        } else {
            System.out.println("Midagi läks valesti. Sisestus peab olema kujul nt. A5.");
            return false;
        }

    }

    /**
     * See meetod kontrollib, kas sisestuses esimene sümbol on korrektne täht
     * @param userGuess
     * @return
     */
    private boolean firstIsLetter(char[] userGuess) {
        if (userGuess[0] == 'A' || userGuess[0] == 'B' || userGuess[0] == 'C' || userGuess[0] == 'D' || userGuess[0] == 'E' ||
                userGuess[0] == 'F' || userGuess[0] == 'G' || userGuess[0] == 'H' || userGuess[0] == 'I' || userGuess[0] == 'J') {
            return true;
        }
        return false;
    }

    /**
     * See meetod kontrollib, kas sisestuses numbrite osa on vastavuses reeglitega
     * @param userGuess
     * @return
     */
    private boolean secondIsNumber(char[] userGuess) {
        if (userGuess.length == 2 && (userGuess[1] == '1' || userGuess[1] == '2' || userGuess[1] == '3' || userGuess[1] == '4' ||
                userGuess[1] == '5' || userGuess[1] == '6' || userGuess[1] == '7' || userGuess[1] == '8' || userGuess[1] == '9')) {
            return true;
        } else if (userGuess.length == 3 && userGuess[1] == '1' && userGuess[2] == '0') {
            return true;
        }

        return false;
    }

}

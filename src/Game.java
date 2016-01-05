import java.util.Scanner;

/**
 * Created by Delia on 22.12.2015.
 */
public class Game {


    /**
     * See meetod paneb mängu käima.
     */
    private String username;
    public void runGame(){
        introduction();
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



    private String introduction(){
        System.out.println("Tere tulemast mängu laevade pommitamine. Sinu ülesandeks on leida üles kõik peidetud laevad. " +
                "Laevade leidmiseks paku ükshaaval asukohti nt A5. Toredat mängu!");
        System.out.println("Sisesta oma nimi.");
        Scanner scanner = new Scanner(System.in);
       username = scanner.nextLine();
        return username;

    }

}

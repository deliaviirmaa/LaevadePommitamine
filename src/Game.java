import java.util.Scanner;

/**
 * Created by Delia on 22.12.2015.
 */
public class Game {

    public void runGame(){
        Board emptyBoard = new Board();
        emptyBoard.buildBattleBoard();
        emptyBoard.printBattleBoard();
    }

    public static void kysiM2ngijaltLaevadeAsukoht() {

        System.out.println("Sisesta 4-se laeva alguse asukoht ning suund (üles - ü, alla - a, paremale - p, vasakule - v), Nt. A5 ü");
        String kasutajaSisestas;
        Scanner scanner = new Scanner(System.in);
        kasutajaSisestas = scanner.next();
        kasutajaSisestas.toUpperCase();
        kasutajaSisestas.toCharArray();
        char[] asukoht = kasutajaSisestas.toCharArray();

    }
    public void teisendaAsukoht(){

    }

}

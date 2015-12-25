import java.util.Scanner;

/**
 * Created by Delia on 05.12.2015.
 */
public class TestClass {

    public static void main(String[] args) {

        Game newGame = new Game();
        newGame.runGame();

    }

    public static void taidaValjak(char[][] valjak) {
        for (int i = 0; i < valjak.length; i++) {
            for (int j = 0; j < valjak.length; j++) {
                valjak[j][i] = '*';
            }
        }
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


}
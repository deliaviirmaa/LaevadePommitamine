import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Delia on 05.12.2015.
 */
public class TestClass extends Application {
    Button alustaMangu = new Button();
    Button l6peta = new Button();

    public static void main(String[] args) {

       //launch(args);
        // suurus muuta 11-ks ja siis lisada see tähestik sinna for loopi
        int suurus = 10;

        char [][] m2nguv2li = new char[suurus][suurus];
        taidaValjak(m2nguv2li);
        printManguValjak(m2nguv2li);
    }

    public static void taidaValjak(char [][] valjak) {
        for(int i = 0; i < valjak.length; i++) {
            for(int j = 0; j < valjak.length; j++) {
                valjak[j][i] = '*';
            }
        }
    }
  public static void printManguValjak(char [][] valjak){
       //char [][] m2nguv2li = new char[ridadeArv][veergudeArv];
      for (int k=0; k<=valjak.length;k++){
        if (k==0) {
            System.out.print(" ");
        }
            else{
                System.out.print(" "+"miagiTulebSiia" +" ");
            }
        }

       System.out.println("  A B C D E F J K L M");
       for (int i=0;i<valjak.length; i++){
           System.out.println();

           if(i<9) {
               System.out.print(i + 1 + " ");
           } else {
               System.out.print(i + 1);
           }

           for (int j=0;j<valjak.length; j++){
               System.out.print(" " + valjak[j][i] + " ");
           }
       }
   }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Levade pommitamine");
        alustaMangu.setText("Alusta");
        StackPane layout = new StackPane();
        layout.getChildren().addAll(alustaMangu,l6peta);
        Scene valiLaevad = new Scene(layout, 600, 400);
        //Scene m2ng = new Scene (layout, 600, 400);
        //alustaMangu.setOnAction(e -> primaryStage.setScene(m2ng));
        //Scene m2ng = new Scene (layout, 600, 400);
        primaryStage.setScene(valiLaevad);
        primaryStage.show();
    }

}

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

       // launch(args);
        tyhiM2nguv2li();
    }


  public static void tyhiM2nguv2li(){
       int ridadeArv = 10;
       int veergudeArv = 10;
       int reaNumber = 1;
       //char [][] m2nguv2li = new char[ridadeArv][veergudeArv];
       System.out.println("  A B C D E F J K L M");
       for (int i=0;i<ridadeArv; i++){
           System.out.println();
           System.out.print(i+1+" ");
           for (int j=0;j<veergudeArv; j++){
               System.out.print(" * ");
               reaNumber = reaNumber+1;
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

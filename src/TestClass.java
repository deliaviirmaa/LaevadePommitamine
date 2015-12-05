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
        launch(args);
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

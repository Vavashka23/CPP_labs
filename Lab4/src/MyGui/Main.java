package MyGui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(15);
        pane.setVgap(10);

        Label oldMen = new Label("Old men");
        oldMen.setTextFill(Color.web("#388422"));
        Label youngMen = new Label("Young men");
        youngMen.setTextFill(Color.web("#D3353D"));
        Button callButton = new Button("Use phone");
        Button putButton = new Button("Switch off");
        Button activateButton = new Button("Use internet");
        Button deactivateButton = new Button("Switch off");
        TextArea textArea = new TextArea();
        textArea.setMaxSize(300,160);
        textArea.setDisable(true);

       // pane.setGridLinesVisible(true);
        GridPane.setHalignment(oldMen, HPos.CENTER);
        GridPane.setHalignment(youngMen, HPos.CENTER);
        GridPane.setHalignment(callButton, HPos.CENTER);
        GridPane.setHalignment(putButton, HPos.CENTER);
        GridPane.setHalignment(activateButton, HPos.CENTER);
        GridPane.setHalignment(deactivateButton, HPos.CENTER);
        pane.add(oldMen, 0, 0);
        pane.add(youngMen, 1,0);
        pane.add(textArea, 2,0, 1, 4);
        pane.add(callButton, 0, 1);
        pane.add(putButton, 0,2);
        pane.add(activateButton, 1,1);
        pane.add(deactivateButton, 1, 2);



        Scene scene = new Scene(pane, 530, 200);
        primaryStage.setTitle("Dial-up");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

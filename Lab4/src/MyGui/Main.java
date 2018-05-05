package MyGui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Threads.*;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setHgap(15);
        pane.setVgap(10);

        MainThread mainThread = new MainThread();

        Label oldMen = new Label("Old men");
        oldMen.setTextFill(Color.web("#388422"));
        Label youngMen = new Label("Young men");
        youngMen.setTextFill(Color.web("#D3353D"));
        Button callButton = new Button("Use phone");
        Button closeButton = new Button("close");
        Label phoneTimer = new Label("0");
        Button activateButton = new Button("Use internet");
        Label internetTimer = new Label("0");
        TextArea textArea = new TextArea();
        textArea.setMaxSize(300,160);
        textArea.setDisable(true);

       // pane.setGridLinesVisible(true);
        GridPane.setHalignment(oldMen, HPos.CENTER);
        GridPane.setHalignment(youngMen, HPos.CENTER);
        GridPane.setHalignment(callButton, HPos.CENTER);
        GridPane.setHalignment(phoneTimer, HPos.CENTER);
        GridPane.setHalignment(activateButton, HPos.CENTER);
        GridPane.setHalignment(internetTimer, HPos.CENTER);
        GridPane.setHalignment(closeButton, HPos.CENTER);
        pane.add(oldMen, 0, 0);
        pane.add(youngMen, 1,0);
        pane.add(textArea, 2,0, 1, 4);
        pane.add(callButton, 0, 1);
        pane.add(phoneTimer, 0,2);
        pane.add(activateButton, 1,1);
        pane.add(internetTimer, 1, 2);
        pane.add(closeButton, 0,3);

        Scene scene = new Scene(pane, 530, 200);
        primaryStage.setTitle("Dial-up");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    stop();
                } catch (Exception e) {}
            }
        });



        int[] time = {0};
        int[] time2 = {0};
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(1000),
                        ae->{
                            time[0] -=1;
                            phoneTimer.setText(""+time[0]);
                        }
                )
        );
        Timeline timeline2 = new Timeline(
                new KeyFrame(
                        Duration.millis(1000),
                        ae -> {
                            time2[0] -= 1;
                            internetTimer.setText("" + time2[0]);
                        }
                )
        );
        callButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(time2[0] == 0) {
                    time[0] = 30;
                    mainThread.usePhone();
                    textArea.setText(textArea.getText() + "- Использование телефона(30 сек)\n");
                    timeline.setCycleCount(30);
                    timeline.play();
                    phoneTimer.setText("30");
                } else textArea.setText(textArea.getText() + "- Ожидайте завершения интернет соединения\n");
            }
        });

        activateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                time2[0] = 30;
                mainThread.surfing();
                if (new String(phoneTimer.getText()).equals("0")) {
                    textArea.setText(textArea.getText() + "- Использование интернета(30 сек)\n");
                    timeline2.setCycleCount(30);
                    timeline2.play();
                    internetTimer.setText("30");
                } else textArea.setText(textArea.getText() + "- Доступ к интернету заблокирован\n");
            }
        });
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText(textArea.getText() + "- Закрытие потоков\n");
                mainThread.closeThreads();
                primaryStage.close();
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}

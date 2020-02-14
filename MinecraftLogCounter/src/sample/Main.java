package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import java.awt.Desktop;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(8);
        grid.setVgap(5);


        Button openLogDirectory = new Button("Open Folder");
        grid.add(openLogDirectory,0,0);

        Text displayChosenDirectoryText = new Text();
        grid.add(displayChosenDirectoryText,1,0);

        Button findHoursOpenedButton = new Button("Find Hours Opened");
        grid.add(findHoursOpenedButton,0,1);

        Text displayHoursOpenedText = new Text("Hours Played: ");
        grid.add(displayHoursOpenedText,1,1);

        Text info = new Text("Minecraft Log Analyzer - Version 0.1 - Made By Stephen5311");
        grid.add(info, 1,2);


        final DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Minecraft's Logs Folder");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));

        openLogDirectory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File directory = directoryChooser.showDialog(primaryStage);
                if (directory != null)
                {
                    displayChosenDirectoryText.setText(directory.getAbsolutePath());
                }
                else
                {
                    displayChosenDirectoryText.setText(null);
                }
            }
        });

        findHoursOpenedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });



        primaryStage.setScene(new Scene(grid));
        primaryStage.show();
    }
}

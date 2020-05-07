package com.datdeveloper.gameserverbrowser.games;

import com.datdeveloper.gameserverbrowser.games.steam.SteamGame;
import com.datdeveloper.gameserverbrowser.util.FileHelper;
import com.datdeveloper.gameserverbrowser.util.UIUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;

import java.io.*;

public class BaseGame {
    public String name = "";
    public String icon = "";

    @FXML
    TilePane serverTiles;

    private JFXButton button;

    public void setButtonStatus(UIUtils.ButtonStatus buttonStatus){
        switch (buttonStatus){
            case NORMAL:
                button.setDisable(false);
                break;
            case SELECTED:
                button.getStyleClass().add("selectedButton");
                button.setDisable(true);
                break;
            case DISABLED:
                button.setDisable(true);
                button.getStyleClass().remove("selectedButton");
        }
    }

    // Setup UI
    public JFXButton setupButton(){
        // Button
        button = new JFXButton();
        button.setButtonType(JFXButton.ButtonType.RAISED);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        button.getStyleClass().add("menuButtons");

        // Text & Image
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        container.getChildren().add(UIUtils.imageBuilder(icon, 40, 40, true));

        // Text
        Label text = new Label(name);
        text.setMaxWidth(Double.MAX_VALUE);
        text.getStyleClass().add("menuText");
        container.getChildren().add(text);
        HBox.setHgrow(text, Priority.ALWAYS);

        button.setGraphic(container);

        return button;
    }

    public Node setupPage(){
        try {
            FXMLLoader tester = new FXMLLoader(getClass().getResource("/Layouts/default.fxml"));
            tester.setController(this);
            return tester.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Serialization
    public void saveGame(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = FileHelper.openFile(new File(FileHelper.getSettingsDirectory() + "/" + this.name + ".json"));

        try {
            if (file != null) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(gson.toJson(this));
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BaseGame loadGame() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        SteamGame temp = new SteamGame();
        File file = FileHelper.openFile(new File(FileHelper.getSettingsDirectory() + "/" + temp.name + ".json"));

        try {
            if (file.exists()) {
                Reader reader = new FileReader(file);
                return gson.fromJson(reader, BaseGame.class);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return temp;
    }
}

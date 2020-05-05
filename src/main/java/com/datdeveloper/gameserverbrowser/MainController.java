package com.datdeveloper.gameserverbrowser;

import com.datdeveloper.gameserverbrowser.games.BaseGame;
import com.datdeveloper.gameserverbrowser.util.UIUtils;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.ArrayList;

public class MainController {
    ArrayList<Pair<JFXButton, Node>> tabs = new ArrayList<>();

    @FXML
    public VBox buttonMenu;

    @FXML
    public AnchorPane pageHost;

    @FXML
    public AnchorPane test;

    @FXML
    public ScrollPane test2;

    @FXML
    public void initialize() {
        System.out.println("test");

        addTab("Garry's Mod", "/Images/gmod.png", new AnchorPane());
    }

    @FXML
    public void testButton(){
        System.out.println("test Button");
    }

    public void addTab(BaseGame game){
        addTab(game.name, game.icon, game.setupPage());
    }

    public void addTab(String TabTitle, String TabIcon, Node Body){
        // Button
        JFXButton button = new JFXButton();
        button.setButtonType(JFXButton.ButtonType.RAISED);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        button.getStyleClass().add("menuButtons");

        // Text & Image
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        container.getChildren().add(UIUtils.imageBuilder(TabIcon, 40, 40, true));

        // Text
        Label text = new Label(TabTitle);
        text.setMaxWidth(Double.MAX_VALUE);
        text.getStyleClass().add("menuText");
        container.getChildren().add(text);
        HBox.setHgrow(text, Priority.ALWAYS);

        button.setGraphic(container);

        buttonMenu.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            final int index = tabs.size();
            @Override
            public void handle(ActionEvent event) {
                tabs.get(index).getValue().toFront();
            }
        });

        pageHost.getChildren().add(Body);

        tabs.add(new Pair<>(button, Body));
    }
}

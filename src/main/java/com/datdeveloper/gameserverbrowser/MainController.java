package com.datdeveloper.gameserverbrowser;

import com.datdeveloper.gameserverbrowser.games.BaseGame;
import com.datdeveloper.gameserverbrowser.games.steam.gmod.GMod;
import com.datdeveloper.gameserverbrowser.util.UIUtils;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MainController {
    ArrayList<BaseGame> games = new ArrayList<>();
    BaseGame currentGame = null;

    @FXML
    public VBox buttonMenu;

    @FXML
    public Pane pageHost;

    @FXML
    public void initialize() {
        System.out.println("test");
        setupGame(new GMod());
    }

    @FXML
    public void testButton(){
        System.out.println("test Button");
    }

    public void setupGame(BaseGame game){
        JFXButton theButton = game.setupButton();
        buttonMenu.getChildren().add(theButton);
        games.add(game);

        if (games.size() == 1){
            setPage(game);
        }
    }

    public void setPage(BaseGame game){
        if(currentGame != null) currentGame.setButtonStatus(UIUtils.ButtonStatus.NORMAL);

        currentGame = game;
        pageHost.getChildren().clear();
        Node page = currentGame.setupPage();
        pageHost.getChildren().add(page);
        VBox.setVgrow(page, Priority.ALWAYS);
        currentGame.setButtonStatus(UIUtils.ButtonStatus.SELECTED);
    }
}

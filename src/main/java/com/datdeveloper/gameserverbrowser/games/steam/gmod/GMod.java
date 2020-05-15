package com.datdeveloper.gameserverbrowser.games.steam.gmod;

import com.datdeveloper.gameserverbrowser.games.steam.SteamGame;
import com.datdeveloper.gameserverbrowser.util.FileHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class GMod extends SteamGame {

    @FXML
    Text Name;

    public GMod(){
        this.name = "Garry's Mod";
        this.icon = "/Images/gmod.png";
        this.ID = "4020";
        this.requiresLogin = false;
    }

    @FXML
    public void initialize() {
        Name.setText("test");
    }

    public static GMod loadGame() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GMod temp = new GMod();
        File file = FileHelper.openFile(new File(FileHelper.getSettingsDirectory() + "/" + temp.name + ".json"));

        try {
            if (file.exists()) {
                Reader reader = new FileReader(file);
                return gson.fromJson(reader, GMod.class);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return temp;
    }
}

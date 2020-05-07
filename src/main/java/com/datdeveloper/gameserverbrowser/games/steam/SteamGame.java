package com.datdeveloper.gameserverbrowser.games.steam;

import com.datdeveloper.gameserverbrowser.games.BaseGame;
import com.datdeveloper.gameserverbrowser.util.FileHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class SteamGame extends BaseGame {
    public String ID = "";
    public boolean requiresLogin = false;

    public static SteamGame loadGame() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        SteamGame temp = new SteamGame();
        File file = FileHelper.openFile(new File(FileHelper.getSettingsDirectory() + "/" + temp.name + ".json"));

        try {
            if (file.exists()) {
                Reader reader = new FileReader(file);
                return gson.fromJson(reader, SteamGame.class);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return temp;
    }
}

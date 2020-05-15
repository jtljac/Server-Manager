package com.datdeveloper.gameserverbrowser.games.steam;

import com.datdeveloper.gameserverbrowser.games.BaseGame;
import com.datdeveloper.gameserverbrowser.util.FileHelper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class SteamGame extends BaseGame {
    public String ID = "";
    public boolean requiresLogin = false;

    public static SteamGame loadGame(String name) {
        Gson gson = new Gson();
        File file = new File(FileHelper.getGamesDirectory() + "/" + name + ".json");

        try {
            if (file.exists()) {
                Reader reader = new FileReader(file);
                return gson.fromJson(reader, SteamGame.class);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}

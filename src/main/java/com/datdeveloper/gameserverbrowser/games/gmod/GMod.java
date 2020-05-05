package com.datdeveloper.gameserverbrowser.games.gmod;

import com.datdeveloper.gameserverbrowser.games.BaseGame;
import com.datdeveloper.gameserverbrowser.games.SteamGame;
import com.datdeveloper.gameserverbrowser.util.FileHelper;
import com.datdeveloper.gameserverbrowser.util.ServerUtils.serverType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class GMod extends SteamGame {
    public transient final static serverType type = serverType.STEAM;

    public GMod(){
        this.name = "Garry's Mod";
        this.icon = "/Images/gmod.png";
        this.ID = "4020";
        this.requiresLogin = false;
    }

    public void saveGame(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = FileHelper.openFile(new File(FileHelper.getSettingsDirectory() + "/" + name + ".json"));

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

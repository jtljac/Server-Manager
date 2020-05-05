package com.datdeveloper.gameserverbrowser.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Settings {
    private static Settings instance = null;
    public General generalSettings = new General();
    public Steam steamSettings = new Steam();
    public static class General {

    }

    public static class Steam {
        String steamCMDInstallLocation = "";
        String authKey = "";
    }

    public static Settings getSettings(){
        if (instance == null) {
            instance = loadSettings();
        }
        return instance;
    }

    public static Settings loadSettings(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File configFile = new File(FileHelper.getSettingsDirectory() + "/config.json");
        if (!configFile.exists()){
            Settings settings = new Settings();

            try {
                if (!configFile.getParentFile().exists()) configFile.getParentFile().mkdirs();
                configFile.createNewFile();

                BufferedWriter writer = new BufferedWriter(new FileWriter(configFile));
                writer.write(gson.toJson(settings));
                writer.close();
            } catch (IOException e) {
                System.out.println("Failed to create config file");
                e.printStackTrace();
            }
            return settings;
        } else {
            try {
                Reader reader = new FileReader(configFile);
                return gson.fromJson(reader, Settings.class);
            } catch (FileNotFoundException e) {
                System.out.println("Failed to load config file");
                e.printStackTrace();
            }
        }

        return new Settings();
    }
}

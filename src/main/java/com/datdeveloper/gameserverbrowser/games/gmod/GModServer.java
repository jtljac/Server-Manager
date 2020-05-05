package com.datdeveloper.gameserverbrowser.games.gmod;

import com.datdeveloper.gameserverbrowser.games.BaseServer;

import java.util.ArrayList;
import java.util.List;

public class GModServer extends BaseServer {
    public static final String[] defaultArguments = {"-tickrate 30"};
    public String gameMode = "";
    public transient String map = "";
    public String defaultMap = "";
    public String workshopCollection = "";
    public List<String> arguments = new ArrayList<>();

    public GModServer(){};

    public GModServer(String directory, String name, String gameMode, int maxPlayers, String workshopCollection) {
        this.serverDirectory = directory;
        this.serverName = name;
        this.serverPort = 27015;
        this.gameMode = gameMode;
        this.maxPlayers = maxPlayers;
        this.workshopCollection = workshopCollection;
    }
}

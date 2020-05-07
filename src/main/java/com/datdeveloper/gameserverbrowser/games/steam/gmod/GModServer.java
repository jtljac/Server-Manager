package com.datdeveloper.gameserverbrowser.games.steam.gmod;

import com.datdeveloper.gameserverbrowser.games.steam.SourceServer;

public class GModServer extends SourceServer {
    public String workshopCollection = "";

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

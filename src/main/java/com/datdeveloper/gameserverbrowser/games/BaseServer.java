package com.datdeveloper.gameserverbrowser.games;

public class BaseServer {
    public String serverDirectory;
    public String serverName;
    public int serverPort;
    public transient int playerCount = 0;
    public int maxPlayers;
}

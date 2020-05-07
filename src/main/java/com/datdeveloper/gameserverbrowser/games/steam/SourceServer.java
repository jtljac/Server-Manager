package com.datdeveloper.gameserverbrowser.games.steam;

import com.datdeveloper.gameserverbrowser.games.BaseServer;

import java.util.ArrayList;
import java.util.List;

public class SourceServer extends BaseServer {
    public String gameMode = "";
    public transient String map = "";
    public String defaultMap = "";
    public String GSLTToken = "";
    public List<String> arguments = new ArrayList<>();
    public String[] defaultArguments = {"-tickrate 30"};
}

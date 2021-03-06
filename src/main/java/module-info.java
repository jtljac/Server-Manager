module GameServerBrowser {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires com.jfoenix;

    opens com.datdeveloper.gameserverbrowser to javafx.fxml;
    opens com.datdeveloper.gameserverbrowser.util;
    opens com.datdeveloper.gameserverbrowser.util.interfaces;
    opens com.datdeveloper.gameserverbrowser.games;
    opens com.datdeveloper.gameserverbrowser.games.steam;
    opens com.datdeveloper.gameserverbrowser.games.steam.gmod;
    exports com.datdeveloper.gameserverbrowser;
    exports com.datdeveloper.gameserverbrowser.util;
    exports com.datdeveloper.gameserverbrowser.util.interfaces;
    exports com.datdeveloper.gameserverbrowser.games;
    exports com.datdeveloper.gameserverbrowser.games.steam;
    exports com.datdeveloper.gameserverbrowser.games.steam.gmod;
}
module GameServerBrowser {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires com.jfoenix;

    opens com.datdeveloper.gameserverbrowser to javafx.fxml;
    opens com.datdeveloper.gameserverbrowser.util to com.google.gson;
    opens com.datdeveloper.gameserverbrowser.games;
    exports com.datdeveloper.gameserverbrowser;
    exports com.datdeveloper.gameserverbrowser.util;
    exports com.datdeveloper.gameserverbrowser.games;
}
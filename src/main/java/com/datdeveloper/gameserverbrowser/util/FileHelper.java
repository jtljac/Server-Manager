package com.datdeveloper.gameserverbrowser.util;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    public static String getSettingsDirectory(){
        return System.getenv("LOCALAPPDATA") + "/GameServerBrowser";
    }

    /**
     * Safely opens the given file, creating the required directories and file if needed
     * @param theFile The file to open
     * @return The opened file
     */
    public static File openFile(File theFile){
        try {
            boolean success = true;
            if (!theFile.getParentFile().exists()) success = theFile.getParentFile().mkdirs();
            if (!theFile.exists()) success = theFile.createNewFile();
            if (!success) throw new IOException();
            return theFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getGamesDirectory() {
        return getSettingsDirectory() + "/games";
    }
}

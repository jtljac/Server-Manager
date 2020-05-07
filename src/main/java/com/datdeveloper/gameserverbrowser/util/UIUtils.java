package com.datdeveloper.gameserverbrowser.util;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;

public class UIUtils {
    public static ImageView imageBuilder(String ImageURL, double Width, double Height, boolean preserveAspect ){
        Image image = null;
        try {
            image = new Image(UIUtils.class.getResource(ImageURL).toURI().toString(), Width, Height, preserveAspect, true);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView();
        imageView.setSmooth(true);
        imageView.setPreserveRatio(preserveAspect);
        imageView.setFitWidth(Width);
        imageView.setFitHeight(Height);
        imageView.setImage(image);

        return imageView;
    }

    public enum ButtonStatus {
        NORMAL,
        SELECTED,
        DISABLED
    }
}

package com.example.mediaplayer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.List;

import static com.example.mediaplayer.UIBuilder.currentFile;

public class PrevButton extends MyButton {

    List<File> files;

    public PrevButton() {};

    PrevButton(List<File> files) {
        super();
        this.files = files;
    }

    @Override
    public void onPress() {
        if (0 > currentFile - 1) {
            currentFile = files.size() - 1;
        }
        else {
            currentFile--;
        }
    }

}

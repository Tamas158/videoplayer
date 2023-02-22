package com.example.mediaplayer;

import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.List;


public class NextButton extends MyButton {

    List<File> files;

    public NextButton(){} ;

    NextButton(List<File> files) {
        super();
        this.files = files;
    }

    @Override
    public void onPress() {
        if (files.size()-1 < UIBuilder.currentFile + 1) {
            UIBuilder.currentFile = 0;
        }
        else {
            UIBuilder.currentFile++;
        }
    }

}

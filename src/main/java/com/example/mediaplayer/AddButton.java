package com.example.mediaplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

public class AddButton extends MyButton {

    public List<File> files;
    public FileChooser fileChooser = new FileChooser();

    public AddButton(){}
    AddButton(List<File> files, FileChooser fileChooser){
        super();
        this.files = files;
        this.fileChooser = fileChooser;
    }

    @Override
    public void onPress() throws FileListNullException{
        files = fileChooser.showOpenMultipleDialog(null);
        if (files == null) return;
    }
    public List<File> getFiles() {
        return files;
    }


}

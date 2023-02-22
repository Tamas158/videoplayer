package com.example.mediaplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class MyButton extends Button implements IMyButton{

    double hight;
    double width;
    String display;
    Color buttonColor;


    MyButton() {
        this.hight = 20;
        this.width = 20;
        this.buttonColor = Color.GREY;
        this.display = "";

        this.setHeight(hight);
        this.setWidth(width);
        this.setText(display);
    }

    @Override
    public abstract void onPress() throws FileListNullException;

    @Override
    public String getDisplay() {

        return display;
    }

    @Override
    public void setDisplay(String display) {

        this.display = display;
    }
}

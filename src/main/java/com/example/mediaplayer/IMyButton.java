package com.example.mediaplayer;

public interface IMyButton {

    public void onPress() throws FileListNullException;

    public String getDisplay();

    public void setDisplay(String display);


}

package com.example.mediaplayer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class UIBuilder {
    MediaPlayer player;
    List<File> files = new ArrayList<>();
    FileChooser fileChooser = new FileChooser();
    @FXML
    public AddButton addButton = new AddButton(files, fileChooser);
    @FXML
    private Button playButton = new Button();
    @FXML
    private Button pauseButton = new Button();
    @FXML
    private PrevButton prevButton = new PrevButton(files);
    @FXML
    private NextButton nextButton = new NextButton(files);
    @FXML
    public Slider volumeSlider = new Slider();
    @FXML
    Slider timeSlider = new Slider();
    @FXML
    MediaView view = new MediaView();

    @FXML
    private ImageView defPic = new ImageView();
    Media media;
    static int currentFile = 0;
    public  void init(){
        if(player!=null) {

            volumeSlider.setValue(player.getVolume() * 1000);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    player.setVolume(volumeSlider.getValue() / 1000);

                }
            });

            InvalidationListener sliderChangeListener = (o-> {
                Duration seekTo = Duration.seconds(timeSlider.getValue());
                player.seek(seekTo);
            });
            timeSlider.valueProperty().addListener(sliderChangeListener);

            timeSlider.maxProperty().bind(Bindings.createDoubleBinding(
                    () -> player.getCycleDuration().toSeconds(),
                    player.totalDurationProperty()));

            player.currentTimeProperty().addListener(l-> {
                timeSlider.valueProperty().removeListener(sliderChangeListener);
                Duration currentTime = player.getCurrentTime();
                double value = currentTime.toSeconds();
                timeSlider.setValue(value);
                timeSlider.valueProperty().addListener(sliderChangeListener);
            });
        }
    }

    public void load() {
        defPic.setImage(null);
        defPic.setFitHeight(0);
        defPic.setFitWidth(0);
        defPic.setVisible(false);
        if(player != null) {
            player.dispose();
        }
        media = new Media(files.get(currentFile).toURI().toString());
        player = new MediaPlayer(media);
        view.setMediaPlayer(player);
        init();
    }

    @FXML
    public void onAddButtonPress(){
        try {
            addButton.onPress();
        } catch (FileListNullException e) {
            throw new RuntimeException(e);
        }
        files = addButton.getFiles();
        load();
        prevButton = new PrevButton(files);
        nextButton = new NextButton( files);
        player.play();
    }


    public void onPlayButtonPress() {
        if (player != null)
            player.play();
    }

    public void onPauseButtonPress() {
        if (player != null)
            player.pause();
    }

    @FXML
    public void onPrevButtonPress () {
        player.stop();
        prevButton.onPress();
        load();
        player.play();

    }

    @FXML
    public void onNextButtonPress() {
        player.stop();
        nextButton.onPress();
        load();
        player.play();
    }


}

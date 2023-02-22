module com.example.zenelejatszo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
            
                            
    opens com.example.mediaplayer to javafx.fxml;
    exports com.example.mediaplayer;
}

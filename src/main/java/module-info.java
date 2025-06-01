module org.adainf.javapro1uipart02 {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.adainf.javapro1uipart02 to javafx.fxml;
    exports org.adainf.javapro1uipart02;
}
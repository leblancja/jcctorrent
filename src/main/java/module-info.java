module org.joralebl {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.joralebl to javafx.fxml;
    exports org.joralebl;
}

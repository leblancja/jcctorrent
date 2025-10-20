module org.joralebl {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.joralebl to javafx.fxml;
    exports org.joralebl.jcctorrent;
    opens org.joralebl.jcctorrent to javafx.fxml;
}

module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.google.gson;

    opens org.example.view to javafx.fxml;
    opens org.example.model to com.google.gson;
    exports org.example;
}
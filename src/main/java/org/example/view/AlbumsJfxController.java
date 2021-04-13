package org.example.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;
import org.example.controllers.AlbumController;

import java.net.URL;
import java.util.ResourceBundle;

public class AlbumsJfxController implements Initializable {
    @FXML private TextField artistInput;
    @FXML private TextField titleInput;
    @FXML private TextField yearInput;

    @FXML private TableView<AlbumJfx> myTable;
    @FXML private TableColumn<AlbumJfx, String> artistColumn;
    @FXML private TableColumn<AlbumJfx, String> nameColumn;
    @FXML private TableColumn<AlbumJfx, Number> yearColumn;

    private ObservableList<AlbumJfx> itemsModel;
    private TextFormatter<Integer> yearFormatter;

    private final AlbumController albumController = new AlbumController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Populate observable list
        itemsModel = FXCollections.observableArrayList();
        albumController
                .getAll()
                .stream()
                .map(AlbumJfx::new)
                .forEach(itemsModel::add);

        // Bind table to observable list
        myTable.setItems(itemsModel);

        // Define columns display
        artistColumn.setCellValueFactory(cell -> cell.getValue().artistProperty());
        nameColumn.setCellValueFactory(cell -> cell.getValue().nameProperty());
        yearColumn.setCellValueFactory(cell -> cell.getValue().yearProperty());

        // Define formatter for year field
        yearFormatter = new TextFormatter<>(
                new IntegerStringConverter(),
                null,
                change -> {
                    if (!change.getText().matches("\\d+")) {
                        change.setText("");
                    }
                    return change;
                });

        // Bind text formatter to year input
        yearInput.setTextFormatter(yearFormatter);
    }

    @FXML
    private void addItem() {
        if (isFormValid()) {
            var artist = artistInput.getText().trim();
            var title = titleInput.getText().trim();
            var year = yearFormatter.getValue();

            var album = albumController.createAlbum(artist, title, year);
            itemsModel.add(new AlbumJfx(album));

            artistInput.clear();
            titleInput.clear();
            yearInput.clear();
        }
    }

    private boolean isFormValid() {
        return !artistInput.getText().isBlank() &&
                !titleInput.getText().isBlank() &&
                !yearInput.getText().isBlank();
    }
}

package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailBookController {
    @FXML
    Label lbID, lbName, lbAuName;

    @FXML
    Button btnBack;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        this.lbID.setText(String.valueOf(this.book.getId()));
        this.lbName.setText(this.book.getName());
        this.lbAuName.setText(this.book.getAuthor().getName());
    }

    public void Back(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemController {
    @FXML
    Label lbID, lbName, lbAuName;

    @FXML
    Button btnSelect;

    private Book book;
    private int clickCount = 0;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        this.lbID.setText(String.valueOf(this.book.getId()));
        this.lbName.setText(this.book.getName());
        this.lbAuName.setText(this.book.getAuthor().getName());
    }

    public void itemDetail(ActionEvent event){
        clickCount++;
        if(clickCount == 2){
            clickCount = 0;
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("detailBook.fxml"));
                Parent detail = loader.load();
                DetailBookController controller = loader.getController();
                controller.setBook(this.book);
                Stage primaryStage = new Stage();
                primaryStage.setScene(new Scene(detail));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void resetClickCount(MouseEvent event){
        clickCount = 0;
    }
}

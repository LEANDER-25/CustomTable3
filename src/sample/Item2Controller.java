package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.List;

public class Item2Controller {
    @FXML
    CheckBox checkBox;

    @FXML
    Label lbID;

    @FXML
    Pane container;

    public void setColor(String color){
        this.container.setStyle("-fx-background-color: " + color);
    }

    public void checked(){

        if(this.checkBox.isSelected()){
            this.container.setAccessibleText("checked");
        }
        else {
            this.container.setAccessibleText("");
        }
    }

    public void setID(int id){
        this.lbID.setText(String.valueOf(id));
    }

    public void setAccessibleText(String text){
        this.container.setAccessibleText(text);
    }
    public String getAccessibleText(){
        return this.container.getAccessibleText();
    }
}

package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private List<Book> list = new ArrayList<>();

    @FXML
    VBox itemHolder = null;

    @FXML
    Button btnDelAll, btnAdd;

    @FXML
    TextField tfID, tfName, tfAuID, tfAuName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0; i < 10; i++){
            //list.add(new Book(i, "A", new Author(1, "hello")));
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Item2.fxml"));
                Node item = loader.load();
                Item2Controller controller = loader.getController();

                item.setAccessibleText(String.valueOf(i));

                controller.setID(i);
                if(i % 2 != 0){
                    controller.setColor("#fab1a0");
                }
                itemHolder.getChildren().add(item);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        for (Book i : list){
//            Node item = add(i);
//            itemHolder.getChildren().add(item);
//        }


    }

    public void deleteChecked(){
        List<Node> tempList = new ArrayList<>();
        for (Node i :  this.itemHolder.getChildren()) {
            if (i.getAccessibleText().equals("checked")){
                System.out.println("checked");
                //them nhung item bi danh dau vao tempList
                tempList.add(i);
            }
        }
        this.itemHolder.getChildren().removeAll(tempList);
        tempList.clear();
    }

    public Node add(Book book){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Item.fxml"));
            Node item = loader.load();
            ItemController controller = loader.getController();
            controller.setBook(book);
            return item;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void create(){
        int id = Integer.parseInt(tfID.getText());
        String name = tfName.getText();
        int idAu = Integer.parseInt(tfAuID.getText());
        String nameAu = tfAuName.getText();
        Author author = new Author(idAu, nameAu);
        Book book = new Book(id, name, author);
        Node e = add(book);
        itemHolder.getChildren().add(e);

    }

    public void removeAll(){
        for (int i = itemHolder.getChildren().size() - 1; i >=0 ; i--){
            itemHolder.getChildren().remove(i);
        }
    }


}

package edu.icet.controller.user.items;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.ItemsBo;
import edu.icet.bo.impl.ItemsBoImpl;
import edu.icet.dto.ItemDto;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;


public class AddItemsFormController {
    public BorderPane addItemsPane;
    public JFXTextField itemCodeTxtField;
    public JFXTextField productNameTxtField;
    public JFXTextField priceTxtField;
    public JFXComboBox categoryComboBox;
    public JFXButton addBtn;
    public JFXButton cancelBtn;


    private ItemsBo itemsBo;

    public void initialize(){
        this.itemsBo = new ItemsBoImpl();
        categoryComboBox.setItems(FXCollections.observableArrayList(new ArrayList<String>(
            Arrays.asList("Electrical", "Electronic"))));
    }




    public void logOutBtnOnAction() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure want to log out?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Log Out");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            try {
                Stage stage = (Stage) addItemsPane.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"))));
                stage.setTitle("User Dashboard");
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void itemsBtnOnAction(ActionEvent actionEvent) {
    }

    public void custBtnOnAction() {
        try {
            Stage stage = (Stage) addItemsPane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user/customers/AddCustomersForm.fxml"))));
            stage.setTitle("User Dashboard");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ordersBtnOnAction() {
        try {
            Stage stage = (Stage) addItemsPane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user/UserDashboardForm.fxml"))));
            stage.setTitle("User Dashboard");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBtnOnAction() {
        String itemCode = itemCodeTxtField.getText();
        String productName = productNameTxtField.getText();
        String category = String.valueOf(categoryComboBox.getValue());
        double price = Double.parseDouble(priceTxtField.getText());

        ItemDto dto = new ItemDto(itemCode, productName, category, price);
        itemsBo.save(dto);

    }

    public void cancelBtnOnAction(ActionEvent actionEvent) {
    }
}

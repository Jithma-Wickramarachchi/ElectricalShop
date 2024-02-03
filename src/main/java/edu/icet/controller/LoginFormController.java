package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Data;

public class LoginFormController {
    public BorderPane loginPane;

    public void adminBtnOnAction(ActionEvent actionEvent) {
    }
    public void userBtnOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) loginPane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user/UserDashboardForm.fxml"))));
            stage.setTitle("User Dashboard");
            stage.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

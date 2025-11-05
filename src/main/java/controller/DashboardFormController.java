package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

    Stage stage=new Stage();
    @FXML
    void customerOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerDashboard.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();


    }

    @FXML
    void employeeOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/EmployeeDashboard.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void itemOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemDashboard.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void supplierOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SupplierDashboard.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

}

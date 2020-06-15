package com.recycl.dashboard.front.controllers;

import com.recycl.dashboard.Configuration.DAOConnection;
import com.recycl.dashboard.back.Beans.User;
import com.recycl.dashboard.back.DAO.UserDAO;
import com.recycl.dashboard.front.helpers.AlertHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {
    @FXML
    public Pane TestPane;

    @FXML
    public TextField loginField;

    @FXML
    public Button submitButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException, SQLException {
        Window owner = TestPane.getScene().getWindow();
        if (loginField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Error!",
                    "Please enter your name");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Error!",
                    "Please enter a password");
            return;
        }

        //if not empty and authenticator is good

        UserDAO user = new UserDAO(DAOConnection.ConnectDb());

//        User created_user = new User();
//        created_user.setUsername("azer");
//        created_user.setPassword("azer");
//        System.out.println(user.Create(created_user));
//        System.out.println(user.IsUserExistsByUsernameAndPassword(loginField.getText(), passwordField.getText()));

        if (user.IsUserExistsByUsernameAndPassword(loginField.getText(), passwordField.getText())) {
            AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                    "Welcome " + loginField.getText());

            switchToMain();
        } else {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Password or Username Error",
                    "You have an error in your Password or your Username ");
        }
    }

    private double x, y;

    private void switchToMain() throws IOException {
        Stage loginstage = (Stage) TestPane.getScene().getWindow();//closes login screen
        // do what you have to do
        loginstage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("main.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main Page");
        /*//borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });*/
        primaryStage.show();
    }
}

package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import databases.DBConnection;
import model.AdminLogin;
import model.Session;
import passwordhasher.PasswordHash;

public class AdminLoginController implements Initializable{

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private double x = 0;
    private double y = 0;

    @FXML
    private Pane login_form;

    @FXML
    private Text errorHandler;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField showpasswordField;

    @FXML
    private Button login;

    @FXML
    private AnchorPane showpass_form;

    @FXML
    private AnchorPane hidepass_form;

    @FXML
    private AnchorPane loginForm;

    @FXML
    private AnchorPane email_form;


    @FXML
    private void forgotPassword(){
        loginForm.setVisible(false);
        email_form.setVisible(true);
    }

    @FXML
    private void backtologin(){
        email_form.setVisible(false);
        loginForm.setVisible(true);
    }

    @FXML
    private void btnLogin(){
        String sql = "SELECT * FROM admin WHERE (username = ? OR email = ?)";

        connect = DBConnection.connect();
        try {
            
            AdminLogin user = null;
            if(showpass_form.isVisible()){
                user = new AdminLogin(usernameField.getText(), passwordField.getText());
            }else if(hidepass_form.isVisible()){
                user = new AdminLogin(usernameField.getText(), showpasswordField.getText());
            }

            if(user == null || user.getUsername().isEmpty() || user.getPassword().isEmpty()){
                errorHandler.setText("Username or password can't be empty");
                errorHandler.setFill(Color.web("EE4266"));
                return;
            }

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, user.getUsername());
                prepare.setString(2, user.getUsername());
                result = prepare.executeQuery();
                
                if(result.next()){
                    boolean verifyPassword = PasswordHash.password_verify(user.getPassword(), result.getString("password"));
                    if(verifyPassword){
                        Session.setUserID(result.getInt("id"));
                        Session.setRole(result.getString("role"));
                        errorHandler.setText("Successfully log in");
                        errorHandler.setFill(Color.web("198754"));
    
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Success message");
                        alert.setHeaderText(null);
                        alert.setContentText("Login successfullyy");
                        alert.showAndWait();
    
                        Stage stage = new Stage();
                        login.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("../views/dashboard_layout.fxml"));
                        Scene scene = new Scene(root);
    
                        root.setOnMousePressed((MouseEvent event) -> {
                            x = event.getSceneX();
                            y = event.getSceneY();
                        });
    
                        root.setOnMouseDragged((MouseEvent event) -> {
                            stage.setX(event.getScreenX() - x);
                            stage.setY(event.getScreenY() - y);
    
                            stage.setOpacity(.8);
                        });
    
                        root.setOnMouseReleased((MouseEvent event) -> {
                            stage.setOpacity(1);
                        });
    
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setScene(scene);
                        stage.show();

                    }else{
                        errorHandler.setText("Wrong password, please try again");
                        errorHandler.setFill(Color.web("EE4266"));
                    }

                }else{
                    errorHandler.setText("Username or email not found");
                    errorHandler.setFill(Color.web("EE4266"));
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showpassword(){
        showpasswordField.setText(passwordField.getText());
        showpass_form.setVisible(false);
        hidepass_form.setVisible(true);
    }

    @FXML
    private void hidepassword(){
        passwordField.setText(showpasswordField.getText());
        hidepass_form.setVisible(false);
        showpass_form.setVisible(true);
    }

    @FXML
    private void btnClose(ActionEvent event){
        System.exit(0);
    }

    @FXML
    private void btnMinimize(ActionEvent event){
        Stage stage = (Stage)login_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resource){

    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package ecommerce;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class Ecommerce extends Application {
    private final int width=500, height=600, headerLine=50;
    Pane bodyPane = new Pane();
    ProductList products = new ProductList();
    Button signInButton = new Button("Sign In");
    Label welcomelabel = new Label("Welcome Customer");
    Customer loggedInCustomer = null;
    
    public GridPane headerBar(){
        GridPane header = new GridPane();
        TextField searchBar = new TextField();
        Button searchBtn = new Button("Search");
        
        searchBtn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(products.getAllProducts());
            }
        });
        
        signInButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(LoginPage());
            }
        });
        
        header.setHgap(10);
        header.add(searchBar,0,0);
        header.add(searchBtn,1,0);
        header.add(signInButton,2,0);
        header.add(welcomelabel, 3, 0);
        return header;
    }
    public GridPane LoginPage(){
        Label userlabel = new Label("User Name:");
        Label passlabel = new Label("Password:");
        TextField username = new TextField();
        username.setPromptText("Enter User Name");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter password");
        Button login =new Button("Login");
        Label msglabel = new Label("Login - Message");
        
        GridPane loginPane = new GridPane();
        loginPane.setHgap(10);
        loginPane.setVgap(10);
        loginPane.setTranslateY(50);
        loginPane.setTranslateX(50);
        loginPane.add(userlabel,0,0);
        loginPane.add(passlabel,0,1);
        loginPane.add(username,1,0);
        loginPane.add(password,1,1);
        loginPane.add(login,0,2);
        loginPane.add(msglabel,1,2);
        Login log = new Login();
        login.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                String user = username.getText();
                String pass = password.getText();
                loggedInCustomer = Login.customerLogin(user, pass);
                if(loggedInCustomer!=null){
                    msglabel.setText("Login Successful!!");
                    welcomelabel.setText("Welcome " + loggedInCustomer.getName());
                    signInButton.setText("Signed In");
                }
                else{
                    msglabel.setText("Login Failed!!");
                }
            }
        });
        
        return loginPane;
    }
    
    private void showDialog(String message){
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("Order Status");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.setContentText(message);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }
    private GridPane footerBar(){
        Button buyNowButton = new Button("Buy Now");
        
        buyNowButton.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Product product = ProductList.getSelectedProduct();
                boolean orderStatus = false;
                if(product!=null && loggedInCustomer!=null){
                    orderStatus = Order.placeOrder(loggedInCustomer,product);
                }
                if(orderStatus==true){
                    showDialog("Order Successful!");
                }
                else{
                     showDialog("Order Failed!");
                }
            }
        });
        
        
        GridPane footer = new GridPane();
        footer.setTranslateY(500);
        footer.add(buyNowButton,0,0);
        footer.setTranslateX(20);
        return footer;
    }
    
    ProductList table = new ProductList();
    private Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width,height+2*headerLine);
        bodyPane = new Pane();
        bodyPane.setPrefSize(width,height);
        bodyPane.setTranslateY(headerLine);
        bodyPane.setTranslateX(10);
        bodyPane.getChildren().add(LoginPage());
        root.getChildren().addAll(headerBar(),bodyPane,footerBar());
        return root;
    }
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Ecommerce");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(createContent());
        
        primaryStage.setTitle("Ecommerce");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

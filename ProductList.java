/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author acer
 */
public class ProductList {
    private static TableView<Product> productTable;
    
    public Pane getAllProducts(){
        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        ObservableList<Product> productList = Product.getAllProducts();
        productTable = new TableView<>();
        productTable.setItems(productList);
        productTable.getColumns().addAll(id,name,price);
        
        Pane tablePane = new Pane();
        tablePane.getChildren().add(productTable);
        return tablePane;
    }
    
    public static Product getSelectedProduct(){
        return productTable.getSelectionModel().getSelectedItem();
    }
}

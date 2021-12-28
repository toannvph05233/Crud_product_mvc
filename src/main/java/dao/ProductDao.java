package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static Connection connection = ConnectMySql.getConnection();

    public static List<Product> getAllProduct() {
        String sqlGetAll = "SELECT * FROM product";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Product> listProduct = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");

                listProduct.add(new Product(id, name, img, price));
            }
            return listProduct;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveProduct(Product product) {
        String saveSQl = "INSERT INTO product(name,img,price) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(saveSQl);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getImg());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteProduct(int id){
        String deleteSQL = "DELETE from product where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

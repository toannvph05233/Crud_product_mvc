package service;

import dao.CategoryDao;
import dao.ProductDao;
import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = ProductDao.getAllProduct();


    public void create(Product product){
        ProductDao.saveProduct(product);
        products = ProductDao.getAllProduct();
    }


    public void delete(int index){
        ProductDao.deleteProduct(products.get(index).getId());
        products = ProductDao.getAllProduct();
    }

    public void edit(int index, Product product){
        products.set(index,product);
    }


    public int findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}

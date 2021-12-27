package service;

import model.Product;

import java.util.ArrayList;

public class ProductService {
    public static ArrayList<Product> products = new ArrayList<>();

    static{
        products.add(new Product(1,"iphone 11", "https://www.xtmobile.vn/vnt_upload/product/08_2019/thumbs/(600x600)_crop_600_iphone_11_pro_max_den_xtmobile.jpg", 600));
        products.add(new Product(2,"iphone 12", "https://img.websosanh.vn/v2/users/root_product/images/dien-thoai-apple-iphone-11-pro/lspfo5py7r1bv.jpg?compress=85", 800));
        products.add(new Product(3,"iphone 13", "https://icdn.dantri.com.vn/thumb_w/640/2020/12/14/iphone-11-pro-1-1607887211166.jpeg", 900));
    }

    public void create(Product product){
        products.add(product);
    }

    public void delete(int index){
        products.remove(index);
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

package service;

import dao.CategoryDao;
import model.Category;

import java.util.List;

public class CategoryService {
    public List<Category> getAll(){
        return CategoryDao.getAllCategory();
    }
}

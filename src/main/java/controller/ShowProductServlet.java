package controller;

import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/products")
public class ShowProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> products = ProductService.products;
        req.setAttribute("listP", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/showProduct.jsp");
        requestDispatcher.forward(req,resp);
    }
}

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

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher = null;

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(request, response, requestDispatcher);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "edit":
                showEditProduct(request,response,requestDispatcher);
                break;
            default:
                showProduct(request, response, requestDispatcher);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher rd;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                //edit khi nhấn sửa xong
                break;
        }

    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(productService.findIndexById(id));
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        productService.create(new Product(id, name, img, price));
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showCreateProduct(HttpServletRequest request, HttpServletResponse response, RequestDispatcher rd) {
        rd = request.getRequestDispatcher("/views/createProduct.jsp");
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showEditProduct(HttpServletRequest request, HttpServletResponse response, RequestDispatcher rd) {
      // ném ra dữ thằng cần sửa.
    }


    public void showProduct(HttpServletRequest request, HttpServletResponse response, RequestDispatcher rd) {
        request.setAttribute("products", ProductService.products);
        rd = request.getRequestDispatcher("/views/showProduct.jsp");
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

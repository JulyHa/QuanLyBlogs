package controller;

import model.Category;
import model.User;
import service.impl.CategoryService;
import service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/categories")
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService;
    @Override
    public void init() throws ServletException {
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }try {
            switch (action){
                case "create":
                    showFormCreate(request, response);
                    break;
                case "edit":
                        showFormEdit(request, response);
                    break;
                case "delete":

                        deleteUser(request, response);

                    break;
                default:
                    showListCategory(request, response);
            }
        } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.selectById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/edit.jsp");
        request.setAttribute("category", category);
        requestDispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(id);
        response.sendRedirect("/categories");
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories= categoryService.selectAll();
        request.setAttribute("categories", categories);
        RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("category/list.jsp");
        resRequestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }try {
            switch (action){
                case "create":
                        CreateCategory(request, response);
                    break;
                case "edit":
                        EditCategory(request, response);
                    break;
                default:
                    showListCategory(request, response);
            }
        } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

    private void EditCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String des = request.getParameter("description");
//        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        Category category = new Category(id, name, des);
        categoryService.update(category);
        response.sendRedirect("/categories");
    }

    private void CreateCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String des = request.getParameter("description");

        Category category = new Category(name, des, true);
        categoryService.insert(category);
        response.sendRedirect("/categories");
    }
}

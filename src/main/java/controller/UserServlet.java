package controller;

import service.impl.UserService;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
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
                case "logout":
                    logOut(request, response);
                default:
                    showListUser(request, response);
            }
        }catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }

    private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        User u = userService.selectById(id, 1);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", u);
        requestDispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        response.sendRedirect("/users");
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.selectAll();
        request.setAttribute("listUser", users);
        RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("user/list.jsp");
        resRequestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action) {
                case "login":
                    loginAcount(request, response);
                    break;
                case "signIn":
                    signIn(request, response);
                    break;
                case "create":
                    createUser(request, response);
                    break;
                case "edit":
                    editUser(request, response);
                    break;

                default:
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private User getUser(HttpServletRequest request, HttpServletResponse response){
        String first = request.getParameter("firstName");
        String last = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phoneNumber");
        String username = request.getParameter("userName");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        return new User(first, last, address, phone, username, email, pass);
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        User user = getUser(request, response);
        userService.insert(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String first = request.getParameter("firstName");
        String last = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(id, first, last, address, phoneNumber, username, email, password, new Date());
        userService.update(user);
        response.sendRedirect("/users");
    }


    private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        User user = getUser(request, response);
        userService.insert(user);
        response.sendRedirect("/users");
    }

    private void loginAcount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(userService.selectByNameAndPass(username, password, 1) > 0){
            User u = new User(username, password);
            request.setAttribute("username", u);
            response.sendRedirect("/users");
        }
        else {

            RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("index.jsp");
            resRequestDispatcher.forward(request, response);
        }

    }
}

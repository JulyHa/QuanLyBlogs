package controller;

import model.Blog;
import model.Category;
import service.impl.BlogService;
import service.impl.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogServlet", urlPatterns = "/blogs")
public class BlogServlet extends HttpServlet {
    BlogService blogService;
    @Override
    public void init() throws ServletException {
        blogService = new BlogService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            default:

                showListBlog(request, response);
                break;
        }
    }

    private void showListBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Blog> blogs= blogService.selectAll();
        request.setAttribute("blogs", blogs);
        RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("blog/list.jsp");
        resRequestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

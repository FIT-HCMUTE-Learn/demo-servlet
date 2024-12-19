package learn.controller.web;

import learn.model.UserModel;
import learn.service.ICategoryService;
import learn.service.IUserService;
import learn.utils.FormUtil;
import learn.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/home", "/login", "/logout"})
public class HomeController extends HttpServlet {

    @Inject
    private ICategoryService categoryService;

    @Inject
    private IUserService userService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String message = request.getParameter("message");
            String alert = request.getParameter("alert");
            if (message != null && alert != null) {
                request.setAttribute("message", resourceBundle.getString(message));
                request.setAttribute("alert", alert);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
            rd.forward(request, respond);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, "USERMODEL");
            respond.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("categories", categoryService);
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(request, respond);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            try {
                UserModel model = FormUtil.toModel(UserModel.class, request);
                model = userService.findByUsernameAndPasswordAndStatus(model.getUsername(), model.getPassword(), model.getStatus());
                if (model != null) {
                    SessionUtil.getInstance().getValue(request, "USERMODEL");
                    if (model.getRole().getCode().equals("USER")) {
                        respond.sendRedirect(request.getContextPath() + "/home");
                    } else if (model.getRole().getCode().equals("ADMIN")) {
                        respond.sendRedirect(request.getContextPath() + "/admin-home");
                    }
                } else {
                    respond.sendRedirect(request.getContextPath() + "/login?action=login&alert=danger&message=username_password_invalid");
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | SQLException e) {
                throw new RuntimeException(e);
            };
        }
    }
}

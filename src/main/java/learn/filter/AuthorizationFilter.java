package learn.filter;

import learn.constant.SystemConstant;
import learn.model.NewsModel;
import learn.model.UserModel;
import learn.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/admin")) {
            UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            if (userModel != null) {
                if (userModel.getRole().getCode().equals(SystemConstant.ADMIN)) {
                    filterChain.doFilter(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/login?action=login&alert=danger&message=not_permission");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login?action=login&alert=danger&message=not_login");
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}

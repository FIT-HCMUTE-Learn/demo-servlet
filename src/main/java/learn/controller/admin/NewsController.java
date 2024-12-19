package learn.controller.admin;

import learn.constant.SystemConstant;
import learn.model.NewsModel;
import learn.paging.IPageable;
import learn.paging.PageRequest;
import learn.service.INewsService;
import learn.sort.Sorter;
import learn.utils.FormUtil;

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

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {

    @Inject
    private INewsService newsService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {

        respond.setContentType("text/html");
        respond.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        NewsModel model;
        try {
            model = FormUtil.toModel(NewsModel.class, request);
            IPageable pageable = new PageRequest(model.getPage(), model.getMaxPageItems(), new Sorter(model.getSortName(), model.getSortBy()));
            model.setListResults(newsService.findAll(pageable));
            model.setTotalItems(newsService.getTotalItems());
            model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / (double) model.getMaxPageItems()));
        } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/list.jsp");
        rd.forward(request, respond);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {

    }
}

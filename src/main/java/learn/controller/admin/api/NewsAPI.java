package learn.controller.admin.api;

import learn.model.NewsModel;
import learn.service.INewsService;
import learn.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet {

    @Inject
    private INewsService newsService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        respond.setContentType("application/json");
        NewsModel newsModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
        // json to string
        try {
            newsService.save(newsModel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // string to json
        mapper.writeValue(respond.getOutputStream(), newsModel);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        respond.setContentType("application/json");
        NewsModel newsModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
        // json to string
        try {
            newsService.update(newsModel);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // string to json
        mapper.writeValue(respond.getOutputStream(), newsModel);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        respond.setContentType("application/json");
        NewsModel newsModel = HttpUtil.of(request.getReader()).toModel(NewsModel.class);
        // json to string
        try {
            newsService.delete(newsModel.getIds());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // string to json
        mapper.writeValue(respond.getOutputStream(), "{delete-successful}");
    }
}

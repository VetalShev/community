package ru.vetalshev.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController implements Controller {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public AbstractController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        System.out.println("CONSTRUCTOR AbstractController");
    }

    @Override
    public void render(String pageTpl) {
        response.setContentType("text/html");

        RequestDispatcher appDispatcher = request.getRequestDispatcher(pageTpl);
        try {
            appDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }
}

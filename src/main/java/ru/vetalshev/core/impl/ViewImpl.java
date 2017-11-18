package ru.vetalshev.core.impl;

import ru.vetalshev.core.View;
import ru.vetalshev.core.ViewAndModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ViewImpl implements View {

    private String name;

    public ViewImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void render(HttpServletRequest request, HttpServletResponse response, ViewAndModel viewModel) {
        response.setContentType("text/html");

        if (viewModel != null) {
            Map<String, Object> model = viewModel.getModel().asMap();

            // populate page model with data from Controller
            for (Map.Entry<String, Object> entry : model.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }
        }

        RequestDispatcher appDispatcher = request.getRequestDispatcher(name);
        try {
            appDispatcher.forward(request, response);
        } catch (ServletException|IOException e) {
            e.printStackTrace();
        }

    }
}

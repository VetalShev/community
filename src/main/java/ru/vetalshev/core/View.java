package ru.vetalshev.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface View {

    void render(HttpServletRequest request, HttpServletResponse response, ViewAndModel vm);

    String getName();

}

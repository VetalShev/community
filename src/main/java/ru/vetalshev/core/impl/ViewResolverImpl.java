package ru.vetalshev.core.impl;

import ru.vetalshev.core.View;
import ru.vetalshev.core.ViewResolver;
import ru.vetalshev.core.exception.ViewResolverException;

import javax.servlet.http.HttpServletRequest;

public class ViewResolverImpl implements ViewResolver {

    private static final String CONTEXT = "/WEB-INF/jsp/page/";


    public View resolve(HttpServletRequest request, String name) throws ViewResolverException {
        String contextPath = request.getContextPath();
        String viewPath = CONTEXT + name + ".jsp";
//        File f = new File(viewPath);

        //TODO: вернуть проверку наличия файла после того как разберемся с передачей контекста во вью резолвер
//        if (f.exists() && f.isFile()) { // !f.isDirectory()
            return new ViewImpl(viewPath);
//        }

//        throw new ViewResolverException("File not found: " + viewPath);
    }
}

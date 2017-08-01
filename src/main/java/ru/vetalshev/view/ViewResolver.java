package ru.vetalshev.view;

import ru.vetalshev.view.exception.ViewResolverException;

import java.io.File;

public class ViewResolver {

    private static final String CONTEXT = "/WEB-INF/jsp/page/";

    public ViewResolver() {
    }

    public String resolve(String name) throws ViewResolverException {
        String viewPath = CONTEXT + name + ".jsp";
        File f = new File(viewPath);

        //TODO: вернуть проверку наличия файла после того как разберемся с передачей контекста во вью резолвер
//        if (f.exists() && f.isFile()) { // !f.isDirectory()
            return viewPath;
//        }

//        throw new ViewResolverException("File not found: " + viewPath);
    }
}

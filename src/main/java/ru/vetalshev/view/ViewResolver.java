package ru.vetalshev.view;

import ru.vetalshev.view.exception.ViewResolverException;

import java.io.File;

public class ViewResolver {

    private static final String CONTEXT = "/WEB-INF/jsp/page/";

    public ViewResolver() {
    }

//    public ViewResolver(String fileName) {
//        getView(fileName);
//    }

    public View getView(String name) throws ViewResolverException {
        String viewPath = CONTEXT + name + ".jsp";
        File f = new File(viewPath);

        if (f.exists() && f.isFile()) { // !f.isDirectory()
            return new View(viewPath);
        }

        throw new ViewResolverException("File not found: " + viewPath);
    }
}

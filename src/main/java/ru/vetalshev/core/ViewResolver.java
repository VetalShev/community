package ru.vetalshev.core;

import ru.vetalshev.core.exception.ViewResolverException;

import javax.servlet.http.HttpServletRequest;

public interface ViewResolver {

    View resolve(HttpServletRequest request, String viewName) throws ViewResolverException;

}

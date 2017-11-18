package ru.vetalshev.core;

import ru.vetalshev.core.exception.ControllerNotFoundException;
import ru.vetalshev.core.exception.HandlerResolverException;
import ru.vetalshev.core.impl.ControllerAndMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerResolver {

    ControllerAndMethod resolveMethod(HttpServletRequest request, HttpServletResponse response) throws ControllerNotFoundException, HandlerResolverException;

}

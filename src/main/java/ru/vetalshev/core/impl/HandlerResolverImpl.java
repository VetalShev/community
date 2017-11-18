package ru.vetalshev.core.impl;

import ru.vetalshev.core.HandlerResolver;
import ru.vetalshev.core.annotation.RequestMapping;
import ru.vetalshev.core.exception.ControllerNotFoundException;
import ru.vetalshev.core.exception.HandlerResolverException;
import ru.vetalshev.core.helper.ClassFinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerResolverImpl implements HandlerResolver {

    private static final String DEFAULT_CONTROLLER_PACKAGE = "ru.vetalshev.controller.impl";

    @Override
    public ControllerAndMethod resolveMethod(HttpServletRequest request, HttpServletResponse response)
            throws HandlerResolverException, ControllerNotFoundException {
        String URL_PATTERN = "^(/articles|/users)(?:/([\\d]*))?$";
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        String uriFreeContextPath = uri.substring(contextPath.length());

        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(uriFreeContextPath);

        if (matcher.find()) {
            String controllerMapping = matcher.group(1);
            String stringParams = matcher.group(2);

            ClassFinder classFinder = new ClassFinder();
            Iterable<Class> classes = null;

            try {
                classes = classFinder.getClasses(DEFAULT_CONTROLLER_PACKAGE);
            } catch (ClassNotFoundException | IOException | URISyntaxException e) {
                e.printStackTrace();
            }

            Class controllerToBeInvoked = findController(classes, controllerMapping);
            Method methodToBeInvoked = null;

            if (controllerToBeInvoked == null) {
                throw new ControllerNotFoundException("HandlerResolver doesn't catch any controller");
            }

            methodToBeInvoked = findControllerMethod(controllerToBeInvoked, calculateRequestParamsNumber(stringParams));

            if (methodToBeInvoked == null) {
                throw new HandlerResolverException("Corresponding handler is not found!");
            }

            ControllerAndMethod cm = new ControllerAndMethod();
            String name = controllerToBeInvoked.getSimpleName();
            Object[] params = extractParamsFromUrl(methodToBeInvoked.getParameterTypes(), stringParams);

            cm.setMethod(methodToBeInvoked);
            cm.setControllerName(name.substring(0, name.length() - 4));
            cm.setMethodParams(params);

            return cm;
        }

        throw new HandlerResolverException("Corresponding handler is not found!");
    }

    private Object[] extractParamsFromUrl(Class<?>[] methodParamTypes, String urlParams) {
        List<Object> params = new ArrayList<>();

        if (urlParams == null) {
            return params.toArray();
        }

        String[] splittedUrlParams = urlParams.split("/");

        if (splittedUrlParams.length > 0) {
            for (int i = 0; i < methodParamTypes.length; i++) {
                Object param;
                try {
                    param = Integer.parseInt(splittedUrlParams[i]);
                } catch (NumberFormatException e) {
                    throw new HandlerResolverException("Wrong URL parameters type", e);
                }

                params.add(param);
            }
        }

        return params.toArray();
    }

    private Class findController(Iterable<Class> classes, String controllerMapping) {
        for (Class cls : classes) {
            if (cls.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping clsAnnotation = (RequestMapping) cls.getAnnotation(RequestMapping.class);

                if (clsAnnotation.value().equals(controllerMapping)) {
                    return cls;
                }
            }
        }

        // TODO:
//        throw new ControllerNotFoundException("some mess");

        return null;
    }

    private Method findControllerMethod(Class controllerToBeInvoked, int requestParamsNumber) {
        Method[] methods = controllerToBeInvoked.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RequestMapping.class)) {
                Parameter[] handlerParams = method.getParameters();

                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class); // TODO: почему тут преобразование типов не нужно, а в предыдущем случе нужно???

                int mappingParamsNumber = calculatedAnnotationParamsNumber(methodAnnotation.value());
                int handlerParamsNumber = handlerParams.length;

                if (mappingParamsNumber == handlerParamsNumber && handlerParamsNumber == requestParamsNumber) {
                    return method;
                }
            }
        }

        return null;
    }

    private int calculatedAnnotationParamsNumber(String request) {
        Pattern pattern = Pattern.compile("[{].*?[}]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(request);

        int paramsNumber = 0;

        while (matcher.find()) {
            paramsNumber++;
        }

        return paramsNumber;
    }

    private int calculateRequestParamsNumber(String request) {
        if (request == null || request.equals("")) {
            return 0;
        }

        String[] params = request.split("/");

        return params.length;
    }

}

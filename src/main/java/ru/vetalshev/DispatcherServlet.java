package ru.vetalshev;

import ru.vetalshev.controller.Controller;
import ru.vetalshev.core.*;
import ru.vetalshev.core.exception.ControllerNotFoundException;
import ru.vetalshev.core.exception.HandlerResolverException;
import ru.vetalshev.core.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(
        urlPatterns = "/"
)
public class DispatcherServlet extends HttpServlet {

    public DispatcherServlet() {
        System.out.println("CONSTRUCTOR DispatcherServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DO_GET");

        HandlerResolver handlerResolver = new HandlerResolverImpl();
        HandlerInvoker invoker = new HandlerInvokerImpl();
        ViewResolver viewResolver = new ViewResolverImpl();

        ControllerAndMethod cm = null;

        try {
            cm = handlerResolver.resolveMethod(request, response);
        } catch (HandlerResolverException|ControllerNotFoundException e) {
            try {
                Class controllerToBeInvoked = Class.forName("ru.vetalshev.controller.impl" + ".HomeControllerImpl");
                Method methodToBeInvoked = controllerToBeInvoked.getMethod("renderLastArticles");
                String name = controllerToBeInvoked.getSimpleName();

                cm = new ControllerAndMethod();

                cm.setMethod(methodToBeInvoked);
                cm.setControllerName(name.substring(0, name.length() - 4));
                cm.setMethodParams(null);
            } catch (ClassNotFoundException | NoSuchMethodException ex) {
                throw new RuntimeException("Can't resolve either Controller or Method name", ex);
            }
        }

        Controller controller = null;

        try {
            controller = (Controller) AppContext.class.getMethod("get" + cm.getControllerName()).invoke(null);
        } catch (IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
            e.printStackTrace();
        }

        // ====================

        HandlerInvokerDataObj handlerInvokerDataObj = new HandlerInvokerDataObj();
        handlerInvokerDataObj.setController(controller);
        handlerInvokerDataObj.setHandler(cm.getMethod());
        handlerInvokerDataObj.setHandlerParams(cm.getMethodParams());

        ViewAndModel vm = invoker.handle(handlerInvokerDataObj);
        View view = viewResolver.resolve(request, vm.getViewName());

        view.render(request, response, vm);
    }

}

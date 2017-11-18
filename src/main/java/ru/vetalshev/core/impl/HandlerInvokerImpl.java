package ru.vetalshev.core.impl;

import ru.vetalshev.controller.Controller;
import ru.vetalshev.core.HandlerInvoker;
import ru.vetalshev.core.ViewAndModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HandlerInvokerImpl implements HandlerInvoker {

    @Override
    public ViewAndModel handle(HandlerInvokerDataObj dataObj) {
        ViewAndModel vm = null;
        Method handler = dataObj.getHandler();
        Controller controller = dataObj.getController();
        Object[] params = dataObj.getHandlerParams();

        try {
            vm = (ViewAndModel) handler.invoke(controller, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return vm;
    }
}

package ru.vetalshev.core.impl;

import ru.vetalshev.controller.Controller;

import java.lang.reflect.Method;

public class HandlerInvokerDataObj {

    private Controller controller;
    private Method handler;
    private Object[] handlerParams;

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Method getHandler() {
        return handler;
    }

    public void setHandler(Method handler) {
        this.handler = handler;
    }

    public Object[] getHandlerParams() {
        return handlerParams;
    }

    public void setHandlerParams(Object[] handlerParams) {
        this.handlerParams = handlerParams;
    }
}

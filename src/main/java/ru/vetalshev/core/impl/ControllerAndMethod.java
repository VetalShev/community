package ru.vetalshev.core.impl;

import java.lang.reflect.Method;

public class ControllerAndMethod {

    private Method method;
    private String controllerName;
    private Object[] methodParams;

    public String getControllerName() {
        return controllerName;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(Object[] methodParams) {
        this.methodParams = methodParams;
    }
}

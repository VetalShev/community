package ru.vetalshev.core;

import ru.vetalshev.core.impl.HandlerInvokerDataObj;

public interface HandlerInvoker {

    ViewAndModel handle(HandlerInvokerDataObj dataObj);

}

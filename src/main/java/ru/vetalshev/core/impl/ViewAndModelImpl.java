package ru.vetalshev.core.impl;

import ru.vetalshev.core.Model;
import ru.vetalshev.core.ViewAndModel;

public class ViewAndModelImpl implements ViewAndModel {

    private String viewName;
    private Model model;

    public ViewAndModelImpl(String viewName, Model model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public Model getModel() {
        return model;
    }
}

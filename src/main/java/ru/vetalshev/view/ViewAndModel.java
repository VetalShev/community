package ru.vetalshev.view;

public class ViewAndModel {

    private View view;
    private Model model;

    public ViewAndModel(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }
}

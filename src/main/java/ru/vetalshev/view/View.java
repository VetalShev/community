package ru.vetalshev.view;

public class View {

    private static ViewResolver viewResolver = new ViewResolver();
    private String name;

    public View(String name) {
        this.name = viewResolver.resolve(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = viewResolver.resolve(name);
    }

}

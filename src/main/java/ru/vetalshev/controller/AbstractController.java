package ru.vetalshev.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractController implements Controller {

    public AbstractController() {
        System.out.println("CONSTRUCTOR AbstractController");
    }
}

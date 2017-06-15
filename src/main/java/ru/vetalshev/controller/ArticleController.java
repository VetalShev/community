package ru.vetalshev.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
        urlPatterns = "/article/*"
)
public class ArticleController extends HttpServlet {

    public ArticleController() {
        System.out.println("CONSTRUCTOR ArticleController");
    }
}

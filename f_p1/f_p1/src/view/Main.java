package view;

import controller.Controller;
import model.Model;

public class Main
{
    public static void main(String[] args)
    {
        Model model = new Model();
        new Controller(model).run();
    }
}
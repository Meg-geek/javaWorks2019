package sample;

import ControllerPackage.Controller;

public class Main {

    public static void main(String[] args) {
        try{
            Controller controller = new Controller();
            controller.go();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}

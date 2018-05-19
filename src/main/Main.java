/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import View.View;
import controller.ControllerGraph;
import deepspace.GameUniverse;
import GUI.MainWindow;


/**
 *
 * @author JuanAntonio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameUniverse model=new GameUniverse();
        View view=new MainWindow();
        ControllerGraph controller=new ControllerGraph(model,view);
        controller.start();
        
        
    }
    
}

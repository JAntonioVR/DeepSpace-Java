/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author i62virej
 */
public class Loot {
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    
    public Loot(int new_nSupplies, int new_nWeapons,
                int new_nShields, int new_nHangars, int new_nMedals){
        nSupplies=new_nSupplies;
        nWeapons=new_nWeapons;
        nShields=new_nShields;
        nHangars=new_nHangars;
        nMedals=new_nMedals;
    }
    
    public int getNSupplies(){
        return nSupplies;
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    public int getNShields(){
        return nShields;
    }
    
    public int getNHangars(){
        return nHangars;
    }  
    
    public int getNMedals(){
        return nMedals;
    }
    
    
    
}

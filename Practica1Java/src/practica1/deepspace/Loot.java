package deepspace;



/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
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
    
    public String toString(){
        String mensaje = "El numero de hangares obtenidos es "+this.getNHangars()+
                ", el numero de armas obtenidos es "+this.getNWeapons()+
                ", el numero de escudos obtenidos es "+this.getNShields()+
                ", el numero de hangares obtenidos es "+this.getNHangars()+
                " y el numero de medallas conseguidas es "+this.getNMedals();
        return mensaje;
    }
    
}

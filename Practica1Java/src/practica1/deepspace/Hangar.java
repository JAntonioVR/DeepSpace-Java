

package deepspace;

import java.util.ArrayList;
/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class Hangar {
    private int maxElements;
    private ArrayList<ShieldBooster> shieldBoosters;
    private ArrayList<Weapon> weapons;
    
    
    Hangar(int capacity){
        maxElements=capacity;
    }
    Hangar(Hangar h){
        maxElements=h.maxElements;
    }
    
    HangarToUI getUIversion(){
        return new HangarToUI(this);
    }
    
    private boolean spaceAvailable(){
        return weapons.size()+shieldBoosters.size() <= maxElements;
    }   
    
    public boolean addWeapon(Weapon w){
        return weapons.add(w);
    }
            
    public boolean addShieldBooster(ShieldBooster w){
        return shieldBoosters.add(w);   
    }
    
    public int getMaxElements(){
        return maxElements;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    
    public Weapon removeWeapon(int w){
        if (w>=weapons.size())
            return null;
        else{
            return weapons.remove(w);
        }
    }
    

    public ShieldBooster removeShieldBooster(int s){
        if (s>=shieldBoosters.size())
            return null;
        else{
            return shieldBoosters.remove(s);
        }
    }
        
    @Override
    public String toString(){
        String res="Esta instancia de la clase Hangar contiene "+weapons.toString()+
                " armas y "+shieldBoosters.toString()+" potenciadores de escudo y puede almacenar "+maxElements+
                " elementos.";
        return res;
    }
    
    
    
    
    
    
}

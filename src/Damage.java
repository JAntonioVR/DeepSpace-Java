
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Pedro Pablo Ruiz Huertas
 */
public class Damage {
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    
    Damage(int w, int s){
        this.nShields=s;
        this.nWeapons=w;
    }
    
    Damage(ArrayList<WeaponType> wl, int s){
        this.nShields=s;
        this.weapons=wl;        
    } 
    
    Damage(Damage d){
        this.nShields=d.nShields;
        this.nWeapons=d.nWeapons;
    }
    
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    }
    
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        this.nShields=s.size();
        this.nWeapons=w.size();
        return this;
    }
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
        Iterator<Weapon> it=w.iterator();
        int i=0;
        Weapon waux=(Weapon) it;
        while(it.hasNext() && waux.getType() != t){
            it.next();
            waux=(Weapon) it;
            i++;
        }
        if (it.hasNext())
            return i;
        else
            return -1;
    }
    
    public void discardWeapon(Weapon w){
        int i=0;
        if (this.weapons.isEmpty())
            this.nWeapons--;
        else{
            while(i<this.weapons.size()){
                if (this.weapons.get(i)==w.getType()){
                    this.weapons.remove(i);
                }
                else
                    i++;
            }
        }
            
    }
    
    
}

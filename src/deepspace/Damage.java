
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
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
        this.weapons=d.weapons;
    }
    
    public int getNShields(){
        return this.nShields;
    }
    
    public int getNWeapons(){
        return this.nWeapons;
    }
    
    public ArrayList<WeaponType> getWeapons(){
        return this.weapons;
    }
    
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    }
    
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int minShields=nShields;
        if (nShields>s.size())
            minShields=s.size();
        
        if (weapons.isEmpty()){
            int minWeapons=nWeapons;
            if (nWeapons>w.size())
                minWeapons=w.size();
     
            return new Damage(minWeapons, minShields);
        }
        else {
            ArrayList<WeaponType> tipos= new ArrayList<WeaponType>();
            int laserWeapons=0, missileWeapons=0, plasmaWeapons=0;
            int laserW=0, missileW=0, plasmaW=0;
            int i;
            
            
            for (i=0; i<weapons.size(); i++){
                if (weapons.get(i)==WeaponType.LASER)
                    laserWeapons++;
                if (weapons.get(i)==WeaponType.MISSILE)
                    missileWeapons++;
                if (weapons.get(i)==WeaponType.PLASMA)
                    plasmaWeapons++;
            }
            
            for (i=0; i<weapons.size(); i++){
                if (w.get(i).getType()==WeaponType.LASER)
                    laserW++;
                if (w.get(i).getType()==WeaponType.MISSILE)
                    missileW++;
                if (w.get(i).getType()==WeaponType.PLASMA)
                    plasmaW++;
            }
            
            int minWeaponsLaser=laserWeapons;
            if(laserWeapons>laserW)
                minWeaponsLaser=laserW;
            
            int minWeaponsMissile=missileWeapons;
            if(missileWeapons>missileW)
                minWeaponsMissile=missileW;
            
            int minWeaponsPlasma=plasmaWeapons;
            if(plasmaWeapons>plasmaW)
                minWeaponsPlasma=laserW;
            
            for (i=0; i<minWeaponsLaser; i++) {
                tipos.add(WeaponType.LASER);
            }
            for (i=0; i<minWeaponsMissile; i++) {
                tipos.add(WeaponType.MISSILE);
            }
            for (i=0; i<minWeaponsPlasma; i++) {
                tipos.add(WeaponType.PLASMA);
            }
            return new Damage(tipos, minShields);
        }
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
    
    public void discardShieldBooster(){
        if (this.nShields>0)
            this.nShields--;      
    }
    
    public boolean hasNoEffect(){
        if(nShields==0 && nWeapons==0 && this.weapons.isEmpty())
             return true;
        else return false;
    }
    
    @Override
    public String toString(){
        String mensaje="El numero de escudos eliminados ha sido"+nShields+
                       ",\nel numero de armas eliminadas ha sido"+nWeapons+
                       ".\ny los tipos de armas eliminadas han sido"+weapons;
        return mensaje;
    }
}

package deepspace;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class EnemyStarShip {
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Damage damage;
    private Loot loot;
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        this.ammoPower=a;
        this.name=n;
        this.shieldPower=s;
        this.loot=l;
        this.damage=d;
    }
    
    EnemyStarShip(EnemyStarShip s){
        this.ammoPower=s.ammoPower;
        this.name=s.name;
        this.shieldPower=s.shieldPower;
        this.loot=s.loot;
        this.damage=s.damage;
    }
    
    public String getName() {
        return this.name;
    }

    public float getAmmoPower() {
        return this.ammoPower;
    }

    public float getShieldPower() {
        return this.shieldPower;
    }

    public Loot getLoot() {
        return this.loot;
    }

    public Damage getDamage() {
        return this.damage;
    }
    
    
    EnemyToUI getUIversion(){
        return new EnemyToUI(this);
    }
    
    public float fire(){
        return this.ammoPower;
    }
    
    public float protection(){
        return this.shieldPower;
    }
    
    public ShotResult receiveShot(float shot){
        if(this.shieldPower<shot)
            return ShotResult.DONOTRESIST;
        else return ShotResult.RESIST;
    }
}

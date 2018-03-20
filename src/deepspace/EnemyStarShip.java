
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
    
}

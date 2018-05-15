/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author JuanAntonio
 */
public class TestP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SuppliesPackage sp=new SuppliesPackage(1,10,1);
        SpaceStation station = new SpaceStation("Juan",sp);
        //System.out.println(station.toString());
        ArrayList<String> nombres=new ArrayList();
        nombres.add("Juan");
        nombres.add("Antonio");
        nombres.add("Pedro");
        GameUniverse gameUniverse = new GameUniverse();
        //gameUniverse.init(nombres); Revienta porque CardDealer tiene errores
        //System.out.println(station.fire());
        //station = new PowerEfficientSpaceStation(station);
        //System.out.println(station.toString());        
        station.receiveHangar(new Hangar(3));
        station.receiveShieldBooster(new ShieldBooster("Escudo ACME",1.5f,2));
        station.receiveShieldBooster(new ShieldBooster("Escudo ACME",1.5f,2));
        station.receiveWeapon(new Weapon("Misil ACME",WeaponType.MISSILE,2));
        station.receiveWeapon(new Weapon("Cañón definitivo",WeaponType.PLASMA,100));
        station.mountShieldBooster(0);
        station.mountWeapon(0);
        
        station = new PowerEfficientSpaceStation(station);
        System.out.println(station.fire());
        System.out.println(station.protection());
        station = new BetaPowerEfficientSpaceStation(station);
        System.out.println(station.fire());
        System.out.println(station.protection());
        
        System.out.println(station.toString());
        
        
        
    }
    
}

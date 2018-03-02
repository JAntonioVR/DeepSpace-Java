/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeepSpace;

/**
 *
 * @author pedropabloruiz
 */
public class TestP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Loot botin;
        ShieldBooster pEscudo;
        Weapon arma;
        Dice dado;
        int i;
        
        arma=new Weapon("Rayo", WeaponType.LASER, 0);
        dado=new Dice();
        pEscudo=new ShieldBooster("Ligero", 3.5f, 0);
        botin= new Loot(1,1,1,1,1);
        
        System.out.format("\nShieldBoost: %f\n", pEscudo.getBoost());
        System.out.format("\nUses: %f\n", pEscudo.getUses());
        
        for(i = 0; i < 100; i++){
            dado=new Dice();
            System.out.format("\nNumero de hangares: %n\n", dado.initWithNHangars());
            System.out.format("\nNumero de armas: %n\n", dado.initWithNWeapons());
            System.out.format("\nNumero de escudos: %n\n", dado.initWithNShields());
            System.out.format("\nComienzo: %n\n", dado.WhoStarts(2));
            System.out.format("\nPrimer disparo: %s\n", dado.firstShot());
        }
        
    }
    
}

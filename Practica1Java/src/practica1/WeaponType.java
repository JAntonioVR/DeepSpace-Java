/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author pedropabloruiz
 */
public enum WeaponType {
    LASER(2.0f), MISSILE(3.0f), PLASMA(4.0f);
    
    private float Power;
    
    WeaponType (float power){
        this.Power=power;
    }
    
    float getPower(){
          return Power;
    }
    
}

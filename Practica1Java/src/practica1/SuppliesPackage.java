
package DeepSpace;

/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class SuppliesPackage {
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    public SuppliesPackage(float new_ammoPower, float new_fuelUnits,
                           float new_shieldPower){
        ammoPower=new_ammoPower;
        fuelUnits=new_fuelUnits;
        shieldPower=new_shieldPower;
    }
    
    public SuppliesPackage(SuppliesPackage s){
        this.ammoPower=s.ammoPower;
        this.fuelUnits=s.fuelUnits;
        this.shieldPower=s.shieldPower;
    }
    
    public float getAmmoPower(){
        return ammoPower;
    }
    
    public float getFuelUnits(){
        return fuelUnits;
    }
    
    public float getShieldPower(){
        return shieldPower;
    }
    
}

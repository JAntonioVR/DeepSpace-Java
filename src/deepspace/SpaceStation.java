

package deepspace;

import java.util.ArrayList;
import static jdk.nashorn.internal.objects.NativeMath.max;


/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class SpaceStation {
    
    
    private static float MAXFUEL=100f;
    private static float SHIELDLOSSPERUNITSHOT=0.1f;
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    
    SpaceStation(String n, SuppliesPackage supplies){
        name=n;
        ammoPower=supplies.getAmmoPower();
        fuelUnits=supplies.getFuelUnits();
        shieldPower=supplies.getShieldPower();
    }
    
    
    private void assignFuelValue(float f){
        if(f>MAXFUEL)
            fuelUnits=MAXFUEL;
        else
            fuelUnits=f;
    }
    
    private void cleanPendingDamage(){
        if(pendingDamage.hasNoEffect())
            pendingDamage=null;
    }
    
    public void cleanUpMountedItems(){
        for (Weapon weapon : weapons) {
            if(weapon.getUses()==0)
                weapons.remove(weapon);
        }
        
        for (ShieldBooster shieldBooster : shieldBoosters){
            if(shieldBooster.getUses()==0)
                shieldBoosters.remove(shieldBooster);
        }
    }
    
    public void discardHangar(){
        hangar=null;
    }
    
    public void discardShieldBooster(int i){
        int size=shieldBoosters.size();
        if(i>=0 && i<size){
            ShieldBooster sh=shieldBoosters.remove(i);
            if(pendingDamage!=null){
                pendingDamage.discardShieldBooster();
                this.cleanPendingDamage();
            }
        }
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(hangar!=null)
            hangar.removeShieldBooster(i);
    }
    
    public void discardWeapon(int i){
        int size=weapons.size();
        if(i>=0 && i<size){
            Weapon w=weapons.remove(i);
            if(pendingDamage!=null){
                pendingDamage.discardWeapon(w);
                this.cleanPendingDamage();
            }
        }
    }
    
    public void discardWeaponInHangar(int i){
        if(hangar!=null)
            hangar.removeWeapon(i);
    }
    
    public float fire(){
        int size=weapons.size();
        float factor=1;
        for (int i=0; i<size; i++){
            Weapon w=weapons.get(i);
            factor*=w.useIt();
        }
        return ammoPower*factor;
    }
    
    public float getAmmoPower(){
        return ammoPower;
    }
    
    public float getFuelUnits(){
        return fuelUnits;
    }
    
    public Hangar getHangar(){
        return hangar;
    }
    
    public String getName(){
        return name;
    }
    
    public int getNMedals(){
        return nMedals;
    }
    
    public Damage getPendingDamage(){
        return pendingDamage;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
    public float getShieldPower(){
        return shieldPower;
    }
    
    public float getSpeed(){
        return fuelUnits/MAXFUEL;
    }
    
    public SpaceStationToUI getUIversion(){
        return new SpaceStationToUI(this);
    }
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    
    public void mountShieldBooster(int i){
        ShieldBooster aux;
        if(hangar!=null){
            aux=hangar.getShieldBoosters().remove(i);
            if(aux!=null) shieldBoosters.add(aux);
        }
    }
    
    public void mountWeapon(int i){
        Weapon aux;
        if(hangar!=null){
            aux=hangar.getWeapons().remove(i);
            if(aux!=null) weapons.add(aux);
        }
    }
    
    public void move(){
        fuelUnits-=(getSpeed()*fuelUnits);
        if(fuelUnits<0)
            fuelUnits=0;
    }
    
    public float protection(){
        int size=shieldBoosters.size();
        float factor=1;
        for(int i=0; i<size; i++){
            ShieldBooster s=shieldBoosters.get(i);
            factor*=s.useIt();
        }
        return shieldPower*factor;
    }
    
    public void receiveHangar(Hangar h){
        if(hangar==null)
            hangar=h;
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        if(hangar==null)
            return false;
        return hangar.addShieldBooster(s);
    }
    
    public ShotResult receiveShot(float shot){
        float myProtection=protection();
        if(myProtection>=shot){
            shieldPower-=SHIELDLOSSPERUNITSHOT*shot;
            shieldPower=(float) max(0.0, shieldPower);
            return ShotResult.RESIST;
            }
        else{
            shieldPower=0.0f;
            return ShotResult.DONOTRESIST;
        }
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower+=s.getAmmoPower();
        fuelUnits+=s.getFuelUnits();
        shieldPower+=s.getShieldPower();
    }
    
    public boolean receiveWeapon(Weapon w){
        if(hangar==null)
            return false;
        return hangar.addWeapon(w);
    }
    
    public void setLoot(Loot loot){
        int elements;
        CardDealer dealer=CardDealer.getInstance();
        int h=loot.getNHangars();
        if(h>0){
            Hangar hangar=dealer.nextHangar();
            this.receiveHangar(hangar);
        }
        elements=loot.getNSupplies();
        for(int i=0; i<elements; i++){
            SuppliesPackage sup=dealer.nextSuppliesPackage();
            this.receiveSupplies(sup);
        }
        elements=loot.getNWeapons();
        for(int i=0; i<elements; i++){
            Weapon weap=dealer.nextWeapon();
            this.receiveWeapon(weap);
        }
        elements=loot.getNShields();
        for(int i=0; i<elements; i++){
            ShieldBooster sh=dealer.nextShieldBooster();
            this.receiveShieldBooster(sh);
        }
        int medals=loot.getNMedals();
        nMedals+=medals;
    }
    
    public void setPendingDamage(Damage d){
        pendingDamage=d.adjust(weapons, shieldBoosters);
    }
    
    public boolean validState(){
        return pendingDamage==null || pendingDamage.hasNoEffect();
    }
    
    @Override
    public String toString(){
        String res="La estacion espacial tiene: \n*Una potencia de disparo de "+ammoPower+
                "\n*"+fuelUnits+" Unidades de combustible \n*"+nMedals+" medallas \n*Una potencia de escudo de "+
                shieldPower + "\nSu nombre es: " + name + "\nARMAS:\n"+weapons.toString()+"\nPOTENCIADORES DE ESCUDO:\n"+
                shieldBoosters.toString()+"\nDaño pendiente: "+pendingDamage.toString()+"\nHangar: "+hangar.toString();
        return res;
    }
    
    
}

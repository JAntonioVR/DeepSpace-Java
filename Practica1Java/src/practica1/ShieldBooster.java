/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author JuanAntonio
 */
public class ShieldBooster {
    private String name; //¿PAQUETE CLASE STRING?
    private float boost;
    private int uses;
    
    public ShieldBooster(String new_name, float new_boost, int new_uses){
        name=new_name;
        boost=new_boost;
        uses=new_uses;
    }
    
    public ShieldBooster(ShieldBooster s){
        this.name=s.name;
        this.boost=s.boost;
        this.uses=s.uses;
    }
    
    public float getBoost(){
        return boost;
    }
    
    public float getUses(){
        return uses;
    }
    
    public float useIt(){
        if(uses>0){
            uses--;
            return boost;
        }
        return (float) 1.0;
    }
}

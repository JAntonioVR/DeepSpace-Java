package deepspace;



/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class ShieldBooster implements Copyable <ShieldBooster> {
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
    
    public int getUses(){
        return uses;
    }
    
    ShieldToUI getUIversion(){
        return new ShieldToUI(this);
    }
    
    public float useIt(){
        if(uses>0){
            uses--;
            return boost;
        }
        return (float) 1.0;
    }
    
    public String toString(){
        String mensaje;
        mensaje = "El nombre del escudo es "+this.name+
                ", el potenciador del escudo es "+this.getBoost()+
                " y los usos que le quedan al escudo son "+this.getUses();
        return mensaje;
    }
    
    public ShieldBooster copy(){
        return new ShieldBooster(this);
    }
}

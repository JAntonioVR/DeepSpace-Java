package deepspace;



/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class Weapon implements Copyable <Weapon> {
    private String name;
    private WeaponType type;
    private int uses;
    
    public Weapon(String new_name, WeaponType new_type, int new_uses ){
        name=new_name;
        type=new_type;
        uses=new_uses;
    }
    
    public Weapon(Weapon s){
        name=s.name;
        type=s.type;
        uses=s.uses;
    }
    
    public WeaponType getType(){
        return type;
    }
    
    public int getUses(){
        return uses;
    }
    
    public float power(){
        return type.getPower();
    }
    
    WeaponToUI getUIversion(){
        return new WeaponToUI(this);
    }
    
    public float useIt(){
        if(uses>0){
            uses--;
            return power();
        }
        else{
            return 1.0f;
        }
    }
    
    public String toString(){
        String mensaje;
        mensaje = "El tipo de arma es "+this.type+
                ", el nombre del arma es "+this.name+
                ", la potencia del arma es "+this.power()+
                " y los usos que le quedan al arma son "+this.uses;
        return mensaje;
    }
    
    WeaponToUI getUIVersion(){
        return new WeaponToUI(this);
    }
    
    public Weapon copy(){
        return new Weapon(this);
    }
}



package deepspace;

import java.util.ArrayList;

/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class GameUniverse {
    private int WIN=10;
    private int currentStationIndex;
    private int turns;
    private GameStateController gamestate;
    private EnemyStarShip currentEnemy;
    private Dice dice;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> SpaceStations=new ArrayList<>();
    
    public GameUniverse(){
        this.turns=0;
        this.dice=new Dice();
        gamestate=new GameStateController();
    }
    
    boolean haveAWinner(){
        if(currentStation.getNMedals()==WIN){
            return true;
        }
        else return false;
    }
    
    public void init(ArrayList<String> names){
      GameState state=gamestate.getState();
      if(state==GameState.CANNOTPLAY){
        ArrayList<SpaceStation> spaceStations=new ArrayList<>();
        CardDealer dealer=CardDealer.getInstance();
        for(int i=0; i< names.size(); i++){
          SuppliesPackage supplies=dealer.nextSuppliesPackage();
          SpaceStation station=new SpaceStation(names.get(i),supplies);
          int nh=dice.initWithNHangars();
          int nw=dice.initWithNWeapons();
          int ns=dice.initWithNShields();
          Loot l=new Loot(0,nw,ns,ns,nh);
          station.setLoot(l);
          spaceStations.add(station);
        }
        currentStationIndex=dice.whoStarts(names.size());
        currentStation=spaceStations.get(currentStationIndex);
        currentEnemy=dealer.nextEnemy();
        gamestate.next(turns,names.size());
        } 
    }
    
    
    void discardHangar(){
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
            currentStation.discardHangar();
    }
    
    void discardShieldBooster(int i){
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
            currentStation.discardShieldBooster(i);
    }
    
    void discardShieldBoosterInHangar(int i){
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
            currentStation.discardShieldBoosterInHangar(i);
    }
    
    void discardWeapon(int i){
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
            currentStation.discardWeapon(i);
    }
    
    void discardWeaponInHangar(int i){
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
            currentStation.discardWeaponInHangar(i);
    }
    
    GameState getState(){
        return this.gamestate.getState();
    }
    
    GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(this.currentStation, this.currentEnemy);
    }
    
    void mountShieldBooster(int i){
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
            this.currentStation.mountShieldBooster(i);
    }
    
    void mountWeapon(int i){
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
            this.currentStation.mountWeapon(i);
    }
    
    @Override
    public String toString(){
        String res;
        res="El universo del juego tiene: \n*Indice de la estacion espacial actual= "+currentStationIndex+
                "\n*"+turns+" turnos, \n*las estaciones espaciales del universo son:"+SpaceStations.toString()+"  \n*El enemigo actual es: "
                +currentEnemy.toString() + ",\nel estado del dado es: " +dice.toString();
        return res;
    }
}

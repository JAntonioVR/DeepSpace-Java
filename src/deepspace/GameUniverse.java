

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
    private ArrayList<SpaceStation> SpaceStations;
    
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
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
            return this.gamestate.getState();
    }
    
    GameUniverseToUI getUIversion(){
        if(gamestate.getState()==GameState.INIT || gamestate.getState()==GameState.AFTERCOMBAT)
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
        String res="El universo del juego tiene: \n*Indice de la estacion espacial actual= "+currentStationIndex+
                "\n*"+turns+" turnos, \n*espacion espacial actual:"+currentStation.toString()+"  \n*El enemigo actual es: "
                +currentEnemy.toString() + ",\nel estado del dado es: " +dice.toString();
        return res;
    }
}
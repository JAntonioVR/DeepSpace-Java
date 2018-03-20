

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
        currentStation.discardHangar();
    }
    
    void discardShieldBooster(int i){
        currentStation.discardShieldBooster(i);
    }
    
    void discardShieldBoosterInHangar(int i){
        currentStation.discardShieldBoosterInHangar(i);
    }
    
    void discardWeapon(int i){
        currentStation.discardWeapon(i);
    }
    
    void discardWeaponInHangar(int i){
        currentStation.discardWeaponInHangar(i);
    }
    
    GameState getState(){
        return this.gamestate.getState();
    }
    
    GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(this.currentStation, this.currentEnemy);
    }
    
    void mountShieldBooster(int i){
        this.currentStation.mountShieldBooster(i);
    }
    
    void mountWeapon(int i){
        this.currentStation.mountWeapon(i);
    }
    
}

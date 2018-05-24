

package controller;


import View.View;
import java.util.ArrayList;
import deepspace.GameState;
import deepspace.GameUniverse;
import deepspace.GameUniverseToUI;
import deepspace.Weapon;
import deepspace.ShieldBooster;
import deepspace.WeaponToUI;
import deepspace.ShieldToUI;
import deepspace.CombatResult;
import deepspace.WeaponType;
import deepspace.Hangar;
import deepspace.HangarToUI;
import deepspace.NumericDamageToUI;
import deepspace.SpecificDamageToUI;
import deepspace.EnemyToUI;
import deepspace.LootToUI;
import deepspace.SpaceStationToUI;


/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class ControllerGraph {
    private GameUniverse model;
    private View view;
    
    public ControllerGraph(GameUniverse m, View v) {
        model = m;
        view = v;
        view.setController(this);
    }
    
    public void start() {
        model.init(view.getNames());
        view.updateView();
        view.showView();
    }
    
    public void finish(int i) {
        if (view.confirmExitMessage())
            System.exit(i);
    }
    
    public GameState getGameState () {
        return model.getState();
    }
    
    public GameUniverseToUI getModelToUI () {
        return model.getUIversion();
    }

    public ShieldToUI dameUnEscudoPrueba(){
        return new ShieldToUI(new ShieldBooster("ESCUDACO",3,4));
    }
    
    public WeaponToUI dameUnArmaPrueba(){
        return new WeaponToUI(new Weapon("ARMACA",WeaponType.PLASMA,5));
    }
    
    public HangarToUI dameUnHangarPrueba(){
        return model.dameUnHangarPrueba().getUIversion();
    }
    
    public NumericDamageToUI dameUnNumericDamagePrueba(){
        return model.dameUnNumericDamagePrueba().getUIversion();
    }
    
    public SpecificDamageToUI dameUnSpecificDamagePrueba(){
        return model.dameUnSpecificDamagePrueba().getUIversion();
    }
    
    public EnemyToUI dameUnEnemyStarShipPrueba(){
        return model.dameUnEnemyStarShipPrueba().getUIversion();
    }
    
    public SpaceStationToUI dameUnSpaceStationPrueba(){
        return model.dameUnSpaceStationPrueba().getUIversion();
    }
    
    public LootToUI dameUnLootPrueba(){
        return model.dameUnLootPrueba().getUIversion();
    }
    
    
    //=================================================================
    static public enum Element {
        WEAPON ("Arma"), 
        SHIELD ("Escudo"), 
        HANGAR ("Hangar");

        final public String text;

        Element (String t) { text = t; }
    };

    static public enum Operation {
        MOUNT ("Montar"), 
        DISCARD ("Descartar");

        final public String text;

        Operation (String t) { text = t; }
    };
    //==================================================================
    
    public CombatResult combat() {
        CombatResult result = model.combat();
        view.updateView();
        return result;
    }
    
    public boolean haveAWinner() {
        return model.haveAWinner();
    }

    public void discardHangar() {
        model.discardHangar();
        view.updateView();
    }

    public boolean nextTurn() {
        boolean result = model.nextTurn();
        view.updateView();
        return result;
    }

    public void mountWeapon(int option) {
        model.mountWeapon(option);
        view.updateView();
    }
    
    public void mountDiscardFromHangar(Operation operation, Element element, int option) {
        switch (element) {
            case WEAPON :
              if (operation == Operation.MOUNT)
                  model.mountWeapon(option);
              else
                  model.discardWeaponInHangar(option);
              break;
            case SHIELD :
              if (operation == Operation.MOUNT)
                  model.mountShieldBooster(option);
              else
                  model.discardShieldBoosterInHangar(option);
              break;
        }
    }
    
    public void discardMountedElements(Element element, int option) {
        switch (element) {
            case WEAPON :
              model.discardWeapon(option);
              break;
            case SHIELD :
              model.discardShieldBooster(option);
              break;
        }
        
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import View.View;
import controller.ControllerGraph;
import deepspace.CombatResult;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import deepspace.GameState;
import deepspace.WeaponToUI;
import deepspace.ShieldToUI;
import deepspace.HangarToUI;
import deepspace.LootToUI;
import deepspace.NumericDamageToUI;
import deepspace.SpecificDamageToUI;
import java.awt.Component;

/**
 *
 * @author JuanAntonio
 */
public class MainWindow extends JFrame implements View{
    static ControllerGraph controller;
    private String name = "DeepSpace";
    private SpaceStationView currentStationView;
    private EnemyView currentEnemyView;
    
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        currentStationView=new SpaceStationView();
        currentStationPanel.add(currentStationView);
        currentEnemyView=new EnemyView();
        currentEnemyPanel.add(currentEnemyView);  
        setTitle(name);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                controller.finish(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentStationPanel = new javax.swing.JPanel();
        combatButton = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        discardHangarButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        mountButton = new javax.swing.JButton();
        currentEnemyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        currentStationPanel.setPreferredSize(new java.awt.Dimension(531, 527));

        combatButton.setFont(new java.awt.Font("AR DESTINE", 0, 24)); // NOI18N
        combatButton.setText("COMBATIR");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        nextTurnButton.setFont(new java.awt.Font("AR DESTINE", 0, 12)); // NOI18N
        nextTurnButton.setText("Siguiente Turno");
        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnButtonActionPerformed(evt);
            }
        });

        finishButton.setFont(new java.awt.Font("AR DESTINE", 0, 12)); // NOI18N
        finishButton.setText("Salir");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        discardHangarButton.setFont(new java.awt.Font("AR DESTINE", 0, 11)); // NOI18N
        discardHangarButton.setText("Descartar Hangar Completo");
        discardHangarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardHangarButtonActionPerformed(evt);
            }
        });

        discardButton.setFont(new java.awt.Font("AR DESTINE", 0, 12)); // NOI18N
        discardButton.setText("Descartar");
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        mountButton.setFont(new java.awt.Font("AR DESTINE", 0, 12)); // NOI18N
        mountButton.setText("Equipar");
        mountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mountButtonActionPerformed(evt);
            }
        });

        currentEnemyPanel.setPreferredSize(new java.awt.Dimension(424, 136));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentStationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardHangarButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentEnemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nextTurnButton, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(finishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentStationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentEnemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextTurnButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mountButton)
                    .addComponent(discardButton)
                    .addComponent(discardHangarButton)
                    .addComponent(finishButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        CombatResult result= controller.combat();
        switch (result){
            case ENEMYWINS:
                JOptionPane.showMessageDialog(this, "Has perdido el combate\nCumple tu castigo", name, JOptionPane.INFORMATION_MESSAGE);
                break;
            case NOCOMBAT:
                JOptionPane.showMessageDialog(this, "El combate no ha podido realizar", name, JOptionPane.INFORMATION_MESSAGE);
                break;
            case STATIONESCAPES:
                JOptionPane.showMessageDialog(this, "¡Has conseguido escapar!\n¡Eres una gallina espacial!", name, JOptionPane.INFORMATION_MESSAGE);
                break;
            case STATIONWINS:
                JOptionPane.showMessageDialog(this, "¡Has ganado el combate!\nDisfruta de tu botín.", name, JOptionPane.INFORMATION_MESSAGE);
            case STATIONWINSANDCONVERTS:
                if(controller.getModelToUI().getCurrentEnemy().getLoot().isGetEfficient())
                    JOptionPane.showMessageDialog(this, "¡Has ganado el combate y ahora\ntu estación es más eficiente!", name, JOptionPane.INFORMATION_MESSAGE);
                if(controller.getModelToUI().getCurrentEnemy().getLoot().isSpaceCity())
                    JOptionPane.showMessageDialog(this, "¡Has ganado el combate y te\nhas convertido en una estación espacial!", name, JOptionPane.INFORMATION_MESSAGE);
                break;
        }
        
        updateView();
        
    }//GEN-LAST:event_combatButtonActionPerformed

    private void discardHangarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardHangarButtonActionPerformed
        controller.discardHangar();
    }//GEN-LAST:event_discardHangarButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        ArrayList<Integer> seleccion=currentStationView.getSelectedWeapons();
        for(int s:seleccion)controller.discardMountedElements(ControllerGraph.Element.WEAPON, s);
        ArrayList<Integer> seleccion2=currentStationView.getSelectedShields();
        for(int e:seleccion2) controller.discardMountedElements(ControllerGraph.Element.SHIELD, e);
        updateView();
    }//GEN-LAST:event_discardButtonActionPerformed

    private void nextTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnButtonActionPerformed
        if(!controller.nextTurn()){
            JOptionPane.showMessageDialog(this, "No puedes avanzar de turno", name, JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_nextTurnButtonActionPerformed

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        controller.finish(0);
    }//GEN-LAST:event_finishButtonActionPerformed

    private void mountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mountButtonActionPerformed
        ArrayList<Integer> seleccion=currentStationView.getSelectedWeaponsFromHangar();
        for(int s:seleccion)controller.mountDiscardFromHangar(ControllerGraph.Operation.MOUNT, ControllerGraph.Element.WEAPON,s);
        ArrayList<Integer> seleccion2=currentStationView.getSelectedShieldsFromHangar();
        for(int e:seleccion2) controller.mountDiscardFromHangar(ControllerGraph.Operation.MOUNT, ControllerGraph.Element.SHIELD, e);
    }//GEN-LAST:event_mountButtonActionPerformed

    @Override
    public void setController(ControllerGraph unControlador) {
        controller=unControlador;
    }

    @Override
    public void updateView() {
        nextTurnButton.setEnabled(controller.getGameState()==GameState.AFTERCOMBAT);
        combatButton.setEnabled(controller.getGameState()==GameState.INIT || controller.getGameState()==GameState.BEFORECOMBAT);
        currentStationView.setSpaceStation(controller.getModelToUI().getCurrentStation());
        currentEnemyView.setEnemyStarShip(controller.getModelToUI().getCurrentEnemy());
        
        /*LootToUI loot=controller.dameUnLootPrueba();
        LootView lv=new LootView();
        lv.setLoot(loot);
        panelPruebas.add(lv);*/
        
        
        
        repaint();
        revalidate();
    }

    @Override
    public void showView() {
        setVisible(true);
    }

    @Override
    public String getAppName() {
        return name;
    }

    @Override
    public ArrayList<String> getNames() {
        NamesCapture namesCapture = new NamesCapture (this);
        return namesCapture.getNames();
    }

    @Override
    public boolean confirmExitMessage() {
        return (JOptionPane.showConfirmDialog(this, "¿Estás segur@ que deseas salir?", getAppName(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combatButton;
    private javax.swing.JPanel currentEnemyPanel;
    private javax.swing.JPanel currentStationPanel;
    private javax.swing.JButton discardButton;
    private javax.swing.JButton discardHangarButton;
    private javax.swing.JButton finishButton;
    private javax.swing.JButton mountButton;
    private javax.swing.JButton nextTurnButton;
    // End of variables declaration//GEN-END:variables
}

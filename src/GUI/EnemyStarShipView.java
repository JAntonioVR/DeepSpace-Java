/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import deepspace.DamageToUI;
import deepspace.EnemyToUI;
import deepspace.LootToUI;
import java.awt.Component;
import java.util.ArrayList;

/**
 *
 * @author JuanAntonio
 */
public class EnemyStarShipView extends javax.swing.JPanel {
    private LootView loot;
    private DamageView damage;
    /**
     * Creates new form EnemyStarShipView
     */
    public EnemyStarShipView() {
        initComponents();
        loot=new LootView();
        damage=new DamageView();
        
        Botin.add(loot);
        Damage.add(damage);
        repaint();
    }
    
    void setEnemyStarShip(EnemyToUI enemy){
        LootView Loot=new LootView();
        DamageView D=new DamageView();
        
        NombreEnemigo.setText(enemy.getName());
        fire.setText(Float.toString(enemy.getAmmoPower()));
        shield.setText(Float.toString(enemy.getShieldPower()));
        LootToUI loot2=enemy.getLoot();
        Loot.setLoot(loot2);
        DamageToUI damage1=enemy.getDamage();
        D.setDamage(damage1);
        
        Botin.removeAll();
        Botin.add(Loot);
        Damage.removeAll();
        Damage.add(D);
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NombreEnemigo = new javax.swing.JLabel();
        fire = new javax.swing.JLabel();
        shield = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Botin = new javax.swing.JPanel();
        Damage = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(424, 136));

        NombreEnemigo.setFont(new java.awt.Font("AR DESTINE", 0, 15)); // NOI18N
        NombreEnemigo.setText("NombreEnemigo");

        fire.setFont(new java.awt.Font("AR DESTINE", 0, 15)); // NOI18N
        fire.setText("fire");

        shield.setFont(new java.awt.Font("AR DESTINE", 0, 15)); // NOI18N
        shield.setText("shield");

        jLabel1.setFont(new java.awt.Font("AR DESTINE", 0, 24)); // NOI18N
        jLabel1.setText("Enemigo");

        jLabel2.setFont(new java.awt.Font("AR DESTINE", 0, 15)); // NOI18N
        jLabel2.setText("Enemigo:");

        jLabel3.setFont(new java.awt.Font("AR DESTINE", 0, 15)); // NOI18N
        jLabel3.setText("Potencia de Fuego:");

        jLabel4.setFont(new java.awt.Font("AR DESTINE", 0, 15)); // NOI18N
        jLabel4.setText("Potencia de Escudo:");

        Botin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botín", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AR DESTINE", 0, 12))); // NOI18N
        Botin.setPreferredSize(new java.awt.Dimension(424, 126));

        Damage.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Daños", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AR DESTINE", 0, 12))); // NOI18N
        Damage.setPreferredSize(new java.awt.Dimension(426, 109));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(216, 300, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fire)
                                    .addComponent(NombreEnemigo)
                                    .addComponent(shield)))
                            .addComponent(Botin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Damage, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NombreEnemigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fire))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(shield))
                .addGap(18, 18, 18)
                .addComponent(Botin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Damage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Botin;
    private javax.swing.JPanel Damage;
    private javax.swing.JLabel NombreEnemigo;
    private javax.swing.JLabel fire;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel shield;
    // End of variables declaration//GEN-END:variables
}
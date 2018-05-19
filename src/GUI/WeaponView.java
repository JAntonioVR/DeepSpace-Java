/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import deepspace.WeaponToUI;

/**
 *
 * @author JuanAntonio
 */
public class WeaponView extends javax.swing.JPanel {
    
    private boolean selected=false;
    /**
     * Creates new form WeaponView
     */
    public WeaponView() {
        setOpaque(selected);
        initComponents();
    }
    
    boolean isSelected(){
        return selected;
    }

    void setWeapon(WeaponToUI w){
        Uses.setText(Integer.toString(w.getUses()));
        Power.setText(Float.toString(w.getPower()));
        if(w.getType()==deepspace.WeaponType.LASER)
            Type.setText("LASER");
        if(w.getType()==deepspace.WeaponType.MISSILE)
            Type.setText("MISSILE");
        if(w.getType()==deepspace.WeaponType.PLASMA)
            Type.setText("PLASMA");
        repaint();      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        TypeText = new javax.swing.JLabel();
        UsesText = new javax.swing.JLabel();
        Type = new javax.swing.JLabel();
        Uses = new javax.swing.JLabel();
        PowerText = new javax.swing.JLabel();
        Power = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        name.setFont(new java.awt.Font("AR DESTINE", 0, 14)); // NOI18N
        name.setText("ARMA");

        TypeText.setFont(new java.awt.Font("AR DESTINE", 0, 11)); // NOI18N
        TypeText.setText("Tipo:");

        UsesText.setFont(new java.awt.Font("AR DESTINE", 0, 11)); // NOI18N
        UsesText.setText("Usos:");

        Type.setFont(new java.awt.Font("AR DESTINE", 0, 11)); // NOI18N
        Type.setText("jLabel4");

        Uses.setFont(new java.awt.Font("AR DESTINE", 0, 11)); // NOI18N
        Uses.setText("jLabel5");

        PowerText.setFont(new java.awt.Font("AR DESTINE", 0, 11)); // NOI18N
        PowerText.setText("Potencia:");

        Power.setFont(new java.awt.Font("AR DESTINE", 0, 11)); // NOI18N
        Power.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TypeText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Type))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PowerText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Power))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UsesText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Uses)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeText)
                    .addComponent(Type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsesText)
                    .addComponent(Uses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PowerText)
                    .addComponent(Power))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selected = !selected;
        setOpaque (selected);
        repaint();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Power;
    private javax.swing.JLabel PowerText;
    private javax.swing.JLabel Type;
    private javax.swing.JLabel TypeText;
    private javax.swing.JLabel Uses;
    private javax.swing.JLabel UsesText;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}

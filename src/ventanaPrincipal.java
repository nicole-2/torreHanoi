/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ventanaPrincipal extends javax.swing.JFrame {

    int contNumMov = 0;
    
    Pila pilaTorreA;
    Pila pilaTorreB;
    Pila pilaTorreC;
    
    DefaultTableModel modeloTablaTorreA, modeloTablaTorreB, modeloTablaTorreC;
    
    int objetivo = 0;
    
    double numMinMov = 0;
    
    boolean stop = false;
    
    public ventanaPrincipal() {
        initComponents();
        
        modeloTablaTorreA = (DefaultTableModel) torreA.getModel();
        modeloTablaTorreA.setRowCount(10);
        
        modeloTablaTorreB = (DefaultTableModel) torreB.getModel();
        modeloTablaTorreB.setRowCount(10);
        
        modeloTablaTorreC = (DefaultTableModel) torreC.getModel();
        modeloTablaTorreC.setRowCount(10);
        
        DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        torreA.getColumnModel().getColumn(0).setCellRenderer(renderA);
        
        DefaultTableCellRenderer renderB = new DefaultTableCellRenderer();
        renderB.setHorizontalAlignment(SwingConstants.CENTER);
        torreB.getColumnModel().getColumn(0).setCellRenderer(renderB);
        
        DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(SwingConstants.CENTER);
        torreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
        
    }

    private void Limpiar(){
        contNumMov = 0;
        numMinMov = 0;
        
        cbNumDiscos.setSelectedItem(String.valueOf(objetivo));
    }
     
    private void PresentarCantMov(){
        contNumMov ++;
        lblNumMov.setText(String.valueOf(contNumMov));
    }
    
    private void Reiniciar(){
        try {
            if(!lblMinMov.getText().equals("")){
                Limpiar();
                Iniciar();
            }
        } catch (Exception e) {
        }
    }
    
    
    private void Iniciar(){
        try {
            pilaTorreA = new Pila();
            pilaTorreB = new Pila();
            pilaTorreC = new Pila();
        
            objetivo = Integer.parseInt(cbNumDiscos.getSelectedItem().toString());
        
            numMinMov = Math.pow(2, objetivo) -1;
        
            lblNumMov.setText(String.valueOf(contNumMov));
            lblMinMov.setText(String.valueOf(String.format("%.0f", numMinMov)));
        
            for(int x = objetivo; x>= 1; x--){
                Nodo plataforma = new Nodo();
                String disco = "";
                    for(int y = x; y>0 ; y--){
                        disco+= "*";
                }
                plataforma.setDato(disco);
                pilaTorreA.Push(plataforma);     
            }
            
            PresentarTorreA();
            PresentarTorreB();
            PresentarTorreC();
            
        } catch (Exception e) {
        }
        
       
    }
    
   private void PresentarTorreA(){
       ((DefaultTableModel)torreA.getModel()).setRowCount(0);
       
       modeloTablaTorreA.setRowCount(10);
       
       Nodo k;
       
       int rowDisco = (10 - pilaTorreA.getContNodo());
       
       if(pilaTorreA.getContNodo() >0){
           for(k=pilaTorreA.getCabeza(); k.getAbajo()!= null; k = k.getAbajo()){
               String[] vectorNormal = {k.getDato()};
               modeloTablaTorreA.insertRow(rowDisco, vectorNormal);
               rowDisco++;
           }
           
           if(k.getAbajo() == null){
               String[] vectorNormal = {k.getDato()};
               modeloTablaTorreA.insertRow(rowDisco, vectorNormal);
           }
       }
       
       torreA.setModel(modeloTablaTorreA);
       modeloTablaTorreA.setRowCount(10);
   }
   
      private void PresentarTorreB(){
       ((DefaultTableModel)torreB.getModel()).setRowCount(0);
       
       modeloTablaTorreB.setRowCount(10);
       
       Nodo k;
       
       int rowDisco = (10 - pilaTorreB.getContNodo());
       
       if(pilaTorreB.getContNodo() >0){
           for(k=pilaTorreB.getCabeza(); k.getAbajo()!= null; k = k.getAbajo()){
               String[] vectorNormal = {k.getDato()};
               modeloTablaTorreB.insertRow(rowDisco, vectorNormal);
               rowDisco++;
           }
           
           if(k.getAbajo() == null){
               String[] vectorNormal = {k.getDato()};
               modeloTablaTorreB.insertRow(rowDisco, vectorNormal);
           }
       }
       
       torreB.setModel(modeloTablaTorreB);
       modeloTablaTorreB.setRowCount(10);
   }
    
      private void PresentarTorreC(){
       ((DefaultTableModel)torreC.getModel()).setRowCount(0);
       
       modeloTablaTorreC.setRowCount(10);
       
       Nodo k;
       
       int rowDisco = (10 - pilaTorreC.getContNodo());
       
       if(pilaTorreC.getContNodo() >0){
           for(k=pilaTorreC.getCabeza(); k.getAbajo()!= null; k = k.getAbajo()){
               String[] vectorNormal = {k.getDato()};
               modeloTablaTorreC.insertRow(rowDisco, vectorNormal);
               rowDisco++;
           }
           
           if(k.getAbajo() == null){
               String[] vectorNormal = {k.getDato()};
               modeloTablaTorreC.insertRow(rowDisco, vectorNormal);
           }
       }
       
       torreC.setModel(modeloTablaTorreC);
       modeloTablaTorreC.setRowCount(10);
   }
      
      
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        torreC = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        torreB = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        torreA = new javax.swing.JTable();
        btnA_B = new javax.swing.JButton();
        btnA_C = new javax.swing.JButton();
        btnB_A = new javax.swing.JButton();
        btnB_C = new javax.swing.JButton();
        btnC_A = new javax.swing.JButton();
        btnC_B = new javax.swing.JButton();
        cbNumDiscos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lblMinMov = new javax.swing.JLabel();
        lblNumMov = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();
        btnResolver = new javax.swing.JButton();

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setFocusable(false);

        torreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Torre C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(torreC);
        if (torreC.getColumnModel().getColumnCount() > 0) {
            torreC.getColumnModel().getColumn(0).setResizable(false);
        }

        jScrollPane2.setFocusable(false);

        torreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Torre B"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(torreB);
        if (torreB.getColumnModel().getColumnCount() > 0) {
            torreB.getColumnModel().getColumn(0).setResizable(false);
        }

        jScrollPane3.setFocusable(false);

        torreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Torre A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(torreA);
        if (torreA.getColumnModel().getColumnCount() > 0) {
            torreA.getColumnModel().getColumn(0).setResizable(false);
        }

        btnA_B.setText("B");
        btnA_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA_BActionPerformed(evt);
            }
        });

        btnA_C.setText("C");
        btnA_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnA_CActionPerformed(evt);
            }
        });

        btnB_A.setText("A");
        btnB_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB_AActionPerformed(evt);
            }
        });

        btnB_C.setText("C");
        btnB_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB_CActionPerformed(evt);
            }
        });

        btnC_A.setText("A");
        btnC_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_AActionPerformed(evt);
            }
        });

        btnC_B.setText("B");
        btnC_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_BActionPerformed(evt);
            }
        });

        cbNumDiscos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbNumDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNumDiscosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMinMov.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMinMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNumMov.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNumMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Número de discos:");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Número min de movimientos:");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Número de movimientos:");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        btnResolver.setText("Resolver");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnA_B)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnA_C)))
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbNumDiscos, 0, 121, Short.MAX_VALUE)
                                    .addComponent(lblMinMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnB_A)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnB_C))
                                    .addComponent(lblNumMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIniciar)
                                .addGap(27, 27, 27)
                                .addComponent(btnReiniciar)
                                .addGap(18, 18, 18)
                                .addComponent(btnResolver)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnC_A)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnC_B)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnA_B)
                    .addComponent(btnA_C)
                    .addComponent(btnB_A)
                    .addComponent(btnB_C)
                    .addComponent(btnC_A)
                    .addComponent(btnC_B))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbNumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lblMinMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(lblNumMov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnReiniciar)
                    .addComponent(btnResolver))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void MoverA_B(){
        try {
            if(pilaTorreA.getContNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreA.Peek());
                if(pilaTorreB.getContNodo() > 0){
                    if(plataforma.getDato().compareTo(pilaTorreB.Peek()) > 0){
                        return;
                    }
                }
                pilaTorreA.Pop();
                pilaTorreB.Push(plataforma);
                
                PresentarTorreA();
                PresentarTorreB();
                PresentarCantMov();
            }
        } catch (Exception e) {
        }
    }
    
    
    private void btnA_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA_BActionPerformed
        MoverA_B();
    }//GEN-LAST:event_btnA_BActionPerformed

    private void MoverB_A(){
        try {
            if(pilaTorreB.getContNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreB.Peek());
                if(pilaTorreA.getContNodo() > 0){
                    if(plataforma.getDato().compareTo(pilaTorreA.Peek()) > 0){
                        return;
                    }
                }
                pilaTorreB.Pop();
                pilaTorreA.Push(plataforma);
                
                PresentarTorreB();
                PresentarTorreA();
                PresentarCantMov();
            }
        } catch (Exception e) {
        }  
    }
    
    private void btnB_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB_AActionPerformed
        MoverB_A();
    }//GEN-LAST:event_btnB_AActionPerformed

    private void MoverC_A(){
         try {
            if(pilaTorreC.getContNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreC.Peek());
                if(pilaTorreA.getContNodo() > 0){
                    if(plataforma.getDato().compareTo(pilaTorreA.Peek()) > 0){
                        return;
                    }
                }
                pilaTorreC.Pop();
                pilaTorreA.Push(plataforma);
                
                PresentarTorreC();
                PresentarTorreA();
                PresentarCantMov();
            }
        } catch (Exception e) {
        }         
    }
    
    private void btnC_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_AActionPerformed
        MoverC_A();
    }//GEN-LAST:event_btnC_AActionPerformed

    private void cbNumDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNumDiscosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNumDiscosActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        contNumMov = 0;
        Iniciar();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        Reiniciar();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void MoverA_C(){
        try {
            if(pilaTorreA.getContNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreA.Peek());
                if(pilaTorreC.getContNodo() > 0){
                    if(plataforma.getDato().compareTo(pilaTorreC.Peek()) > 0){
                        return;
                    }
                }
                pilaTorreA.Pop();
                pilaTorreC.Push(plataforma);
                
                PresentarTorreA();
                PresentarTorreC();
                PresentarCantMov();
                
                if(pilaTorreC.getContNodo() == objetivo && contNumMov == numMinMov){
                    JOptionPane.showMessageDialog(null, "¡Ganaste con el objetivo mínimo de movimientos!", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
                }else{
                    if(pilaTorreC.getContNodo() == objetivo && contNumMov != numMinMov){
                        JOptionPane.showMessageDialog(null, "¡Ganaste!", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
        }     
    }
    
    
    private void btnA_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnA_CActionPerformed
        MoverA_C();
    }//GEN-LAST:event_btnA_CActionPerformed

    private void MoverB_C(){
        try {
            if(pilaTorreB.getContNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreB.Peek());
                if(pilaTorreC.getContNodo() > 0){
                    if(plataforma.getDato().compareTo(pilaTorreC.Peek()) > 0){
                        return;
                    }
                }
                pilaTorreB.Pop();
                pilaTorreC.Push(plataforma);
                
                PresentarTorreB();
                PresentarTorreC();
                PresentarCantMov();
                
                if(pilaTorreC.getContNodo() == objetivo && contNumMov == numMinMov){
                    JOptionPane.showMessageDialog(null, "¡Ganaste con el objetivo mínimo de movimientos!", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
                }else{
                    if(pilaTorreC.getContNodo() == objetivo && contNumMov != numMinMov){
                        JOptionPane.showMessageDialog(null, "¡Ganaste!", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
        }  
    }
    
    
    private void btnB_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB_CActionPerformed
        MoverB_C();
    }//GEN-LAST:event_btnB_CActionPerformed
    private void MoverC_B(){
                 try {
            if(pilaTorreC.getContNodo() > 0){
                Nodo plataforma = new Nodo();
                plataforma.setDato(pilaTorreC.Peek());
                if(pilaTorreB.getContNodo() > 0){
                    if(plataforma.getDato().compareTo(pilaTorreB.Peek()) > 0){
                        return;
                    }
                }
                pilaTorreC.Pop();
                pilaTorreB.Push(plataforma);
                
                PresentarTorreC();
                PresentarTorreB();
                PresentarCantMov();
            }
        } catch (Exception e) {
        }      
    }
    private void btnC_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_BActionPerformed
        MoverC_B();
    }//GEN-LAST:event_btnC_BActionPerformed

    
    boolean stop1 = false;
    
    private void MoverPlataforma(Pila origen, Pila destino){
        if(stop1 == false){
            Nodo plataforma = new Nodo();
            plataforma.setDato(origen.Peek());
            origen.Pop();
            
            destino.Push(plataforma);
            
            PresentarTorreA();
            PresentarTorreB();
            PresentarTorreC();
            PresentarCantMov();
            
            JOptionPane pane = new JOptionPane("Paso *" + lblNumMov.getText() + "¿Continuar?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
            JDialog dialog = pane.createDialog("Número de pasos");
            dialog.setLocation(600,400);
            dialog.setVisible(true);
            int opt = (int) pane.getValue();
            if(opt == JOptionPane.NO_OPTION){
                stop1 = true;
            }
        }
    }
    
    private void ResolverHanoi(int n, Pila origen, Pila auxiliar, Pila destino){
        if(n == 1){
            MoverPlataforma(origen, destino);
            
        }else{
            ResolverHanoi( n -1, origen, destino, auxiliar);
            MoverPlataforma(origen, destino);
            ResolverHanoi( n -1, auxiliar, origen, destino);
        
        }
    }
    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        if(!lblMinMov.getText().equals("") && pilaTorreC.getContNodo() != objetivo){
            Reiniciar();
            stop1 = false;
            ResolverHanoi(objetivo, pilaTorreA, pilaTorreB, pilaTorreC);
        }
    }//GEN-LAST:event_btnResolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA_B;
    private javax.swing.JButton btnA_C;
    private javax.swing.JButton btnB_A;
    private javax.swing.JButton btnB_C;
    private javax.swing.JButton btnC_A;
    private javax.swing.JButton btnC_B;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JComboBox cbNumDiscos;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMinMov;
    private javax.swing.JLabel lblNumMov;
    private javax.swing.JTable torreA;
    private javax.swing.JTable torreB;
    private javax.swing.JTable torreC;
    // End of variables declaration//GEN-END:variables
}

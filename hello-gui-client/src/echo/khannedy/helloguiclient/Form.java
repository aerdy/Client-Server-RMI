/*
 *  Copyright 2009 Eko Kurniawan Khannedy
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

/*
 * Form.java
 *
 * Created on Oct 14, 2009, 5:38:17 PM
 */
package echo.khannedy.helloguiclient;

import echo.khannedy.helloguiapi.Hello;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class Form extends javax.swing.JFrame implements ActionListener {

    private Hello hello;
    

    /** Creates new form Form */
    public Form(Hello hello) {

        this.hello = hello;

        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        buttonSayHello = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textResponse = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama :");

        buttonSayHello.setText("Say Hello");
        buttonSayHello.addActionListener(this);

        jLabel2.setText("Respon Server :");

        textResponse.setEditable(false);
        textResponse.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textResponse)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSayHello))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSayHello))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textResponse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == buttonSayHello) {
            Form.this.buttonSayHelloActionPerformed(evt);
        }
        else if (evt.getSource() == textResponse) {
            Form.this.textResponseActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSayHelloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSayHelloActionPerformed
        // TODO add your handling code here:
        try {
            String response = hello.sayHello(textNama.getText());
            textResponse.setText(response);
        } catch (RemoteException exception) {
            exception.printStackTrace();
        }
    }//GEN-LAST:event_buttonSayHelloActionPerformed

    private void textResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textResponseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textResponseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSayHello;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textResponse;
    // End of variables declaration//GEN-END:variables
}

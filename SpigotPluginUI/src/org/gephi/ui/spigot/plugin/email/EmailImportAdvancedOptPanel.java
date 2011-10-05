/*
Copyright 2008-2010 Gephi
Authors : Yi Du <duyi001@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */

/*
 * EmailImportAdvancedOptPanel.java
 *
 * Created on Jun 18, 2010, 11:51:38 PM
 */

package org.gephi.ui.spigot.plugin.email;

/**
 *
 * @author Yi Du
 */
public class EmailImportAdvancedOptPanel extends javax.swing.JPanel {
    private String currentServerType;
    private EmailVisualPanel1 parentPanel;
    
    /** Creates new form EmailImportAdvancedOptPanel */
    public EmailImportAdvancedOptPanel() {
        initComponents();
    }

    EmailImportAdvancedOptPanel(String toString, EmailVisualPanel1 panel) {
        this.currentServerType = toString;
        this.parentPanel = panel;
        initComponents();
        jTextFieldPort.setText(Integer.toString(parentPanel.getPort()));
        jCheckBoxUseSSL.setSelected(parentPanel.useSSL());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPort = new javax.swing.JLabel();
        jTextFieldPort = new javax.swing.JTextField();
        jCheckBoxUseSSL = new javax.swing.JCheckBox();

        jLabelPort.setText(org.openide.util.NbBundle.getMessage(EmailImportAdvancedOptPanel.class, "EmailImportAdvancedOptPanel.jLabelPort.text")); // NOI18N

        jTextFieldPort.setText(org.openide.util.NbBundle.getMessage(EmailImportAdvancedOptPanel.class, "EmailImportAdvancedOptPanel.jTextFieldPort.text")); // NOI18N

        jCheckBoxUseSSL.setText(org.openide.util.NbBundle.getMessage(EmailImportAdvancedOptPanel.class, "EmailImportAdvancedOptPanel.jCheckBoxUseSSL.text")); // NOI18N
        jCheckBoxUseSSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxUseSSLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxUseSSL)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPort)
                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxUseSSL)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxUseSSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxUseSSLActionPerformed
        if(jCheckBoxUseSSL.isSelected() && parentPanel.getServerType().equals("POP3"))
            jTextFieldPort.setText("995");
        if(!jCheckBoxUseSSL.isSelected() && parentPanel.getServerType().equals("POP3"))
            jTextFieldPort.setText("110");
        if(jCheckBoxUseSSL.isSelected() && parentPanel.getServerType().equals("IMAP"))
            jTextFieldPort.setText("993");
        if(!jCheckBoxUseSSL.isSelected() && parentPanel.getServerType().equals("IMAP"))
            jTextFieldPort.setText("143");

        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxUseSSLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxUseSSL;
    private javax.swing.JLabel jLabelPort;
    private javax.swing.JTextField jTextFieldPort;
    // End of variables declaration//GEN-END:variables

    void save() {
        parentPanel.setPort(Integer.parseInt(jTextFieldPort.getText().trim()));
        parentPanel.setUseSSL(jCheckBoxUseSSL.isSelected());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginregistration;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class LoginForm extends java.awt.Frame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        setSize(400,300);     
        label3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        textField1 = new java.awt.TextField();
        label2 = new java.awt.Label();
        textField2 = new java.awt.TextField();
        button1 = new java.awt.Button();
        label3 = new java.awt.Label();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(null);

        label1.setText("UserId");
        add(label1);
        label1.setBounds(100, 60, 41, 20);
        add(textField1);
        textField1.setBounds(190, 60, 150, 20);

        label2.setText("Password");
        add(label2);
        label2.setBounds(100, 110, 60, 20);
        add(textField2);
        textField2.setBounds(190, 110, 150, 20);

        button1.setLabel("Login");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1);
        button1.setBounds(190, 160, 47, 24);

        label3.setText("label3");
        add(label3);
        label3.setBounds(80, 220, 270, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try {
            Connection con = DBConnectionUtil.connectOracle();
            String userId = textField1.getText();
            String password = textField2.getText();
            String sql = "SELECT user_id,uname,city from users where user_id=? and pwd = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                label3.setVisible(true);
                label3.setText("LOGGED IN");
                label3.setForeground(Color.GREEN);
            } else {
                label3.setVisible(true);
                label3.setText("Can't Login wrong userid or password");
                label3.setForeground(Color.red);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    // End of variables declaration//GEN-END:variables
}

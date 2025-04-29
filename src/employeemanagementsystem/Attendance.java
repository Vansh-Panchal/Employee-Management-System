/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employeemanagementsystem;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author 91870
 */
public class Attendance extends javax.swing.JFrame {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    String empId;
    public Attendance(String em)
    {
        empId = em;
        initComponents();
        this.setLocationRelativeTo(null);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesystem","root","vansh");
            stmt = conn.createStatement();
            cbFirst.addItem("Present");
            cbFirst.addItem("Absent");
            cbSecond.addItem("Present");
            cbSecond.addItem("Absent");
            System.out.println("Employee ID is = "+empId);
            txtEmpId.setText(empId);
            String id = empId;
            rs = stmt.executeQuery("select Name, Email from personalinfo where EmpId = '"+id+"'");
            while(rs.next())
            {
                System.out.println("Employee id = '"+id+"'");
                System.out.println("Employee id = '"+id+"'");
                txtName.setText(rs.getString(1));
                txtEmail.setText(rs.getString(2));
               
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.print(e);
        }
    }
    
    public Attendance() {
        
//        initComponents();
//        try
//        {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesystem","root","vansh");
//            stmt = conn.createStatement();
//            cbFirst.addItem("Present");
//            cbFirst.addItem("Absent");
//            cbSecond.addItem("Present");
//            cbSecond.addItem("Absent");
//            
//            rs =stmt.executeQuery("select EmpId,Name,Email from personalinfo where EmpId = '"+empId+"'");
//            while(rs.next())
//            {
//                txtEmpId.setText(rs.getString(1));
//                txtName.setText(rs.getString(2));
//                txtEmail.setText(rs.getString(3));
//            }
//        }
//        catch(ClassNotFoundException | SQLException e)
//        {
//            System.out.print(e);
//        }
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmpId = new javax.swing.JTextField();
        cbSecond = new javax.swing.JComboBox<>();
        cbFirst = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FILL YOUR ATTENDANCE");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 570, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Second Half");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 100, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 100, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Emp Id ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("First Half");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 100, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 100, 30));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 230, 30));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 230, 30));
        jPanel1.add(txtEmpId, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 230, 30));

        cbSecond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSecondActionPerformed(evt);
            }
        });
        jPanel1.add(cbSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 230, 30));

        cbFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFirstActionPerformed(evt);
            }
        });
        jPanel1.add(cbFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 230, 30));

        btnExit.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 110, 40));

        btnSubmit.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSecondActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSecondActionPerformed

    private void cbFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFirstActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String id,name,email,first,second,date;
        id = txtEmpId.getText();
        name = txtName.getText();
        email = txtEmail.getText();
        first = cbFirst.getSelectedItem().toString();
        second = cbSecond.getSelectedItem().toString();
        Date d = new Date();
        d.toString();
        try 
        {
            stmt.executeUpdate("insert into attendance values('"+id+"','"+name+"','"+email+"','"+first+"','"+second+"','"+d+"')");
            JOptionPane.showMessageDialog(null, "Your Attendance is Submit", "Message Box", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (SQLException ex)
        {
            System.out.print(ex);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
       
        setVisible(false);
        new User_HomePage(empId).setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Attendance().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbFirst;
    private javax.swing.JComboBox<String> cbSecond;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

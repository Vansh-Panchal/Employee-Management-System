/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employeemanagementsystem;


import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.net.Authenticator;
//import java.net.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author 91870
 */
public class AddDetails extends javax.swing.JFrame {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Message message;
    /**
     * Creates new form AddDetails
     */
    Random ran = new Random();
    int num = ran.nextInt(999999);
    
    public AddDetails() {
        initComponents();
        this.setLocationRelativeTo(null);
        
         

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//         pack();
//        jPanel1.setSize(screenSize.width,screenSize.height);
//        Dimension screenDimension=Toolkit.getDefaultToolkit().getScreenSize();
//        int x= (int) ( (screenDimension.getWidth()-this.getWidth())/2 ); 
//        int y= (int) ( (screenDimension.getHeight()-this.getHeight())/2 );
//        jPanel1.setSize((int)screenDimension.getWidth(),(int)screenDimension.getHeight());
//        setLocation(x,y);
        
        cbEducation.addItem("Diploma");
        cbEducation.addItem("BCA");
        cbEducation.addItem("BA");
        cbEducation.addItem("BSC");
        cbEducation.addItem("BCom");
        cbEducation.addItem("BTech");
        cbEducation.addItem("BBA");
        cbEducation.addItem("MCA");
        cbEducation.addItem("MA");
        cbEducation.addItem("MSC");
        cbEducation.addItem("MComm");
        cbEducation.addItem("MTech");
        cbEducation.addItem("MBA");
        
        cbDepartment.addItem("HR Department");
        cbDepartment.addItem("Accounting and Finanace Department");
        cbDepartment.addItem("Developing Department");
        cbDepartment.addItem("Adminstration  Department");
        cbDepartment.addItem("Security Department");
        cbDepartment.addItem("Sales Department");
        cbDepartment.addItem("Programming Department");
       
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesystem","root","vansh");
            stmt = conn.createStatement();
            String empid;
            empid = ""+num;
            lblId.setText(empid);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.print(e);
        }
    }
    
    void sendEmail()
    {
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session= Session.getDefaultInstance(props, new Authenticator()
        {
            
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("vanshhrems@gmail.com","wotr ueyu zbiy qfsj");
            }
        });
        try 
        {
            String email=txtEmail.getText();
            // Create a default MimeMessage object.
            message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress("vanshhrems@gmail.com"));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(email));

            message.setRecipients(Message.RecipientType.CC,
               InternetAddress.parse(email));
            
            message.setRecipients(Message.RecipientType.BCC,
               InternetAddress.parse(email));
            
            // Set Subject: header field
            message.setSubject("Testing Subject");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText("Greetings of the day, "
                    + "Welcome to our Employee Management System. Now you are a part of this System. Have nice day");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
//            messageBodyPart = new MimeBodyPart();
//            String filename = "c:/amit/amit.txt";
//            String filenameAttachment=filename.substring(filename.lastIndexOf('/')+1);
//            DataSource source = (DataSource) new FileDataSource(filename);
//            messageBodyPart.setDataHandler(new DataHandler((javax.activation.DataSource) source));
//            messageBodyPart.setFileName(filenameAttachment);
//            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            

        }
        catch(MessagingException ex)
        {
            System.out.print("Exception is = "+ex);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDesg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        cbEducation = new javax.swing.JComboBox<>();
        txtAdhar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbDepartment = new javax.swing.JComboBox<>();
        cbJob = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NEW EMPLOYEE DETAILS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Employee Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("D.O.B");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Email Id");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Designate");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtDesg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesgActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Father's Name");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Salary");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Phone");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("High Education");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Adhar Number");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Job Post");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Employee Id");

        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaryActionPerformed(evt);
            }
        });

        cbEducation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Education" }));

        txtAdhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdharActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Department");

        cbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Department" }));

        cbJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Job Post" }));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("GO TO HOME PAGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setText("ADD DETAILS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Verify");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(72, 72, 72)
                                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(72, 72, 72)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(83, 83, 83)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(70, 70, 70)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtDesg, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))))))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(txtfname, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(cbEducation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbJob, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdhar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 110, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButton1)
                .addGap(245, 245, 245))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(cbEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdhar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDesg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)))))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(cbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3)))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDesgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesgActionPerformed

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalaryActionPerformed

    private void txtAdharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdharActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String fname = txtfname.getText();
        String dob = txtDOB.getText();
        String salary = txtSalary.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String desg = txtDesg.getText();
        String address = txtAddress.getText();
        String adhar = txtAdhar.getText();
        String id = lblId.getText();
        String education = cbEducation.getSelectedItem().toString();
        String department = cbDepartment.getSelectedItem().toString();
        String job = cbJob.getSelectedItem().toString();
        boolean flag = false;
        try{
            if(name.matches("^[a-z A-Z]*$") && !name.isEmpty())
            {
            }
            else{
                JOptionPane.showMessageDialog(null, "Employee Name is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
            if(fname.matches("^[a-z A-Z]*$") && !fname.isEmpty())
            {  
            }
            else{
                JOptionPane.showMessageDialog(null, "Father Name is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            Date testDate = null;
            boolean valid = false;
            try {
                df.parse(dob);
                valid = true;
            } catch (java.text.ParseException ex) {
                
            } // valid will still be false
                if (!valid) {  
                    JOptionPane.showMessageDialog(null, "Invalid Date of Birth", "Message Box", JOptionPane.WARNING_MESSAGE);
                 }
//            if(dob.matches("^[0-9]*$") && !dob.isEmpty())
//            {  
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "Date of Birth is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
//            }
//            
            if(salary.matches("^[0-9]*$") && !salary.isEmpty())
            {  
            }
            else{
                JOptionPane.showMessageDialog(null, "Salary is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
            if(phone.matches("^[0-9]*$") && phone.length()==10)
            {  
            }
            else{
                JOptionPane.showMessageDialog(null, "Phone Number is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
            if(email.matches("^[\\p{L}0-9!#$%&'*+\\/=?^_`{|}~-][\\p{L}0-9.!#$%&'*+\\/=?^_`{|}~-]{0,63}@[\\p{L}0-9-]+(?:\\.[\\p{L}0-9-]{2,7})*$"))
            {
            }
            else{  
                JOptionPane.showMessageDialog(null, "Email is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
             if(education.equals("Education"))
            {  
                JOptionPane.showMessageDialog(null, "Education is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
            if(desg.matches("^[a-z A-Z]*$") && !desg.isEmpty())
            {  
            }
            else{
                JOptionPane.showMessageDialog(null, "Designation is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
            if(adhar.matches("^[0-9]*$") && !adhar.isEmpty() && !adhar.isEmpty())
            {  
            }
            else{
                JOptionPane.showMessageDialog(null, "Adhar Number is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
           
            if(department.equalsIgnoreCase("Department"))
            {  
                JOptionPane.showMessageDialog(null, "Department is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
            if(job.equalsIgnoreCase("Job Post"))
            {
                JOptionPane.showMessageDialog(null, "Job Post is Invalid", "Message Box", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(HeadlessException e)
        {
            System.out.println(e);
        }
        try{
            
            stmt.executeUpdate("insert into personalinfo values('"+id+"','"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+desg+"','"+adhar+"','"+job+"')");
            sendEmail();
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Details added successfully", "Message Box", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(HeadlessException e)
        {
            System.out.println(e);
        } catch (SQLException ex) {
            Logger.getLogger(AddDetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(AddDetails.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         String department = cbDepartment.getSelectedItem().toString();
//         cbJob.removeAll();
         cbJob.removeAllItems();
         if(!department.equalsIgnoreCase("Department"))
        {
        } else {
             cbJob.addItem("Job Post");
        }
        if(department.equalsIgnoreCase("HR Department"))
        {
            cbJob.addItem("Job Post");
            cbJob.addItem("Human Resources Manager");
            cbJob.addItem("Recruiter");
            cbJob.addItem("Human Resources Generalist");
            cbJob.addItem("Recruitment Manager");
            cbJob.addItem("HR Director");
            cbJob.addItem("Chief Human Resources Officer");
        }
        if(department.equalsIgnoreCase("Accounting and Finanace Department"))
        {
            cbJob.addItem("Job Post");
            cbJob.addItem("Accounting Clerk");
            cbJob.addItem("Accounting Information System Specialist");
            cbJob.addItem("Budget Analyst");
            cbJob.addItem("Finance Analyst");
            cbJob.addItem("Cost Accountant");
            cbJob.addItem("Payroll Accountant");
            cbJob.addItem("Tax Consultant");
        }
        if(department.equalsIgnoreCase("Developing Department"))
        {
            cbJob.addItem("Job Post");
            cbJob.addItem("Frontened Web Developer");
            cbJob.addItem("Backend Web Developer");
            cbJob.addItem("Full Stack Web Developer");
            cbJob.addItem("Java Developer");
            cbJob.addItem("Android Developer");
            cbJob.addItem("Software Developer");
            cbJob.addItem("Game Developer");
        }
        if(department.equalsIgnoreCase("Adminstration  Department"))
        {
            cbJob.addItem("Job Post");
            cbJob.addItem("Administrative specialist");
            cbJob.addItem("Administrative assistant");
            cbJob.addItem("Administrative associate");
            cbJob.addItem("Virtual assistant");
            cbJob.addItem("Office assistant");
        }
        if(department.equalsIgnoreCase("Security Department"))
        {
            cbJob.addItem("Job Post");
            cbJob.addItem("Security Engineer");
            cbJob.addItem("Security Analyst");
            cbJob.addItem("Security Specialist");
            cbJob.addItem("Security Architect");
            cbJob.addItem("Cybersecurity Manager");
            cbJob.addItem("Cybersecurity Engineer");
        }
        if(department.equalsIgnoreCase("Sales Department"))
        {
            cbJob.addItem("Job Post");
            cbJob.addItem("Collection agent");
            cbJob.addItem("Sales consultant");
            cbJob.addItem("Account executive");
            cbJob.addItem("Account manager");
            cbJob.addItem("Sales Manager");
            cbJob.addItem("Sales representative");
        }
        if(department.equalsIgnoreCase("Programming Department"))
        {
            cbJob.addItem("Job Post");
            cbJob.addItem("Data scientist");
            cbJob.addItem("Cloud engineer");
            cbJob.addItem("Programmer analyst");
            cbJob.addItem("Computer systems engineer");
            cbJob.addItem("Computer programmer");
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new HomePage().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddDetails().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbDepartment;
    private javax.swing.JComboBox<String> cbEducation;
    private javax.swing.JComboBox<String> cbJob;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAdhar;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtDesg;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtfname;
    // End of variables declaration//GEN-END:variables
}

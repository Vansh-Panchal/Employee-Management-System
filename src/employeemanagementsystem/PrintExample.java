/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.*;
/**
 *
 * @author 91870
 */
public class PrintExample extends JFrame implements ActionListener{
   public PrintExample() {
    super("Printing Swing Components");
    WindowUtilities.setNativeLookAndFeel();
    addWindowListener(new ExitListener());
    Container content = getContentPane();
    JButton printButton = new JButton("Print");
    printButton.addActionListener(this);
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(Color.white);
    buttonPanel.add(printButton);
    content.add(buttonPanel, BorderLayout.SOUTH);
    DrawingPanel drawingPanel = new DrawingPanel();
    content.add(drawingPanel, BorderLayout.CENTER);
    pack();
    setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    PrintUtilities.printComponent(this);
  } 
 
}

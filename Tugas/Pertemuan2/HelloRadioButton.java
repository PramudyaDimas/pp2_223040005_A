package Pertemuan2;

import java.awt.event.*;
import javax.swing.*;

public class HelloRadioButton extends JFrame {

    // Declare radio buttons outside the constructor to access them in the actionPerformed method
    JRadioButton radioButton1; 
    JRadioButton radioButton2;
    JRadioButton radioButton3;
    JTextField textField;
    JTextArea txtOutput;

    public HelloRadioButton() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(10, 40, 350, 30);

        textField = new JTextField();
        textField.setBounds(15, 70, 350, 30);

        JLabel labelRadio = new JLabel("Jenis Member:");
        labelRadio.setBounds(15, 100, 350, 30);

        radioButton1 = new JRadioButton("Silver");
        radioButton1.setBounds(15, 130, 350, 30);

        radioButton2 = new JRadioButton("Gold");
        radioButton2.setBounds(15, 160, 350, 30);

        radioButton3 = new JRadioButton("Platinum");
        radioButton3.setBounds(15, 190, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 220, 100, 40);

        txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 250, 350, 100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisMember = ""; // Initialize with an empty string

                if (radioButton1.isSelected()) {
                    jenisMember = radioButton1.getText();
                } else if (radioButton2.isSelected()) { 
                    jenisMember = radioButton2.getText();
                } else if (radioButton3.isSelected()) {
                    jenisMember = radioButton3.getText();
                }

                String nama = textField.getText();
                txtOutput.append("Hello " + nama + "\n");

                // Check if a radio button is selected before appending to txtOutput
                if (!jenisMember.isEmpty()) { 
                    txtOutput.append("Anda adalah member " + jenisMember + "\n");
                } else {
                    txtOutput.append("Pilih jenis member terlebih dahulu\n"); 
                }

                textField.setText(""); 
            }
        });

        // Add components to the frame
        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null); 
        this.setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new HelloRadioButton(); // Create an instance of the class
    }
}
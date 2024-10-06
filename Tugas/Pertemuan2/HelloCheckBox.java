package Pertemuan2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HelloCheckBox extends JFrame {

    private boolean CheckBoxSelected;

    public HelloCheckBox(){
        this.CheckBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel LabelInput = new JLabel("Input Nama:");
        LabelInput.setBounds(15,40,350,10);

        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);

        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(15,100,350,30);

        JButton button = new JButton("Simpan");
        button.setBounds(15,150,100,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,200,350,100);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                CheckBoxSelected = e.getStateChange()==1;
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (CheckBoxSelected) {
                    String nama = textField.getText();
                    txtOutput.append("Hello "+nama+"\n");
                    textField.setText("");
                } else {
                    txtOutput.append("Anda tidak mencentang kotak persetujuan\n");
                }
            }
        });

        this.add(button);
        this.add(textField);
        this.add(checkBox);
        this.add(LabelInput);
        this.add(txtOutput);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloCheckBox h = new HelloCheckBox();
                h.setVisible(true);
            }
        });
    }
    

    
}

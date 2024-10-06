package Pertemuan2;

import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import javax.swing.SpinnerDateModel;

public class NasabahBank extends JFrame {

    public NasabahBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nama input label and field
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 20, 350, 10);

        JTextField textNama = new JTextField();
        textNama.setBounds(15, 40, 350, 30);

        // Nomor HP input label and field
        JLabel labelHP = new JLabel("Nomor HP:");
        labelHP.setBounds(15, 80, 350, 10);

        JTextField textHP = new JTextField();
        textHP.setBounds(15, 100, 350, 30);

        // Jenis Kelamin label and radio buttons
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 140, 350, 10);

        JRadioButton rbMale = new JRadioButton("Laki-Laki", true);
        rbMale.setBounds(15, 160, 100, 30);

        JRadioButton rbFemale = new JRadioButton("Perempuan");
        rbFemale.setBounds(15, 190, 100, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        // Jenis Tabungan label and list with scroll pane
        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        labelTabungan.setBounds(15, 230, 350, 10);

        String[] tabunganTypes = {"Tabungan Reguler", "Tabungan Pendidikan", "Tabungan Bisnis", "Tabungan Haji", "Tabungan Investasi", "Tabungan Dollar", "Tabungan Premium"};
        JList<String> listTabungan = new JList<>(tabunganTypes);
        listTabungan.setVisibleRowCount(6);  // Make sure all types are visible
        JScrollPane scrollPaneTabungan = new JScrollPane(listTabungan);
        scrollPaneTabungan.setBounds(15, 250, 350, 120);  // Increase height to show all options

        // Frekuensi Transaksi per Bulan input with JSpinner
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelFrekuensi.setBounds(15, 380, 350, 10);

        JSpinner spinnerFrekuensi = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinnerFrekuensi.setBounds(15, 400, 350, 30);

        // Input Tanggal Lahir with JSpinner
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 440, 350, 10);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner spinnerTanggal = new JSpinner(dateModel);
        spinnerTanggal.setEditor(new JSpinner.DateEditor(spinnerTanggal, "dd/MM/yyyy"));
        spinnerTanggal.setBounds(15, 460, 350, 30);

        // Password and Confirm Password fields
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 500, 350, 10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(15, 520, 350, 30);

        JLabel labelConfirmPassword = new JLabel("Konfirmasi Password:");
        labelConfirmPassword.setBounds(15, 560, 350, 10);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 580, 350, 30);

        // Warga Negara Asing checkbox
        JCheckBox cbWNA = new JCheckBox("Warga Negara Asing");
        cbWNA.setBounds(15, 620, 200, 30);

        // Simpan button
        JButton button = new JButton("Simpan");
        button.setBounds(15, 660, 100, 40);

        // Output text area
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 720, 350, 100);

        // Button action listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gender = rbMale.isSelected() ? "Laki-Laki" : "Perempuan";
                String nama = textNama.getText();
                String hp = textHP.getText();
                String jenisTabungan = listTabungan.getSelectedValue();
                int frekuensi = (int) spinnerFrekuensi.getValue();
                Date tanggalLahir = (Date) spinnerTanggal.getValue();
                String isWNA = cbWNA.isSelected() ? "Ya" : "Tidak";
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();

                // Check password matching
                boolean passwordMatch = String.valueOf(password).equals(String.valueOf(confirmPassword));

                txtOutput.setText(""); // clear previous output
                txtOutput.append("Nama: " + nama + "\n");
                txtOutput.append("Nomor HP: " + hp + "\n");
                txtOutput.append("Jenis Kelamin: " + gender + "\n");
                txtOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
                txtOutput.append("Frekuensi Transaksi: " + frekuensi + " kali/bulan\n");
                txtOutput.append("Tanggal Lahir: " + tanggalLahir + "\n");
                txtOutput.append("Warga Negara Asing: " + isWNA + "\n");
                txtOutput.append("Password cocok: " + (passwordMatch ? "Ya" : "Tidak") + "\n");

                // Clear inputs after displaying the output
                textNama.setText("");
                textHP.setText("");
                genderGroup.clearSelection();
                rbMale.setSelected(true); // default selection after clearing
                cbWNA.setSelected(false);
                listTabungan.clearSelection();
                spinnerFrekuensi.setValue(1);
                spinnerTanggal.setValue(new Date());
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });

        // Adding Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem resetMenu = new JMenuItem("Reset");
        JMenuItem exitMenu = new JMenuItem("Exit");

        resetMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all inputs and output
                textNama.setText("");
                textHP.setText("");
                genderGroup.clearSelection();
                rbMale.setSelected(true); // default selection
                cbWNA.setSelected(false);
                listTabungan.clearSelection();
                spinnerFrekuensi.setValue(1);
                spinnerTanggal.setValue(new Date());
                passwordField.setText("");
                confirmPasswordField.setText("");
                txtOutput.setText("");
            }
        });

        exitMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(resetMenu);
        menu.add(exitMenu);
        menuBar.add(menu);

        // Setting menu bar
        this.setJMenuBar(menuBar);

        // Adding components to frame
        this.add(labelNama);
        this.add(textNama);
        this.add(labelHP);
        this.add(textHP);
        this.add(labelGender);
        this.add(rbMale);
        this.add(rbFemale);
        this.add(labelTabungan);
        this.add(scrollPaneTabungan); // Adding scroll pane containing the list
        this.add(labelFrekuensi);
        this.add(spinnerFrekuensi);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggal);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(cbWNA);
        this.add(button);
        this.add(txtOutput);

        this.setSize(400, 900);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NasabahBank bankForm = new NasabahBank();
                bankForm.setVisible(true);
            }
        });
    }
}

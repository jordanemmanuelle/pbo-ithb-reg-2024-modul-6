package View;

import javax.swing.*;
import Controller.DBController;
import java.awt.*;

public class FormPencarianData {
    
    public FormPencarianData() {
        showSearchForm();
    }

    public void showSearchForm() {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

        int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
        int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

        final int FRAME_WIDTH = 500; // SET WIDTH
        final int FRAME_HEIGHT = 200; // SET HEIGHT

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y
        
        JFrame frame = new JFrame("Cetak KTP");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel with a more stylish layout
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(238, 238, 238)); // Set background color to light gray
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        // Use a more modern font style
        JLabel keyLabel = new JLabel("Masukkan NIK : ");
        keyLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        keyLabel.setBounds(20, 30, 150, 25);
        panel.add(keyLabel);

        JTextField keyField = new JTextField();
        keyField.setBounds(170, 30, 250, 30);
        keyField.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(keyField);

        // Customize the search button for a more modern feel
        JButton searchButton = new JButton("SEARCH");
        searchButton.setBounds(170, 80, 150, 40);
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setBackground(new Color(0, 123, 255)); // Set background color
        searchButton.setForeground(Color.WHITE); // White text color
        searchButton.setFocusPainted(false); // Remove border focus
        panel.add(searchButton);

        searchButton.addActionListener(e -> {

            if (!keyField.getText().isEmpty()) {
                
                if (DBController.getKTP(keyField.getText()) != null) {
                    
                    frame.dispose();
                    new FormInputData(2, DBController.getKTP(keyField.getText()));

                }
                else {

                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan!", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);

                }

            }
            else {

                JOptionPane.showMessageDialog(null, "Field Harus Diisi!", "Error", JOptionPane.ERROR_MESSAGE);

            }

        });

        // Add a stylish "BACK TO MAIN MENU" button
        JButton mainMenuButton = new JButton("BACK TO MAIN MENU");
        mainMenuButton.setBounds(20, 80, 140, 40);
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 14));
        mainMenuButton.setBackground(new Color(220, 53, 69)); // Set background color to red
        mainMenuButton.setForeground(Color.WHITE); // White text color
        mainMenuButton.setFocusPainted(false); // Remove border focus
        panel.add(mainMenuButton);

        mainMenuButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}

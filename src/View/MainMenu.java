package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    
    private JFrame frame;

    public MainMenu() {
        showMainMenu();
    }

    public void showMainMenu() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int FRAME_WIDTH = 450;
        final int FRAME_HEIGHT = 410;

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);

        frame = new JFrame("Main Menu");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setOpacity(0.95f);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        panel.setBackground(new Color(44, 62, 80));

        JLabel title = new JLabel("PEREKAMAN DATA");
        title.setBounds(30, 40, 380, 50);
        title.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title);

        JLabel title2 = new JLabel("E-KTP");
        title2.setBounds(130, 90, 200, 50);
        title2.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
        title2.setForeground(Color.WHITE);
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(title2);

        JButton perekamanBtn = new JButton("PEREKAMAN");
        perekamanBtn.setBounds(60, 160, 320, 50);
        styleButton(perekamanBtn, new Color(26, 188, 156), new Color(46, 204, 113));
        perekamanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new FormInputData(1, null);
            }
        });
        panel.add(perekamanBtn);

        JButton pencarianBtn = new JButton("PENCARIAN");
        pencarianBtn.setBounds(60, 230, 320, 50);
        styleButton(pencarianBtn, new Color(52, 152, 219), new Color(41, 128, 185));
        pencarianBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new FormPencarianData();
            }
        });
        panel.add(pencarianBtn);

        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBounds(60, 300, 320, 50);
        styleButton(exitBtn, new Color(241, 196, 15), new Color(230, 126, 34));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(exitBtn);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void styleButton(JButton button, Color defaultColor, Color hoverColor) {
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setBackground(defaultColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(defaultColor, 2));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(defaultColor);
            }
        });
    }
}

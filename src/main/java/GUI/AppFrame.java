/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package GUI;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class AppFrame extends JFrame implements ActionListener {
    private JButton compressButton;
    private JButton decompressButton;

    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(20, 100, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(250, 100, 200, 30);
        decompressButton.addActionListener(this);

        JLabel compressLabel = new JLabel("Compress File:");
        compressLabel.setBounds(20, 70, 200, 30);

        JLabel label = new JLabel("Compressor Decompressor");
        label.setBounds(150, 30, 200, 30);
        
        JLabel decompressLabel = new JLabel("Decompress File:");
        decompressLabel.setBounds(250, 70, 200, 30);

        this.add(compressLabel);
        this.add(label);
        this.add(compressButton);
        this.add(decompressLabel);
        this.add(decompressButton);
        this.setSize(500, 300);
        this.getContentPane().setBackground(Color.black);
        //this.getContentPane().setForeground (Color.white);
        compressLabel.setForeground (Color.white);
        label.setForeground (Color.white);
        decompressLabel.setForeground (Color.white);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Compressor.method(file);
                    JOptionPane.showMessageDialog(this, "Compression successful!");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, "Compression error: " + exception.getMessage());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Decompressor.method(file);
                    JOptionPane.showMessageDialog(this, "Decompression successful!");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, "Decompression error: " + exception.getMessage());
                }
            }
        }
    }

   
}

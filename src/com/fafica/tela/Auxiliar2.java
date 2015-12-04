package com.fafica.tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Auxiliar2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auxiliar2 frame = new Auxiliar2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Auxiliar2() {

		setTitle("Escolha de tela");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), Color.GRAY));
		panel.setBounds(159, 11, 205, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOQueDeseja = new JLabel("Escolha a tela");
		lblOQueDeseja.setForeground(Color.DARK_GRAY);
		lblOQueDeseja.setBounds(56, 25, 92, 16);
		panel.add(lblOQueDeseja);
		lblOQueDeseja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnEstante = new JButton("Estante");
		btnEstante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaEstante().setVisible(true);
			}
		});
		btnEstante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEstante.setBounds(43, 122, 104, 23);
		contentPane.add(btnEstante);
		
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCaixa().setVisible(true);
			}
		});
		btnCaixa.setBounds(380, 122, 104, 23);
		contentPane.add(btnCaixa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(201, 64, 148, 20);
	}

}

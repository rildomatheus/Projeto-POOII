package com.fafica.tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTree;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Auxiliar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auxiliar frame = new Auxiliar();
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
	public Auxiliar() {
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
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAdministrador().setVisible(true);
			}
		});
		btnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdministrador.setBounds(209, 122, 104, 23);
		contentPane.add(btnAdministrador);
		
		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaFuncionario().setVisible(true);
			}
		});
		btnFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnFuncionario.setBounds(39, 103, 104, 23);
		contentPane.add(btnFuncionario);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCliente().setVisible(true);
			}
		});
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCliente.setBounds(39, 137, 104, 23);
		contentPane.add(btnCliente);
		
		JButton btnEstante = new JButton("Estante");
		btnEstante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaEstante().setVisible(true);
			}
		});
		btnEstante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEstante.setBounds(379, 137, 104, 23);
		contentPane.add(btnEstante);
		
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCaixa().setVisible(true);
			}
		});
		btnCaixa.setBounds(379, 103, 104, 23);
		contentPane.add(btnCaixa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(201, 64, 148, 20);
		
	}
}

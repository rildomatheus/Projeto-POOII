package com.fafica.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JLayeredPane;

public class TelaCliente {

	private JFrame frmTelaCliente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente window = new TelaCliente();
					window.frmTelaCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCliente = new JFrame();
		frmTelaCliente.setFont(new Font("Dialog", Font.PLAIN, 15));
		frmTelaCliente.setForeground(Color.BLACK);
		frmTelaCliente.setTitle("Cliente");
		frmTelaCliente.setBounds(100, 100, 625, 339);
		frmTelaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCliente.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 589, 75);
		frmTelaCliente.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		panel_1.add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(57, 8, 72, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(151, 11, 46, 14);
		panel_1.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 8, 379, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLoja = new JLabel("Loja");
		lblLoja.setBounds(10, 36, 46, 14);
		panel_1.add(lblLoja);
		
		textField_2 = new JTextField();
		textField_2.setBounds(57, 33, 72, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBounds(200, 48, 89, 23);
		panel_1.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(299, 48, 89, 23);
		panel_1.add(btnAtualizar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 97, 589, 44);
		frmTelaCliente.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 11, 46, 14);
		panel_2.add(label);
		
		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(10, 11, 46, 14);
		panel_2.add(lblCodigo_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(58, 11, 73, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(155, 11, 89, 23);
		panel_2.add(btnRemover);
		
		JButton btnExiste = new JButton("Existe");
		btnExiste.setBounds(254, 11, 89, 23);
		panel_2.add(btnExiste);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(353, 11, 89, 23);
		panel_2.add(btnProcurar);
	}
}

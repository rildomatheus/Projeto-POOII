package com.fafica.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.administrador.Administrador;
import com.fafica.projeto.administrador.AdministradorJaCadastradoException;
import com.fafica.projeto.administrador.AdministradorNaoEncontradoException;
import com.fafica.projeto.fachada.Fachada;
import com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException;
import com.fafica.projeto.funcionario.Funcionario;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TelaAdministrador extends JFrame {

	private JFrame frmAdministrador;
	private JTable table;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textCodigo2;
	private DefaultTableModel defaultTableModelAdministrador;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministrador window = new TelaAdministrador();
					window.frmAdministrador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAdministrador() {
		
		fachada = Fachada.getInstance();
	
		
		setTitle("Administrador");
		setBounds(100, 100, 625, 339);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 589, 75);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 11, 46, 14);
		panel.add(lblCdigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(55, 8, 62, 20);
		panel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(139, 11, 46, 14);
		panel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(183, 8, 396, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cadastrar();
			}
		});
		btnCadastrar.setBounds(183, 39, 104, 23);
		panel.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			atualizar();
			}
		});
		btnAtualizar.setBounds(298, 39, 104, 23);
		panel.add(btnAtualizar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 97, 589, 44);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCdigo_1 = new JLabel("C\u00F3digo:");
		lblCdigo_1.setBounds(10, 11, 46, 14);
		panel_1.add(lblCdigo_1);
		
		textCodigo2 = new JTextField();
		textCodigo2.setBounds(57, 8, 60, 20);
		panel_1.add(textCodigo2);
		textCodigo2.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			remover();
			}
		});
		btnRemover.setBounds(182, 7, 107, 23);
		panel_1.add(btnRemover);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			procurar();
			}
		});
		btnProcurar.setBounds(299, 7, 107, 23);
		panel_1.add(btnProcurar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 589, 112);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(549);
		defaultTableModelAdministrador = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		JButton btnListarAdministradores = new JButton("Listar Administradores");
		btnListarAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			listar();
			}
		});
		btnListarAdministradores.setBounds(425, 267, 174, 23);
		getContentPane().add(btnListarAdministradores);
	}
	
	public void cadastrar(){
		String codigo 	=	textCodigo.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		String nome		=	textNome.getText();
		
		try {
			Administrador administrador = new Administrador(Integer.parseInt(codigo),nome);
			fachada.cadastrarAdministrador(administrador);
			JOptionPane.showMessageDialog(frmAdministrador, "Administrador cadastrado com sucesso!");
			limparCampos();
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (AdministradorJaCadastradoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (com.fafica.projeto.administrador.CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmAdministrador, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void limparTableAdministrador(){
		defaultTableModelAdministrador.setNumRows(0);
	}
	
	public void limparCampos(){
		textCodigo.setText("");
		textNome.setText("");
	}
	
	public void atualizar(){
		String codigo = textCodigo.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		String nome = textNome.getText();
		
		try {
			Administrador administrador = new Administrador(Integer.parseInt(codigo),nome);
			fachada.atualizarAdministrador(administrador);
			JOptionPane.showMessageDialog(frmAdministrador, "Administrador atualizado com sucesso!");
			limparCampos();
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (AdministradorNaoEncontradoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (com.fafica.projeto.administrador.CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmAdministrador, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void remover(){
		String codigo = textCodigo2.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		try {
			fachada.removerAdministrador(Integer.parseInt(codigo));
			JOptionPane.showMessageDialog(frmAdministrador, "Administrador removido com sucesso!");
			limparCampos();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (AdministradorNaoEncontradoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (com.fafica.projeto.administrador.CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmAdministrador, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void procurar(){
		String codigo = textCodigo2.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		try {
			Administrador administrador = fachada.procurarAdministrador(Integer.parseInt(codigo));
			fachada.procurarAdministrador(Integer.parseInt(codigo));
			limparCampos();
			limparTableAdministrador();
			Vector vector = new Vector();
			vector.add(administrador.getCodigo());
			vector.add(administrador.getNome());
			defaultTableModelAdministrador.addRow(vector);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (AdministradorNaoEncontradoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (com.fafica.projeto.administrador.CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmAdministrador, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmAdministrador, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void listar(){
		limparTableAdministrador();
		ArrayList<Administrador> arrayListAdministrador = fachada.listarAdministrador();
		for(Administrador administrador : arrayListAdministrador) {
			Vector vector = new Vector();
			vector.add(administrador.getCodigo());
			vector.add(administrador.getNome());
			defaultTableModelAdministrador.addRow(vector);
		}
	}
}

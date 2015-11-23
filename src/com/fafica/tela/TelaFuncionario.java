package com.fafica.tela;

import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JButton;


import javax.swing.JTable;


import javax.swing.JOptionPane;


import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Vector;

import com.fafica.projeto.fachada.Fachada;
import com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException;
import com.fafica.projeto.funcionario.Funcionario;
import com.fafica.projeto.funcionario.FuncionarioJaCadastradoException;
import com.fafica.projeto.funcionario.FuncionarioNaoEncontradoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class TelaFuncionario {

	private JFrame frmCadastroDeFuncionario;
	private JTextField txtNome;
	private JTextField txtCodigo2;
	private JTable table;
	private DefaultTableModel defaultTableModelFuncionario;
	private JTextField txtCodigo;
	private Fachada fachada;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario window = new TelaFuncionario();
					window.frmCadastroDeFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaFuncionario() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeFuncionario = new JFrame();
		frmCadastroDeFuncionario.setTitle("Cadastrar Funcion\u00E1rio");
		frmCadastroDeFuncionario.setBounds(100, 100, 625, 350);
		frmCadastroDeFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeFuncionario.getContentPane().setLayout(null);
		
		JPanel panel_AtualizarCadastrar = new JPanel();
		panel_AtualizarCadastrar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_AtualizarCadastrar.setBounds(10, 11, 589, 75);
		frmCadastroDeFuncionario.getContentPane().add(panel_AtualizarCadastrar);
		panel_AtualizarCadastrar.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 11, 46, 14);
		panel_AtualizarCadastrar.add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(153, 11, 46, 14);
		panel_AtualizarCadastrar.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(192, 8, 387, 20);
		panel_AtualizarCadastrar.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.setBounds(192, 41, 89, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		panel_AtualizarCadastrar.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizar.setBounds(291, 41, 89, 23);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		panel_AtualizarCadastrar.add(btnAtualizar);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(57, 8, 86, 20);
		panel_AtualizarCadastrar.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();				
			}
		});
		btnListar.setBounds(390, 41, 89, 23);
		panel_AtualizarCadastrar.add(btnListar);
		
		JPanel panel_ProcuraRemover = new JPanel();
		panel_ProcuraRemover.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_ProcuraRemover.setBounds(10, 97, 589, 44);
		frmCadastroDeFuncionario.getContentPane().add(panel_ProcuraRemover);
		panel_ProcuraRemover.setLayout(null);
		
		JLabel lblCdigo_1 = new JLabel("C\u00F3digo:");
		lblCdigo_1.setBounds(10, 15, 46, 14);
		panel_ProcuraRemover.add(lblCdigo_1);
		
		txtCodigo2 = new JTextField();
		txtCodigo2.setBounds(57, 12, 86, 20);
		panel_ProcuraRemover.add(txtCodigo2);
		txtCodigo2.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(192, 10, 89, 23);
		panel_ProcuraRemover.add(btnRemover);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProcurar.setBounds(291, 10, 89, 23);
		panel_ProcuraRemover.add(btnProcurar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
				limparTabelaFuncionario();
			}
		});
		btnLimpar.setBounds(390, 11, 89, 23);
		panel_ProcuraRemover.add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 589, 149);
		frmCadastroDeFuncionario.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(1).setPreferredWidth(566);
		defaultTableModelFuncionario = (DefaultTableModel) table.getModel(); 
		scrollPane.setViewportView(table);
		
		

	}
	private void limparCampos(){
		txtCodigo.setText("");
		txtNome.setText("");
		txtCodigo2.setText("");
	}
	
	private void cadastrar(){
		
		String codigo = txtCodigo.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		String nome = txtNome.getText();
		
		
		
		try {
			Funcionario funcionario = new Funcionario(Integer.parseInt(codigo), nome);
			fachada.cadastrarFuncionario(funcionario);
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, "Funcionário cadastrado com sucesso!");
			limparCampos();
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (FuncionarioJaCadastradoException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, "ERROR", "ERRO", JOptionPane.ERROR_MESSAGE);
		} 
		
	}
	private void atualizar(){
		
		String codigo = txtCodigo.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		String nome = txtNome.getText();
							
			try {
				Funcionario funcionario = new Funcionario(Integer.parseInt(codigo), nome);
				fachada.atualizarFuncionario(funcionario);
				JOptionPane.showMessageDialog(frmCadastroDeFuncionario, "Funcionário atualizado com sucesso!");
				limparCampos();
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} catch (CampoObrigatorioInvalidoException e) {
				JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} catch (FuncionarioNaoEncontradoException e) {
				JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e){
				JOptionPane.showMessageDialog(frmCadastroDeFuncionario, "ERROR", "ERRO", JOptionPane.ERROR_MESSAGE);
			}	
	}
	private void remover(){
		String codigo = txtCodigo2.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		try {
			fachada.removerFuncionario(Integer.parseInt(codigo));
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, "Funcionário removido com sucesso!");
			limparCampos();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (FuncionarioNaoEncontradoException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, "ERROR", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void listar(){
		limparTabelaFuncionario();
		ArrayList<Funcionario> funcionarios = fachada.listarFuncionario();
		for(Funcionario funcionario : funcionarios) {
			Vector vector = new Vector();
			vector.add(funcionario.getCodigo());
			vector.add(funcionario.getNome());
			defaultTableModelFuncionario.addRow(vector);
		}
	}
	private void limparTabelaFuncionario() {
		defaultTableModelFuncionario.setNumRows(0);
	}
	private void procurar(){
		String codigo = txtCodigo2.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		try {
			Funcionario funcionario = fachada.procurarFuncionario(Integer.parseInt(codigo));
			limparCampos();
			limparTabelaFuncionario();
			Vector vector = new Vector();
			vector.add(funcionario.getCodigo());
			vector.add(funcionario.getNome());
			defaultTableModelFuncionario.addRow(vector);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (FuncionarioNaoEncontradoException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastroDeFuncionario, "ERROR", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}

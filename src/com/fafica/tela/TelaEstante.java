package com.fafica.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.estante.Estante;
import com.fafica.projeto.estante.EstanteJaCadastradaException;
import com.fafica.projeto.estante.EstanteNaoEncontradaException;
import com.fafica.projeto.fachada.Fachada;
import com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException;
import com.fafica.projeto.funcionario.Funcionario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaEstante extends JFrame{

	private JFrame frmCadastrarEstante;
	private JTextField txtCodigo;
	private JTextField txtRua;
	private JTable tableEstante;
	private Fachada fachada;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstante window = new TelaEstante();
					window.frmCadastrarEstante.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaEstante() {
		
		fachada = Fachada.getInstance();
		
		setTitle("Estante");
		setBounds(100, 100, 625, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 589, 68);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdigo.setBounds(27, 11, 46, 14);
		panel.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(68, 8, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRua.setBounds(230, 11, 46, 14);
		panel.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setBounds(257, 8, 232, 20);
		panel.add(txtRua);
		txtRua.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnCadastrar.setBounds(24, 34, 89, 23);
		panel.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizar.setBounds(137, 34, 89, 23);
		panel.add(btnAtualizar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProcurar.setBounds(250, 34, 89, 23);
		panel.add(btnProcurar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemover.setBounds(363, 34, 89, 23);
		panel.add(btnRemover);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnListar.setBounds(476, 34, 89, 23);
		panel.add(btnListar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLimpar.setBounds(260, 90, 89, 23);
		getContentPane().add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 589, 177);
		getContentPane().add(scrollPane);
		
		tableEstante = new JTable();
		tableEstante.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Rua"
			}
		));
		tableEstante.getColumnModel().getColumn(0).setPreferredWidth(49);
		tableEstante.getColumnModel().getColumn(1).setPreferredWidth(297);
		model = (DefaultTableModel) tableEstante.getModel();
		scrollPane.setViewportView(tableEstante);
		
	}
	private void limparCampos(){
		limparTabelaEstante();
		txtCodigo.setText("");
		txtRua.setText("");
		
	}
	private void cadastrar(){
		String codigo = txtCodigo.getText();
		String rua = txtRua.getText();
		
		if(codigo.equals("")){
			codigo = "0";
		}
		
		try {
			Estante estante = new Estante(Integer.parseInt(codigo), rua);
			fachada.cadastrarEstante(estante);
			JOptionPane.showMessageDialog(frmCadastrarEstante, "Estante cadastrada com sucesso!");
			limparCampos();
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (EstanteJaCadastradaException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastrarEstante, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void atualizar(){
		String codigo = txtCodigo.getText();
		String rua = txtRua.getText();

		if(codigo.equals("")){
			codigo = "0";
		}
		
		
		
		try {
			Estante estante = new Estante(Integer.parseInt(codigo), rua);
			fachada.atualizarEstante(estante);
			JOptionPane.showMessageDialog(frmCadastrarEstante, "Estante atualizada com sucesso!");
			limparCampos();
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (EstanteNaoEncontradaException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastrarEstante, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void procurar(){
		String codigo = txtCodigo.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		try {
			Estante estante = fachada.procurarEstante(Integer.parseInt(codigo));
			limparCampos();
			Vector vector = new Vector();
			vector.add(estante.getCodigo());
			vector.add(estante.getRua());
			model.addRow(vector);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (EstanteNaoEncontradaException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastrarEstante, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	private void listar(){
		limparTabelaEstante();
		ArrayList<Estante> estantes = fachada.listarEstante();
		for(Estante estante : estantes) {
			Vector vector = new Vector();
			vector.add(estante.getCodigo());
			vector.add(estante.getRua());
			model.addRow(vector);
		}
	}
	
	
	private void limparTabelaEstante(){
		model.setNumRows(0);
	}
	private void remover(){
		String codigo = txtCodigo.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		try {
			fachada.removerEstante(Integer.parseInt(codigo));
			JOptionPane.showMessageDialog(frmCadastrarEstante, "Estante removida com sucesso!");
			limparCampos();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (EstanteNaoEncontradaException e) {
			JOptionPane.showMessageDialog(frmCadastrarEstante, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastrarEstante, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}

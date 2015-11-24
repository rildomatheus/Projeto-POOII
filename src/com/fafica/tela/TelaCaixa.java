package com.fafica.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.caixa.Caixa;
import com.fafica.projeto.caixa.CaixaJaCadastradaException;
import com.fafica.projeto.caixa.CaixaNaoEncontradaException;
import com.fafica.projeto.caixa.CampoObrigatorioInvalidoException;
import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.estante.Estante;
import com.fafica.projeto.estante.EstanteNaoEncontradaException;
import com.fafica.projeto.fachada.Fachada;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TelaCaixa extends JFrame{

	private JFrame frmCadastrarCaixa;
	private JLabel lblCdigoDaEstante;
	private JTextField txtCodigoEstante;
	private JLabel lblCdigoDaCaixa;
	private JTextField txtCodigoCaixa;
	private JLabel lblDescrioDaCaixa;
	private JTextField txtDescricao;
	private DefaultTableModel model;
	private JLabel lblCdigoDoCliente;
	private JTextField txtCodigoCliente;
	private Fachada fachada;
	private Cliente cliente;
	private Estante estante;
	private JTable tableCaixa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCaixa window = new TelaCaixa();
					window.frmCadastrarCaixa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCaixa() {
		
		fachada = Fachada.getInstance();
	
		
		setTitle("Caixa");
		setBounds(100, 100, 625, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panelDeCampos = new JPanel();
		panelDeCampos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelDeCampos.setBounds(10, 11, 589, 60);
		getContentPane().add(panelDeCampos);
		panelDeCampos.setLayout(null);
		
		lblCdigoDaEstante = new JLabel("C\u00F3digo da estante:");
		lblCdigoDaEstante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdigoDaEstante.setBounds(203, 36, 100, 14);
		panelDeCampos.add(lblCdigoDaEstante);
		
		txtCodigoEstante = new JTextField();
		txtCodigoEstante.setBounds(300, 33, 86, 20);
		panelDeCampos.add(txtCodigoEstante);
		txtCodigoEstante.setColumns(10);
		
		lblCdigoDaCaixa = new JLabel("C\u00F3digo da caixa:");
		lblCdigoDaCaixa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdigoDaCaixa.setBounds(10, 11, 86, 14);
		panelDeCampos.add(lblCdigoDaCaixa);
		
		txtCodigoCaixa = new JTextField();
		txtCodigoCaixa.setBounds(95, 8, 86, 20);
		panelDeCampos.add(txtCodigoCaixa);
		txtCodigoCaixa.setColumns(10);
		
		lblDescrioDaCaixa = new JLabel("Descri\u00E7\u00E3o da caixa:");
		lblDescrioDaCaixa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrioDaCaixa.setBounds(203, 11, 100, 14);
		panelDeCampos.add(lblDescrioDaCaixa);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(301, 8, 200, 20);
		panelDeCampos.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		lblCdigoDoCliente = new JLabel("C\u00F3digo do cliente:");
		lblCdigoDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdigoDoCliente.setBounds(10, 36, 100, 14);
		panelDeCampos.add(lblCdigoDoCliente);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(101, 33, 86, 20);
		panelDeCampos.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		JPanel panelDeBotoes = new JPanel();
		panelDeBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelDeBotoes.setBounds(10, 82, 589, 46);
		getContentPane().add(panelDeBotoes);
		panelDeBotoes.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.setBounds(24, 11, 89, 23);
		panelDeBotoes.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizar.setBounds(137, 11, 89, 23);
		panelDeBotoes.add(btnAtualizar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProcurar.setBounds(250, 11, 89, 23);
		panelDeBotoes.add(btnProcurar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemover.setBounds(363, 11, 89, 23);
		panelDeBotoes.add(btnRemover);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listar();
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnListar.setBounds(476, 11, 89, 23);
		panelDeBotoes.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 589, 128);
		getContentPane().add(scrollPane);
		
		tableCaixa = new JTable();
		tableCaixa.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Caixa", "Descri\u00E7\u00E3o", "Estante", "Rua", "Cliente", "N\u00FAmero da Loja"
			}
		));
		tableCaixa.getColumnModel().getColumn(0).setPreferredWidth(68);
		tableCaixa.getColumnModel().getColumn(5).setPreferredWidth(95);
		model = (DefaultTableModel) tableCaixa.getModel();
		scrollPane.setViewportView(tableCaixa);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLimpar.setBounds(260, 139, 89, 23);
		getContentPane().add(btnLimpar);
	}
	public void cadastrar(){
	
		String codigoCaixa = txtCodigoCaixa.getText();
		String descricao = txtDescricao.getText();
		String codigoEstante = txtCodigoEstante.getText();
		String codigoCliente = txtCodigoCliente.getText();
		
		if(codigoCaixa.equals("")){
			codigoCaixa = "0";
		}
		if(codigoEstante.equals("")){
			codigoEstante = "0";
		}
		if(codigoCliente.equals("")){
			codigoCliente = "0";
		}
	
		
		
		try {
			estante = fachada.procurarEstante(Integer.parseInt(codigoEstante));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (EstanteNaoEncontradaException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		 try {
			cliente = fachada.procurarCliente(Integer.parseInt(codigoCliente));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (ClienteNaoEncontradoException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			
			Caixa caixa = new Caixa(Integer.parseInt(codigoCaixa), descricao,cliente,estante);
			fachada.cadastrarCaixa(caixa);
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Caixa cadastrada com sucesso!");
		} catch (CaixaJaCadastradaException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObritarorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public void atualizar(){
		
		String codigoCaixa = txtCodigoCaixa.getText();
		String descricao = txtDescricao.getText();
		String codigoEstante = txtCodigoEstante.getText();
		String codigoCliente = txtCodigoCliente.getText();
		
		if(codigoCaixa.equals("")){
			codigoCaixa = "0";
		}
		if(codigoEstante.equals("")){
			codigoEstante = "0";
		}
		if(codigoCliente.equals("")){
			codigoCliente = "0";
		}
	
		
		
		try {
			estante = fachada.procurarEstante(Integer.parseInt(codigoEstante));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (com.fafica.projeto.funcionario.CampoObrigatorioInvalidoException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (EstanteNaoEncontradaException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		 try {
			cliente = fachada.procurarCliente(Integer.parseInt(codigoCliente));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (ClienteNaoEncontradoException e1) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e1){
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		
		try {
			 Caixa caixa = new Caixa(Integer.parseInt(codigoCaixa), descricao,cliente,estante);
			 fachada.atualizarCaixa(caixa);
			 JOptionPane.showMessageDialog(frmCadastrarCaixa, "Caixa atualizada com sucesso!");
			} catch (CaixaNaoEncontradaException e) {
				JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e){
				JOptionPane.showMessageDialog(frmCadastrarCaixa, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
	}
	private void listar(){
		limparTabelaCaixa();
		ArrayList<Caixa> caixas = fachada.listarCaixa();
		for(Caixa caixa : caixas) {
			Vector vector = new Vector();
			vector.add(caixa.getCodigo());
			vector.add(caixa.getDescricao());
			vector.add(caixa.getEstante().getCodigo());
			vector.add(caixa.getEstante().getRua());
			vector.add(caixa.getCliente().getNome());
			vector.add(caixa.getCliente().getLoja());
			
			model.addRow(vector);
		}
	}
	
	private void limparTabelaCaixa(){
		model.setNumRows(0);
	}
	
	private void procurar(){
		String codigoCaixa = txtCodigoCaixa.getText();
		if(codigoCaixa.equals("")){
			codigoCaixa = "0";
		}
		
		try {
			Caixa caixa = fachada.procurarCaixa(Integer.parseInt(codigoCaixa));
			Vector vector = new Vector();
			vector.add(caixa.getCodigo());
			vector.add(caixa.getDescricao());
			vector.add(caixa.getEstante().getCodigo());
			vector.add(caixa.getEstante().getRua());
			vector.add(caixa.getCliente().getNome());
			vector.add(caixa.getCliente().getLoja());
			limparCampos();
			model.addRow(vector);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CaixaNaoEncontradaException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void limparCampos(){
		limparTabelaCaixa();
		txtCodigoCaixa.setText("");
		txtDescricao.setText("");
		txtCodigoEstante.setText("");
		txtCodigoCliente.setText("");
	} 
	
	private void remover(){
		String codigoCaixa = txtCodigoCaixa.getText();
		if(codigoCaixa.equals("")){
			codigoCaixa = "0";
		}
		try {
			fachada.removerCaixa(Integer.parseInt(codigoCaixa));
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Caixa removida com sucesso!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CaixaNaoEncontradaException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}

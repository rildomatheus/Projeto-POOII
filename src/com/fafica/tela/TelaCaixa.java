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
import com.fafica.projeto.caixa.CampoObrigatorioInvalidoException;
import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.estante.Estante;
import com.fafica.projeto.fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCaixa {

	private JFrame frmCadastrarCaixa;
	private JLabel lblCdigoDaEstante;
	private JTextField txtCodigoEstante;
	private JLabel lblRuaDaEstante;
	private JTextField txtRuaEstante;
	private JLabel lblMdulosDaEstante;
	private JTextField txtModulosEstante;
	private JLabel lblCdigoDaCaixa;
	private JTextField txtCodigoCaixa;
	private JLabel lblDescrioDaCaixa;
	private JTextField txtDescricao;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblNomeDoCliente;
	private JLabel lblCdigoDoCliente;
	private JTextField txtNomeCliente;
	private JTextField txtCodigoCliente;
	private JLabel lblNmeroDaLoja;
	private JTextField txtNumeroLoja;
	private Fachada fachada;

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
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarCaixa = new JFrame();
		frmCadastrarCaixa.setTitle("Cadastrar caixa");
		frmCadastrarCaixa.setBounds(100, 100, 625, 350);
		frmCadastrarCaixa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarCaixa.getContentPane().setLayout(null);
		
		JPanel panelDeCampos = new JPanel();
		panelDeCampos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelDeCampos.setBounds(10, 11, 589, 88);
		frmCadastrarCaixa.getContentPane().add(panelDeCampos);
		panelDeCampos.setLayout(null);
		
		lblCdigoDaEstante = new JLabel("C\u00F3digo da estante:");
		lblCdigoDaEstante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdigoDaEstante.setBounds(10, 64, 100, 14);
		panelDeCampos.add(lblCdigoDaEstante);
		
		txtCodigoEstante = new JTextField();
		txtCodigoEstante.setBounds(107, 61, 86, 20);
		panelDeCampos.add(txtCodigoEstante);
		txtCodigoEstante.setColumns(10);
		
		lblRuaDaEstante = new JLabel("Rua da estante:");
		lblRuaDaEstante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRuaDaEstante.setBounds(203, 64, 86, 14);
		panelDeCampos.add(lblRuaDaEstante);
		
		txtRuaEstante = new JTextField();
		txtRuaEstante.setBounds(286, 61, 86, 20);
		panelDeCampos.add(txtRuaEstante);
		txtRuaEstante.setColumns(10);
		
		lblMdulosDaEstante = new JLabel("M\u00F3dulos da estante:");
		lblMdulosDaEstante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMdulosDaEstante.setBounds(382, 64, 100, 14);
		panelDeCampos.add(lblMdulosDaEstante);
		
		txtModulosEstante = new JTextField();
		txtModulosEstante.setBounds(485, 61, 94, 20);
		panelDeCampos.add(txtModulosEstante);
		txtModulosEstante.setColumns(10);
		
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
		txtDescricao.setBounds(301, 8, 118, 20);
		panelDeCampos.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		lblNomeDoCliente = new JLabel("Nome do cliente:");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoCliente.setBounds(10, 36, 86, 14);
		panelDeCampos.add(lblNomeDoCliente);
		
		lblCdigoDoCliente = new JLabel("C\u00F3digo do cliente:");
		lblCdigoDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdigoDoCliente.setBounds(247, 36, 100, 14);
		panelDeCampos.add(lblCdigoDoCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(95, 33, 142, 20);
		panelDeCampos.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(338, 33, 86, 20);
		panelDeCampos.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		lblNmeroDaLoja = new JLabel("N\u00FAmero da loja:");
		lblNmeroDaLoja.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNmeroDaLoja.setBounds(434, 36, 86, 14);
		panelDeCampos.add(lblNmeroDaLoja);
		
		txtNumeroLoja = new JTextField();
		txtNumeroLoja.setBounds(515, 33, 48, 20);
		panelDeCampos.add(txtNumeroLoja);
		txtNumeroLoja.setColumns(10);
		
		JPanel panelDeBotoes = new JPanel();
		panelDeBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelDeBotoes.setBounds(10, 103, 589, 46);
		frmCadastrarCaixa.getContentPane().add(panelDeBotoes);
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
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizar.setBounds(137, 11, 89, 23);
		panelDeBotoes.add(btnAtualizar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnProcurar.setBounds(250, 11, 89, 23);
		panelDeBotoes.add(btnProcurar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemover.setBounds(363, 11, 89, 23);
		panelDeBotoes.add(btnRemover);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnListar.setBounds(476, 11, 89, 23);
		panelDeBotoes.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 589, 123);
		frmCadastrarCaixa.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo da Caixa", "Descri\u00E7\u00E3o", "Rua ", "C\u00F3digo da Estante"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(145);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
	}
	public void cadastrar(){
		String codigoCaixa = txtCodigoCaixa.getText();
		String descricao = txtDescricao.getText();
		String codigoEstante = txtCodigoEstante.getText();
		String ruaEstante = txtRuaEstante.getText();
		String modulos = txtModulosEstante.getText();
		String nomeCliente = txtNomeCliente.getText();
		String codigoCliente = txtCodigoCliente.getText();
		String numeroLoja = txtNumeroLoja.getText();
		
		if(codigoCaixa.equals("")){
			codigoCaixa = "0";
		}
		if(codigoEstante.equals("")){
			codigoEstante = "0";
		}
		if(modulos.equals("")){
			modulos = "0";
		}
		if(codigoCliente.equals("")){
			codigoCliente = "0";
		}
		if(numeroLoja.equals("")){
			numeroLoja = "0";
		}
		
		
		try {
			Cliente cliente = new Cliente(Integer.parseInt(codigoCliente),nomeCliente,Integer.parseInt(numeroLoja));
			Estante estante = new Estante(Integer.parseInt(codigoEstante),ruaEstante,Integer.parseInt(modulos));
			Caixa caixa = new Caixa(Integer.parseInt(codigoCaixa), descricao,cliente,estante);
			
			fachada.cadastrarCaixa(caixa);
			System.out.println(fachada.listarCaixa());
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "Caixa cadastrada com sucesso!");
		} catch (CaixaJaCadastradaException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObrigatorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObritarorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmCadastrarCaixa, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastrarCaixa, "ERRO", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	
		
	}
}

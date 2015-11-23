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
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.cliente.CampoObritarorioInvalidoException;
import com.fafica.projeto.cliente.Cliente;
import com.fafica.projeto.cliente.ClienteJaCadastradoException;
import com.fafica.projeto.cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.fachada.Fachada;
import javax.swing.border.LineBorder;

public class TelaCliente {

	private JFrame frmTelaCliente;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textLoja;
	private Fachada fachada;
	private JTable table;
	private DefaultTableModel defaultTableModelCliente;
	private JTextField textCodigo2;

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
		fachada = Fachada.getInstance();
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
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 589, 75);
		frmTelaCliente.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 11, 46, 14);
		panel_1.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(57, 8, 72, 20);
		panel_1.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(151, 11, 46, 14);
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(200, 8, 379, 20);
		panel_1.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblLoja = new JLabel("Loja");
		lblLoja.setBounds(10, 36, 46, 14);
		panel_1.add(lblLoja);
		
		textLoja = new JTextField();
		textLoja.setBounds(57, 33, 72, 20);
		panel_1.add(textLoja);
		textLoja.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cadastrar();
			}
		});
		btnCadastrar.setBounds(200, 48, 114, 23);
		panel_1.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(324, 48, 89, 23);
		panel_1.add(btnAtualizar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 97, 589, 44);
		frmTelaCliente.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 11, 46, 14);
		panel_2.add(label);
		
		JLabel lblCodigo_1 = new JLabel("C\u00F3digo");
		lblCodigo_1.setBounds(10, 11, 46, 14);
		panel_2.add(lblCodigo_1);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			remover();
			}
		});
		btnRemover.setBounds(199, 11, 116, 23);
		panel_2.add(btnRemover);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			procurar();
			}
		});
		btnProcurar.setBounds(328, 11, 89, 23);
		panel_2.add(btnProcurar);
		
		textCodigo2 = new JTextField();
		textCodigo2.setColumns(10);
		textCodigo2.setBounds(57, 8, 72, 20);
		panel_2.add(textCodigo2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 589, 112);
		frmTelaCliente.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Loja"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(474);
		defaultTableModelCliente = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listar();
			}
		});
		btnListarClientes.setBounds(474, 267, 125, 23);
		frmTelaCliente.getContentPane().add(btnListarClientes);
		
	}
	private void cadastrar(){
		String codigo	=	textCodigo.getText();
		String nome		=	textNome.getText();
		String loja		=	textLoja.getText();
		
		if(codigo.equals("")){
			codigo = "0";
		}
		
		if(loja.equals("")){
			loja = "0";
		}
		
		
		try {
			Cliente cliente = new Cliente(Integer.parseInt(codigo),nome,Integer.parseInt(loja));
			fachada.cadastrarCliente(cliente);
			JOptionPane.showMessageDialog(frmTelaCliente, "Cliente Cadastrado Com Sucesso");
			limparCampos();
		} catch (ClienteJaCadastradoException e) {
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (CampoObritarorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void atualizar() {

		String codigo 	=	textCodigo.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		String nome		=	textNome.getText();
		String loja		=	textLoja.getText();
		if(loja.equals("")){
			loja = "0";
		}
			
		
				try {
					Cliente cliente = new Cliente(Integer.parseInt(codigo),nome,Integer.parseInt(loja));	
					fachada.atualizarCliente(cliente);
					JOptionPane.showMessageDialog(frmTelaCliente,"Cliente Atualizado Com Sucesso");
					limparCampos();
				} catch (ClienteNaoEncontradoException e) {
					JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} catch (CampoObritarorioInvalidoException e) {
					JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			
			
	
	}
	
	public void limparCampos(){
		textCodigo.setText("");
		textNome.setText("");
		textLoja.setText("");
	}
	
	private void limparTabelaCliente() {
		defaultTableModelCliente.setNumRows(0);;
	}
	
	public void listar(){
		this.limparTabelaCliente();
		ArrayList<Cliente> arrayListCliente = fachada.listarCliente();
		for(Cliente cliente : arrayListCliente){
			Vector vector = new Vector();
			vector.add(cliente.getCodigo());
			vector.add(cliente.getNome());
			vector.add(cliente.getLoja());
			defaultTableModelCliente.addRow(vector);
		}
	}
	
	public void remover(){
		
		try {
			fachada.removerCliente(Integer.parseInt(textCodigo2.getText()));
			JOptionPane.showMessageDialog(frmTelaCliente, "Cliente Removido Com Sucesso");

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		} catch (ClienteNaoEncontradoException e) {
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		} catch (CampoObritarorioInvalidoException e) {
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		} catch (Exception e){
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		}
		
		
	}
	
	public void procurar(){
		String codigo	=	textCodigo2.getText();
		if(codigo.equals("")){
			codigo = "0";
		}
		try {
			Cliente cliente = fachada.procurarCliente(Integer.parseInt(codigo));
			limparCampos();
			limparTabelaCliente();
			Vector vector = new Vector();
			vector.add(cliente.getCodigo());
			vector.add(cliente.getNome());
			vector.add(cliente.getLoja());
			defaultTableModelCliente.addRow(vector);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		} catch (ClienteNaoEncontradoException e) {
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		} catch (Exception e){
			JOptionPane.showMessageDialog(frmTelaCliente, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		}
	}
}

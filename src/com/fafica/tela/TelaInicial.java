package com.fafica.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.EtchedBorder;

import com.fafica.projeto.administrador.AdministradorNaoEncontradoException;
import com.fafica.projeto.administrador.CampoObrigatorioInvalidoException;
import com.fafica.projeto.fachada.Fachada;
import com.fafica.projeto.funcionario.FuncionarioNaoEncontradoException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial {

	private JFrame frame;
	private JPasswordField pwdCodigoAdm;
	private JPasswordField pwdCodigoFuncionario;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelAdm = new JPanel();
		panelAdm.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelAdm.setBounds(186, 65, 261, 109);
		frame.getContentPane().add(panelAdm);
		panelAdm.setLayout(null);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdministrador.setBounds(87, 11, 87, 14);
		panelAdm.add(lblAdministrador);
		
		JLabel lblDigiteSeuCdigo = new JLabel("Digite seu c\u00F3digo:");
		lblDigiteSeuCdigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDigiteSeuCdigo.setBounds(42, 50, 93, 14);
		panelAdm.add(lblDigiteSeuCdigo);
		
		pwdCodigoAdm = new JPasswordField();
		pwdCodigoAdm.setBounds(130, 48, 87, 17);
		panelAdm.add(pwdCodigoAdm);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(existeAdm()){
					new Auxiliar().setVisible(true);
				} else
					try {
						throw new AdministradorNaoEncontradoException();
					} catch (AdministradorNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}

			
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEntrar.setBounds(86, 75, 89, 23);
		panelAdm.add(btnEntrar);
		
		JPanel panelFuncionario = new JPanel();
		panelFuncionario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelFuncionario.setBounds(186, 185, 261, 100);
		frame.getContentPane().add(panelFuncionario);
		panelFuncionario.setLayout(null);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFuncionrio.setBounds(94, 11, 72, 14);
		panelFuncionario.add(lblFuncionrio);
		
		JLabel lblDigiteSeuCdigo_1 = new JLabel("Digite seu c\u00F3digo:");
		lblDigiteSeuCdigo_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDigiteSeuCdigo_1.setBounds(42, 39, 85, 14);
		panelFuncionario.add(lblDigiteSeuCdigo_1);
		
		pwdCodigoFuncionario = new JPasswordField();
		pwdCodigoFuncionario.setBounds(129, 36, 87, 17);
		panelFuncionario.add(pwdCodigoFuncionario);
		
		JButton btnEntrar_1 = new JButton("Entrar");
		btnEntrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(existeFuncionario()){
					new Auxiliar2().setVisible(true);
				} else{
					try{
						throw new FuncionarioNaoEncontradoException();
					} catch (FuncionarioNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(frame, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					}
				}
			
		});
		btnEntrar_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEntrar_1.setBounds(86, 64, 89, 23);
		panelFuncionario.add(btnEntrar_1);
	}
	
	private boolean existeAdm(){
		String codigoAdm = pwdCodigoAdm.getText();
		
		if(codigoAdm.equals("")){
			codigoAdm = "0";
		}
		
		
			try {
				if(codigoAdm.equals("admin")){
					limparCampos();
					return true;
				}if(fachada.existeAdministrador(Integer.parseInt(codigoAdm))){
					return true;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(frame,"Código inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
			}  catch (Exception e1){
				JOptionPane.showMessageDialog(frame, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			limparCampos();
		return false;
		
	}
	
	private boolean existeFuncionario(){
		String codigoFuncionario = pwdCodigoFuncionario.getText();
		
		if(codigoFuncionario.equals("")){
			codigoFuncionario = "0";
		}
		try {
			if(fachada.existeFuncionario(Integer.parseInt(codigoFuncionario))){
				limparCampos();
				return true;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame,"Código inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
		}  catch (Exception e1){
			JOptionPane.showMessageDialog(frame, "Ocorreu um erro!\n Tente novamente.\n Se persistir, contactar administrador do sistema.", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		limparCampos();
		return false;
	}
	private void limparCampos(){
		pwdCodigoFuncionario.setText("");
		pwdCodigoAdm.setText("");
	}
}

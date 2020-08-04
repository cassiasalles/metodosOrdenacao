package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;

public class ViewDados extends JFrame {

	private JPanel contentPane;
	private JButton btnGerarGrafico;
	private JButton btnSair;
	private JButton btnQuick;
	private JButton btnMerge;
	private JButton btnBolha;
	private JLabel lblDadosInt;
	private JLabel lblDadosDouble;
	private JLabel lblDadosString;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewDados frame = new ViewDados();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */

	public void msgBemVindo() {
		JOptionPane.showMessageDialog(null, "Seja Bem-vindo ao programa de ordenação de dados!", "Boas Vindas",
				JOptionPane.PLAIN_MESSAGE);
	}

	public void msgResultado(String vet){
		JOptionPane.showMessageDialog(null, vet, "Dados antes e depois da execução",
				JOptionPane.PLAIN_MESSAGE);
	}

	public void msgSair() {
		JOptionPane.showMessageDialog(null, "Obrigado por utilizar nossa plataforma", "Sair",
				JOptionPane.PLAIN_MESSAGE);
	}

	public ViewDados(int qtdI, int qtdD, int qtdS) {
		setTitle("Ordenação de Dados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLocation(750, 500);

		lblDadosInt = new JLabel("Dados Int: " + qtdI + " dados");
		lblDadosInt.setBounds(80, 34, 186, 21);
		contentPane.add(lblDadosInt);

		lblDadosDouble = new JLabel("Dados Double: " + qtdD + " dados");
		lblDadosDouble.setBounds(80, 72, 186, 21);
		contentPane.add(lblDadosDouble);

		lblDadosString = new JLabel("Dados String: " + qtdS + " dados");
		lblDadosString.setBounds(80, 115, 186, 16);
		contentPane.add(lblDadosString);

		btnGerarGrafico = new JButton("Gerar Grafico");
		btnGerarGrafico.setBounds(167, 201, 117, 29);
		contentPane.add(btnGerarGrafico);

		btnSair = new JButton("Sair");
		btnSair.setBounds(359, 221, 65, 29);
		contentPane.add(btnSair);

		btnQuick = new JButton("Quick Sort");
		btnQuick.setBounds(167, 162, 117, 29);
		contentPane.add(btnQuick);

		btnMerge = new JButton("Merge Sort");
		btnMerge.setBounds(283, 162, 117, 29);
		contentPane.add(btnMerge);

		btnBolha = new JButton("Bubble Sort");
		btnBolha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBolha.setBounds(48, 162, 117, 29);
		contentPane.add(btnBolha);

	}

	public void addGerarListener(ActionListener ger) {
		btnGerarGrafico.addActionListener(ger);
	}

	public void addSairListener(ActionListener sair) {
		btnSair.addActionListener(sair);
	}

	public void addQuickListener(ActionListener quick) {
		btnQuick.addActionListener(quick);
	}

	public void addMergeListener(ActionListener merge) {
		btnMerge.addActionListener(merge);
	}

	public void addBolhaListener(ActionListener bolha) {
		btnBolha.addActionListener(bolha);
	}
}


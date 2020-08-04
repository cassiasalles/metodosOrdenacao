package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.DAODados;
import dao.DAOResultadoDados;
import model.Dados;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import view.ViewDados;
import factory.*;

public class controllerMain {
	public Dados dado = new Dados();
	public ViewDados viewD;
	DAODados daoD = new DAODados();
	DAOResultadoDados daoR = new DAOResultadoDados();
	BubbleSort bs = new BubbleSort();
	MergeSort mg = new MergeSort();
	QuickSort qs = new QuickSort();
	ResultSet rs;
	String vet;
	long tempoInt;
	long tempoDouble;
	long tempoString;

	public controllerMain(Dados model, ViewDados view, DAOResultadoDados daoR) throws ClassNotFoundException,
			SQLException {
		dado = model;
		viewD = view;
		dado.setExecucaoResultado(daoR.contadorExecucao() + 1);
		view.addGerarListener(new gerarGrafico());
		view.addSairListener(new sair());
		view.addQuickListener(new quick());
		view.addMergeListener(new merge());
		view.addBolhaListener(new bubble());
	}

	class bubble implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vet = bs.bubbleSortInt(daoD, daoR, dado);
			viewD.msgResultado(vet);
			vet = bs.bubbleSortDouble(daoD, daoR, dado);
			viewD.msgResultado(vet);
			vet = bs.bubbleSortString(daoD, daoR, dado);
			viewD.msgResultado(vet);
		}
	}

	class merge implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vet = mg.mergeSortInt(daoD, daoR, dado);
			viewD.msgResultado(vet);
			vet = mg.mergeSortDouble(daoD, daoR, dado);
			viewD.msgResultado(vet);
			vet = mg.mergeSortString(daoD, daoR, dado);
			viewD.msgResultado(vet);
		}
	}

	class quick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vet = qs.quickSortInt(daoD, daoR, dado);
			viewD.msgResultado(vet);
			vet = qs.quickSortDouble(daoD, daoR, dado);
			viewD.msgResultado(vet);
			vet = qs.quickSortString(daoD, daoR, dado);
			viewD.msgResultado(vet);
		}
	}

	class gerarGrafico implements ActionListener {
		private Connection connection;	
		public gerarGrafico() throws ClassNotFoundException {
			   this.connection = new Conexao().getConnection();
		}
		public void actionPerformed(ActionEvent e) {
			try {
				HashMap<String, Object> parametro = new HashMap<String, Object>();
				int execucao = dado.getExecucaoResultado();
				parametro.put("Execucao", execucao);
				//Relatório INT
				JasperPrint jpI = JasperFillManager.fillReport("src/relatorios/GraficoDadosInt.jasper", parametro, connection);
				JasperViewer jwI = new JasperViewer(jpI, false);
				jwI.getDefaultCloseOperation();
				//Relatório Double
				JasperPrint jpD = JasperFillManager.fillReport("src/relatorios/GraficoDadosDouble.jasper", parametro, connection);
				JasperViewer jwD = new JasperViewer(jpD, false);
				jwD.getDefaultCloseOperation();
				//Relatório String
				JasperPrint jpS = JasperFillManager.fillReport("src/relatorios/GraficoDadosString.jasper", parametro, connection);
				JasperViewer jwS = new JasperViewer(jpS, false);
				jwS.getDefaultCloseOperation();
				
				jwI.setVisible(true);
				jwD.setVisible(true);
				jwS.setVisible(true);
			} catch (Exception erro) {
				System.out.println("Erro no relatorio");
				erro.printStackTrace();
			}
		}
	}

	class sair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			viewD.dispose();
			// try { daoD.fechar(); } catch (SQLException e1) { e1.printStackTrace(); }
			viewD.msgSair();
		}
	}

}

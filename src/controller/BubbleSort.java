package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import dao.DAODados;
import dao.DAOResultadoDados;
import model.Dados;
import view.ViewDados;

public class BubbleSort {

	int quantidade;
	
	public String bubbleSortInt(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
		String vet;
		quantidade = daoD.contadorInt();
		int vetID[] = new int[quantidade];
		int vetI[] = new int[quantidade];
		for (int x = 1; x <= quantidade; x++) {
			dado.setIdDadosInt(x);
			daoD.selecionarInt(dado);
			vetID[x - 1] = dado.getDados_int();
			vetI[x - 1] = dado.getDados_int();
		}
		long tempoInicial = System.currentTimeMillis();
		vetI = ordenaBubbleSortInt(vetI);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("BubbleSort");
		dado.setTipo("Inteiro(INT)");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetID) + "\n Dados Ordenados: " + Arrays.toString(vetI);
		daoR.inserir(dado);
		return vet;
	}

	public String bubbleSortDouble(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
		String vet;
		quantidade = daoD.contadorInt();
		double vetDD[] = new double[quantidade];
		double vetD[] = new double[quantidade];
		for (int i = 1; i <= quantidade; i++) {
			dado.setIdDadosDouble(i);
			daoD.selecionarDouble(dado);
			vetDD[i - 1] = dado.getDados_double();
			vetD[i - 1] = dado.getDados_double();
		}
		long tempoInicial = System.currentTimeMillis();
		vetD = ordenaBubbleSortDouble(vetD);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("BubbleSort");
		dado.setTipo("Ponto Flutuante(Double)");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetDD) + "\n Dados Ordenados: " + Arrays.toString(vetD);
		daoR.inserir(dado);
		return vet;
	}

	public String bubbleSortString(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
		quantidade = daoD.contadorInt();
		String vet;
		String vetSD[] = new String[quantidade];
		String vetS[] = new String[quantidade];
		for (int i = 1; i <= quantidade; i++) {
			dado.setIdDadosString(i);
			daoD.selecionarString(dado);
			vetSD[i - 1] = dado.getDados_String();
			vetS[i - 1] = dado.getDados_String();
		}

		long tempoInicial = System.currentTimeMillis();
		vetS = ordenaBubbleSortString(vetS);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("BubbleSort");
		dado.setTipo("String");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetSD) + "\n Dados Ordenados: " + Arrays.toString(vetS);
		daoR.inserir(dado);
		return vet;
	}

	private static int[] ordenaBubbleSortInt(int vet[]) {
		boolean troca = true;
		int aux;
		while (troca == true) {
			troca = false;
			for (int i = 0; i < vet.length - 1; i++) {
				if (vet[i] > vet[i + 1]) {
					aux = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = aux;
					troca = true;
				}

			}
		}
		return vet;
	}

	private static double[] ordenaBubbleSortDouble(double vet[]) {
		boolean troca = true;
		double aux;
		while (troca == true) {
			troca = false;
			for (int i = 0; i < vet.length - 1; i++) {
				if (vet[i] > vet[i + 1]) {
					aux = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = aux;
					troca = true;
				}
			}
		}
		return vet;
	}

	private static String[] ordenaBubbleSortString(String vet[]) {
		boolean troca = true;
		String aux;
		while (troca == true) {
			troca = false;
			for (int i = 0; i < vet.length - 1; i++) {
				if (vet[i].compareTo(vet[i + 1]) > 0) {
					aux = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = aux;
					troca = true;
				}

			}
		}
		return vet;
	}
}

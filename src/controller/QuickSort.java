package controller;

import java.util.Arrays;

import dao.DAODados;
import dao.DAOResultadoDados;
import model.Dados;
import view.ViewDados;

public class QuickSort {

	int quantidade;

	public String quickSortInt(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
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
		int aux[] = new int[vetI.length];
		long tempoInicial = System.currentTimeMillis();
		ordenaQuickSortInt(vetI, 0, vetI.length - 1);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("QuickSort");
		dado.setTipo("Inteiro(INT)");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetID) + "\n Dados Ordenados: " + Arrays.toString(vetI);
		daoR.inserir(dado);
		return vet;
	}

	public String quickSortDouble(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
		String vet;
		quantidade = daoD.contadorInt();
		double vetDD[] = new double[quantidade];
		double vetD[] = new double[quantidade];
		for (int x = 1; x <= quantidade; x++) {
			dado.setIdDadosDouble(x);
			daoD.selecionarDouble(dado);
			vetDD[x - 1] = dado.getDados_double();
			vetD[x - 1] = dado.getDados_double();
		}
		double aux[] = new double[vetD.length];
		long tempoInicial = System.currentTimeMillis();
		ordenaQuickSortDouble(vetD, 0, vetD.length - 1);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("QuickSort");
		dado.setTipo("Ponto Flutuante(Double)");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetDD) + "\n Dados Ordenados: " + Arrays.toString(vetD);
		daoR.inserir(dado);
		return vet;
	}

	public String quickSortString(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
		quantidade = daoD.contadorString();
		String vet;
		String vetSD[] = new String[quantidade];
		String vetS[] = new String[quantidade];
		for (int x = 1; x <= quantidade; x++) {
			dado.setIdDadosString(x);
			daoD.selecionarString(dado);
			vetSD[x - 1] = dado.getDados_String();
			vetS[x - 1] = dado.getDados_String();
		}
		String aux[] = new String[vetS.length];
		long tempoInicial = System.currentTimeMillis();
		ordenaQuickSortString(vetS, 0, vetS.length - 1);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("QuickSort");
		dado.setTipo("String");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetSD) + "\n Dados Ordenados: " + Arrays.toString(vetS);
		daoR.inserir(dado);
		return vet;
	}

	// INT//
	private static void ordenaQuickSortInt(int vet[], int esquerda, int direita) {
		if (esquerda < direita) {
			int posicaoPivo = separarInt(vet, esquerda, direita);
			ordenaQuickSortInt(vet, esquerda, posicaoPivo - 1);
			ordenaQuickSortInt(vet, posicaoPivo + 1, direita);
		}
	}

	public static int separarInt(int[] vet, int esquerda, int direita) {

		int pivo = vet[esquerda];
		int i = esquerda + 1, f = direita;

		while (i <= f) {
			if (vet[i] <= pivo) {
				i++;
			} else if (pivo < vet[f]) {
				f--;
			}

			else {
				int troca = vet[i];
				vet[i] = vet[f];
				vet[f] = troca;
				i++;
				f--;
			}
		}
		vet[esquerda] = vet[f];
		vet[f] = pivo;
		return f;
	}
	// FIM INT//

	// DOUBLE//
	private static void ordenaQuickSortDouble(double vet[], int esquerda, int direita) {
		if (esquerda < direita) {
			int posicaoPivo = separarDouble(vet, esquerda, direita);
			ordenaQuickSortDouble(vet, esquerda, posicaoPivo - 1);
			ordenaQuickSortDouble(vet, posicaoPivo + 1, direita);
		}
	}

	public static int separarDouble(double[] vet, int esquerda, int direita) {

		double pivo = vet[esquerda];
		int i = esquerda + 1, f = direita;

		while (i <= f) {
			if (vet[i] <= pivo) {
				i++;
			} else if (pivo < vet[f]) {
				f--;
			}

			else {
				double troca = vet[i];
				vet[i] = vet[f];
				vet[f] = troca;
				i++;
				f--;
			}
		}
		vet[esquerda] = vet[f];
		vet[f] = pivo;
		return f;
	}
	// FIM DOUBLE//

	// STRING//
	private static void ordenaQuickSortString(String vet[], int esquerda, int direita) {
		if (esquerda < direita) {
			int posicaoPivo = separarString(vet, esquerda, direita);
			ordenaQuickSortString(vet, esquerda, posicaoPivo - 1);
			ordenaQuickSortString(vet, posicaoPivo + 1, direita);
		}
	}

	public static int separarString(String[] vet, int esquerda, int direita) {

		String pivo = vet[esquerda];
		int i = esquerda + 1, f = direita;

		while (i <= f) {
			if (vet[i].compareTo(pivo) < 0) {
				i++;
			} else if (pivo.compareTo(vet[f]) < 0) {
				f--;
			}

			else {
				String troca = vet[i];
				vet[i] = vet[f];
				vet[f] = troca;
				i++;
				f--;
			}
		}
		vet[esquerda] = vet[f];
		vet[f] = pivo;
		return f;
	}
	// FIM STRING//
}

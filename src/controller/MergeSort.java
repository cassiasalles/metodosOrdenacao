package controller;

import java.awt.event.ActionListener;
import java.util.Arrays;

import dao.DAODados;
import dao.DAOResultadoDados;
import model.Dados;
import view.ViewDados;

public class MergeSort {

	public String mergeSortInt(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
		String vet;
		int quantidade;
		quantidade = daoD.contadorInt();
		int vetID[] = new int[quantidade];
		int vetI[] = new int[quantidade]; 
		int aux[] = new int[vetI.length];
		for (int i = 1; i <= quantidade; i++) {
			dado.setIdDadosInt(i);
			daoD.selecionarInt(dado);
			vetID[i - 1] = dado.getDados_int();
			vetI[i - 1] = dado.getDados_int();
		}
		long tempoInicial = System.currentTimeMillis();
		vetI = ordenaMergeSortInt(vetI, aux, 0, vetI.length - 1);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("MergeSort");
		dado.setTipo("Inteiro(INT)");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetID) + "\n Dados Ordenados: " + Arrays.toString(vetI);
		daoR.inserir(dado);
		return vet;
	}

	public String mergeSortDouble(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
		String vet;
		int quantidade;
		quantidade = daoD.contadorInt();
		double vetDD[] = new double[quantidade];
		double vetD[] = new double[quantidade];
		double aux[] = new double[vetD.length];
		for (int x = 1; x <= quantidade; x++) {
			dado.setIdDadosDouble(x);
			daoD.selecionarDouble(dado);
			vetDD[x - 1] = dado.getDados_double();
			vetD[x - 1] = dado.getDados_double();
		}
		long tempoInicial = System.currentTimeMillis();
		vetD = ordenaMergeSortDouble(vetD, aux, 0, vetD.length - 1);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("MergeSort");
		dado.setTipo("Ponto Flutuante(Double)");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetDD) + "\n Dados Ordenados: " + Arrays.toString(vetD);
		daoR.inserir(dado);
		return vet;
	}

	public String mergeSortString(DAODados daoD, DAOResultadoDados daoR, Dados dado) {
		int quantidade;
		quantidade = daoD.contadorInt();
		String vet;
		String vetSD[] = new String[quantidade];
		String vetS[] = new String[quantidade];
		String aux[] = new String[vetS.length];
		for (int x = 1; x <= quantidade; x++) {
			dado.setIdDadosString(x);
			daoD.selecionarString(dado);
			vetSD[x - 1] = dado.getDados_String();
			vetS[x - 1] = dado.getDados_String();
		}
		long tempoInicial = System.currentTimeMillis();
		vetS = ordenaMergeSortString(vetS, aux, 0, vetS.length - 1);
		long tempoFinal = System.currentTimeMillis();
		dado.setTempo(tempoFinal - tempoInicial);
		dado.setMetodo("MergeSort");
		dado.setTipo("String");
		dado.setIdResult(daoR.contador() + 1);
		vet = "Dados desordenados: " + Arrays.toString(vetSD) + "\n Dados Ordenados: " + Arrays.toString(vetS);
		daoR.inserir(dado);
		return vet;
	}

	// INT//
	public static int[] ordenaMergeSortInt(int[] vetor, int[] aux, int inicio, int fim) {
		if (inicio < fim) {
			// calcula o indice do meio do vetor
			int meio = (inicio + fim) / 2;

			// chama o merge do inicio ate o meio
			ordenaMergeSortInt(vetor, aux, inicio, meio);

			// chama o merge do meio+1 ate o fim
			ordenaMergeSortInt(vetor, aux, meio+1, fim);

			// intercala os dois vetores
			intercalarInt(vetor, aux, inicio, meio, fim);

		}
		return vetor;
	}

	private static void intercalarInt(int[] vetor, int[] aux, int inicio, int meio, int fim) {
		for (int i = inicio; i <= fim; i++) {
			aux[i] = vetor[i];
		}

		int ini = inicio;
		int ini2 = meio + 1;

		for (int i = inicio; i <= fim; i++) {
			if (ini > meio)
				vetor[i] = aux[ini2++];
			else if (ini2 > fim)
				vetor[i] = aux[ini++];
			else if (aux[ini] < aux[ini2])
				vetor[i] = aux[ini++];
			else
				vetor[i] = aux[ini2++];
		}

	}
	// FIM-INT//

	// DUBLE//
	public static double[] ordenaMergeSortDouble(double[] vetor, double[] aux, int inicio, int fim) {
		if (inicio < fim) {
			// calcula o indice do meio do vetor
			int meio = (inicio + fim) / 2;

			// chama o merge do inicio ate o meio
			ordenaMergeSortDouble(vetor, aux, inicio, meio);

			// chama o merge do meio+1 ate o fim
			ordenaMergeSortDouble(vetor, aux, meio+1, fim);

			// intercala os dois vetores
			intercalarDouble(vetor, aux, inicio, meio, fim);

		}
		return vetor;
	}

	private static void intercalarDouble(double[] vetor, double[] aux, int inicio, int meio, int fim) {
		for (int i = inicio; i <= fim; i++) {
			aux[i] = vetor[i];
		}

		int ini = inicio;
		int ini2 = meio + 1;

		for (int i = inicio; i <= fim; i++) {
			if (ini > meio)
				vetor[i] = aux[ini2++];
			else if (ini2 > fim)
				vetor[i] = aux[ini++];
			else if (aux[ini] < aux[ini2])
				vetor[i] = aux[ini++];
			else
				vetor[i] = aux[ini2++];
		}

	}
	// FIM-DOUBLE//

	// STRING//
	public static String[] ordenaMergeSortString(String[] vetor, String[] aux, int inicio, int fim) {
		if (inicio < fim) {
			// calcula o indice do meio do vetor
			int meio = (inicio + fim) / 2;

			// chama o merge do inicio ate o meio
			ordenaMergeSortString(vetor, aux, inicio, meio);

			// chama o merge do meio+1 ate o fim
			ordenaMergeSortString(vetor, aux, meio+1, fim);

			// intercala os dois vetores
			intercalarString(vetor, aux, inicio, meio, fim);

		}
		return vetor;
	}

	private static void intercalarString(String[] vetor, String[] aux, int inicio, int meio, int fim) {
		for (int i = inicio; i <= fim; i++) {
			aux[i] = vetor[i];
		}

		int ini = inicio;
		int ini2 = meio + 1;

		for (int i = inicio; i <= fim; i++) {
			if (ini > meio)
				vetor[i] = aux[ini2++];
			else if (ini2 > fim)
				vetor[i] = aux[ini++];
			else if (aux[ini].compareTo(aux[ini2]) < 0)
				vetor[i] = aux[ini++];
			else
				vetor[i] = aux[ini2++];
		}

	}
	// FIM-INT//

}

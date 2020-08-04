package main;

import java.util.Random;
import model.Dados;
import dao.DAODados;

public class GerarDados{
	private Dados dadoM = new Dados();

	public static void main(String[] args) throws ClassNotFoundException{
		int quantidade = 100000;
		DAODados daoD = new DAODados();
		GerarDados gd = new GerarDados();
		gd.gerarInt(quantidade,daoD);
		gd.gerarDouble(quantidade,daoD);
		gd.gerarString(quantidade,daoD);
		
		System.out.println("Dados Gerados");
	}

	public void gerarInt(int quantidade, DAODados daoD) {
		for (int i = 0; i < quantidade; i++) {
			dadoM.setDados_int((int) (Math.random() * quantidade));
			dadoM.setIdDadosInt(daoD.contadorInt() + 1);
			daoD.inserirInt(dadoM);
		}
	}
	
	public void gerarDouble(int quantidade, DAODados daoD) {
		for (int i = 0; i < quantidade; i++) {
			dadoM.setDados_double((double) (Math.random() * quantidade));
			dadoM.setIdDadosDouble(daoD.contadorDouble() + 1);
			daoD.inserirDouble(dadoM);
		}

	}

	public void gerarString(int quantidade, DAODados daoD) {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ"; // Determia as letras que poderão estar presente nas chaves
		Random random = new Random();

		int index = 0;
		int index2 = 0;
		int index3 = 0;
		for (int i = 0; i < quantidade; i++) {
			index = random.nextInt(letras.length());
			index2 = random.nextInt(letras.length());
			index3 = random.nextInt(letras.length());
			dadoM.setDados_String(letras.substring(index, index + 1) + letras.substring(index2, index2 + 1) + letras
					.substring(index3, index3 + 1));
			dadoM.setIdDadosString(daoD.contadorString() + 1);
			daoD.inserirString(dadoM);

		}
	}
	
}

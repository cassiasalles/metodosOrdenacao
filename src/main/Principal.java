package main;

import java.sql.SQLException;

import controller.*;
import view.*;
import model.*;
import dao.*;

public class Principal {
	public static void main(String[] args) throws ClassNotFoundException,
	SQLException{
		Dados dadoD = new Dados();
		DAODados daoD = new DAODados();
		DAOResultadoDados daoR = new DAOResultadoDados();
		ViewDados viewD = new ViewDados(daoD.contadorInt(), daoD.contadorDouble(), daoD.contadorString());
		controllerMain controllerM = new controllerMain(dadoD, viewD, daoR);
		viewD.msgBemVindo();
		viewD.setVisible(true);
	}

}

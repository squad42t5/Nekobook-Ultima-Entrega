package controller;


import java.util.Date;

import model.*;


public class main {

	public static void main(String[] args) {

		AlunoDAO AlunoDAO = new AlunoDAO();

		// inserindo dados Cliente--------------------
		Aluno Aluno = new Aluno();
//		//
		  Aluno.setNome("igor"); 
		  Aluno.setCpf("854477"); 
		  Aluno.setEmail("igorcamaras");
		  Aluno.setFone(89102255);
	 
//		
		  AlunoDAO.save(Aluno);
		// atualizando dados
		// Atualizar
//				Aluno al1 = new Aluno();
//				al1.setNome("breno");
//				al1.setCpf("6847813");
//				al1.setEmail("jeansilvera@g");
//				al1.setFone(88812070);
//				
//				//UPDATE
//				AlunoDAO.update(al1);
		// deletando
//				AlunoDAO.removeByCPF("null");
//		// Visualização dos registros do banco de dados TODOS
//		for (Aluno c : AlunoDAO.getAlunos()) {
//			System.out.println("Aluno: " + c.getCpf());
//			System.out.println("Nome: " + c.getNome());
//			System.out.println("----------------------------");
//			}


	}

}

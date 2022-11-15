package controller;

import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import model.AlunoDAO;

@WebServlet("/Registrar")
public class Registrar extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		int fone = Integer.parseInt(request.getParameter("fone"));
		String senha = request.getParameter("senha");

		Aluno Aluno = new Aluno();

		Aluno.setNome(nome);
		Aluno.setCpf(cpf);
		Aluno.setEmail(email);
		Aluno.setFone(fone);
		Aluno.setSenha(senha);

		AlunoDAO AlunoDAO = new AlunoDAO();
		AlunoDAO.save(Aluno);

		response.sendRedirect("index.html");

	}

}

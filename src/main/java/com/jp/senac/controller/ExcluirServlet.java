package com.jp.senac.controller;

import java.io.IOException;
import java.util.List;

import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));	
		HttpSession session = request.getSession();
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos");

		Aluno aluno = null;
		for (Aluno a : listaAlunos) {
			if (a.getId() == id ) {
				aluno = a;
			}
		}

		listaAlunos.remove(aluno);
		session.setAttribute("listaAlunos", listaAlunos);
		request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
	}

}

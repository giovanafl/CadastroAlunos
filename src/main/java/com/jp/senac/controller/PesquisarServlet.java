package com.jp.senac.controller;

import java.io.IOException;
import java.util.List;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PesquisarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String opcao = request.getParameter("opcao");
				String pesquisa = request.getParameter("valor");
				AlunoJDBCdao dao = new AlunoJDBCdao();
				
				try {
					List<Aluno> listaAlunos = dao.pesquisarPor(pesquisa, opcao);

					
					
					System.out.println(listaAlunos);
					
					request.setAttribute("listaAlunos", listaAlunos);
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
			

		
		
	}

}
	
package com.jp.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jp.senac.model.Aluno;

public class AlunoJDBCdao {

	public Connection getConexao () throws ClassNotFoundException {

		//Driver
		String driver = "com.mysql.jdbc.Driver";

		//Banco de Dados
		String url = "jdbc:mysql://localhost:3306/cadastroalunos?useTimezone=true&serverTimezone=UTC";

		//Variáveis de Login e Senha

		String user = "root";
		String password = "root";

		Connection con =null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Conectado ao Banco de Dados.");
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return con;
	}

	public List<Aluno> listarAlunos () throws SQLException {

		List<Aluno> alunos = new ArrayList<>();
		String query = "select * from alunos";

		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String semestre = rs.getString(4);
				String genero = rs.getString(5);
				String matricula = rs.getString(6);
				alunos.add(new Aluno (id,nome,idade,semestre,genero,matricula));
			}
			rs.close();
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return alunos;
	}

}

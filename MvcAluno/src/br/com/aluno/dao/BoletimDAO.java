package br.com.aluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import br.com.aluno.model.Boletim;
import br.com.aluno.util.ConnectionFactory;

public class BoletimDAO {

	private Boletim boletim;
	private Connection conn; //=== conecta com o bando de dados
	private PreparedStatement ps; //=== permite que o java execute os comandos em sql
	private ResultSet rs; //=== retorna o resultado da tabela do banco
	
	
	public BoletimDAO () throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		}catch (Exception e) {
			throw new Exception("Erro" + e.getMessage());
		}
	}
	
	
	//=== metodo salvar
	
	public void salvar (Boletim boletim) throws Exception{
		try {
			String sql = "INSERT INTO DBALUNO.BOLETIM (Nome_Disciplina,Nota,"
					+ "Semestre,Faltas,Rgm)"
					+ "values (?,?,?,?,?)";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1,boletim.getNome_Disciplina());
		ps.setString(2,boletim.getNota());
		ps.setString(3,boletim.getSemestre());
		ps.setInt(4, boletim.getFaltas());
		ps.setInt(5, boletim.getRgm());
		ps.executeUpdate();
	
		}catch (Exception e) {
			throw new Exception ("Erro ao salvar boletim. Tente novamente.");
			
		}
	}
	
	
	///== metodo alterar os dados
	
	public void alterar (Boletim boletim) throws Exception{
		
		String sql = "UPDATE DBALUNO.BOLETIM SET nota = ?,semestre = ?,faltas = ? WHERE ( rgm = ? and Nome_Disciplina =?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,boletim.getNota());
			ps.setString(2,boletim.getSemestre());
			ps.setInt(3,boletim.getFaltas());
			ps.setInt(4,boletim.getRgm());
			ps.setString(5,boletim.getNome_Disciplina());
			ps.executeUpdate();
					
		}catch(SQLException sqle) {
			throw new Exception ("Erro ao alterar dados do aluno" + sqle);
		}finally {
			ConnectionFactory.closeConnection(conn,ps);
		}
	}
	
	
	//== metodo exluir os dados 
	
	public void excluir (String Nome_Disciplina) throws Exception{
		try {
			String sql = "DELETE FROM DBALUNO.Boletim WHERE Nome_Disciplina = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Nome_Disciplina);
			ps.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Erro ao excluir dados do aluno.Tente novamente.");
		}
	}

	//== metodo listar
	
	public List listarTodos(int rgm) throws Exception{
		List<Boletim> lista = new ArrayList<Boletim>();
		
		try {
			ps=conn.prepareStatement("SELECT * FROM DBALUNO.Boletim WHERE RGM =?");
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				int Cod_Disciplina = rs.getInt("Cod_Disciplina");
				String Nome_Disciplina = rs.getString("Nome_Disciplina");
				String Nota = rs.getString("Nota");
				String Semestre = rs.getString("Semestre");
				int Faltas = rs.getInt("Faltas");
				
				boletim = new Boletim(Cod_Disciplina,Nome_Disciplina,Nota,Semestre,Faltas,rgm);
				lista.add(boletim);
			}
		return lista;
	}catch (Exception e) {
		throw new Exception("Erro ao listar. Tente novamente.");
		
	}	
}
	

	//=== metodo consultar

	public Boletim consultar (String Nome_Disciplina, int Rgm) throws Exception{
		
		try {
		
		Boletim boletim = new Boletim();
		String sql = "SELECT * FROM DBALUNO.BOLETIM WHERE Nome_Disciplina = ? and Rgm=?";
		conn=this.conn;
		ps = conn.prepareStatement(sql);
		ps.setString(1,Nome_Disciplina);
		ps.setInt(2, Rgm);
		rs = ps.executeQuery();
	
		if(rs.next()) {
		
		String Nome_Disciplina1 = rs.getString("Nome_Disciplina");
		boletim.setNome_Disciplina(rs.getString("Nome_Disciplina"));
		boletim.setNota(rs.getString("Nota"));
		boletim.setSemestre(rs.getString("Semestre"));
		boletim.setFaltas(rs.getInt("Faltas"));
		boletim.setRgm(rs.getInt("Rgm"));
		
		return boletim;

			}else {
				return null;
			}
		
		}catch(Exception e) {
		throw new Exception("Erro ao consultar os dados. Tente novamente.");
	}
}
}
	
		   
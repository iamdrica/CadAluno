package br.com.aluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluno.model.Aluno;
import br.com.aluno.util.ConnectionFactory;

public class AlunoDAO { //CRUD - Create / Read / Update / Delete
	
	private Aluno aluno;
	private Connection conn; // conecta com o banco de dados
	private PreparedStatement ps; // permite que o java execute comandos sql
	private ResultSet rs; // tabela
	
	public AlunoDAO() throws Exception{
		try {
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro de conexão. Tente novamente."); //dev debugar os erros;
		}
	}

	// metodo salvar
	public void salvar(Aluno aluno) throws Exception{
		try {
			String sql = "INSERT INTO Aluno(rgm,nome,dta_nascimento,cpf,email,endereco,municipio,uf,celular,nome_curso,campus,periodo)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,aluno.getRgm());
			ps.setString(2,aluno.getNome());
			ps.setString(3,aluno.getDta_Nascimento());
			ps.setString(4,aluno.getCpf());
			ps.setString(5,aluno.getEmail());
			ps.setString(6,aluno.getEndereco());
			ps.setString(7,aluno.getMunicipio());
			ps.setString(8,aluno.getUf());
			ps.setString(9,aluno.getCelular());
			ps.setString(10,aluno.getNome_Curso());
			ps.setString(11,aluno.getCampus());
			ps.setString(12,aluno.getPeriodo());
			ps.executeUpdate(); //para incluir, alterar, excluir
							
		}catch(Exception e) {
			throw new Exception("Erro ao salvar" + e.getMessage()); //dev debugar os erros;
		}
	}
	// alterar os dados
	public void alterar(Aluno aluno) throws Exception{
		try {
			String sql = "UPDATE DBALUNO.ALUNO SET nome = ?,dta_nascimento = ?,cpf = ?,email = ?,"
					+ "endereco=?,municipio=?,uf=?,celular=?,nome_curso=?,campus=?,periodo = ?"
					+ "WHERE (rgm = ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,aluno.getNome());
			ps.setString(2,aluno.getDta_Nascimento());
			ps.setString(3,aluno.getCpf());
			ps.setString(4,aluno.getEmail());
			ps.setString(5,aluno.getEndereco());
			ps.setString(6,aluno.getMunicipio());
			ps.setString(7,aluno.getUf());
			ps.setString(8,aluno.getCelular());
			ps.setString(9,aluno.getNome_Curso());
			ps.setString(10,aluno.getCampus());
			ps.setString(11,aluno.getPeriodo());
			ps.setInt(12,aluno.getRgm());
			ps.executeUpdate(); //para incluir, alterar, excluir
			
			
		}catch(SQLException sqle) { //((Exception e)
			throw new Exception("Erro ao alterar os dados" + sqle); // e.getMessage()/ dev debugar os erros;
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	//Metodo exluir
	public void excluir(int rgm) throws Exception{
		try {
			String sql = "DELETE FROM Aluno WHERE rgm=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,rgm);
			ps.executeUpdate(); //para incluir, alterar, excluir
							
		}catch(Exception e) {
			throw new Exception("Erro ao excluir.Tente novamente."); //e.getMessage())-dev debugar os erros;
		}
	}
	
	// metodo listar
	public List listarTodos() throws Exception {
		List <Aluno> lista = new ArrayList<Aluno>();
		
		try {
			ps = conn.prepareStatement("SELECT * FROM Aluno");
			rs = ps.executeQuery(); // para selecionar query
			while(rs.next()) { //percorre registro por registro dentro da tabela e retorna falso pro while e sai dele;
				int rgm = rs.getInt("Rgm");
				String Nome = rs.getString("Nome");
				String Dta_Nascimento = rs.getString("Data Nascimento");
				String Cpf = rs.getString("Cpf");
				String Email = rs.getString("E-mail");
				String Endereco = rs.getString("Endereco");
				String Municipio = rs.getString("Municipio");
				String Uf = rs.getString("Uf");
				String Celular = rs.getString("Celular");
				String Nome_curso = rs.getString("Curso");
				String Campus = rs.getString("Campus");
				String Periodo = rs.getString("Período");
				
				aluno = new Aluno (rgm,Nome,Dta_Nascimento,Cpf,Email,Endereco,Municipio,Uf,Celular,Nome_curso,Campus,Periodo);
				lista.add(aluno);
				
			}
			return lista;
			
		}catch(Exception e) {
			throw new Exception("Erro ao listar. Tente novamente.");
		}
	}
	
	// Metodo consultar
		public Aluno consultar(int rgm) throws Exception {
			try {
				
				Aluno aluno = new Aluno();
				
				ps = conn.prepareStatement ("SELECT * FROM Aluno WHERE rgm = ?");
				ps.setInt(1,rgm);
				rs = ps.executeQuery(); // Executa o comando select na tabela do banco
				
				//Verifica se a consulta encontrou o aluno com o rgm informado;
				if(rs.next()) { //
					
					aluno.setNome(rs.getString("Nome"));
					aluno.setDta_Nascimento(rs.getString("Dta_Nascimento"));
					aluno.setCpf(rs.getString("Cpf"));
					aluno.setEmail(rs.getString("Email"));
					aluno.setEndereco(rs.getString("Endereco"));
					aluno.setMunicipio(rs.getString("Municipio"));
					aluno.setUf(rs.getString("Uf"));
					aluno.setCelular(rs.getString("Celular"));
					aluno.setNome_Curso(rs.getString("Nome_Curso"));
					aluno.setCampus(rs.getString("Campus"));
					aluno.setPeriodo(rs.getString("Periodo"));
					
					return aluno; 
					
				}else {
					return null;
					
				}
					
			}catch(Exception e) {
				throw new Exception("Erro ao consultar. Tente novamente.");
			}
		}
}

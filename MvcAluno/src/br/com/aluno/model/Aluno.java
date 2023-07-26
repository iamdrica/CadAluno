package br.com.aluno.model;

public class Aluno {

	// Atributos
	
	private int rgm;
	private String Nome;
	private String Dta_Nascimento;
	private String Cpf;
	private String Email;
	private String Endereco;
	private String Municipio;
	private String Uf;
	private String Celular;
	private String Nome_Curso;
	private String Campus;
	private String Periodo;
	
	// Construtor padrao, vazio
	public Aluno() {
	}
	//construtor com campos

	public Aluno(int rgm, String nome, String dta_Nascimento, String cpf, String email, String endereco,
			String municipio, String uf, String celular, String nome_Curso, String campus, String periodo) {
		super();
		rgm = rgm;
		Nome = nome;
		Dta_Nascimento = dta_Nascimento;
		Cpf = cpf;
		Email = email;
		Endereco = endereco;
		Municipio = municipio;
		Uf = uf;
		Celular = celular;
		Nome_Curso = nome_Curso;
		Campus = campus;
		Periodo = periodo;
	}

	//gerar getters e setters
	
	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getDta_Nascimento() {
		return Dta_Nascimento;
	}

	public void setDta_Nascimento(String dta_Nascimento) {
		this.Dta_Nascimento = dta_Nascimento;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		this.Cpf = cpf;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		this.Endereco = endereco;
	}

	public String getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(String municipio) {
		this.Municipio = municipio;
	}

	public String getUf() {
		return Uf;
	}

	public void setUf(String uf) {
		this.Uf = uf;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		this.Celular = celular;
	}

	public String getNome_Curso() {
		return Nome_Curso;
	}

	public void setNome_Curso(String nome_Curso) {
		this.Nome_Curso = nome_Curso;
	}

	public String getCampus() {
		return Campus;
	}

	public void setCampus(String campus) {
		this.Campus = campus;
	}

	public String getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}

}

package br.com.aluno.model;

public class Boletim {
	
	//Atributos
	
	private int Cod_Disciplina;
	private String Nome_Disciplina;
	private String Nota;
	private String Semestre;
	private int Faltas;
	private int rgm;
	
	//Contrutor padrão vazio
	
	public Boletim () {
		
	}

	// Construtor com campos
	
	public Boletim (int cod_disciplina,String nome_disciplina,String nota,String semestre,int faltas,int rgm) {
		
		Cod_Disciplina = cod_disciplina;
		Nome_Disciplina = nome_disciplina;
		Nota = nota;
		Semestre = semestre;
		Faltas = faltas;
		
		//Gerar getters e setters		
	}

	public int getCod_Disciplina() {
		return Cod_Disciplina;
	}

	public void setCod_Disciplina(int cod_Disciplina) {
		this.Cod_Disciplina = cod_Disciplina;
	}

	public String getNome_Disciplina() {
		return Nome_Disciplina;
	}

	public void setNome_Disciplina(String Nome_Disciplina) {
		this.Nome_Disciplina = Nome_Disciplina;
	}

	public String getNota() {
		return Nota;
	}

	public void setNota(String nota) {
		this.Nota = nota;
	}

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(String semestre) {
		this.Semestre = semestre;
	}

	public int getFaltas() {
		return Faltas;
	}

	public void setFaltas(int faltas) {
		this.Faltas = faltas;
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}
}

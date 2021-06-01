package prjFinal.model;

public class Empregado {

	private int codigoEmpregado;
	private String nomeEmpregado;
	private String setor;
	private double SalarioBruto;
	private double recInss;
	
	public Empregado() {
		// TODO Auto-generated constructor stub
	}

	public Empregado(int cod, String nome, String setor, Double salario) {
		this.codigoEmpregado = cod;
		this.nomeEmpregado = nome;
		this.setor = setor;
		this.SalarioBruto = salario;
	}
	
	public int getCodigoEmpregado() {
		return codigoEmpregado;
	}

	public void setCodigoEmpregado(int codigoEmpregado) {
		this.codigoEmpregado = codigoEmpregado;
	}

	public String getNomeEmpregado() {
		return nomeEmpregado;
	}

	public void setNomeEmpregado(String nomeEmpregado) {
		this.nomeEmpregado = nomeEmpregado;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public double getSalarioBruto() {
		return SalarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		SalarioBruto = salarioBruto;
	}

	public double getRecInss() {
		return recInss;
	}

	public void setRecInss(double recInss) {
		this.recInss = recInss;
	}
	
	

}

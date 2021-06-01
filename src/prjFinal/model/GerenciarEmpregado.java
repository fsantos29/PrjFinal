package prjFinal.model;

import java.util.ArrayList;
import java.util.List;

import prjFinal.model.Empregado;

public class GerenciarEmpregado {
	
	public static List<Empregado> listaEmpregados;
	
	public GerenciarEmpregado() {
		this.listaEmpregados = new ArrayList<Empregado>();
	}
	
	public void adicionarEmpregado(Empregado empregado) {
		this.listaEmpregados.add(empregado);
	}
	
	public List<Empregado> adicionarEmpregado() {
		return this.listaEmpregados;
	}
	
	public void removerEmpregado(Empregado empregado) {
		this.listaEmpregados.remove(empregado);
	}
	
	public boolean verificarExistencia(Empregado empregado) {
		for (Empregado emp : listaEmpregados) {
			if(emp.getNomeEmpregado().equals(empregado.getNomeEmpregado()) &&
				emp.getCodigoEmpregado() == empregado.getCodigoEmpregado()	&&
				emp.getSetor().equals(empregado.getSetor()) &&
				emp.getSalarioBruto() == empregado.getSalarioBruto())
				return true;
		}
		return false;//this.listaEmpregados.contains(empregado);//TODO
	}
}

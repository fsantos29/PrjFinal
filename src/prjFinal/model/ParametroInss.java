package prjFinal.model;

public class ParametroInss {

	public static final double FAIXA1 = 0.075;
	public static final double LIMITEFAIXA1 = 1100.0;
	public static final double FAIXA2 = 0.09;
	public static final double LIMITEFAIXA2 = 2203.48;
	public static final double FAIXA3 = 0.12;
	public static final double LIMITEFAIXA3 = 3300.22;
	public static final double FAIXA4 = 0.14;
	public static final double LIMITEFAIXA4 = 6433.57;
	
	public double calcularInss(double salario) {
		double recInss = 0;
		
		recInss = LIMITEFAIXA1 * FAIXA1; //Faixa 1
		
		if(salario > LIMITEFAIXA1) { //Faixa 2
			if(salario < LIMITEFAIXA2) { 
				recInss += (salario - LIMITEFAIXA1) * FAIXA2;
			} else {
				recInss += (LIMITEFAIXA2 - LIMITEFAIXA1) * FAIXA2;
			}
		}
			
		if(salario > LIMITEFAIXA2) { //Faixa 3
			if(salario < LIMITEFAIXA3) { 
				recInss += (salario - LIMITEFAIXA2) * FAIXA3;
			} else {
				recInss += (LIMITEFAIXA3 - LIMITEFAIXA2) * FAIXA3;
			}
		}
		
		if(salario > LIMITEFAIXA3) { //Faixa 4
			if(salario < LIMITEFAIXA4) { 
				recInss += (salario - LIMITEFAIXA3) * FAIXA4;
			} else {
				recInss += (LIMITEFAIXA4 - LIMITEFAIXA3) * FAIXA4;
			}
		}	
		
		return recInss;
	}

}

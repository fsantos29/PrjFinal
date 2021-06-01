package prjFinal.view;


import prjFinal.model.Empregado;
import prjFinal.model.GerenciarEmpregado;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class GerenciarEmpregadosGUI extends JFrame {

	private JPanel contentPane;
	private GerenciarEmpregado ge;
	private JTable tabela;

	public GerenciarEmpregadosGUI() {
		setTitle("Gerenciar Empregados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		DecimalFormat df = new DecimalFormat("R$ #,##0.00");
		Object colunas[] = { "Código", "Nome", "Setor", "Salário", "Recolhimento" };
		Object listEmp[][] = new Object [ge.listaEmpregados.size()][5];
		int index = 0;
		for (Empregado emp : ge.listaEmpregados) {
			listEmp[index][0] = emp.getCodigoEmpregado();
			listEmp[index][1] = emp.getNomeEmpregado();
			listEmp[index][2] = emp.getSetor();
			listEmp[index][3] = df.format(emp.getSalarioBruto());
			listEmp[index][4] = df.format(emp.getRecInss());
			  index++;
		}
		tabela = new JTable(listEmp,colunas);
		scrollPane.setViewportView(tabela);
	}

}

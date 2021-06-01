package prjFinal;

import java.awt.EventQueue;
import prjFinal.view.EmpregadoGUI;

public class GerenciarPrograma {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpregadoGUI frame = new EmpregadoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

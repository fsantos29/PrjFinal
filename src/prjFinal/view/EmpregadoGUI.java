package prjFinal.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;

import prjFinal.model.Empregado;
import prjFinal.model.GerenciarEmpregado;
import prjFinal.model.ParametroInss;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class EmpregadoGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblValRecolhimento;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtSetor;
	private JTextField txtSalario;
	
	public Empregado e;
	public GerenciarEmpregado ge;
	


	
	private void limparFormulario() {
		lblValRecolhimento.setText("R$ ");
		txtCodigo.setText(null);
		txtNome.setText(null);
		txtSetor.setText(null);
		txtSalario.setText(null);
	}

	public EmpregadoGUI() {
		
		this.ge = new GerenciarEmpregado();
			
		setTitle("Cadastro de Empregados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo do Empregado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		JLabel lblNomeDoEmpregado = new JLabel("Nome do Empregado");
		lblNomeDoEmpregado.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtSetor = new JTextField();
		txtSetor.setColumns(10);
		
		JLabel lblSalrioBruto = new JLabel("Sal\u00E1rio Bruto");
		lblSalrioBruto.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		
		lblValRecolhimento = new JLabel("R$");
		lblValRecolhimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if(btnCadastrar.isEnabled()) {
					try {
						if(ge.verificarExistencia(e))
							throw new Exception("Empregado já cadastrado!"); 
						ge.adicionarEmpregado(e);
						limparFormulario();
						JOptionPane.showMessageDialog(
								null, "Empregado Cadastrado!", "Sucesso!",
								JOptionPane.INFORMATION_MESSAGE);
					} catch(Exception ex) {
						limparFormulario();
						JOptionPane.showMessageDialog(
								null, ex.getMessage(), "Erro!",
								JOptionPane.ERROR_MESSAGE);
					} finally {
						btnCadastrar.setEnabled(false);
					}	
				}
			}
		});
		
		JButton btnNewButton = new JButton("Calcular Recolhimento INSS");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				try {
					if((txtCodigo.getText().length()>0)
							&& (txtNome.getText().length()>0)
							&& (txtSetor.getText().length()>0)
							&& (txtSalario.getText().length()>0)) {
						int cod = Integer.parseInt(txtCodigo.getText());
						String nome = txtNome.getText();
						String setor = txtSetor.getText();
						Double sal_bruto = Double.parseDouble(txtSalario.getText());
						
						e = new Empregado(cod, nome, setor, sal_bruto);
						double rec_inss = new ParametroInss().calcularInss(sal_bruto);
						e.setRecInss(rec_inss);
						
						
						DecimalFormat df = new DecimalFormat("R$ #,##0.00");
						lblValRecolhimento.setText(df.format(rec_inss));
						
						btnCadastrar.setEnabled(true);
					} else {
						throw new Exception("Verifique os campos informados!"); 
					}					
				} catch(Exception ex) {
					btnCadastrar.setEnabled(false);
					JOptionPane.showMessageDialog(
							null, ex.getMessage(), "Erro!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnApresentarEmpregados = new JButton("Apresentar Empregados");
		btnApresentarEmpregados.setFont(new Font("Tahoma", Font.BOLD, 12));	
		btnApresentarEmpregados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				try {
					GerenciarEmpregadosGUI frame = new GerenciarEmpregadosGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblRecolhimento = new JLabel("Recolhimento:");
		lblRecolhimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//alinhamento do layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNomeDoEmpregado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblSetor, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalrioBruto, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRecolhimento))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnApresentarEmpregados, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(txtNome, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(txtCodigo, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(txtSetor, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(txtSalario, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(lblValRecolhimento, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNomeDoEmpregado)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(lblSetor))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtSetor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblSalrioBruto))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(txtSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRecolhimento)
						.addComponent(lblValRecolhimento))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnApresentarEmpregados, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

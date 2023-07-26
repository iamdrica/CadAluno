package br.com.aluno.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.aluno.dao.AlunoDAO;
import br.com.aluno.dao.BoletimDAO;
import br.com.aluno.model.Aluno;
import br.com.aluno.model.Boletim;
import javax.swing.JTextArea;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem MenuItemSalvarN;
	private JMenuItem MenuItemAlterarN;
	private JMenuItem MenuItemExcluirN;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JSeparator separator;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblRgm;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNome;
	private JLabel lblDataDeNascimento;
	private JLabel lblCpf;
	private JLabel lblEmail;
	private JLabel lblEndereco;
	private JLabel lblMunicipio;
	private JLabel lblUf;
	private JLabel lblCelular;
	private JTextField txtRgm;
	private JComboBox cmbUf;
	private JFormattedTextField txtData;
	private JFormattedTextField txtCelular;
	private JFormattedTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtMunicipio;
	private JLabel lblNewLabel;
	private JLabel lblCampus;
	private JLabel lblPeriodo;
	private JComboBox cmbCurso;
	private JComboBox cmbCampus;
	private JRadioButton rdbtnMatutino;
	private JRadioButton rdbtnVespertino;
	private JRadioButton rdbtnNoturno;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private Aluno aluno;
	private AlunoDAO dao;
	private JLabel lblNewLabel_1;
	private JTextField txtRgmNF;
	private JTextField txtNomeNF;
	private JTextField txtCursoNf;
	private JLabel lblNewLabel_2;
	private JComboBox cmbDisciplina;
	private JLabel lblNewLabel_3;
	private JComboBox cmbSemestre;
	private JLabel lblNewLabel_4;
	private JComboBox cmbNotas;
	private JLabel lblNewLabel_5;
	private JTextField txtFaltas;
	private JButton btnNovoNf;
	private JButton btnSalvarNf;
	private JButton btnConsultarNf;
	private JButton btnAlterarNf;
	private JButton btnExcluirNf;
	private JLabel lblNewLabel_6;
	private JTextField txtRGMB;
	private JTextField txtAlunoB;
	private JTextField txtCursoB;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JButton btnConsultarNf_1;
	private JButton btnLimparNf_1;
	private JTextField txtNome;
	private TextArea txtListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/veio botao/Botao TelaP copiar.png"));
		setTitle("CadAluno - Universidade Cidade de São Paulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 434);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Alunos");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//======
				
				aluno = new Aluno();
				aluno.setRgm(Integer.parseInt(txtRgm.getText()));
				aluno.setNome(txtNome.getText());
				aluno.setDta_Nascimento(txtData.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setMunicipio(txtMunicipio.getText());
				aluno.setUf((String) cmbUf.getSelectedItem());
				aluno.setCelular(txtCelular.getText());
				aluno.setNome_Curso((String) cmbCurso.getSelectedItem());
				aluno.setCampus((String) cmbCampus.getSelectedItem());
				
				boolean isMatutinoSelected = rdbtnMatutino.isSelected();
				boolean isVespertinoSelected = rdbtnVespertino.isSelected();
				boolean isNoturnoSelected = rdbtnNoturno.isSelected();
					if(isMatutinoSelected) {
					aluno.setPeriodo("Matutino");
					} else if (isVespertinoSelected) {
					aluno.setPeriodo("Vespertino");
					} else if (isNoturnoSelected) {
					aluno.setPeriodo("Noturno");	
					}else {
						JOptionPane.showMessageDialog(null,"Obrigatório inserir um período");		
					}
				
				// Abrir o BD
				try {
					AlunoDAO dao = new AlunoDAO();
					// Chama o metodo salvar
					dao.salvar(aluno);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");				
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar. Tente novamente.");
				}
				
				//======	
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//======
				try {
				    int rgm = Integer.parseInt(txtRgm.getText());
				    AlunoDAO dao = new AlunoDAO();        
				    Aluno aluno = dao.consultar(rgm);
				    if(aluno==null) {
				        JOptionPane.showMessageDialog(null, "Aluno não encontrado");
				    } else {
				        txtNome.setText(aluno.getNome());
				        txtData.setText(aluno.getDta_Nascimento());
				        txtCpf.setText(aluno.getCpf());
				        txtEmail.setText(aluno.getEmail());
				        txtEndereco.setText(aluno.getEndereco());
				        txtMunicipio.setText(aluno.getMunicipio());
				        cmbUf.setSelectedItem(aluno.getUf());
				        txtCelular.setText(aluno.getCelular());
				        cmbCurso.setSelectedItem(aluno.getNome_Curso());
				        cmbCampus.setSelectedItem(aluno.getCampus());
				        
				        String Periodo = aluno.getPeriodo();
				        if (aluno.getPeriodo().equals("Matutino")) {
				            rdbtnMatutino.setSelected(true);
				        } else if (aluno.getPeriodo().equals("Vespertino")) {
				            rdbtnVespertino.setSelected(true);
				        } else if (aluno.getPeriodo().equals("Noturno")) {
				            rdbtnNoturno.setSelected(true);
				        }
				    }
				} catch(Exception e1) {
				    JOptionPane.showMessageDialog(null, "Erro ao consultar. Tente novamente.");
				}

				
				//======

			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//======
				try {
				    int rgm = Integer.parseInt(txtRgm.getText());
				    AlunoDAO dao = new AlunoDAO();        
				    Aluno aluno = dao.consultar(rgm);
				    if(aluno==null) {
				        JOptionPane.showMessageDialog(null, "Aluno não encontrado. Faça o cadastro novamente.");
				    } else {
				        txtNome.setText(aluno.getNome());
				        txtData.setText(aluno.getDta_Nascimento());
				        txtCpf.setText(aluno.getCpf());
				        txtEmail.setText(aluno.getEmail());
				        txtEndereco.setText(aluno.getEndereco());
				        txtMunicipio.setText(aluno.getMunicipio());
				        cmbUf.setSelectedItem(aluno.getUf());
				        txtCelular.setText(aluno.getCelular());
				        cmbCurso.setSelectedItem(aluno.getNome_Curso());
				        cmbCampus.setSelectedItem(aluno.getCampus());
				        
				        String Periodo = aluno.getPeriodo();
				        if (aluno.getPeriodo().equals("Matutino")) {
				            rdbtnMatutino.setSelected(true);
				        } else if (aluno.getPeriodo().equals("Vespertino")) {
				            rdbtnVespertino.setSelected(true);
				        } else if (aluno.getPeriodo().equals("Noturno")) {
				            rdbtnNoturno.setSelected(true);
				        }
				    }
				} catch(Exception e1) {
				    JOptionPane.showMessageDialog(null, "Erro ao consultar. Tente novamente.");
				}

				//======
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Excluir");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//====
				
				// Abrir o BD
				try {
					AlunoDAO dao = new AlunoDAO();
					// Chama o metodo excluir
					dao.excluir(Integer.parseInt(txtRgm.getText()));
					JOptionPane.showMessageDialog(null, "Excluído com Sucesso");				
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir. Tente novamente.");
				}
				//====
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		separator = new JSeparator();
		mnNewMenu.add(separator);
		
		mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		mnNewMenu_1 = new JMenu("Notas e Faltas");
		menuBar.add(mnNewMenu_1);
		
		MenuItemSalvarN = new JMenuItem("Salvar");
		MenuItemSalvarN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==
				
				
				Boletim boletim = new Boletim();
				
				boletim.setNome_Disciplina(cmbDisciplina.getSelectedItem().toString());
				boletim.setSemestre(cmbSemestre.getSelectedItem().toString());
				boletim.setNota(cmbNotas.getSelectedItem().toString());
				boletim.setFaltas(Integer.parseInt(txtFaltas.getText()));
				boletim.setRgm(Integer.parseInt(txtRgmNF.getText()));
		
				//Abrir o Database;
				try {
					BoletimDAO dao = new BoletimDAO();
					//Chama o metodo para salvar os dados:
					dao.salvar(boletim);
					JOptionPane.showMessageDialog(null, "Boletim salvo com Sucesso!");
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao salvar. Tente novamente.");
				}
				
			
				//==
			
			}
		});
		mnNewMenu_1.add(MenuItemSalvarN);
		
		MenuItemAlterarN = new JMenuItem("Alterar");
		MenuItemAlterarN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=====
				
				Boletim boletim = new Boletim();

				boletim.setNome_Disciplina(cmbDisciplina.getSelectedItem().toString());
				boletim.setSemestre(cmbSemestre.getSelectedItem().toString());
				boletim.setNota(cmbNotas.getSelectedItem().toString());
				boletim.setFaltas(Integer.parseInt(txtFaltas.getText()));
				boletim.setRgm(Integer.parseInt(txtRgmNF.getText()));

				try {
					BoletimDAO dao = new BoletimDAO();
					dao.alterar(boletim);
					JOptionPane.showMessageDialog(null,"Alterado com sucesso");
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao alterar.Tente novamente.");
				}
				
				//=====
			}
		});
		MenuItemAlterarN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_1.add(MenuItemAlterarN);
		
		MenuItemExcluirN = new JMenuItem("Excluir");
		MenuItemExcluirN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				// Abrir o BD
				try {
					BoletimDAO dao = new BoletimDAO();
					// excluir
					String Nome_Disciplina = (cmbDisciplina.getSelectedItem().toString());
					dao.excluir(Nome_Disciplina);
					JOptionPane.showMessageDialog(null, "Excluído com Sucesso");				
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao excluir. Tente novamente.");
				}
				
				
				//====
				
			}
		});
		mnNewMenu_1.add(MenuItemExcluirN);
		
		mntmNewMenuItem_8 = new JMenuItem("Consultar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//====				
				//Abrir o Database;
				try {
					
					String Nome_Disciplina = (cmbDisciplina.getSelectedItem().toString());
					int Rgm = (Integer.parseInt(txtRgmNF.getText()));
					BoletimDAO dao = new BoletimDAO();
					Boletim boletim = dao.consultar(Nome_Disciplina, Rgm);
					
					
					cmbNotas.setSelectedItem(boletim.getNota());
					cmbSemestre.setSelectedItem(boletim.getSemestre());
					txtFaltas.setText(String.valueOf(boletim.getFaltas()));
					
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar.Tente novamente");
				}
				
				//====
				
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		mnNewMenu_2 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_9 = new JMenuItem("Sobre");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//===
				
				JOptionPane.showMessageDialog(null, "Acesse nosso site para mais informações: www.unicid.com");
				
				//===
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(18, 22, 611, 333);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		panel.setFont(new Font("Arial", Font.PLAIN, 20));
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Arial", Font.PLAIN, 21));
		lblRgm.setBounds(5, 25, 48, 25);
		panel.add(lblRgm);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNome.setBounds(210, 25, 56, 25);
		panel.add(lblNome);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 21));
		lblDataDeNascimento.setBounds(5, 83, 194, 25);
		panel.add(lblDataDeNascimento);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 21));
		lblCpf.setBounds(373, 83, 42, 25);
		panel.add(lblCpf);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 21));
		lblEmail.setBounds(5, 134, 53, 25);
		panel.add(lblEmail);
		
		lblEndereco = new JLabel("End.");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 21));
		lblEndereco.setBounds(5, 185, 44, 25);
		panel.add(lblEndereco);
		
		lblMunicipio = new JLabel("Município");
		lblMunicipio.setFont(new Font("Arial", Font.PLAIN, 21));
		lblMunicipio.setBounds(5, 228, 92, 25);
		panel.add(lblMunicipio);
		
		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 21));
		lblUf.setBounds(253, 228, 28, 25);
		panel.add(lblUf);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 21));
		lblCelular.setBounds(367, 228, 68, 25);
		panel.add(lblCelular);
		
		txtRgm = new JTextField();
		txtRgm.setFont(new Font("Arial", Font.PLAIN, 15));
		txtRgm.setBounds(57, 16, 146, 42);
		panel.add(txtRgm);
		txtRgm.setColumns(10);
		
		cmbUf = new JComboBox();
		cmbUf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		cmbUf.setModel(new DefaultComboBoxModel(new String[] {"", "SP ", "AC ", "AL ", "AP ", "AM ", "BA ", "CE ", "DF ", "ES ", "GO ", "MA ", "MT ", "MS ", "MG ", "PA ", "PB ", "PR ", "PE ", "PI ", "RJ ", "RN ", "RS ", "RO ", "RR ", "SC ", "SE ", "TO"}));
		cmbUf.setActionCommand("");
		cmbUf.setFont(new Font("Arial", Font.PLAIN, 13));
		cmbUf.setBounds(278, 227, 87, 27);
		panel.add(cmbUf);
		
		txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtData.setFont(new Font("Arial", Font.PLAIN, 15));
		txtData.setBounds(205, 74, 156, 43);
		panel.add(txtData);
		
		txtCelular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		txtCelular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		txtCelular.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCelular.setBounds(437, 219, 146, 42);
		panel.add(txtCelular);
		
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCpf.setBounds(417, 74, 165, 43);
		panel.add(txtCpf);
	
		
		txtEmail = new JTextField();
		txtEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(64, 125, 521, 42);
		panel.add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(61, 176, 521, 42);
		panel.add(txtEndereco);
		
		txtMunicipio = new JTextField();
		txtMunicipio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		txtMunicipio.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(98, 219, 156, 42);
		panel.add(txtMunicipio);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNome.setColumns(10);
		txtNome.setBounds(269, 16, 313, 42);
		panel.add(txtNome);
		
		panel_1 = new JPanel();
		panel_1.setFont(new Font("Arial", Font.PLAIN, 21));
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Curso");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel.setBounds(23, 26, 61, 16);
		panel_1.add(lblNewLabel);
		
		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Arial", Font.PLAIN, 21));
		lblCampus.setBounds(23, 70, 79, 25);
		panel_1.add(lblCampus);
		
		lblPeriodo = new JLabel("Período");
		lblPeriodo.setFont(new Font("Arial", Font.PLAIN, 21));
		lblPeriodo.setBounds(23, 124, 79, 25);
		panel_1.add(lblPeriodo);
		
		cmbCurso = new JComboBox();
		cmbCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
			}
		});
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"", "Análise e Desenvolvimento de Sistema", "Publicidade e Propaganda", "Direito", "Administração", "Enfermagem"}));
		cmbCurso.setFont(new Font("Arial", Font.PLAIN, 15));
		cmbCurso.setBounds(113, 21, 460, 27);
		panel_1.add(cmbCurso);
		
		cmbCampus = new JComboBox();
		cmbCampus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"", "Tatuapé", "Anália Franco", "Centro", "Planalto", "Rio Vermelho", "Barra "}));
		cmbCampus.setFont(new Font("Arial", Font.PLAIN, 15));
		cmbCampus.setBounds(113, 69, 460, 27);
		panel_1.add(cmbCampus);
		
		rdbtnMatutino = new JRadioButton("Matutino");
		rdbtnMatutino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//====
				// Para ao ticar em uma das opções as outras destiquem;
				
				rdbtnVespertino.setSelected(false);
				rdbtnNoturno.setSelected(false);
					
				boolean isMatutinoSelected = rdbtnMatutino.isSelected();
				
				//======
				
			}
		});
		rdbtnMatutino.setFont(new Font("Arial", Font.PLAIN, 21));
		rdbtnMatutino.setBounds(120, 126, 141, 23);
		panel_1.add(rdbtnMatutino);
		
		rdbtnVespertino = new JRadioButton("Vespertino");
		rdbtnVespertino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=======
				
				// Para ao ticar em uma das opções as outras destiquem;
				
				rdbtnMatutino.setSelected(false);
				rdbtnNoturno.setSelected(false);
				
				boolean isVespertinoSelected = rdbtnVespertino.isSelected();
				
			//=====
				
			}
		});
		rdbtnVespertino.setFont(new Font("Arial", Font.PLAIN, 21));
		rdbtnVespertino.setBounds(262, 126, 141, 23);
		panel_1.add(rdbtnVespertino);
		
		rdbtnNoturno = new JRadioButton("Noturno");
		rdbtnNoturno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=====
				// Para ao ticar em uma das opções as outras destiquem;
				
				rdbtnVespertino.setSelected(false);
				rdbtnMatutino.setSelected(false);
				
				boolean isNoturnoSelected = rdbtnNoturno.isSelected();
				
				//======
			}
		});
		rdbtnNoturno.setFont(new Font("Arial", Font.PLAIN, 21));
		rdbtnNoturno.setBounds(415, 126, 141, 23);
		panel_1.add(rdbtnNoturno);
		
		btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-01.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=== Limpar a tela pelo botao novo na aba curso;
			
				txtRgm.setText(null);
				txtNome.setText(null);
				txtData.setText(null);
				txtCpf.setText(null);
				txtEmail.setText(null);
				txtEndereco.setText(null);
				txtMunicipio.setText(null);
				cmbUf.setSelectedIndex(0);
				txtCelular.setText(null);
				cmbCurso.setSelectedIndex(0);
				cmbCampus.setSelectedIndex(0);
				rdbtnMatutino.setSelected(false);
				rdbtnVespertino.setSelected(false);
				rdbtnNoturno.setSelected(false);
				
				//==================
			}
		});
		btnNovo.setBounds(17, 194, 102, 78);
		panel_1.add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-02.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//======
				
				aluno = new Aluno();
				aluno.setRgm(Integer.parseInt(txtRgm.getText()));
				aluno.setNome(txtNome.getText());
				aluno.setDta_Nascimento(txtData.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setMunicipio(txtMunicipio.getText());
				aluno.setUf((String) cmbUf.getSelectedItem());
				aluno.setCelular(txtCelular.getText());
				aluno.setNome_Curso((String) cmbCurso.getSelectedItem());
				aluno.setCampus((String) cmbCampus.getSelectedItem());
				
				boolean isMatutinoSelected = rdbtnMatutino.isSelected();
				boolean isVespertinoSelected = rdbtnVespertino.isSelected();
				boolean isNoturnoSelected = rdbtnNoturno.isSelected();
					if(isMatutinoSelected) {
					aluno.setPeriodo("Matutino");
					} else if (isVespertinoSelected) {
					aluno.setPeriodo("Vespertino");
					} else if (isNoturnoSelected) {
					aluno.setPeriodo("Noturno");	
					}else {
						JOptionPane.showMessageDialog(null,"Obrigatório inserir um período");		
					}
				
				// Abrir o BD
				try {
					AlunoDAO dao = new AlunoDAO();
					// Chama o metodo salvar
					dao.salvar(aluno);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");				
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar. Tente novamente.");
				}
				
				//======
			}
		});
		btnSalvar.setBounds(128, 192, 105, 80);
		panel_1.add(btnSalvar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-04.png"));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//======
				try {
				    int rgm = Integer.parseInt(txtRgm.getText());
				    AlunoDAO dao = new AlunoDAO();        
				    Aluno aluno = dao.consultar(rgm);
				    if(aluno==null) {
				        JOptionPane.showMessageDialog(null, "Aluno não encontrado");
				    } else {
				        txtNome.setText(aluno.getNome());
				        txtData.setText(aluno.getDta_Nascimento());
				        txtCpf.setText(aluno.getCpf());
				        txtEmail.setText(aluno.getEmail());
				        txtEndereco.setText(aluno.getEndereco());
				        txtMunicipio.setText(aluno.getMunicipio());
				        cmbUf.setSelectedItem(aluno.getUf());
				        txtCelular.setText(aluno.getCelular());
				        cmbCurso.setSelectedItem(aluno.getNome_Curso());
				        cmbCampus.setSelectedItem(aluno.getCampus());
				        
				        String Periodo = aluno.getPeriodo();
				        if (aluno.getPeriodo().equals("Matutino")) {
				            rdbtnMatutino.setSelected(true);
				        } else if (aluno.getPeriodo().equals("Vespertino")) {
				            rdbtnVespertino.setSelected(true);
				        } else if (aluno.getPeriodo().equals("Noturno")) {
				            rdbtnNoturno.setSelected(true);
				        }
				    }
				} catch(Exception e1) {
				    JOptionPane.showMessageDialog(null, "Erro ao consultar. Tente novamente.");
				}

				
				//======
			}
		});
		btnConsultar.setBounds(243, 192, 105, 80);
		panel_1.add(btnConsultar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-05.png"));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//===========
	
				aluno = new Aluno();
				aluno.setRgm(Integer.parseInt(txtRgm.getText()));
				aluno.setNome(txtNome.getText());
				aluno.setDta_Nascimento(txtData.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setMunicipio(txtMunicipio.getText());
				aluno.setUf((String) cmbUf.getSelectedItem());
				aluno.setCelular(txtCelular.getText());
				aluno.setNome_Curso((String) cmbCurso.getSelectedItem());
				aluno.setCampus((String) cmbCampus.getSelectedItem());
				
						
				boolean isMatutinoSelected = rdbtnMatutino.isSelected();
				boolean isVespertinoSelected = rdbtnVespertino.isSelected();
				boolean isNoturnoSelected = rdbtnNoturno.isSelected();
					if(isMatutinoSelected) {
					aluno.setPeriodo("Matutino");
					} else if (isVespertinoSelected) {
					aluno.setPeriodo("Vespertino");
					} else if (isNoturnoSelected) {
					aluno.setPeriodo("Noturno");	
					}else {
						JOptionPane.showMessageDialog(null,"Obrigatório inserir um período");		
					}
				
				
				// Abrir o BD
				try {
					AlunoDAO dao = new AlunoDAO();
					// Chama o metodo alterar
					dao.alterar(aluno);
					JOptionPane.showMessageDialog(null, "Alterado com Sucesso");				
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro al alterar. Tente novamente.");
				}
				
				//======	
			}
		});
		btnAlterar.setBounds(356, 192, 105, 80);
		panel_1.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-03.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====
			
				// Abrir o BD
				try {
					AlunoDAO dao = new AlunoDAO();
					// Chama o medoto excluir
					dao.excluir(Integer.parseInt(txtRgm.getText()));
					JOptionPane.showMessageDialog(null, "Excluído com Sucesso");				
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao excluir. Tente novamente.");
				}
				
				
				//====
			}
		});
		btnExcluir.setBounds(467, 192, 105, 80);
		panel_1.add(btnExcluir);
		
		panel_2 = new JPanel();
		panel_2.setFont(new Font("Arial", Font.PLAIN, 21));
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("RGM");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(7, 22, 48, 25);
		panel_2.add(lblNewLabel_1);
		
		txtRgmNF = new JTextField();
		txtRgmNF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=======
				//Adicionar o metodo consulta no text field do rgm aba curso
				
				try {
				    int rgm = Integer.parseInt(txtRgmNF.getText());
				    //aluno.setNome_Curso((String) cmbCurso.getSelectedItem());
				    AlunoDAO dao = new AlunoDAO();        
				    Aluno aluno = dao.consultar(rgm);
				    if(aluno==null) {
				        JOptionPane.showMessageDialog(null, "Aluno não encontrado");
				    } else {
				       txtNomeNF.setText(aluno.getNome());
				       txtCursoNf.setText(aluno.getNome_Curso().toString());
					
				    }
					}catch(Exception e1) {
					    JOptionPane.showMessageDialog(null, e1.getMessage());
				
				
				//=======
			}
			}
		});
		txtRgmNF.setBounds(67, 17, 147, 34);
		panel_2.add(txtRgmNF);
		txtRgmNF.setColumns(10);
		
		txtNomeNF = new JTextField();
		txtNomeNF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=======
			
				//=======
			}
		});
		txtNomeNF.setColumns(10);
		txtNomeNF.setBounds(226, 17, 356, 34);
		panel_2.add(txtNomeNF);
		
		txtCursoNf = new JTextField();
		txtCursoNf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=======
				
				//=======
			}
		});
		txtCursoNf.setColumns(10);
		txtCursoNf.setBounds(6, 60, 575, 34);
		panel_2.add(txtCursoNf);
		
		lblNewLabel_2 = new JLabel("Disciplina");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(6, 111, 93, 25);
		panel_2.add(lblNewLabel_2);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setModel(new DefaultComboBoxModel(new String[] {"Seleciona a disciplina", "Técnicas de Programação", "Programação Orientada a Objetos", "Pesquisa de mercado", "Mídias Sociais", "Direito Trabalhista", "Direito Penal", "Matemática I", "Matemática II", "Anatomia I", "Anatomia II", "", ""}));
		cmbDisciplina.setBounds(111, 102, 473, 43);
		panel_2.add(cmbDisciplina);
		
		lblNewLabel_3 = new JLabel("Semestre");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_3.setBounds(6, 157, 91, 25);
		panel_2.add(lblNewLabel_3);
		
		cmbSemestre = new JComboBox();
		cmbSemestre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"", "2023-1", "2023-2", "2023-3", "2023-4", "2023-5", "2023-6", "2023-7", "2023-8"}));
		cmbSemestre.setBounds(97, 148, 168, 43);
		panel_2.add(cmbSemestre);
		
		lblNewLabel_4 = new JLabel("Notas");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(266, 157, 56, 25);
		panel_2.add(lblNewLabel_4);
		
		cmbNotas = new JComboBox();
		cmbNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cmbNotas.setModel(new DefaultComboBoxModel(new String[] {"", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0"}));
		cmbNotas.setBounds(318, 148, 93, 43);
		panel_2.add(cmbNotas);
		
		lblNewLabel_5 = new JLabel("Faltas");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_5.setBounds(410, 157, 59, 25);
		panel_2.add(lblNewLabel_5);
		
		txtFaltas = new JTextField();
		txtFaltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtFaltas.setColumns(10);
		txtFaltas.setBounds(473, 152, 111, 34);
		panel_2.add(txtFaltas);
		
		btnNovoNf = new JButton("Novo");
		btnNovoNf.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-01.png"));
		btnNovoNf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//===
				txtRgmNF.setText(null);
				txtNomeNF.setText(null);
				txtCursoNf.setText(null);
				cmbDisciplina.setSelectedIndex(0);
				cmbSemestre.setSelectedIndex(0);
				cmbNotas.setSelectedIndex(0);
				txtFaltas.setText(null);
		
			//====
				
			}
		});
		btnNovoNf.setBounds(17, 195, 105, 80);
		panel_2.add(btnNovoNf);
		
		btnSalvarNf = new JButton("Salvar");
		btnSalvarNf.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-02.png"));
		btnSalvarNf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===

				Boletim boletim = new Boletim();
				
				boletim.setNome_Disciplina(cmbDisciplina.getSelectedItem().toString());
				boletim.setSemestre(cmbSemestre.getSelectedItem().toString());
				boletim.setNota(cmbNotas.getSelectedItem().toString());
				boletim.setFaltas(Integer.parseInt(txtFaltas.getText()));
				boletim.setRgm(Integer.parseInt(txtRgmNF.getText()));
		
				//Abrir o Database;
				try {
					BoletimDAO dao = new BoletimDAO();
					//Chama o metodo para salvar os dados:
					dao.salvar(boletim);
					JOptionPane.showMessageDialog(null, "Boletim salvo com Sucesso!");
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao salvar. Tente novamente.");
				}
				
				//===
			}
			
		});
		btnSalvarNf.setBounds(131, 195, 105, 80);
		panel_2.add(btnSalvarNf);
		
		btnConsultarNf = new JButton("Consultar");
		btnConsultarNf.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-04.png"));
		btnConsultarNf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//====				
				//Abrir o Database;
				try {
					
					String Nome_Disciplina = (cmbDisciplina.getSelectedItem().toString());
					int Rgm = (Integer.parseInt(txtRgmNF.getText()));
					BoletimDAO dao = new BoletimDAO();
					Boletim boletim = dao.consultar(Nome_Disciplina, Rgm);
					
					
					cmbNotas.setSelectedItem(boletim.getNota());
					cmbSemestre.setSelectedItem(boletim.getSemestre());
					txtFaltas.setText(String.valueOf(boletim.getFaltas()));
					
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar.Tente novamente");
				}
				
				//====
			}
		});
		btnConsultarNf.setBounds(244, 195, 105, 80);
		panel_2.add(btnConsultarNf);
		
		btnAlterarNf = new JButton("Alterar");
		btnAlterarNf.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-05.png"));
		btnAlterarNf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=====
				
				Boletim boletim = new Boletim();

				boletim.setNome_Disciplina(cmbDisciplina.getSelectedItem().toString());
				boletim.setSemestre(cmbSemestre.getSelectedItem().toString());
				boletim.setNota(cmbNotas.getSelectedItem().toString());
				boletim.setFaltas(Integer.parseInt(txtFaltas.getText()));
				boletim.setRgm(Integer.parseInt(txtRgmNF.getText()));

				try {
					BoletimDAO dao = new BoletimDAO();
					dao.alterar(boletim);
					JOptionPane.showMessageDialog(null,"Alterado com sucesso");
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao alterar.Tente novamente.");
				}
				
			
				//=====
			
			}
		});
		btnAlterarNf.setBounds(357, 195, 105, 80);
		panel_2.add(btnAlterarNf);
		
		btnExcluirNf = new JButton("Excluir");
		btnExcluirNf.setIcon(new ImageIcon("/Users/milololol/Desktop/SEV/Drica/UNICID/2 semestre/tecnicas de programacao/MVC/novoooo-03.png"));
		btnExcluirNf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//====
				
				// Abrir o BD
				try {
					BoletimDAO dao = new BoletimDAO();
					// excluir
					String Nome_Disciplina = (cmbDisciplina.getSelectedItem().toString());
					dao.excluir(Nome_Disciplina);
					JOptionPane.showMessageDialog(null, "Excluído com Sucesso");				
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Erro ao excluir. Tente novamente.");
				}
				
				
				//====
				
			}
		});
		btnExcluirNf.setBounds(471, 195, 105, 80);
		panel_2.add(btnExcluirNf);
		
		panel_3 = new JPanel();
		panel_3.setFont(new Font("Arial", Font.PLAIN, 21));
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		lblNewLabel_6 = new JLabel("RGM");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_6.setBounds(10, 15, 48, 25);
		panel_3.add(lblNewLabel_6);
		
		txtRGMB = new JTextField();
		txtRGMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=======
				//adicionar o metodo consulta RGM Boletim Lista
				
				try {
				    int rgm = Integer.parseInt(txtRGMB.getText());
				    //aluno.setNome_Curso((String) cmbCurso.getSelectedItem());
				    AlunoDAO dao = new AlunoDAO();        
				    Aluno aluno = dao.consultar(rgm);
				    if(aluno==null) {
				        JOptionPane.showMessageDialog(null, "Aluno não encontrado");
				    } else {
				       txtAlunoB.setText(aluno.getNome());
				       txtCursoB.setText(aluno.getNome_Curso().toString());
					
				    }
					}catch(Exception e1) {
					    JOptionPane.showMessageDialog(null, e1.getMessage());
				
				
				//=======
					}
			}
		});
		txtRGMB.setColumns(10);
		txtRGMB.setBounds(72, 10, 218, 34);
		panel_3.add(txtRGMB);
		
		txtAlunoB = new JTextField();
		txtAlunoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=====
				
				//=====
			}
			
		});
		txtAlunoB.setColumns(10);
		txtAlunoB.setBounds(72, 51, 511, 34);
		panel_3.add(txtAlunoB);
		
		txtCursoB = new JTextField();
		txtCursoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//==
			}
		});
		txtCursoB.setColumns(10);
		txtCursoB.setBounds(72, 90, 511, 34);
		panel_3.add(txtCursoB);
		
		lblNewLabel_7 = new JLabel("Aluno");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_7.setBounds(8, 56, 55, 25);
		panel_3.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Curso");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_8.setBounds(9, 95, 57, 25);
		panel_3.add(lblNewLabel_8);
		
		btnConsultarNf_1 = new JButton("Consultar");
		btnConsultarNf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//====
				try {
					
					List<Boletim> lista = new ArrayList<Boletim>();
					int rgm = Integer.parseInt(txtRGMB.getText());
					BoletimDAO dao = new BoletimDAO();
					lista = dao.listarTodos(rgm);
					
					for(Boletim boletim: lista) {
						txtListar.append("Nome_Disciplina: "+boletim.getNome_Disciplina()+"\n");
						txtListar.append("Semestre: "+boletim.getSemestre()+"\n");
						txtListar.append("Nota: "+boletim.getNota()+"\n");
						txtListar.append("Faltas: "+boletim.getFaltas()+"\n\n");
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao listar. Tente novamente.");
				}
				
				//====
				
			}
		});
		btnConsultarNf_1.setBounds(341, 5, 105, 44);
		panel_3.add(btnConsultarNf_1);
		
		btnLimparNf_1 = new JButton("Limpar");
		btnLimparNf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=====
				txtRGMB.setText(null);
				txtAlunoB.setText(null);
				txtCursoB.setText(null);
				txtListar.setText(null);
				//=====
				
			}
		});
		btnLimparNf_1.setBounds(469, 5, 105, 45);
		panel_3.add(btnLimparNf_1);
		
		txtListar = new TextArea();
		txtListar.setFont(new Font("Arial", Font.ITALIC, 12));
		txtListar.setBackground(new Color(255, 255, 255));
		txtListar.setBounds(16, 125, 563, 151);
		panel_3.add(txtListar);
	}
}

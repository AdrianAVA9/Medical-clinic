package IU;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import Logica.Gestor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

public class ConsultarExpediente extends JFrame {

	private JPanel contentPane;
	private JTextField txtDatosBusqueda;
	private JTextField txtNunexpediente;
	private JTextField txtFecha;
	private JTextField txtNombrepaciente;
	private JLabel lblCedula;
	private JTextField txtCedula_1;
	private JLabel lblFechaNacimiento;
	private JTextField txtFechanacimiento;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JSeparator separator_1;
	private DefaultListModel<String> listModel;
	private JList<String>list;
	private JLabel lblConsultas;
	private JLabel lblFechaRealizacion;
	private JLabel lblDescripcion;
	private JLabel lblMedicinas;
	private JLabel lblDoctor;
	private JSeparator separator_2;
	private JLabel lblIdentificacion;
	private JLabel lblEspecialidad;
	private JLabel lblTelefono;
	private JTextField txtNombredoctor;
	private JTextField txtIdentificacion;
	private JTextField txtEspecilidad;
	private JTextField txtTelefono;
	private JTextField txtFecharealizacion;
	private JTextField txtDescripcion;
	private JTextField txtMedicinas;
	private Gestor gestor;
	private String[] listaDatosExpediente;
	private String[][] listaDatosConsultas;
	private String[] listaDatosDoctor;
	private String[] listaDatosPaciente;
	private JLabel lblTelefono_1;
	private JTextField txtTelefono_1;
	private JButton btnAtras;
	private JRadioButton rdbtnCedula;
	private JRadioButton rdbtnExpediente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarExpediente frame = new ConsultarExpediente();
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
	public ConsultarExpediente() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Consultar Expediente");
		gestor=new Gestor();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, -20, 516, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setBounds(12, 102, 481, 4);
		contentPane.add(separator);
		
		JLabel lblBuscarPorNumero = new JLabel("Seleccione el tipo de busqueda");
		lblBuscarPorNumero.setBounds(12, 13, 196, 16);
		contentPane.add(lblBuscarPorNumero);
		
		JLabel lblBuscarPorCedula = new JLabel("Ingrese los datos para la busqueda");
		lblBuscarPorCedula.setBounds(12, 44, 210, 16);
		contentPane.add(lblBuscarPorCedula);
		
		txtDatosBusqueda = new JTextField();
		txtDatosBusqueda.setBounds(236, 42, 257, 22);
		contentPane.add(txtDatosBusqueda);
		txtDatosBusqueda.setColumns(10);
		
		JLabel lblNumeroDeExpediente = new JLabel("Numero de Expediente");
		lblNumeroDeExpediente.setBounds(12, 119, 165, 16);
		contentPane.add(lblNumeroDeExpediente);
		
		txtNunexpediente = new JTextField();
		txtNunexpediente.setEditable(false);
		txtNunexpediente.setBounds(283, 116, 210, 22);
		contentPane.add(txtNunexpediente);
		txtNunexpediente.setColumns(10);
		
		JLabel lblFechaAperturaDel = new JLabel("Fecha Apertura del Expediente");
		lblFechaAperturaDel.setBounds(12, 154, 205, 16);
		contentPane.add(lblFechaAperturaDel);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(283, 151, 210, 22);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblNombrePaciente = new JLabel("Nombre Paciente");
		lblNombrePaciente.setBounds(12, 224, 205, 16);
		contentPane.add(lblNombrePaciente);
		
		txtNombrepaciente = new JTextField();
		txtNombrepaciente.setEditable(false);
		txtNombrepaciente.setBounds(283, 221, 210, 22);
		contentPane.add(txtNombrepaciente);
		txtNombrepaciente.setColumns(10);
		
		lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 189, 56, 16);
		contentPane.add(lblCedula);
		
		txtCedula_1 = new JTextField();
		txtCedula_1.setEditable(false);
		txtCedula_1.setBounds(283, 186, 210, 22);
		contentPane.add(txtCedula_1);
		txtCedula_1.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(12, 259, 205, 16);
		contentPane.add(lblFechaNacimiento);
		
		txtFechanacimiento = new JTextField();
		txtFechanacimiento.setEditable(false);
		txtFechanacimiento.setBounds(283, 256, 210, 22);
		contentPane.add(txtFechanacimiento);
		txtFechanacimiento.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(12, 294, 56, 16);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setBounds(283, 291, 210, 22);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 329, 117, 16);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setBounds(283, 326, 210, 22);
		txtDireccion.setColumns(10);
		JScrollPane scrolls = new JScrollPane();
		scrolls.setViewportView(txtDireccion);
		scrolls.setBounds(283, 326, 210, 22);
		scrolls.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrolls);
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(12, 391, 481, 7);
		contentPane.add(separator_1);
		
		listModel = new DefaultListModel<String>();
		JScrollPane scroll = new JScrollPane();
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setBounds(12, 425, 179, 209);
		contentPane.add(scroll);
		list = new JList(listModel);
		scroll.setViewportView(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarInfoConsulta();
			}
		});

		
		lblConsultas = new JLabel("Consultas");
		lblConsultas.setBounds(64, 395, 89, 16);
		contentPane.add(lblConsultas);
		
		lblFechaRealizacion = new JLabel("Fecha Realizacion");
		lblFechaRealizacion.setBounds(203, 406, 117, 16);
		contentPane.add(lblFechaRealizacion);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(203, 435, 101, 16);
		contentPane.add(lblDescripcion);
		
		lblMedicinas = new JLabel("Medicinas");
		lblMedicinas.setBounds(203, 464, 101, 16);
		contentPane.add(lblMedicinas);
		
		lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(203, 513, 101, 16);
		contentPane.add(lblDoctor);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(Color.GRAY);
		separator_2.setBounds(203, 493, 290, 7);
		contentPane.add(separator_2);
		
		lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(203, 546, 101, 16);
		contentPane.add(lblIdentificacion);
		
		lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(203, 575, 95, 16);
		contentPane.add(lblEspecialidad);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(203, 604, 89, 16);
		contentPane.add(lblTelefono);
		
		txtNombredoctor = new JTextField();
		txtNombredoctor.setEditable(false);
		txtNombredoctor.setBounds(337, 510, 156, 22);
		contentPane.add(txtNombredoctor);
		txtNombredoctor.setColumns(10);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setEditable(false);
		txtIdentificacion.setBounds(337, 540, 156, 22);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtEspecilidad = new JTextField();
		txtEspecilidad.setEditable(false);
		txtEspecilidad.setBounds(337, 572, 156, 22);
		contentPane.add(txtEspecilidad);
		txtEspecilidad.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(337, 601, 156, 22);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFecharealizacion = new JTextField();
		txtFecharealizacion.setEditable(false);
		txtFecharealizacion.setBounds(338, 403, 155, 22);
		contentPane.add(txtFecharealizacion);
		txtFecharealizacion.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(337, 432, 156, 22);
		txtDescripcion.setColumns(10);
		JScrollPane scrolls1 = new JScrollPane();
		scrolls1.setViewportView(txtDescripcion);
		scrolls1.setBounds(337, 432, 156, 22);
		scrolls1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrolls1);
		
		txtMedicinas = new JTextField();
		txtMedicinas.setEditable(false);
		txtMedicinas.setBounds(337, 461, 156, 22);
		contentPane.add(txtMedicinas);
		txtMedicinas.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnConsultar.setBounds(235, 77, 114, 22);
		contentPane.add(btnConsultar);
		
		lblTelefono_1 = new JLabel("Telefono");
		lblTelefono_1.setBounds(12, 362, 56, 16);
		contentPane.add(lblTelefono_1);
		
		txtTelefono_1 = new JTextField();
		txtTelefono_1.setEditable(false);
		txtTelefono_1.setBounds(283, 361, 210, 22);
		contentPane.add(txtTelefono_1);
		txtTelefono_1.setColumns(10);
		
		btnAtras = new JButton("< Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ventanaInicio= new Inicio();
				ventanaInicio.setLocationRelativeTo(null);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(12, 663, 97, 25);
		contentPane.add(btnAtras);
		
		ButtonGroup grupoButtom = new ButtonGroup();
		
		rdbtnCedula = new JRadioButton("Cedula",true);
		rdbtnCedula.setBounds(236, 9, 79, 25);
		contentPane.add(rdbtnCedula);
		
		rdbtnExpediente = new JRadioButton("Expediente");
		rdbtnExpediente.setBounds(367, 9, 101, 25);
		contentPane.add(rdbtnExpediente);
	
		grupoButtom.add(rdbtnCedula);
		grupoButtom.add(rdbtnExpediente);

		
		
	}
	private void buscar(){

		try {
			
			if(!txtDatosBusqueda.getText().equals("")){
				
				if(rdbtnCedula.isSelected()){				
					listaDatosExpediente=gestor.buscarExpedientePorCedula(Integer.parseInt(txtDatosBusqueda.getText()));
					cargarInfo();
								
				}else{
					listaDatosExpediente=gestor.buscarExpedientePorNumeroExpediente(txtDatosBusqueda.getText());	
					cargarInfo();
				}
						
			}else{				
				JOptionPane.showMessageDialog(null, "Ingrese los datos para  poder hacer la  consulta");
			}
			
		}catch(NumberFormatException x){ 
			
			JOptionPane.showMessageDialog(null, "Solo se admiten valores numericos","Error",JOptionPane.ERROR_MESSAGE);
			
		}catch (Exception e){
				txtNombrepaciente.setText("");
				txtCedula_1.setText("");
				txtFechanacimiento.setText("");
				txtEdad.setText("");
				txtDireccion.setText("");
				txtTelefono_1.setText("");
				txtIdentificacion.setText("");
				txtNombredoctor.setText("");
				txtEspecilidad.setText("");
				txtTelefono.setText("");
				txtFecharealizacion.setText("");
				txtDescripcion.setText("");
				txtMedicinas.setText("");
				txtNunexpediente.setText("");
				txtFecha.setText("");
				listModel.clear();
				JOptionPane.showMessageDialog(null,e.getMessage());			
			}
	}
	
	private void cargarInfo(){
		
		try {
			txtNunexpediente.setText("");
			txtFecha.setText("");
			txtNombrepaciente.setText("");
			txtCedula_1.setText("");
			txtFechanacimiento.setText("");
			txtEdad.setText("");
			txtDireccion.setText("");
			txtTelefono_1.setText("");
			txtIdentificacion.setText("");
			txtNombredoctor.setText("");
			txtEspecilidad.setText("");
			txtTelefono.setText("");
			txtFecharealizacion.setText("");
			txtDescripcion.setText("");
			txtMedicinas.setText("");
			listaDatosPaciente=gestor.buscarDatosPacientePorExpediente(listaDatosExpediente[0]);
			txtNunexpediente.setText(listaDatosExpediente[0]);
			txtFecha.setText(listaDatosExpediente[2]);
			txtNombrepaciente.setText(listaDatosPaciente[1]);
			txtCedula_1.setText(listaDatosPaciente[0]);
			txtFechanacimiento.setText(listaDatosPaciente[2]);
			txtEdad.setText(listaDatosPaciente[3]);
			txtDireccion.setText(listaDatosPaciente[5]);
			txtTelefono_1.setText(listaDatosPaciente[4]);
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,e1.getMessage());
		}
		
		String datos="";
	
			listaDatosConsultas = gestor.buscarConsultasDeUnExpediente(listaDatosExpediente[0]);
			listModel.clear();
			if(listaDatosConsultas!=null){
				for(int i=0; i < listaDatosConsultas.length;i++){
					datos="FECHA DE LA CONSULTA> "+listaDatosConsultas[i][3];
					listModel.addElement(datos);
				}
		
			}else{
				
				datos="NO CONSULTAS";
				listModel.addElement(datos);
			}
			
			
			
			
		
	}
	private void cargarInfoConsulta(){
		int posicion = list.getSelectedIndex();
		try {
			
			txtIdentificacion.setText("");
			txtNombredoctor.setText("");
			txtEspecilidad.setText("");
			txtTelefono.setText("");
			txtFecharealizacion.setText("");
			txtDescripcion.setText("");
			txtMedicinas.setText("");
			listaDatosDoctor=gestor.buscarDoctorDeUnaConsulta(Integer.parseInt(listaDatosConsultas[posicion][0]),listaDatosConsultas[posicion][1]);
			txtIdentificacion.setText(listaDatosDoctor[0]);
			txtNombredoctor.setText(listaDatosDoctor[1]);
			txtEspecilidad.setText(listaDatosDoctor[2]);
			txtTelefono.setText(listaDatosDoctor[3]);
			txtFecharealizacion.setText(listaDatosConsultas[posicion][3]);
			txtDescripcion.setText(listaDatosConsultas[posicion][4]);
			txtMedicinas.setText(listaDatosConsultas[posicion][5]);
			
		} catch (Exception e) {
			if(e.getMessage().equals("-1")){
				JOptionPane.showMessageDialog(null,"No tiene consultas registradas");
			}else{
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
			
		}	
	}
}

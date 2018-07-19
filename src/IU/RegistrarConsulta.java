package IU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import Logica.Gestor;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JRadioButton;

public class RegistrarConsulta extends JFrame {

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
	private JSeparator separator_3;
	private JTextField txtIdentificacionDelDoctor;
	private JTextField txtDecripcionDelProblema;
	private JTextField txtMedicinasrecetadas;
	private JLabel lblRegistrarCosulta;
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
					RegistrarConsulta frame = new RegistrarConsulta();
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
	public RegistrarConsulta() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Registrar Consulta");
		gestor=new Gestor();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, -20, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 102, 481, 4);
		separator.setBackground(Color.GRAY);
		contentPane.add(separator);
		
		JLabel lblBuscarPorNumero = new JLabel("Seleccione el tipo de busqueda");
		lblBuscarPorNumero.setBounds(12, 13, 205, 16);
		contentPane.add(lblBuscarPorNumero);
		
		JLabel lblBuscarPorCedula = new JLabel("Ingrese los datos para la busqueda");
		lblBuscarPorCedula.setBounds(12, 44, 210, 16);
		contentPane.add(lblBuscarPorCedula);
		
		txtDatosBusqueda = new JTextField();
		txtDatosBusqueda.setBounds(234, 41, 259, 22);
		contentPane.add(txtDatosBusqueda);
		txtDatosBusqueda.setColumns(10);
		
		JLabel lblNumeroDeExpediente = new JLabel("Numero de Expediente");
		lblNumeroDeExpediente.setBounds(12, 119, 165, 16);
		contentPane.add(lblNumeroDeExpediente);
		
		txtNunexpediente = new JTextField();
		txtNunexpediente.setBounds(283, 116, 210, 22);
		txtNunexpediente.setEditable(false);
		contentPane.add(txtNunexpediente);
		txtNunexpediente.setColumns(10);
		
		JLabel lblFechaAperturaDel = new JLabel("Fecha Apertura del Expediente");
		lblFechaAperturaDel.setBounds(12, 154, 205, 16);
		contentPane.add(lblFechaAperturaDel);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(283, 151, 210, 22);
		txtFecha.setEditable(false);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtNombrepaciente = new JTextField();
		txtNombrepaciente.setBounds(283, 221, 210, 22);
		txtNombrepaciente.setEditable(false);
		contentPane.add(txtNombrepaciente);
		txtNombrepaciente.setColumns(10);
		
		lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 189, 56, 16);
		contentPane.add(lblCedula);
		
		txtCedula_1 = new JTextField();
		txtCedula_1.setBounds(283, 186, 210, 22);
		txtCedula_1.setEditable(false);
		contentPane.add(txtCedula_1);
		txtCedula_1.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(12, 259, 205, 16);
		contentPane.add(lblFechaNacimiento);
		
		txtFechanacimiento = new JTextField();
		txtFechanacimiento.setBounds(283, 256, 210, 22);
		txtFechanacimiento.setEditable(false);
		contentPane.add(txtFechanacimiento);
		txtFechanacimiento.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(12, 294, 56, 16);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(283, 291, 210, 22);
		txtEdad.setEditable(false);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 329, 117, 16);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(283, 326, 210, 22);
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		JScrollPane scrolls1 = new JScrollPane();
		scrolls1.setViewportView(txtDireccion);
		scrolls1.setBounds(283, 326, 210, 22);
		scrolls1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrolls1);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(12, 391, 481, 7);
		separator_1.setBackground(Color.GRAY);
		contentPane.add(separator_1);
		
		

		listModel = new DefaultListModel<String>();
		list = new JList(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cargarInfoConsulta();
				
				
			}
		});
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(list);
		scroll.setBounds(516, 42, 295, 268);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		lblConsultas = new JLabel("Consultas del Paciente");
		lblConsultas.setBounds(566, 13, 178, 16);
		contentPane.add(lblConsultas);
		
		lblFechaRealizacion = new JLabel("Fecha Realizacion");
		lblFechaRealizacion.setBounds(521, 332, 117, 16);
		contentPane.add(lblFechaRealizacion);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(521, 361, 101, 16);
		contentPane.add(lblDescripcion);
		
		lblMedicinas = new JLabel("Medicinas");
		lblMedicinas.setBounds(521, 390, 101, 16);
		contentPane.add(lblMedicinas);
		
		lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(521, 439, 101, 16);
		contentPane.add(lblDoctor);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(516, 424, 304, 2);
		separator_2.setBackground(Color.GRAY);
		contentPane.add(separator_2);
		
		lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(521, 472, 101, 16);
		contentPane.add(lblIdentificacion);
		
		lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(521, 501, 95, 16);
		contentPane.add(lblEspecialidad);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(521, 530, 89, 16);
		contentPane.add(lblTelefono);
		
		txtNombredoctor = new JTextField();
		txtNombredoctor.setBounds(650, 436, 156, 22);
		txtNombredoctor.setEditable(false);
		contentPane.add(txtNombredoctor);
		txtNombredoctor.setColumns(10);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(650, 469, 156, 22);
		txtIdentificacion.setEditable(false);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtEspecilidad = new JTextField();
		txtEspecilidad.setBounds(650, 498, 156, 22);
		txtEspecilidad.setEditable(false);
		contentPane.add(txtEspecilidad);
		txtEspecilidad.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(650, 527, 156, 22);
		txtTelefono.setEditable(false);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFecharealizacion = new JTextField();
		txtFecharealizacion.setBounds(651, 329, 155, 22);
		txtFecharealizacion.setEditable(false);
		contentPane.add(txtFecharealizacion);
		txtFecharealizacion.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(650, 359, 156, 22);
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		JScrollPane scroll1 = new JScrollPane();
		scroll1.setViewportView(txtDescripcion);
		scroll1.setBounds(650, 359, 156, 22);
	    scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll1);
		
		txtMedicinas = new JTextField();
		txtMedicinas.setBounds(650, 387, 156, 22);
		txtMedicinas.setEditable(false);
		contentPane.add(txtMedicinas);
		txtMedicinas.setColumns(10);
		
		JButton btnConsultar = new JButton("Buscar");
		btnConsultar.setBounds(234, 76, 97, 22);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		contentPane.add(btnConsultar);
		
		lblTelefono_1 = new JLabel("Telefono");
		lblTelefono_1.setBounds(12, 362, 56, 16);
		contentPane.add(lblTelefono_1);
		
		txtTelefono_1 = new JTextField();
		txtTelefono_1.setBounds(283, 361, 210, 22);
		txtTelefono_1.setEditable(false);
		contentPane.add(txtTelefono_1);
		txtTelefono_1.setColumns(10);
		
		separator_3 = new JSeparator();
		separator_3.setBackground(Color.GRAY);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(505, 13, 2, 578);
		contentPane.add(separator_3);
		
		txtIdentificacionDelDoctor = new JTextField();
		txtIdentificacionDelDoctor.setBounds(233, 436, 260, 22);
		contentPane.add(txtIdentificacionDelDoctor);
		txtIdentificacionDelDoctor.setColumns(10);
		txtIdentificacionDelDoctor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
			}
		});
		
		
		JLabel lblIdentificacionDelDoctor = new JLabel("Identificacion del Doctor");
		lblIdentificacionDelDoctor.setBounds(12, 439, 189, 16);
		contentPane.add(lblIdentificacionDelDoctor);
		
		JLabel lblDescripcionDelProblema = new JLabel("Descripcion del problema");
		lblDescripcionDelProblema.setBounds(12, 472, 189, 16);
		contentPane.add(lblDescripcionDelProblema);
		
		txtDecripcionDelProblema = new JTextField();
		txtDecripcionDelProblema.setBounds(233, 464, 260, 55);
		txtDecripcionDelProblema.setColumns(20);
		JScrollPane scrolls = new JScrollPane();
		scrolls.setViewportView(txtDecripcionDelProblema);
		scrolls.setBounds(233, 464, 260, 55);
		scrolls.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrolls);
		
		JLabel lblMedicinasRecetadas = new JLabel("Medicinas recetadas");
		lblMedicinasRecetadas.setBounds(12, 527, 178, 16);
		contentPane.add(lblMedicinasRecetadas);
		
		txtMedicinasrecetadas = new JTextField();
		txtMedicinasrecetadas.setBounds(233, 527, 260, 22);
		contentPane.add(txtMedicinasrecetadas);
		txtMedicinasrecetadas.setColumns(10);
		
		JButton btnRegistrarCosulta = new JButton("Registrar Cosulta");
		btnRegistrarCosulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnRegistrarCosulta.setBounds(128, 561, 156, 30);
		contentPane.add(btnRegistrarCosulta);
		
		lblRegistrarCosulta = new JLabel("Registrar cosulta");
		lblRegistrarCosulta.setBounds(172, 411, 156, 16);
		contentPane.add(lblRegistrarCosulta);
		
		btnAtras = new JButton("< Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ventanaInicio= new Inicio();
				ventanaInicio.setLocationRelativeTo(null);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(12, 561, 97, 30);
		contentPane.add(btnAtras);
		ButtonGroup grupoButtom = new ButtonGroup();
		
		rdbtnCedula = new JRadioButton("Cedula",true);
		rdbtnCedula.setBounds(234, 9, 79, 25);
		contentPane.add(rdbtnCedula);
		
		rdbtnExpediente = new JRadioButton("Numero de Expediente");
		rdbtnExpediente.setBounds(328, 9, 165, 25);
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
			listaDatosDoctor=gestor.buscarDoctorDeUnaConsulta(Integer.parseInt(listaDatosConsultas[posicion][0]),listaDatosConsultas[posicion][1]);
			txtIdentificacion.setText("");
			txtNombredoctor.setText("");
			txtEspecilidad.setText("");
			txtTelefono.setText("");
			txtFecharealizacion.setText("");
			txtDescripcion.setText("");
			txtMedicinas.setText("");
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
	private void registrar(){
		try {
			if(!(txtNunexpediente.getText().equals(""))){
				if(!(txtDecripcionDelProblema.getText().equals(""))&&!(txtMedicinasrecetadas.getText().equals(""))&&!(txtMedicinasrecetadas.getText().equals(""))){
					if(gestor.buscarDoctor(Integer.parseInt(txtIdentificacionDelDoctor.getText()))!=null){
						Calendar fechaActualCalendar = GregorianCalendar.getInstance();	
						SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyy");
						String fechaActual= mascara.format(fechaActualCalendar.getTime());
						
						gestor.registraConsulta(Integer.parseInt(txtIdentificacionDelDoctor.getText()),
						fechaActual,txtDecripcionDelProblema.getText(),txtMedicinasrecetadas.getText(),
						txtNunexpediente.getText());
						txtMedicinasrecetadas.setText("");
						txtDecripcionDelProblema.setText("");
						txtIdentificacionDelDoctor.setText("");
						JOptionPane.showMessageDialog(null, "Consulta registrada","Mensaje",JOptionPane.INFORMATION_MESSAGE);
						cargarInfo();
						
					}else{
						JOptionPane.showMessageDialog(null,"Medico no registrado en el sistema.\nPor favor verifique la identificacion de medico");
					}
				}else{
					JOptionPane.showMessageDialog(null,"Debe ingresar todos los datos de la consulta");

				}
			
			}else{
				JOptionPane.showMessageDialog(null,"Ningun expediente relacionado a esta consulta");
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}

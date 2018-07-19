package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Logica.Gestor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class AbrirExpediente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JDateChooser fechaNacimiento;
	private Gestor gestor;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirExpediente frame = new AbrirExpediente();
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
	public AbrirExpediente() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Abrir Expediente");
		gestor=new Gestor();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 546, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelPaciente = new JLabel("Nombre del Paciente");
		lblNombreDelPaciente.setBounds(12, 29, 174, 23);
		contentPane.add(lblNombreDelPaciente);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(248, 29, 268, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(12, 78, 143, 16);
		contentPane.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(248, 75, 268, 22);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
			}
		});
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 168, 108, 16);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(248, 165, 268, 22);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 217, 108, 16);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(248, 214, 268, 22);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
			}
		});
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(12, 126, 174, 16);
		contentPane.add(lblFechaDeNacimiento);
		
		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setBounds(248, 120, 268, 22);
		contentPane.add(fechaNacimiento);
		
		
		JButton btnCrearExpediente = new JButton("Crear Expediente");
		btnCrearExpediente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearExpediente();
			}
		});
		btnCrearExpediente.setBounds(143, 268, 154, 25);
		contentPane.add(btnCrearExpediente);
		
		btnAtras = new JButton("<Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ventanaInicio= new Inicio();
				ventanaInicio.setLocationRelativeTo(null);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(12, 268, 97, 25);
		contentPane.add(btnAtras);
	}
	
	public void crearExpediente(){
		if(!(txtNombre.getText().equals(""))&&!(txtCedula.getText().equals(""))&&!(txtDireccion.getText().equals(""))&&!(txtTelefono.getText().equals(""))&&validarFecha()){
			int edad;
			Calendar fechaActualCalendar = GregorianCalendar.getInstance();	
			SimpleDateFormat mascara= new SimpleDateFormat("dd/MM/yyyy");
			String fechaActual= mascara.format(fechaActualCalendar.getTime());
			mascara= new SimpleDateFormat("dd/MM/yyyy");
			String fechaNacimienro=mascara.format(fechaNacimiento.getCalendar().getTime());
			edad=calcularEdad(fechaNacimienro);
			
			try {
				gestor.crearExpediente(fechaActual,Integer.parseInt(txtCedula.getText()),
				txtNombre.getText(),txtDireccion.getText(),Integer.parseInt(txtTelefono.getText()),
				fechaNacimienro,edad);
				txtCedula.setText("");
				txtDireccion.setText("");
				txtNombre.setText("");
				txtTelefono.setText("");
				JOptionPane.showMessageDialog(null,"Expediente creado con exito");
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(this,(String) e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(this,"Ingrese todos los datos correctamente por favor","Error",JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public  int calcularEdad(String fecha){
	    Date fechaNac=null;
	        try {
	            fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
	        } catch (Exception ex) {
	            System.out.println("Error:"+ex);
	        }
	        Calendar fechaNacimiento = Calendar.getInstance();
	        Calendar fechaActual = Calendar.getInstance();
	        fechaNacimiento.setTime(fechaNac);
	        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
	        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
	        int anno = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
	        if(mes<0 || (mes==0 && dia<0)){
	        	anno--;
	        }
	        return anno;
	    }
	
	private boolean validarFecha()
	{	
		Calendar fechaActual = GregorianCalendar.getInstance();
		try{
		if(fechaNacimiento.getCalendar().before(fechaActual)){
			return true;
		}else{
			JOptionPane.showMessageDialog(this,"Ingrese la fecha correctamente."+"\nLa fecha presenta una condicion no valida.","Error",JOptionPane.WARNING_MESSAGE);	
			return false;
		}
		}catch(Exception e){
		
			JOptionPane.showMessageDialog(this,"Ingrese la fecha Por favor","Error",JOptionPane.WARNING_MESSAGE);	
			return false;
		}
	}

}

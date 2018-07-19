package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Gestor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class RegistrarDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdentificacion;
	private JTextField txtNombre;
	private JTextField txtEspecialida;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	Gestor gestor;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarDoctor frame = new RegistrarDoctor();
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
	public RegistrarDoctor() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Registrar Doctor");
		gestor=new Gestor();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 401, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(12, 23, 134, 16);
		contentPane.add(lblIdentificacion);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(171, 20, 204, 22);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		txtIdentificacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 63, 96, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(171, 60, 204, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(12, 102, 121, 16);
		contentPane.add(lblEspecialidad);
		
		txtEspecialida = new JTextField();
		txtEspecialida.setBounds(171, 99, 204, 22);
		contentPane.add(txtEspecialida);
		txtEspecialida.setColumns(10);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 150, 56, 16);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(171, 147, 204, 22);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
			}
		});
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				registrar();
			}
		});
		btnRegistrar.setBounds(278, 186, 97, 25);
		contentPane.add(btnRegistrar);
		
		btnAtras = new JButton("< Atras ");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ventanaInicio= new Inicio();
				ventanaInicio.setLocationRelativeTo(null);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(12, 186, 97, 25);
		contentPane.add(btnAtras);
	}
	private void registrar(){
		
		if(!(txtIdentificacion.getText().equals(""))&&!(txtNombre.getText().equals(""))&&!(txtEspecialida.getText().equals(""))&&!(txtTelefono.getText().equals(""))){
			try {
				gestor.registrarDoctor(Integer.parseInt(txtIdentificacion.getText()),txtNombre.getText(),txtEspecialida.getText(),Integer.parseInt(txtTelefono.getText()));
				txtIdentificacion.setText("");
				txtNombre.setText("");
				txtEspecialida.setText("");
				txtTelefono.setText("");
				JOptionPane.showMessageDialog(null,"Doctor registrado con exito");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this,(String) e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

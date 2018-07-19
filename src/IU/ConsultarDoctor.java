package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Logica.Gestor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class ConsultarDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdentificacion;
	private JTextField txtIdentifica;
	private JTextField txtEspecialidad;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private DefaultListModel<String> listModel;
	private JList<String>list;
	private String[][]infoDoctores;
	private Gestor gestor;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarDoctor frame = new ConsultarDoctor();
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
	public ConsultarDoctor() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Consultar Doctor");
		gestor=new Gestor();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 652, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLaIdentificacion = new JLabel("Ingrese la identificacion del doctor");
		lblIngreseLaIdentificacion.setBounds(12, 25, 231, 16);
		contentPane.add(lblIngreseLaIdentificacion);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtIdentifica.setText("");
				txtNombre.setText("");
				txtEspecialidad.setText("");
				txtTelefono.setText("");
				cargarInfoListDoctores();
			}
		});
		txtIdentificacion.setBounds(277, 22, 249, 22);
		contentPane.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		txtIdentificacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
				char car = e.getKeyChar();
				if(car<'0' || car>'9')e.consume();
			}
		});
		
		
		listModel = new DefaultListModel<String>();
		list = new JList(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedIndex()!=-1){
					cargarDatosDoctor();
				}
				
			}
		});
		list.setBounds(0, 0, 209, 257);
		JScrollPane scroll = new JScrollPane(list);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setBounds(12, 54, 279, 201);
		contentPane.add(scroll);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(315, 84, 112, 16);
		contentPane.add(lblIdentificacion);
		
		txtIdentifica = new JTextField();
		txtIdentifica.setEditable(false);
		txtIdentifica.setBounds(439, 81, 169, 22);
		contentPane.add(txtIdentifica);
		txtIdentifica.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(315, 125, 56, 16);
		contentPane.add(lblNombre);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setEditable(false);
		txtEspecialidad.setBounds(439, 167, 169, 22);
		contentPane.add(txtEspecialidad);
		txtEspecialidad.setColumns(10);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(315, 170, 105, 16);
		contentPane.add(lblEspecialidad);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(439, 122, 169, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(315, 219, 71, 16);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.BLACK);
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(439, 216, 169, 22);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAtras = new JButton("< Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ventanaInicio= new Inicio();
				ventanaInicio.setLocationRelativeTo(null);
				ventanaInicio.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(12, 269, 97, 25);
		contentPane.add(btnAtras);	
	}	
	
	public void cargarInfoListDoctores(){
		String datos="";
		try {
			infoDoctores = gestor.buscarDoctoresPorID(Integer.parseInt("0"+txtIdentificacion.getText()));
			listModel.clear();
			for(int i=0; i < infoDoctores.length;i++){
					datos="IDENTIFICACION > "+infoDoctores[i][0];
					datos+=" NOMBRE > "+infoDoctores[i][1];
					listModel.addElement(datos);
			}
		} catch (Exception e) {
			e.printStackTrace();
			datos="NO RESULTADOS";
			listModel.addElement(datos);
			
		}
		
		
		
	}
	private void cargarDatosDoctor(){
		int posicion = list.getSelectedIndex();
		
		txtIdentifica.setText(infoDoctores[posicion][0]);
		txtNombre.setText(infoDoctores[posicion][1]);
		txtEspecialidad.setText(infoDoctores[posicion][2]);
		txtTelefono.setText(infoDoctores[posicion][3]);
		
	}
}

package IU;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setResizable(false);
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrarDoctor = new JButton("Registrar Doctor");
		btnRegistrarDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarDoctor ventanaRegistrarDoctor= new RegistrarDoctor();
				ventanaRegistrarDoctor.setLocationRelativeTo(null);
				ventanaRegistrarDoctor.setVisible(true);
				dispose();
			}
		});
		btnRegistrarDoctor.setBounds(40, 37, 286, 36);
		contentPane.add(btnRegistrarDoctor);
		
		JButton btnAbrirExpediente = new JButton("Abrir Expediente");
		btnAbrirExpediente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AbrirExpediente ventanaAbrirExpediente= new AbrirExpediente();
				ventanaAbrirExpediente.setLocationRelativeTo(null);
				ventanaAbrirExpediente.setVisible(true);
				dispose();
			}
		});
		btnAbrirExpediente.setBounds(40, 137, 286, 36);
		contentPane.add(btnAbrirExpediente);
		
		JButton btnConsultarDoctor = new JButton("Consultar Doctor");
		btnConsultarDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConsultarDoctor ventanaConsultarDoctor= new ConsultarDoctor();
				ventanaConsultarDoctor.setLocationRelativeTo(null);
				ventanaConsultarDoctor.setVisible(true);
				dispose();
			}
		});
		btnConsultarDoctor.setBounds(40, 186, 286, 36);
		contentPane.add(btnConsultarDoctor);
		
		JButton btnRegistrarconsulta = new JButton("RegistrarConsulta");
		btnRegistrarconsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarConsulta ventanaRegistrarConsulta= new RegistrarConsulta();
				ventanaRegistrarConsulta.setLocationRelativeTo(null);
				ventanaRegistrarConsulta.setVisible(true);
				dispose();
			}
		});
		btnRegistrarconsulta.setBounds(40, 88, 286, 36);
		contentPane.add(btnRegistrarconsulta);
		
		JButton btnConsultarExpediente = new JButton("Consultar Expediente");
		btnConsultarExpediente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConsultarExpediente ventanaConsultarExpediente= new ConsultarExpediente();
				ventanaConsultarExpediente.setLocationRelativeTo(null);
				ventanaConsultarExpediente.setVisible(true);
				dispose();
			}
		});
		btnConsultarExpediente.setBounds(40, 235, 286, 36);
		contentPane.add(btnConsultarExpediente);
	}

}

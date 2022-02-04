package ejercicio2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAutocar extends JFrame {

	private JPanel contentPane;
	private JTextField txtModelo;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtKilometros;
	private JTable tablaListado;
	private JLabel lblTitulo;
	private JLabel lblMatricula;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblKilometros;
	private JLabel lblPlazas;
	private JSpinner spinnerPlazas;
	private JButton btnInsertar;
	private JButton btnMostrar;
	private JScrollPane scrollPane;
	
	private ArrayList<Autocar> listaAutocares;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAutocar frame = new VentanaAutocar();
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
	public VentanaAutocar() {
		
		listaAutocares = new ArrayList<Autocar>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][][grow]", "[][][][][][]"));
		
		lblTitulo = new JLabel("Gesti\u00F3n autocares");
		lblTitulo.setOpaque(true);
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 24));
		contentPane.add(lblTitulo, "cell 0 0 6 1,grow");
		
		lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblMatricula, "cell 0 1,alignx trailing");
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(txtMatricula, "cell 1 1 3 1,growx");
		txtMatricula.setColumns(10);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblMarca, "cell 0 2,alignx trailing");
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(txtMarca, "cell 1 2 3 1,growx");
		txtMarca.setColumns(10);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblModelo, "cell 4 2,alignx trailing");
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(txtModelo, "cell 5 2,growx");
		txtModelo.setColumns(10);
		
		lblKilometros = new JLabel("Kil\u00F3metros:");
		lblKilometros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblKilometros, "cell 0 3,alignx trailing");
		
		txtKilometros = new JTextField();
		txtKilometros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(txtKilometros, "cell 1 3 3 1,growx");
		txtKilometros.setColumns(10);
		
		lblPlazas = new JLabel("Plazas:");
		lblPlazas.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblPlazas, "cell 4 3,alignx right");
		
		spinnerPlazas = new JSpinner();
		spinnerPlazas.setModel(new SpinnerNumberModel(30, 1, 80, 1));
		contentPane.add(spinnerPlazas, "cell 5 3");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 5 6 1,grow");
		
		tablaListado = new JTable();
		tablaListado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Marca", "Modelo", "Kilometros", "Num_plazas"
			}
		));
		tablaListado.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(tablaListado);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertarAutocar();
				
			}
		});
		btnInsertar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(btnInsertar, "cell 2 4");
		
		btnMostrar = new JButton("Mostrar Datos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mostrarDatos();
				
			}
		});
		btnMostrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(btnMostrar, "cell 3 4 3 1");
		
		
	}

	protected void mostrarDatos() {
		
		DefaultTableModel modelo = (DefaultTableModel) tablaListado.getModel();
		modelo.setRowCount(0);
		for (Autocar autocar : listaAutocares) {
			Object fila[] = {autocar.getMatricula(), autocar.getMarca(), autocar.getModelo(), autocar.getKilometros(), autocar.getNum_plazas()};
			modelo.addRow(fila);
		}
		
	}

	protected void insertarAutocar() {
		
		Autocar a = new Autocar();
		a.setMatricula(txtMatricula.getText());
		a.setMarca(txtMarca.getText());
		a.setModelo(txtModelo.getText());
		a.setKilometros(Integer.parseInt(txtKilometros.getText()));
		a.setNum_plazas((Integer)spinnerPlazas.getValue());
		
		if(!listaAutocares.contains(a)) {
			listaAutocares.add(a);
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe un autocar con esa matricula", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}

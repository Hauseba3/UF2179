package ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentaBilletes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtPrecio;
	private final ButtonGroup grupo = new ButtonGroup();
	private JLabel lblTitulo;
	private JLabel lblOrigen;
	private JComboBox cbbOrigen;
	private JLabel lblDestino;
	private JComboBox cbbDestino;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblPrecio;
	private JLabel lblBillete;
	private JRadioButton nrbIda;
	private JRadioButton nrbIdayvuelta;
	private JRadioButton nrbTarjeta;
	private JTextArea txtArea;
	private JButton btnCalcular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaBilletes frame = new VentaBilletes();
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
	public VentaBilletes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow][][][][][grow][][][90.00,grow][][]", "[][][][][][][][grow]"));
		
		lblTitulo = new JLabel("Venta de billetes");
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblTitulo, "cell 0 0 13 1,grow");
		
		lblOrigen = new JLabel("Origen:");
		lblOrigen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblOrigen, "cell 0 1,alignx trailing");
		
		cbbOrigen = new JComboBox();
		cbbOrigen.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "And\u00FAjar", "Cabra", "Carde\u00F1a", "Obejo", "Santaella"}));
		cbbOrigen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(cbbOrigen, "cell 1 1 12 1,growx");
		
		lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblDestino, "cell 0 2,alignx trailing");
		
		cbbDestino = new JComboBox();
		cbbDestino.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "Andujar", "Cabra", "Carde\u00F1a", "Obejo", "Santaella"}));
		cbbDestino.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(cbbDestino, "cell 1 2 12 1,growx");
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblNombre, "cell 0 3,alignx trailing");
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(txtNombre, "cell 1 3 2 1,growx");
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblApellidos, "cell 3 3,alignx trailing");
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(txtApellidos, "cell 4 3 9 1,growx");
		txtApellidos.setColumns(10);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblPrecio, "cell 0 4,alignx trailing");
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(txtPrecio, "cell 1 4,growx");
		txtPrecio.setColumns(10);
		
		lblBillete = new JLabel("Billete:");
		lblBillete.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(lblBillete, "cell 0 5,alignx right");
		
		nrbIda = new JRadioButton("Ida");
		nrbIda.setSelected(true);
		grupo.add(nrbIda);
		nrbIda.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(nrbIda, "cell 1 5,alignx right");
		
		nrbIdayvuelta = new JRadioButton("Ida y Vuelta");
		grupo.add(nrbIdayvuelta);
		nrbIdayvuelta.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(nrbIdayvuelta, "cell 2 5");
		
		nrbTarjeta = new JRadioButton("Tarjeta Dorada");
		grupo.add(nrbTarjeta);
		nrbTarjeta.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(nrbTarjeta, "cell 3 5 2 1");
		
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(txtArea, "cell 0 7 13 1,grow");
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cbbOrigen.getSelectedIndex()==cbbDestino.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar origen y destino diferentes", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
				} else {
					calcularPrecio();
					añadir();
				}
				
				
			}
		});
		btnCalcular.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contentPane.add(btnCalcular, "cell 2 6 3 1,alignx center");
		
		
	}

	protected void añadir() {
		
		txtArea.setText(null);
		txtArea.setText("Trayecto: " + cbbOrigen.getSelectedItem().toString() + " a " + cbbDestino.getSelectedItem().toString() + "\n"
				+ "Viajero: " + txtNombre.getText() + " " + txtApellidos.getText() + "\n"
				+ "Precio: " + calcularPrecio());
		
	}

	protected double calcularPrecio() {
		
		double precio=0;
		double coste = Double.parseDouble(txtPrecio.getText());
		if(nrbIda.isSelected()) {
			
			precio = coste;
			
		} else if(nrbIdayvuelta.isSelected()) {
			
			precio =(coste*2)*0.8;
					
		} else if(nrbTarjeta.isSelected()) {
			
			precio = coste*0.7;
			
		}
		return precio;
	}

}

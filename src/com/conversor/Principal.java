package com.conversor;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.conversor.combLongitud.ValorLongitud;
import com.conversor.combMonedas.ValorMoneda;
import com.conversor.combTemperaturas.ValorTemperatura;

import java.awt.Cursor;

public class Principal {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<TipoConversor> comboBox_type;
	private JComboBox<Object> comboBox_1;
	private JComboBox<Object> comboBox_2;
	private JButton btnResult;
	private JLabel Label_titulo;
	private JLabel Label_nombre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
							
		frame = new JFrame();
		frame.setResizable(false);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.getContentPane().setBackground(new Color(0, 128, 192));
		frame.setBounds(100, 100, 400, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboBox_1 = new JComboBox<>(new DefaultComboBoxModel<Object>(ValorMoneda.values()));
		comboBox_1.setToolTipText("Unidad inicial");
		comboBox_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_1.setRequestFocusEnabled(false);
		comboBox_1.setBounds(95, 64, 115, 25);
		frame.getContentPane().add(comboBox_1);

		comboBox_2 = new JComboBox<>(new DefaultComboBoxModel<Object>(ValorMoneda.values()));
		comboBox_2.setToolTipText("Unidad a convertir");
		comboBox_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_2.setRequestFocusEnabled(false);
		comboBox_2.setBounds(95, 99, 115, 25);
		frame.getContentPane().add(comboBox_2);
		
		//Boton de seleccion de conversor
		
		comboBox_type = new JComboBox<TipoConversor>();
		comboBox_type.setToolTipText("Seleccione el tipo de conversor");
		comboBox_type.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_type.addItemListener(new ItemListener() {
			private TipoConversor seleccion;
			public void itemStateChanged(ItemEvent e) {
				seleccion = (TipoConversor) comboBox_type.getSelectedItem();
				textField_1.setText(null);
				textField_2.setText(null);

				switch (seleccion) {
				case MONEDAS: 
					comboBox_1.setModel(new DefaultComboBoxModel<Object>(ValorMoneda.values()));
					comboBox_2.setModel(new DefaultComboBoxModel<Object>(ValorMoneda.values()));
					break;
				case LONGITUD:
					comboBox_1.setModel(new DefaultComboBoxModel<Object>(ValorLongitud.values()));
					comboBox_2.setModel(new DefaultComboBoxModel<Object>(ValorLongitud.values()));
					break;
				case TEMPERATURA:
					comboBox_1.setModel(new DefaultComboBoxModel<Object>(ValorTemperatura.values()));
					comboBox_2.setModel(new DefaultComboBoxModel<Object>(ValorTemperatura.values()));
					break;
				default:
					comboBox_1.setModel(new DefaultComboBoxModel<Object>(ValorMoneda.values()));
					comboBox_2.setModel(new DefaultComboBoxModel<Object>(ValorMoneda.values()));
					break;					
				}
			}
		});
		comboBox_type.setModel(new DefaultComboBoxModel<TipoConversor>(TipoConversor.values()));
		comboBox_type.setBounds(95, 29, 115, 25);
		frame.getContentPane().add(comboBox_type);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Introduce un valor numérico para convertir");
		textField_1.setBorder(null);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setBounds(235, 64, 130, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 128, 192));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_2.setBounds(235, 99, 130, 25);
		frame.getContentPane().add(textField_2);

		//Boton convertir
		
		btnResult = new JButton("Convertir");
		btnResult.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResult.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnResult.setForeground(Color.WHITE);
		btnResult.setBackground(new Color(255, 99, 71));
		btnResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnResult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TipoConversor seleccion = (TipoConversor) comboBox_type.getSelectedItem();
				
				try {
					double valor = Double.parseDouble(textField_1.getText());
					textField_2.setForeground(Color.white);
					if (valor < 0 && seleccion != TipoConversor.TEMPERATURA) {
						textField_2.setText("Ingrese un valor positivo");
						textField_2.setForeground(Color.blue);
						textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
						throw new ingresoException("Ingrese un valor positivo");
					}

				} catch (NumberFormatException ex){
					textField_2.setText("Ingrese un valor numérico");
					textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
					textField_2.setForeground(Color.blue);
					ex.getMessage();
				}
				
				switch (seleccion) {
				
				case MONEDAS:
					ValorMoneda moneda_1 = (ValorMoneda) comboBox_1.getSelectedItem();
					ValorMoneda moneda_2 = (ValorMoneda) comboBox_2.getSelectedItem();
				
					ConvertirMonedas conversionMon = new ConvertirMonedas(moneda_1.name(), moneda_2.name(), textField_1.getText());
					textField_2.setText(Double.toString(conversionMon.Calcular()));
					break;
					
				case LONGITUD:
					ValorLongitud longitud_1 = (ValorLongitud) comboBox_1.getSelectedItem();
					ValorLongitud longitud_2 = (ValorLongitud) comboBox_2.getSelectedItem();
					
					ConvertirLongitud conversionLong = new ConvertirLongitud(longitud_1.name(), longitud_2.name(), textField_1.getText());
					textField_2.setText(Double.toString(conversionLong.Calcular()));
					break;
					
				case TEMPERATURA:
					ValorTemperatura temperatura_1 = (ValorTemperatura) comboBox_1.getSelectedItem();
					ValorTemperatura temperatura_2 = (ValorTemperatura) comboBox_2.getSelectedItem();
					
					ConvertirTemperatura conversionTemp = new ConvertirTemperatura(temperatura_1.name(), temperatura_2.name(), textField_1.getText());
					textField_2.setText(Double.toString(conversionTemp.Calcular()));
					break;
					
				default:
					ValorMoneda moneda_1def = (ValorMoneda) comboBox_1.getSelectedItem();
					ValorMoneda moneda_2def = (ValorMoneda) comboBox_2.getSelectedItem();
				
					ConvertirMonedas conversionMondef = new ConvertirMonedas(moneda_1def.name(), moneda_2def.name(), textField_1.getText());
					textField_2.setText(Double.toString(conversionMondef.Calcular()));
					break;
				}
											
			}
		});
		btnResult.setBounds(95, 134, 115, 40);
		frame.getContentPane().add(btnResult);
		
		//Etiquetas de texto
		
		JLabel lblDe = new JLabel("de:");
		lblDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDe.setBounds(11, 64, 75, 25);
		frame.getContentPane().add(lblDe);
		
		JLabel lblA = new JLabel("a:");
		lblA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblA.setBounds(10, 99, 75, 25);
		frame.getContentPane().add(lblA);
		
		JLabel lblConversor = new JLabel("conversor:");
		lblConversor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConversor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConversor.setBounds(10, 29, 75, 25);
		frame.getContentPane().add(lblConversor);
		
		Label_titulo = new JLabel("CONVERSOR");
		Label_titulo.setForeground(new Color(25, 25, 112));
		Label_titulo.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Label_titulo.setBounds(235, 29, 130, 25);
		frame.getContentPane().add(Label_titulo);
		
		JLabel Label_Alura = new JLabel("Alura - Oracle Next Education");
		Label_Alura.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Alura.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Label_Alura.setBounds(235, 155, 130, 14);
		frame.getContentPane().add(Label_Alura);
		
		JLabel Label_2023 = new JLabel("2023 Challenge -  Conversor");
		Label_2023.setHorizontalAlignment(SwingConstants.CENTER);
		Label_2023.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Label_2023.setBounds(235, 140, 130, 14);
		frame.getContentPane().add(Label_2023);
		Label_nombre = new JLabel("by Augusto ♥");
		Label_nombre.setForeground(Color.WHITE);
		Label_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Label_nombre.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Label_nombre.setBounds(235, 175, 130, 14);
		frame.getContentPane().add(Label_nombre);
	}
}

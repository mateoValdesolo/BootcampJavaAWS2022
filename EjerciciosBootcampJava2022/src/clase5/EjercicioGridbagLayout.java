package clase5;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 * @author Mateo Valdesolo
 *
 */
public class EjercicioGridbagLayout {

	public static void main(String[] args) {
		
		JFrame j = new JFrame("Ejemplo GridBagLayout");

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		j.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();

		// JTextArea en la fila 0, columna 0 y que ocupa dos filas y dos columnas de
		// ancho.
		JLabel label = new JLabel("Ejercicio GridBagLayout");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 2;
		// Hay que estirar la fila 0.
		constraints.weighty = 1.0;
		// El area de texto debe estirarse en ambos sentidos.
		constraints.fill = GridBagConstraints.BOTH;
		j.getContentPane().add(label, constraints);
		// Restauramos el valor de weighty para no afectar a los siguientes componentes.
		constraints.weighty = 0.0;

		// JButton en la fila 0, columna 2 y que ocupa 1 celda de ancho por una de alto.
		JButton button = new JButton("Boton 1");
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		// Hay que estirar la fila 0.
		constraints.weighty = 1.0;
		// El botón 1 debe ocupar la posición NORTH de su celda
		constraints.anchor = GridBagConstraints.NORTH;
		// El botón 1 no debe estirarse. Habíamos cambiado este valor en el area de
		// texto, asi que lo restauramos.
		constraints.fill = GridBagConstraints.NONE;
		// Agrego un evento al boton1
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Apretaste el boton 1!");
			}
		});
		j.getContentPane().add(button, constraints);
		// Restauramos el valor de weighty para no afectar a los siguientes componentes.
		constraints.weighty = 0.0;
		

		// JButton en la fila 1, columna 2 y que ocupa 1x1 celdas.
		JButton button2 = new JButton("Boton 2");
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		// Hay que estirar la fila 1.
		constraints.weighty = 1.0;
		// El boton 2 debe ocupar la posición NORTH de su celda.
		constraints.anchor = GridBagConstraints.NORTH;
		// Agrego un evento al boton2
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Apretaste el boton 2!");
			}
		});
		j.getContentPane().add(button2, constraints);
		// Restauramos el valor de weighty para no afectar a los siguientes componentes.
		constraints.weighty = 0.0;


		// JCheckBox en la fila 2, columna 1 y que ocupa 1x1 celdas.
		JCheckBox check = new JCheckBox("CheckBox");
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		// Hay que estirar la columna 1.
		constraints.weightx = 1.0;
		// El campo de texto debe estirarse sólo en horizontal.
		constraints.fill = GridBagConstraints.HORIZONTAL;
		// Agrego un evento al check
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Apretaste el checkBox!");
			}
		});
		j.getContentPane().add(check, constraints);
		
		// JRadioButton en la fila 3, columna 1 y que ocupa 1x1 celdas.
		JRadioButton radio = new JRadioButton("RadioButton");
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		// Agrego un evento al radio
		radio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Apretaste el radioButton!");
			}
		});
		j.getContentPane().add(radio, constraints);

		j.pack();
		j.setVisible(true);

	}

}

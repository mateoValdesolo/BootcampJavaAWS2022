package clase5;

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
public class EjerciciosClase5 {
	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setTitle("Ejercicio 1");
		window.setSize(250, 250);

		JLabel label = new JLabel("Ejercicio 1");
		label.setBounds(50, 50, 150, 20);
		window.add(label);

		JButton button = new JButton("Boton 1");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Apretaste el boton 1!");
			}
		});

		JButton button2 = new JButton("Boton 2");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Apretaste el boton 2!");
			}
		});

		JRadioButton radio = new JRadioButton("RadioButton");
		radio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Apretaste el radioButton!");
			}
		});

		JCheckBox check = new JCheckBox("CheckBox");
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Apretaste el checkBox!");
			}
		});

		button.setBounds(50, 70, 100, 20);
		button2.setBounds(50, 90, 100, 20);
		radio.setBounds(50, 120, 150, 30);
		check.setBounds(50, 160, 150, 30);
		window.add(button);
		window.add(button2);
		window.add(radio);
		window.add(check);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}

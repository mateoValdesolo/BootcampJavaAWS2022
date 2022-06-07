package clase5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 * @author Mateo Valdesolo
 *
 */
public class EjercicioFlowLayout {

	public static void main(String[] args) {
		
		JFrame j = new JFrame("Ejemplo FlowLayout");

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();

		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		p.setBorder(padding);

		p.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel label = new JLabel("Ejercicio 1");

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

		p.add(label);
		p.add(button);
		p.add(button2);
		p.add(check);
		p.add(radio);

		j.getContentPane().add(p);
		j.pack();
		j.setVisible(true);

	}

}

package clase5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
public class EjercicioBoxLayout {
	public static void main(String[] args) {

		JFrame j = new JFrame("Ejemplo BoxLayout");

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout(10, 10));

		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		p.setBorder(padding);
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		
		JLabel label = new JLabel("Ejercicio BoxLayout");

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

		p1.add(label);
		p1.add(button);
		p1.add(button2);

		JPanel p2 = new JPanel();

		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

		p2.add(check);
		p2.add(radio);

		p.add(p1, BorderLayout.LINE_START);
		p.add(p2, BorderLayout.LINE_END);

		j.getContentPane().add(p);
		j.pack();
		j.setVisible(true);
	}
}

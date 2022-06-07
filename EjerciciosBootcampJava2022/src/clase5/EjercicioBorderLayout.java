package clase5;

import java.awt.BorderLayout;
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
public class EjercicioBorderLayout {

	public static void main(String[] args) {

		// BorderLayout fue el Layout que mas facil me resulto usar, ya que es bastente
		// intuitivo el orden de los elementos.
		JFrame j = new JFrame("Ejemplo BorderLayout");

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();

		Border padding = BorderFactory.createEmptyBorder(50, 50, 50, 50);

		p.setBorder(padding);

		p.setLayout(new BorderLayout(10, 10));

		JLabel label = new JLabel("Ejercicio BorderLayout");

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

		p.add(label, BorderLayout.PAGE_START);
		p.add(check, BorderLayout.LINE_START);
		p.add(button, BorderLayout.CENTER);
		p.add(radio, BorderLayout.LINE_END);
		p.add(button2, BorderLayout.PAGE_END);

		j.getContentPane().add(p);
		j.pack();
		j.setVisible(true);
	}
}

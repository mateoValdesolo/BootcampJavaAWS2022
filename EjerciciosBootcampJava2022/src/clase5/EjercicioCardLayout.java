package clase5;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Mateo Valdesolo
 *
 */
public class EjercicioCardLayout {

	public static void main(String[] args) {

		(new EjercicioCardLayout()).createAndShowGUI();

	}

	private final static String BUTTONPANEL = "Card con botones";
	private final static String CHECKPANEL = "Card con checks";

	private JPanel cards;

	private void createAndShowGUI() {

		JFrame frame = new JFrame("Ejemplo CardLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel comboBoxPane = new JPanel();
		String comboBoxItems[] = { BUTTONPANEL, CHECKPANEL };
		JComboBox<String> cb = new JComboBox<String>(comboBoxItems);

		cb.setEditable(false);
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards, (String) e.getItem());
			}
		});

		comboBoxPane.add(cb);
		
		JLabel label = new JLabel("Ejercicio CardLayout");
		JLabel label2 = new JLabel("Ejercicio CardLayout");
		
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
				label2.setText("Apretaste el radio!");
			}
		});

		JCheckBox check = new JCheckBox("CheckBox");
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label2.setText("Apretaste el check!");
			}
		});

		JPanel card1 = new JPanel();
		card1.add(button);
		card1.add(button2);
		card1.add(label);

		JPanel card2 = new JPanel();
		card2.add(check);
		card2.add(radio);
		card2.add(label2);
		
		cards = new JPanel(new CardLayout());
		cards.add(card1, BUTTONPANEL);
		cards.add(card2, CHECKPANEL);

		frame.getContentPane().add(comboBoxPane, BorderLayout.PAGE_START);
		frame.getContentPane().add(cards, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}
}

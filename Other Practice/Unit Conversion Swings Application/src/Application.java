/**
 * Application.java
 *
 * Version:
 *     $1.0$
 *
 * Author:
 * 	  Shivkumar Dudhani
 * Revisions:
 *     $New$
 * Description
 * 	  Swing application to perform conversions
 */

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/*
 inches to meter and meter to inches
 km/h to mph and mph to km/h
 km to lightyear and lightyear to km
 Celcius to Fahrenheit and Fahrenheit to Celcius
 */
import javax.swing.*;

class screen {
	public static final String rb_name = "rb";
	int radio_button_count = 4;
	int option_selected = 0;// Default
	JFrame frame = new JFrame("Conversions");
	JLabel left_txt_label = new JLabel("Mph");
	JLabel right_txt_label = new JLabel("Kmph");

	NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale
			.getDefault());
	DecimalFormat decimalFormat = (DecimalFormat) numberFormat;

	JFormattedTextField left_txt_field = new JFormattedTextField(decimalFormat);
	JFormattedTextField right_txt_field = new JFormattedTextField(decimalFormat);

	/*
	 * JTextField left_txt_field = new JTextField(); JTextField right_txt_field
	 * = new JTextField();
	 */
	/*
	 * Convert Mph to Kmph
	 */
	double compute_option0(double left, double right, boolean deriv) {
		if (deriv == true)
			return left * 1.60934;
		else
			return right * 0.621371;
	}

	void check_if_blank() {
		if (left_txt_field.getText().isEmpty())
			left_txt_field.setText("0");
		if (right_txt_field.getText().isEmpty())
			right_txt_field.setText("0");
	}

	/*
	 * Convert Inches to Meter
	 */
	double compute_option1(double left, double right, boolean deriv) {
		if (deriv == true)
			return left * 39.370;
		else
			return right / 39.370;
	}

	/*
	 * Convert Km to Light Year
	 */
	double compute_option2(double left, double right, boolean deriv) {
		double cons = 9.4605284 * (Math.pow(10, 12));
		if (deriv == true) {
			return left / cons;
		} else {
			return right * cons;
		}
	}

	/*
	 * Convert Celcius to Farenheight
	 */
	double compute_option3(double left, double right, boolean deriv) {
		double val;
		if (deriv == true) {
			val = 9 * left / 5 + 32;
			return val;
		} else {
			val = right = ((right - 32) * 5) / 9;
			return val;
		}
	}

	/*
	 * Action listener to handle the radio button actions
	 */
	ActionListener rb_action_listner = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			// Based on the radio button selected determinet the coumputation to
			// be performed
			for (int i = 0; i < radio_button_count; i++) {
				if (e.getActionCommand().equals(rb_name + i)) {
					// Action found
					option_selected = i;
					switch (i) {
					case 0:
						// "Mph to Kmph",
						left_txt_label.setText("Mph");
						right_txt_label.setText("Kmph");
						break;
					case 1:
						// "Inches to meter",
						left_txt_label.setText("Inches");
						right_txt_label.setText("Meter");

						break;
					case 2:
						// "Km to lightyear",
						left_txt_label.setText("Km");
						right_txt_label.setText("LightYear");

						break;
					case 3:
						// "Celcius to Fahrenheit"
						left_txt_label.setText("Celcius");
						right_txt_label.setText("Fahrenheit");
						break;
					}

				}
			}
		}
	};

	/*
	 * Create the elements on the screen
	 */
	screen() {
		/*
		 * Defualting the screen
		 */
		// decimalFormat.setGroupingUsed(false);
		left_txt_field.setText("0");
		right_txt_field.setText("0");

		/*
		 * Set editable
		 */

		left_txt_field.setEditable(false);
		right_txt_field.setEditable(false);
		left_txt_field.setBackground(Color.WHITE);
		right_txt_field.setBackground(Color.WHITE);

		right_txt_field.setText(String.valueOf(compute_option0(
				Double.parseDouble(left_txt_field.getText()),
				Double.parseDouble(right_txt_field.getText()), true)));

		getScreen();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		/*
		 * Set Screen Attributes
		 */
		frame.setBounds(100, 100, 600, 250);
		frame.setMinimumSize(new Dimension(600, 250));
		frame.setVisible(true);
	}

	/*
	 * Get the screen components
	 */
	public Component getScreen() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		frame.setLayout(layout);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		/*
		 * Add the radio button
		 */
		frame.add(createRadioButtons(), gbc);
		/*
		 * Add input and button
		 */

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		frame.add(createTextFields(), gbc);

		return frame;
	}

	/*
	 * Create Radio buttons for the option selection
	 */
	public Component createRadioButtons() {
		JPanel pane = new JPanel(new GridLayout(4, 1)); // Add a grid layout
		ButtonGroup group = new ButtonGroup();
		String radioButtonText[] = { "Mph to Kmph", "Inches to meter",
				"Km to lightyear", "Celcius to Fahrenheit" };
		JRadioButton radiobutton[] = new JRadioButton[radio_button_count];
		/*
		 * Create Radio Buttons for each conversion option toe be provided to be
		 * user and group them together
		 */

		for (int i = 0; i < radio_button_count; i++) {
			radiobutton[i] = new JRadioButton();
			radiobutton[i].setText(radioButtonText[i]);
			radiobutton[i].setActionCommand(rb_name + i);
			radiobutton[i].addActionListener(rb_action_listner);
			group.add(radiobutton[i]);
			pane.add(radiobutton[i]);
		}
		if (radio_button_count > 0)
			radiobutton[0].setSelected(true);
		return pane;
	}

	/*
	 * Create the text fields for the data entry Left field and Right field
	 */
	public Component createTextFields() {
		ActionListener button_action_listner = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Based on the button clicked determine the derivation
				 * direction and change the unit elements
				 */
				boolean deriv = true;

				double ret_val = 0;
				if (e.getActionCommand().equals("-->")) {
					deriv = true;
				} else {
					deriv = false;
				}
				check_if_blank();

				switch (option_selected) {
				case 0:
					// "Mph to Kmph",
					ret_val = compute_option0(
							Double.parseDouble(left_txt_field.getText()),
							Double.parseDouble(right_txt_field.getText()),
							deriv);
					if (deriv == true)
						right_txt_field.setText(String.valueOf(ret_val));
					else
						left_txt_field.setText(String.valueOf(ret_val));
					break;
				case 1:
					// "Inches to meter",
					ret_val = compute_option1(
							Double.parseDouble(left_txt_field.getText()),
							Double.parseDouble(right_txt_field.getText()),
							deriv);
					if (deriv == true)
						right_txt_field.setText(String.valueOf(ret_val));
					else
						left_txt_field.setText(String.valueOf(ret_val));

					break;
				case 2:
					// "Km to lightyear",
					ret_val = compute_option2(
							Double.parseDouble(left_txt_field.getText()),
							Double.parseDouble(right_txt_field.getText()),
							deriv);
					if (deriv == true)
						right_txt_field.setText(String.valueOf(ret_val));
					else
						left_txt_field.setText(String.valueOf(ret_val));

					break;
				case 3:
					// "Celcius to Fahrenheit"
					// "Inches to meter",
					ret_val = compute_option3(
							Double.parseDouble(left_txt_field.getText()),
							Double.parseDouble(right_txt_field.getText()),
							deriv);
					if (deriv == true)
						right_txt_field.setText(String.valueOf(ret_val));
					else
						left_txt_field.setText(String.valueOf(ret_val));

					break;
				}

			}
		};

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel pane = new JPanel(layout);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;

		/*
		 * **************************************************************
		 * Panel for buttons
		 */
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout((new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)));
		/*
		 * Button : -->
		 */
		JButton butleft = new JButton("    >>>    ");
		butleft.setActionCommand("-->");
		butleft.addActionListener(button_action_listner);
		/*
		 * Button : <--
		 */
		JButton butright = new JButton("    <<<    ");
		butright.setActionCommand("<--");
		butright.setSize(5, 10);
		butright.addActionListener(button_action_listner);
		/*
		 * Add the buttons to the Panel
		 */
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		buttonPanel.add(butleft, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		buttonPanel.add(butright, gbc);
		/*
		 * *******************************************************************
		 */

		/*
		 * Left Text Field Pane
		 */
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		JPanel left_txt_panel = new JPanel();
		left_txt_panel
				.setLayout(new BoxLayout(left_txt_panel, BoxLayout.Y_AXIS));
		Keypad left_keypad = new Keypad(left_txt_field);
		left_txt_panel.add(left_txt_label);
		left_txt_panel.add(left_txt_field);
		left_txt_panel.add(left_keypad.getKeypad());
		/*
		 * Right Text Field Pane
		 */
		JPanel right_txt_panel = new JPanel();
		right_txt_panel.setLayout(new BoxLayout(right_txt_panel,
				BoxLayout.Y_AXIS));
		Keypad right_keypad = new Keypad(right_txt_field);
		right_txt_panel.add(right_txt_label);
		right_txt_panel.add(right_txt_field);
		right_txt_panel.add(right_keypad.getKeypad());
		/*
		 * Add the components to main pane
		 */
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		pane.add(left_txt_panel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		pane.add(buttonPanel, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		pane.add(right_txt_panel, gbc);

		return pane;
	}

	/*
	 * Number keypad
	 */
	class Keypad implements ActionListener {
		public static final String clearAll = "C";
		public static final String clear = "CE";
		JTextField txtfield;
		JPanel keypad = new JPanel(new GridLayout(5, 3));
		JButton num_buttons[] = new JButton[13];

		Keypad(JTextField txtfield) {
			this.txtfield = txtfield;
			create_keypad();
		}

		public Component getKeypad() {
			return keypad;
		}

		public void actionPerformed(ActionEvent e) {
			String str;
			if (e.getActionCommand() == clearAll) {
				str = txtfield.getText();
				txtfield.setText("0");
			} else if (e.getActionCommand() == clear) {
				str = txtfield.getText();
				str = str.substring(0, str.length() - 1);
				if (str.equals(""))
					txtfield.setText("0");
				else
					txtfield.setText(str);

				/*
				 * if (str.equals("")) txtfield.setText("0");
				 */
				// txtfield.setText(str);
			} else if (e.getActionCommand() == ".") {
				str = txtfield.getText();
				if (!str.contains(".")) {
					str = str + e.getActionCommand();
					txtfield.setText(str);
				}
			} else {
				str = txtfield.getText();
				str = str + e.getActionCommand();
				txtfield.setText(str);
			}
		}

		Component create_keypad() {
			/*
			 * Add the number buttons
			 */
			for (int i = 0; i < 10; i++) {
				num_buttons[i] = new JButton("" + i);
				num_buttons[i].setActionCommand("" + i);
				num_buttons[i].addActionListener(this);
				keypad.add(num_buttons[i]);
			}

			/*
			 * Add the other buttons
			 */
			num_buttons[10] = new JButton(".");
			num_buttons[10].setActionCommand(".");
			num_buttons[10].addActionListener(this);
			keypad.add(num_buttons[10]);

			num_buttons[11] = new JButton(clearAll);
			num_buttons[11].setActionCommand(clearAll);
			num_buttons[11].addActionListener(this);
			keypad.add(num_buttons[11]);

			num_buttons[12] = new JButton(clear);
			num_buttons[12].setActionCommand(clear);
			num_buttons[12].addActionListener(this);
			keypad.add(num_buttons[12]);

			return keypad;
		}
	}
}

/*
 * Class for execution of the screen
 */
public class Application {

	public static void main(String[] args) {
		screen app = new screen();

	}

}

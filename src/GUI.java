import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/*
 * Utilize Java Swing Libraries to build the window, with layouts, buttons and actionListeners events to run the app.
 * Next, we use our CurrencyConverter class to give us the converted currencies results and we
 * just apply the value on the GUI
 */
public class GUI {

	private static String selectedCurrency = "None";

	public static void main(String[] args) {
		displayWindow();
	}

	/*
	 * Creates the top level of the window with size, layout and by actually calling
	 * UIFrame method
	 */
	private static void displayWindow() {
		JFrame frame = new JFrame("Currency Converter");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setResizable(false);

		JPanelWithBackground panel = new JPanelWithBackground(new ImageIcon("src/background.jpg").getImage());
		panel.setLayout(new FlowLayout()); // or whatever layout you want
		frame.setContentPane(panel);

		createUI(frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/*
	 * 
	 * Creates top_panel with five radio buttons and with a title Bottom panel with
	 * amount_label, amount_text_field and with a convert button Add them both with
	 * each top_layout and bottom_layout with the actual frame Lastly, just listens
	 * for any actions by calling actionListeners method and passing all the JRadio
	 * buttons and text_field as the parameters
	 * 
	 */
	private static void createUI(final JFrame frame) {
		JPanel top_panel = new JPanel();
		LayoutManager top_layout = new FlowLayout();
		top_panel.setLayout(top_layout);

		top_panel.setOpaque(false);

		JLabel title_label = new JLabel("Select The Currency You Want To Convert From:", JLabel.CENTER);
		title_label.setHorizontalAlignment(JLabel.CENTER);
		title_label.setVerticalAlignment(JLabel.CENTER);
		title_label.setFont(new Font("Calibri", Font.BOLD, 18));
		title_label.setBorder(new EmptyBorder(50, 0, 0, 0));

		title_label.setFont(new Font("Calibri", Font.BOLD, 18));
		title_label.setForeground(Color.white);

		JRadioButton dollar_btn = new JRadioButton("DOLLAR");
		JRadioButton pound_btn = new JRadioButton("POUND");
		JRadioButton euro_btn = new JRadioButton("EURO");
		JRadioButton yen_btn = new JRadioButton("YEN");
		JRadioButton rupee_btn = new JRadioButton("RUPEE");

		dollar_btn.setFocusable(false);
		dollar_btn.setOpaque(false);
		dollar_btn.setFont(new Font("Calibri", Font.BOLD, 18));
		dollar_btn.setForeground(Color.white);

		pound_btn.setFocusable(false);
		pound_btn.setOpaque(false);
		pound_btn.setFont(new Font("Calibri", Font.BOLD, 18));
		pound_btn.setForeground(Color.white);

		euro_btn.setFocusable(false);
		euro_btn.setOpaque(false);
		euro_btn.setFont(new Font("Calibri", Font.BOLD, 18));
		euro_btn.setForeground(Color.white);

		yen_btn.setFocusable(false);
		yen_btn.setOpaque(false);
		yen_btn.setFont(new Font("Calibri", Font.BOLD, 18));
		yen_btn.setForeground(Color.white);

		rupee_btn.setFocusable(false);
		rupee_btn.setOpaque(false);
		rupee_btn.setFont(new Font("Calibri", Font.BOLD, 18));
		rupee_btn.setForeground(Color.white);

		JLabel amount_label = new JLabel("Amount:", JLabel.CENTER);
		JButton convert_button = new JButton("Convert");

		convert_button.setFont(new Font("Calibri", Font.BOLD, 18));
		convert_button.setForeground(Color.white);
		convert_button.setBackground(Color.decode("#7DB4FE"));

		amount_label.setFont(new Font("Calibri", Font.BOLD, 18));
		amount_label.setForeground(Color.white);

		JTextField amount_field = new JTextField(5);
		amount_field.setFont(new Font("Calibri", Font.BOLD, 18));

		JPanel bottom_panel = new JPanel();
		LayoutManager bottom_layout = new FlowLayout();
		bottom_panel.setLayout(bottom_layout);
		bottom_panel.setBorder(new EmptyBorder(0, 100, 0, 100));

		bottom_panel.setOpaque(true);
		bottom_panel.setBackground(new Color(0, 0, 0, 0));

		frame.add(title_label);
		top_panel.add(dollar_btn);
		top_panel.add(pound_btn);
		top_panel.add(rupee_btn);
		top_panel.add(euro_btn);
		top_panel.add(yen_btn);

		frame.getContentPane().add(top_panel, BorderLayout.CENTER);

		bottom_panel.add(amount_label);
		bottom_panel.add(amount_field);
		bottom_panel.add(convert_button);

		frame.getContentPane().add(bottom_panel, BorderLayout.CENTER);

		JPanel converted_result_panel = new JPanel();
		LayoutManager converted_result_panel_layout = new GridLayout(0, 2);
		converted_result_panel.setLayout(converted_result_panel_layout);

		converted_result_panel.setBorder(new EmptyBorder(25, 0, 0, 0));
		converted_result_panel.setOpaque(false);

		JLabel dollar = new JLabel("Dollar($) :", JLabel.CENTER);
		JLabel dollar_result = new JLabel("0", JLabel.CENTER);
		JLabel pound = new JLabel("Pound(\u00a3) :", JLabel.CENTER);
		JLabel pound_result = new JLabel("0", JLabel.CENTER);
		JLabel rupee = new JLabel("Rupee(\u20B9) :", JLabel.CENTER);
		JLabel rupee_result = new JLabel("0", JLabel.CENTER);
		JLabel yen = new JLabel("Yen(\u00A5) :", JLabel.RIGHT);
		JLabel yen_result = new JLabel("0", JLabel.CENTER);
		JLabel euro = new JLabel("Euro(\u20AC) :", JLabel.RIGHT);
		JLabel euro_result = new JLabel("0", JLabel.CENTER);

		dollar.setFont(new Font("Calibri", Font.BOLD, 18));
		dollar_result.setFont(new Font("Calibri", Font.BOLD, 18));
		pound.setFont(new Font("Calibri", Font.BOLD, 18));
		pound_result.setFont(new Font("Calibri", Font.BOLD, 18));
		rupee.setFont(new Font("Calibri", Font.BOLD, 18));
		rupee_result.setFont(new Font("Calibri", Font.BOLD, 18));
		yen.setFont(new Font("Calibri", Font.BOLD, 18));
		yen_result.setFont(new Font("Calibri", Font.BOLD, 18));
		euro.setFont(new Font("Calibri", Font.BOLD, 18));
		euro_result.setFont(new Font("Calibri", Font.BOLD, 18));

		dollar.setForeground(Color.white);
		dollar_result.setForeground(Color.white);
		pound.setForeground(Color.white);
		pound_result.setForeground(Color.white);
		rupee.setForeground(Color.white);
		rupee_result.setForeground(Color.white);
		yen.setForeground(Color.white);
		yen_result.setForeground(Color.white);
		euro.setForeground(Color.white);
		euro_result.setForeground(Color.white);

		converted_result_panel.add(dollar);
		converted_result_panel.add(dollar_result);
		converted_result_panel.add(pound);
		converted_result_panel.add(pound_result);

		converted_result_panel.add(rupee);
		converted_result_panel.add(rupee_result);
		converted_result_panel.add(yen);
		converted_result_panel.add(yen_result);
		converted_result_panel.add(euro);
		converted_result_panel.add(euro_result);

		frame.getContentPane().add(converted_result_panel);

		// Button Action Listeners
		actionsListeners(dollar_btn, pound_btn, euro_btn, rupee_btn, yen_btn, convert_button, amount_field, frame,
				dollar_result, pound_result, rupee_result, yen_result, euro_result);

	}

	/*
	 * Takes four JRadioButton as a parameters Listens their actions and if one of
	 * them is selected, then the other will be disabled
	 */
	private static void actionsListeners(JRadioButton dollar_btn, JRadioButton pound_btn, JRadioButton euro_btn,
			JRadioButton rupee_btn, JRadioButton yen_btn, JButton convert_button, JTextField amount_field, JFrame frame,
			JLabel dollar_result, JLabel pound_result, JLabel rupee_result, JLabel yen_result, JLabel euro_result) {

		convert_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String getValue = amount_field.getText();
				try {
					if (getValue.equals("") || getValue.contains(" ")) {
						JOptionPane.showMessageDialog(frame, "Amount is required!", "Alert", JOptionPane.ERROR_MESSAGE);
					} else if (Double.parseDouble(getValue) < 0) {
						JOptionPane.showMessageDialog(frame, "Amount can't be negative!", "Alert",
								JOptionPane.ERROR_MESSAGE);
					}

					else if (selectedCurrency.equals("None")) {
						JOptionPane.showMessageDialog(frame, "Base currency must be selected", "Alert",
								JOptionPane.ERROR_MESSAGE);
					} else {

						CurrencyConverter currencyConverter = new CurrencyConverter(Double.parseDouble(getValue));
						CurrencyConverter.currencyConversion(selectedCurrency);

						Hashtable<String, String> cc = CurrencyConverter.getConverted_currencies();

						dollar_result.setText((cc.get("Dollar") == null) ? "Done!" : cc.get("Dollar"));
						pound_result.setText((cc.get("Pound") == null) ? "Done!" : cc.get("Pound"));
						rupee_result.setText((cc.get("Rupee") == null) ? "Done!" : cc.get("Rupee"));
						yen_result.setText((cc.get("Yen") == null) ? "Done!" : cc.get("Yen"));
						euro_result.setText((cc.get("Euro") == null) ? "Done!" : cc.get("Euro"));
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(frame, "Enter a valid amount", "Alert", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		dollar_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if (((JRadioButton) source).isSelected()) {
					yen_btn.setEnabled(false);
					rupee_btn.setEnabled(false);
					pound_btn.setEnabled(false);
					euro_btn.setEnabled(false);
					selectedCurrency = "DOLLAR";
				} else {
					yen_btn.setEnabled(true);
					rupee_btn.setEnabled(true);
					pound_btn.setEnabled(true);
					euro_btn.setEnabled(true);
					selectedCurrency = "None";
				}

			}
		});

		yen_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if (((JRadioButton) source).isSelected()) {
					dollar_btn.setEnabled(false);
					rupee_btn.setEnabled(false);
					pound_btn.setEnabled(false);
					euro_btn.setEnabled(false);
					selectedCurrency = "YEN";
				} else {
					dollar_btn.setEnabled(true);
					rupee_btn.setEnabled(true);
					pound_btn.setEnabled(true);
					euro_btn.setEnabled(true);
					selectedCurrency = "None";
				}

			}
		});

		rupee_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if (((JRadioButton) source).isSelected()) {
					yen_btn.setEnabled(false);
					dollar_btn.setEnabled(false);
					euro_btn.setEnabled(false);
					pound_btn.setEnabled(false);
					selectedCurrency = "RUPEE";
				} else {
					yen_btn.setEnabled(true);
					dollar_btn.setEnabled(true);
					euro_btn.setEnabled(true);
					pound_btn.setEnabled(true);
					selectedCurrency = "None";
				}

			}
		});
		pound_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if (((JRadioButton) source).isSelected()) {
					yen_btn.setEnabled(false);
					dollar_btn.setEnabled(false);
					euro_btn.setEnabled(false);
					rupee_btn.setEnabled(false);
					selectedCurrency = "POUND";
				} else {
					yen_btn.setEnabled(true);
					dollar_btn.setEnabled(true);
					euro_btn.setEnabled(true);
					rupee_btn.setEnabled(true);
					selectedCurrency = "None";
				}

			}
		});
		euro_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if (((JRadioButton) source).isSelected()) {
					yen_btn.setEnabled(false);
					dollar_btn.setEnabled(false);
					pound_btn.setEnabled(false);
					rupee_btn.setEnabled(false);
					selectedCurrency = "EURO";
				} else {
					yen_btn.setEnabled(true);
					dollar_btn.setEnabled(true);
					pound_btn.setEnabled(true);
					rupee_btn.setEnabled(true);
					selectedCurrency = "None";
				}

			}
		});

	}
}
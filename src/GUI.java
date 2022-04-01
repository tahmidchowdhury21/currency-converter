import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class GUI {

	public static void main(String[] args) {
		displayWindow();
	}
	
	private static void displayWindow() {    
	      JFrame frame = new JFrame("Currency Converter");
	      frame.setLayout(new FlowLayout());
	      
	      
	      
	      JLabel title_label = new JLabel("Select The Currency You Want To Convert From:",JLabel.CENTER);
	      title_label.setHorizontalAlignment(JLabel.CENTER);
	      title_label.setVerticalAlignment(JLabel.CENTER);

	      
	      frame.add(title_label); 
	      
	      createUI(frame);
	      
	      
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setSize(560, 200);      
	      frame.setLocationRelativeTo(null);  
	      frame.setVisible(true);
	   }

	   private static void createUI(final JFrame frame){  
	      JPanel panel = new JPanel();
	      LayoutManager layout = new FlowLayout();  
	      panel.setLayout(layout);       
	      

	      JRadioButton dollar_btn = new JRadioButton("DOLLAR");
	      JRadioButton pound_btn = new JRadioButton("POUND");
	      JRadioButton euro_btn = new JRadioButton("EURO");
	      JRadioButton yen_btn = new JRadioButton("YEN");
	      JRadioButton rupee_btn = new JRadioButton("RUPEE");

	      dollar_btn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            Object source = e.getSource();
	            if(((JRadioButton)source).isSelected()) {
	            	yen_btn.setEnabled(false);
	            	rupee_btn.setEnabled(false);
	            	pound_btn.setEnabled(false);
	            	euro_btn.setEnabled(false);
	            }
	            else {
	            	yen_btn.setEnabled(true);
	            	rupee_btn.setEnabled(true);
	            	pound_btn.setEnabled(true);
	            	euro_btn.setEnabled(true);
	            }
	           
	         }
	      });
	      
	      yen_btn.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		            Object source = e.getSource();
		            if(((JRadioButton)source).isSelected()) {
		            	dollar_btn.setEnabled(false);
		            	rupee_btn.setEnabled(false);
		            	pound_btn.setEnabled(false);
		            	euro_btn.setEnabled(false);
		            }
		            else {
		            	dollar_btn.setEnabled(true);
		            	rupee_btn.setEnabled(true);
		            	pound_btn.setEnabled(true);
		            	euro_btn.setEnabled(true);
		            }
		            
		           
		         }
		      });
	      
	      rupee_btn.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		            Object source = e.getSource();
		            if(((JRadioButton)source).isSelected()) {
		            	yen_btn.setEnabled(false);
		            	dollar_btn.setEnabled(false);
		            	euro_btn.setEnabled(false);
		            	pound_btn.setEnabled(false);
		            }
		            else {
		            	yen_btn.setEnabled(true);
		            	dollar_btn.setEnabled(true);
		            	euro_btn.setEnabled(true);
		            	pound_btn.setEnabled(true);
		            }
		            
		           
		         }
		      });
	      pound_btn.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		            Object source = e.getSource();
		            if(((JRadioButton)source).isSelected()) {
		            	yen_btn.setEnabled(false);
		            	dollar_btn.setEnabled(false);
		            	euro_btn.setEnabled(false);
		            	rupee_btn.setEnabled(false);
		            }
		            else {
		            	yen_btn.setEnabled(true);
		            	dollar_btn.setEnabled(true);
		            	euro_btn.setEnabled(true);
		            	rupee_btn.setEnabled(true);
		            }
		            
		           
		         }
		      });
	      euro_btn.addActionListener(new ActionListener() {
		         @Override
		         public void actionPerformed(ActionEvent e) {
		            Object source = e.getSource();
		            if(((JRadioButton)source).isSelected()) {
		            	yen_btn.setEnabled(false);
		            	dollar_btn.setEnabled(false);
		            	pound_btn.setEnabled(false);
		            	rupee_btn.setEnabled(false);
		            }
		            else {
		            	yen_btn.setEnabled(true);
		            	dollar_btn.setEnabled(true);
		            	pound_btn.setEnabled(true);
		            	rupee_btn.setEnabled(true);
		            }
		            
		           
		         }
		      });

	      
	      panel.add(dollar_btn);
	      panel.add(pound_btn);
	      panel.add(rupee_btn);
	      panel.add(euro_btn);
	      panel.add(yen_btn);
	      
	      

	      frame.getContentPane().add(panel, BorderLayout.CENTER);    
	   }
	}
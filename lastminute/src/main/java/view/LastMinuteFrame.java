package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Records;

public class LastMinuteFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Controller controller;

	private JLabel labelOrigin;
	private JTextField origin;
	private JLabel labelDestination;
	private JTextField destination;
	private JLabel labelDeparture;
	private JFormattedTextField departure;
	private JLabel labelPassengers;
	private JTextField passengers;
	private JButton search;
	private boolean visible;
	
	public LastMinuteFrame(boolean v) {
		visible = v;
		this.setTitle("Lastminute");
		this.setLayout(new BorderLayout());
		
		createComponents();
		
		centerFrame();
		
		setVisible(v);
	}
	
	private void createComponents() {
		labelOrigin = new JLabel("Origin: ");
		origin = new JTextField(3);
		labelDestination = new JLabel("Destination: ");
		destination = new JTextField(3);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		
		topPanel.add(labelOrigin);
		topPanel.add(origin);
		topPanel.add(labelDestination);
		topPanel.add(destination);
		
		add(topPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		
		labelDeparture = new JLabel("Departure: ");
		departure = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
		departure.setValue(new java.util.Date());
		labelPassengers = new JLabel("Passengers: ");
		passengers = new JTextField(2);
		
		centerPanel.add(labelDeparture);
		centerPanel.add(departure);
		centerPanel.add(labelPassengers);
		centerPanel.add(passengers);
		
		add(centerPanel, BorderLayout.CENTER);
		
		search = new JButton("Search");
		search.addActionListener(this);
		
		JPanel downPanel = new JPanel();
		downPanel.setLayout(new FlowLayout());
		
		downPanel.add(search);
		
		add(downPanel, BorderLayout.SOUTH);
	}

	private void centerFrame() {
		pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	public void actionPerformed(ActionEvent arg0) {
		controller.search(origin.getText(), destination.getText(), 
				departure.getText(), Integer.parseInt(passengers.getText()));
	}

	public void setController(Controller c) {
		controller = c;
		
	}

	public void showflights(Records flights) {
		if(visible) {
			JOptionPane.showMessageDialog(this, flights, "Flights - Prices",
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

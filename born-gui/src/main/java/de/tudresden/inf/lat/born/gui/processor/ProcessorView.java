package de.tudresden.inf.lat.born.gui.processor;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import de.tudresden.inf.lat.born.gui.BornIcon;
import de.tudresden.inf.lat.born.gui.Message;
import de.tudresden.inf.lat.born.owlapi.processor.ProcessorConfiguration;

/**
 * This is the panel to compute inference.
 * 
 * @author Julian Mendez
 */
public class ProcessorView extends JPanel {

	private static final long serialVersionUID = -3489883631448640992L;

	public static final String WRONG_FILE_NAME_ERROR_MESSAGE = "WRONG FILE NAME! --> ";

	private JButton buttonInputOntologyFile = new JButton();
	private JButton buttonBayesianNetwork = new JButton();
	private JButton buttonConsoleInput = new JButton();
	private JButton buttonConsoleOutput = new JButton();
	private JButton buttonComputeInference = new JButton();
	private JLabel labelProgress = new JLabel("computing ...");
	private JTextField textInputOntologyFile = new JTextField();
	private JTextField textBayesianNetworkFile = new JTextField();
	private JTextArea textConsoleInput = new JTextArea();
	private JTextArea textConsoleOutput = new JTextArea();
	private JScrollPane scrollConsoleInput = new JScrollPane();
	private JScrollPane scrollConsoleOutput = new JScrollPane();
	private final ProcessorConfiguration model;

	public ProcessorView(ProcessorConfiguration model) {
		if (model == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.model = model;
		setLayout(null);
		createPanel();
	}

	public void addButtonInputOntologyListener(ActionListener listener, String actionCommand) {
		if (listener == null) {
			throw new IllegalArgumentException("Null argument.");
		}
		if (actionCommand == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.buttonInputOntologyFile.addActionListener(listener);
		this.buttonInputOntologyFile.setActionCommand(actionCommand);
	}

	public void addButtonBayesianNetworkListener(ActionListener listener, String actionCommand) {
		if (listener == null) {
			throw new IllegalArgumentException("Null argument.");
		}
		if (actionCommand == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.buttonBayesianNetwork.addActionListener(listener);
		this.buttonBayesianNetwork.setActionCommand(actionCommand);
	}

	public void addButtonConsoleInputListener(ActionListener listener, String actionCommand) {
		if (listener == null) {
			throw new IllegalArgumentException("Null argument.");
		}
		if (actionCommand == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.buttonConsoleInput.addActionListener(listener);
		this.buttonConsoleInput.setActionCommand(actionCommand);
	}

	public void addButtonConsoleOutputListener(ActionListener listener, String actionCommand) {
		if (listener == null) {
			throw new IllegalArgumentException("Null argument.");
		}
		if (actionCommand == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.buttonConsoleOutput.addActionListener(listener);
		this.buttonConsoleOutput.setActionCommand(actionCommand);
	}

	public void addButtonComputeInferenceListener(ActionListener listener, String actionCommand) {
		if (listener == null) {
			throw new IllegalArgumentException("Null argument.");
		}
		if (actionCommand == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.buttonComputeInference.addActionListener(listener);
		this.buttonComputeInference.setActionCommand(actionCommand);
	}

	void createPanel() {

		JLabel lblNewLabel = new JLabel("ontology");
		lblNewLabel.setBounds(168, 83, 70, 15);
		add(lblNewLabel);

		buttonInputOntologyFile.setIcon(BornIcon.OPEN_FILE);
		buttonInputOntologyFile.setBounds(168, 43, 54, 28);
		add(buttonInputOntologyFile);
		buttonInputOntologyFile.setToolTipText(Message.tooltipOpenInputOntologyFile);

		textInputOntologyFile.setBounds(282, 43, 228, 28);
		add(textInputOntologyFile);
		textInputOntologyFile.setToolTipText(Message.tooltipTextFieldInputOntologyFile);
		textInputOntologyFile.setAlignmentX(LEFT_ALIGNMENT);

		JLabel lblNewLabel_1 = new JLabel("Bayesian network");
		lblNewLabel_1.setBounds(168, 184, 128, 15);
		add(lblNewLabel_1);

		buttonBayesianNetwork.setIcon(BornIcon.OPEN_FILE);
		buttonBayesianNetwork.setBounds(168, 135, 54, 28);
		add(buttonBayesianNetwork);
		buttonBayesianNetwork.setToolTipText(Message.tooltipOpenInputOntologyFile);

		textBayesianNetworkFile.setBounds(282, 152, 228, 28);
		add(textBayesianNetworkFile);
		textBayesianNetworkFile.setToolTipText(Message.tooltipTextFieldBayesianNetworkFile);
		textBayesianNetworkFile.setAlignmentX(LEFT_ALIGNMENT);

		JLabel lblInput = new JLabel("input");
		lblInput.setBounds(168, 283, 70, 15);
		add(lblInput);

		buttonConsoleInput.setIcon(BornIcon.OPEN_FILE);
		buttonConsoleInput.setBounds(168, 246, 54, 28);
		add(buttonConsoleInput);
		buttonConsoleInput.setToolTipText(Message.tooltipOpenInputOntologyFile);

		textBayesianNetworkFile.setBounds(282, 135, 228, 28);
		add(textBayesianNetworkFile);

		textConsoleInput.setToolTipText(Message.tooltipTextFieldListOfParents);
		textConsoleInput.setAlignmentX(LEFT_ALIGNMENT);

		scrollConsoleInput.setBounds(282, 246, 228, 65);
		add(scrollConsoleInput);
		scrollConsoleInput.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollConsoleInput.setViewportView(textConsoleInput);

		JLabel lblOutput = new JLabel("output");
		lblOutput.setBounds(168, 395, 70, 15);
		add(lblOutput);

		textConsoleOutput.setToolTipText(Message.tooltipTextFieldOutputFile);
		textConsoleOutput.setAlignmentX(LEFT_ALIGNMENT);
		scrollConsoleOutput.setViewportView(textConsoleOutput);

		buttonConsoleOutput.setIcon(BornIcon.SAVE_FILE);
		buttonConsoleOutput.setBounds(168, 355, 54, 28);
		add(buttonConsoleOutput);
		buttonConsoleOutput.setToolTipText(Message.tooltipOpenInputOntologyFile);

		scrollConsoleOutput.setBounds(282, 355, 228, 65);
		add(scrollConsoleOutput);
		scrollConsoleOutput.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		buttonComputeInference.setIcon(BornIcon.RUN);
		buttonComputeInference.setBounds(168, 476, 54, 28);
		add(buttonComputeInference);
		buttonComputeInference.setToolTipText(Message.tooltipComputeInference);

		labelProgress.setBounds(168, 516, 99, 15);
		labelProgress.setVisible(false);
		add(labelProgress);

	}

	String read(Reader r) throws IOException {
		StringBuffer sbuf = new StringBuffer();
		BufferedReader in = new BufferedReader(r);
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			sbuf.append(line);
			sbuf.append("\n");
		}
		return sbuf.toString();
	}

	void write(Reader input, Writer output) throws IOException {
		BufferedWriter out = new BufferedWriter(output);
		BufferedReader in = new BufferedReader(input);
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			out.write(line);
			out.newLine();
		}
		out.flush();
	}

	public ProcessorConfiguration getModel() {
		return this.model;
	}

	public String getInputOntology() {
		return this.textInputOntologyFile.getText();
	}

	public void setInputOntology(String fileName) {
		this.textInputOntologyFile.setText(fileName);
	}

	public String getBayesianNetwork() {
		return this.textBayesianNetworkFile.getText();
	}

	public void setBayesianNetwork(String fileName) {
		this.textBayesianNetworkFile.setText(fileName);
	}

	public String getConsoleInput() {
		return this.textConsoleInput.getText();
	}

	public void setConsoleInput(String text) {
		this.textConsoleInput.setText(text);
	}

	public void readConsoleInput(String consoleInputFile) {
		if (consoleInputFile != null && !consoleInputFile.trim().isEmpty()) {
			try {
				String text = read(new FileReader(consoleInputFile));
				this.textConsoleInput.setText(text);
				updateQuery();
			} catch (IOException e) {
				setInputOntology(WRONG_FILE_NAME_ERROR_MESSAGE);
			}
		}
	}

	public void writeConsoleOutput(String consoleOutputFile) {
		if (consoleOutputFile != null && !consoleOutputFile.trim().isEmpty()) {
			try {
				String text = this.textConsoleOutput.getText();
				write(new StringReader(text), new FileWriter(consoleOutputFile));
			} catch (IOException e) {
				setInputOntology(WRONG_FILE_NAME_ERROR_MESSAGE);
			}
		}
	}

	public String getConsoleOutput() {
		return this.textConsoleOutput.getText();
	}

	public void setConsoleOutput(String fileName) {
		this.textConsoleOutput.setText(fileName);
	}

	public void setButtonLoadEnabled(boolean b) {
		this.buttonInputOntologyFile.setEnabled(b);
	}

	public void setButtonComputeInferenceEnabled(boolean b) {
		this.buttonComputeInference.setEnabled(b);
	}

	void updateInputOntologyFile() {
		String inputOntologyFile = getInputOntology();
		if (inputOntologyFile != null && !inputOntologyFile.trim().isEmpty()) {
			try {
				getModel().setOntologyInputStream(new FileInputStream(inputOntologyFile));
			} catch (IOException e) {
				setInputOntology(WRONG_FILE_NAME_ERROR_MESSAGE);
			}
		}
	}

	void updateBayesianNetworkFile() {
		String bayesianNetworkFile = getBayesianNetwork();
		if (bayesianNetworkFile != null && !bayesianNetworkFile.trim().isEmpty()) {
			try {
				getModel().setBayesianNetworkInputStream(new FileInputStream(bayesianNetworkFile));
			} catch (IOException e) {
				setBayesianNetwork(WRONG_FILE_NAME_ERROR_MESSAGE);
			}
		}
	}

	void updateQuery() {
		String query = this.textConsoleInput.getText();
		if (query != null && !query.trim().isEmpty()) {
			getModel().setQueryInputStream(new ByteArrayInputStream(query.getBytes()));
		}
	}

	void updateConsoleOutputFile() {
		String consoleOutputFile = getConsoleOutput();
		if (consoleOutputFile != null && !consoleOutputFile.trim().isEmpty()) {
			setResult(consoleOutputFile);
		}
	}

	public void setResult(String result) {
		this.textConsoleOutput.setText(result);
	}

	public void setComputing(boolean status) {
		labelProgress.setVisible(status);
	}

	public void setButtonsEnabled(boolean status) {
		buttonInputOntologyFile.setEnabled(status);
		buttonBayesianNetwork.setEnabled(status);
		buttonConsoleInput.setEnabled(status);
		buttonConsoleOutput.setEnabled(status);
		buttonComputeInference.setEnabled(status);
	}

}
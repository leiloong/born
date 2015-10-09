package de.tudresden.inf.lat.born.gui.experimentmaker;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.tudresden.inf.lat.born.gui.BornIcon;
import de.tudresden.inf.lat.born.gui.Message;
import de.tudresden.inf.lat.born.owlapi.multiprocessor.MultiProcessorConfiguration;

/**
 * This is the panel to compute inference.
 * 
 * @author Julian Mendez
 */
public class ExperimentMakerView extends JPanel {

	private static final long serialVersionUID = 8987374313881883318L;

	public static final String WRONG_FILE_NAME_ERROR_MESSAGE = "WRONG FILE NAME! --> ";

	private JButton buttonInputOntologyDirectory = new JButton();
	private JButton buttonBayesianNetworkDirectory = new JButton();
	private JButton buttonOutputDirectory = new JButton();
	private JButton buttonUpdateSeed = new JButton();
	private JButton buttonComputeInference = new JButton();
	private JLabel labelProgress = new JLabel("computing ...");
	private JTextField textInputOntologyDirectory = new JTextField();
	private JTextField textBayesianNetworkDirectory = new JTextField();
	private JTextField textNumberOfQueries = new JTextField();
	private JTextField textOutputDirectory = new JTextField();
	private JTextField textSeed = new JTextField();
	private final MultiProcessorConfiguration model;

	public ExperimentMakerView(MultiProcessorConfiguration model) {
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

		this.buttonInputOntologyDirectory.addActionListener(listener);
		this.buttonInputOntologyDirectory.setActionCommand(actionCommand);
	}

	public void addButtonBayesianNetworkListener(ActionListener listener, String actionCommand) {
		if (listener == null) {
			throw new IllegalArgumentException("Null argument.");
		}
		if (actionCommand == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.buttonBayesianNetworkDirectory.addActionListener(listener);
		this.buttonBayesianNetworkDirectory.setActionCommand(actionCommand);
	}

	public void addButtonConsoleInputListener(ActionListener listener, String actionCommand) {
		if (listener == null) {
			throw new IllegalArgumentException("Null argument.");
		}
		if (actionCommand == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.buttonOutputDirectory.addActionListener(listener);
		this.buttonOutputDirectory.setActionCommand(actionCommand);
	}

	public void addButtonConsoleOutputListener(ActionListener listener, String actionCommand) {
		if (listener == null) {
			throw new IllegalArgumentException("Null argument.");
		}
		if (actionCommand == null) {
			throw new IllegalArgumentException("Null argument.");
		}

		this.buttonUpdateSeed.addActionListener(listener);
		this.buttonUpdateSeed.setActionCommand(actionCommand);
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

		JLabel lblInputOntologyDirectory = new JLabel("ontology directory");
		lblInputOntologyDirectory.setBounds(292, 83, 128, 15);
		add(lblInputOntologyDirectory);

		buttonInputOntologyDirectory.setIcon(BornIcon.OPEN_FILE);
		buttonInputOntologyDirectory.setBounds(216, 43, 54, 28);
		buttonInputOntologyDirectory.setToolTipText(Message.tooltipOpenInputOntologyFile);
		add(buttonInputOntologyDirectory);

		textInputOntologyDirectory.setBounds(282, 43, 688, 28);
		textInputOntologyDirectory.setToolTipText(Message.tooltipTextFieldInputOntologyFile);
		textInputOntologyDirectory.setAlignmentX(LEFT_ALIGNMENT);
		add(textInputOntologyDirectory);

		JLabel lblBayesianNetworkDirectory = new JLabel("Bayesian network directory");
		lblBayesianNetworkDirectory.setBounds(292, 186, 220, 15);
		add(lblBayesianNetworkDirectory);

		buttonBayesianNetworkDirectory.setIcon(BornIcon.OPEN_FILE);
		buttonBayesianNetworkDirectory.setBounds(216, 135, 54, 28);
		buttonBayesianNetworkDirectory.setToolTipText(Message.tooltipOpenInputOntologyFile);
		add(buttonBayesianNetworkDirectory);

		textBayesianNetworkDirectory.setBounds(282, 135, 688, 28);
		textBayesianNetworkDirectory.setToolTipText(Message.tooltipTextFieldBayesianNetworkFile);
		textBayesianNetworkDirectory.setAlignmentX(LEFT_ALIGNMENT);
		add(textBayesianNetworkDirectory);

		JLabel lblInput = new JLabel("output directory");
		lblInput.setBounds(292, 283, 128, 15);
		add(lblInput);

		buttonOutputDirectory.setIcon(BornIcon.OPEN_FILE);
		buttonOutputDirectory.setBounds(216, 243, 54, 28);
		buttonOutputDirectory.setToolTipText(Message.tooltipButtonOutputDirectory);
		add(buttonOutputDirectory);

		textOutputDirectory = new JTextField();
		textOutputDirectory.setToolTipText(Message.tooltipTextFieldOutputDirectory);
		textOutputDirectory.setAlignmentX(LEFT_ALIGNMENT);
		textOutputDirectory.setBounds(282, 243, 688, 28);
		add(textOutputDirectory);

		JLabel lblNumberOfQueries = new JLabel(Message.textNumberOfQueries);
		lblNumberOfQueries.setBounds(292, 381, 140, 15);
		add(lblNumberOfQueries);

		textNumberOfQueries.setBounds(290, 341, 106, 28);
		textNumberOfQueries.setToolTipText(Message.tooltipTextFieldNumberOfQueries);
		textNumberOfQueries.setAlignmentX(LEFT_ALIGNMENT);
		add(textNumberOfQueries);

		JLabel lblSeed = new JLabel(Message.textSeed);
		lblSeed.setBounds(550, 381, 70, 15);
		add(lblSeed);

		textSeed.setBounds(540, 341, 89, 28);
		textSeed.setToolTipText(Message.tooltipTextFieldSeed);
		textSeed.setAlignmentX(LEFT_ALIGNMENT);
		add(textSeed);

		buttonUpdateSeed.setIcon(BornIcon.REFRESH);
		buttonUpdateSeed.setBounds(474, 341, 54, 28);
		buttonUpdateSeed.setToolTipText(Message.tooltipButtonUpdateSeed);
		add(buttonUpdateSeed);

		buttonComputeInference.setIcon(BornIcon.RUN);
		buttonComputeInference.setBounds(227, 429, 54, 28);
		buttonComputeInference.setToolTipText(Message.tooltipComputeInference);
		add(buttonComputeInference);

		labelProgress.setBounds(237, 478, 99, 15);
		labelProgress.setVisible(false);
		add(labelProgress);

	}

	public MultiProcessorConfiguration getModel() {
		return this.model;
	}

	public String getInputOntologyDirectory() {
		return this.textInputOntologyDirectory.getText();
	}

	public void setInputOntologyDirectory(String fileName) {
		this.textInputOntologyDirectory.setText(fileName);
		updateInputOntologyDirectory();
	}

	public String getBayesianNetworkDirectory() {
		return this.textBayesianNetworkDirectory.getText();
	}

	public void setBayesianNetworkDirectory(String fileName) {
		this.textBayesianNetworkDirectory.setText(fileName);
		updateBayesianNetworkDirectory();
	}

	public String getOutputDirectory() {
		return this.textOutputDirectory.getText();
	}

	public void setOutputDirectory(String fileName) {
		this.textOutputDirectory.setText(fileName);
		updateOutputDirectory();
	}

	public void setButtonLoadEnabled(boolean b) {
		this.buttonInputOntologyDirectory.setEnabled(b);
	}

	public void setButtonComputeInferenceEnabled(boolean b) {
		this.buttonComputeInference.setEnabled(b);
	}

	void updateInputOntologyDirectory() {
		String inputOntologyDirectory = getInputOntologyDirectory();
		if (inputOntologyDirectory != null && !inputOntologyDirectory.trim().isEmpty()) {
			// try {
			// getModel().setOntology(ProcessorConfiguration.readOntology(new
			// FileInputStream(inputOntologyFile)));
			// } catch (IOException e) {
			// setInputOntology(WRONG_FILE_NAME_ERROR_MESSAGE);
			// } catch (OWLOntologyCreationException e) {
			// setInputOntology(WRONG_FILE_NAME_ERROR_MESSAGE);
			// }
		}
	}

	void updateBayesianNetworkDirectory() {
		String bayesianNetworkDirectory = getBayesianNetworkDirectory();
		if (bayesianNetworkDirectory != null && !bayesianNetworkDirectory.trim().isEmpty()) {
			// try {
			// getModel().setBayesianNetwork(ProcessorConfiguration.read(new
			// FileReader(bayesianNetworkFile)));
			// } catch (IOException e) {
			// setBayesianNetwork(WRONG_FILE_NAME_ERROR_MESSAGE);
			// }
		}
	}

	void updateOutputDirectory() {
		String outputDirectory = getOutputDirectory();
		if (outputDirectory != null && !outputDirectory.trim().isEmpty()) {
			// try {
			// getModel().setBayesianNetwork(ProcessorConfiguration.read(new
			// FileReader(bayesianNetworkFile)));
			// } catch (IOException e) {
			// setBayesianNetwork(WRONG_FILE_NAME_ERROR_MESSAGE);
			// }
		}
	}

	void updateSeed() {
		String seedStr = this.textSeed.getText();
		int seed = 0;
		try {
			seed = Integer.parseInt(seedStr);
		} catch (NumberFormatException e) {
		}
		this.textSeed.setText("" + seed);
		this.model.setSeed(seed);
	}

	void updateNumberOfQueries() {
		String numberOfQueriesStr = this.textNumberOfQueries.getText();
		int numberOfQueries = 0;
		try {
			numberOfQueries = Integer.parseInt(numberOfQueriesStr);
		} catch (NumberFormatException e) {
		}
		this.textSeed.setText("" + numberOfQueries);
		this.model.setNumberOfQueries(numberOfQueries);
	}

	public void update() {
		updateInputOntologyDirectory();
		updateBayesianNetworkDirectory();
		updateOutputDirectory();
		updateSeed();
	}

	public void setResult(String result) {
	}

	public void setComputing(boolean status) {
		labelProgress.setVisible(status);
	}

	public String getNumebrOfQueries() {
		return this.textNumberOfQueries.getText();
	}

	public String getSeed() {
		return this.textSeed.getText();
	}

	public void setSeed(String seed) {
		this.textSeed.setText(seed);
	}

	public void setButtonsEnabled(boolean status) {
		buttonInputOntologyDirectory.setEnabled(status);
		buttonBayesianNetworkDirectory.setEnabled(status);
		buttonOutputDirectory.setEnabled(status);
		buttonUpdateSeed.setEnabled(status);
		buttonComputeInference.setEnabled(status);
	}

}

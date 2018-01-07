package moment6;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;


public class TestUI6 extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private Timer timer;
	private ColorDisplay cd;
	protected static int ARRAY_SIZE = 7;
	protected static int NUMBER_OF_COLUMNS_TO_DISPLAY = 98;
	protected static int TIMER_DELAY = 40;
	protected static int NUMBER_OF_ARRAYS_WIDE = 5;
	
	private JTextField[] jtextLeftArray = new JTextField[ARRAY_SIZE];
	private JTextField[] jtextRightArray = new JTextField[ARRAY_SIZE];

	private JButton btnRight = new JButton("Right--->");
	private JButton btnLeft = new JButton("<---Left");
	private JButton btnLeftText = new JButton("<---Left Text");
	private JButton btnRightText = new JButton("Right Text-->");

	private JPanel pnlLeft = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlRight = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JTextField inputTextField = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestUI6 frame = new TestUI6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestUI6() {
		controller = new Controller(this);
		cd = new ColorDisplay(1, 5, Color.BLACK, Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(pnlLeft, BorderLayout.WEST);
		pnlLeft.setLayout(new GridLayout(7, 1, 0, 0));
		contentPane.add(pnlCenter);
		contentPane.add(pnlRight, BorderLayout.EAST);
		pnlRight.setLayout(new GridLayout(7, 1, 0, 0));

		for (int row = 0; row < ARRAY_SIZE; row++) {
			jtextLeftArray[row] = new JTextField("");
			jtextRightArray[row] = new JTextField("");
			pnlLeft.add(jtextLeftArray[row]);
			pnlRight.add(jtextRightArray[row]);
		}
		
		pnlCenter.setLayout(new BorderLayout(0, 0));
		pnlCenter.add(cd);
		pnlCenter.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.add(btnLeftText);
		pnlSouth.add(btnLeft);
		pnlSouth.add(btnRight);
		pnlSouth.add(btnRightText);
		pnlSouth.add(inputTextField);
		inputTextField.setColumns(20); // Length of the textfield for text input
		inputTextField.setText("Programmering ar kul!");

		btnLeft.addActionListener(new ButtonListener());
		btnRight.addActionListener(new ButtonListener());
		btnLeftText.addActionListener(new ButtonListener());
		btnRightText.addActionListener(new ButtonListener());
		controller.randomize();
	}

	/**
	 * Method that receive all the 7x7 arrays from our controller and convert them
	 * to int[][] format and sends them one by one to ColorDisplay for showing on
	 * the screen. Second part synchronize the left and right JText-arrays in the UI
	 * with the left/right column-arrays in the controller.
	 * 
	 */
	public void updateScreen() {
		for (int index = 0; index < NUMBER_OF_ARRAYS_WIDE; index++) {
			cd.setDisplay(controller.getArray7x7(index).toIntArray(), 0, index);
		}
		cd.updateDisplay();

		for (int row = 0; row < ARRAY_SIZE; row++) {
			writeLeftColumn(controller.getLeftColumn());
			writeRightColumn(controller.getRightColumn());
		}
	}

	/**
	 * Method that return a String from the JTextField
	 * 
	 * @return String with JTextField data.
	 */
	public String getTextField() {
		return inputTextField.getText();
	}

	/** 
	 * Method that take an incoming Array7 and write it to the left jText-array in the UI.
	 * @param leftColumn Array7 with 7 values.
	 */
	public void writeLeftColumn(Array7 leftColumn) {
		for (int row = 0; row < jtextLeftArray.length; row++) {
			jtextLeftArray[row].setText(Integer.toString(leftColumn.getElement(row)));
		}
	}

	/**
	 * Method that take an incoming Array7 and write it to the right JText-array in the UI.
	 * @param rightColumn Array7 with 7 values.
	 */
	public void writeRightColumn(Array7 rightColumn) {
		for (int row = 0; row < jtextRightArray.length; row++) {
			jtextRightArray[row].setText(Integer.toString(rightColumn.getElement(row)));
		}
	}

	/**
	 * Method that read the values in the left column in the UI and return it
	 * as a new Array7.
	 * @return newArray - Array7 with 7 values
	 */
	public Array7 readLeftColumn() {
		Array7 newArray = new Array7();
		for (int row = 0; row < jtextLeftArray.length; row++) {
			newArray.setElement(row, Integer.parseInt(jtextLeftArray[row].getText()));
		}
		return newArray;
	}
	
	/**
	 * Method that reads the values in the right column in the UI and return it
	 * as a new Array7. 
	 * @return newArray - Array7 with 7 values.
	 */
	public Array7 readRightColumn() {
		Array7 newArray = new Array7();
		for (int row = 0; row < jtextRightArray.length; row++) {
			newArray.setElement(row, Integer.parseInt(jtextRightArray[row].getText()));
		}
		return newArray;
	}

	/**
	 * Method that turn the JButtons in the UI on and off.
	 * @param status - Boolean. Buttons turns on if true, and off if false.
	 */

	public void enableButtons(boolean status) {
		btnLeftText.setEnabled(status);
		btnRightText.setEnabled(status);
		btnLeft.setEnabled(status);
		btnRight.setEnabled(status);
	}

	/**
	 * Method that disable the buttons and creates a new Timer for the '<--left button' 
	 * and starts a schedule that uses the MoveLeft class every 40ms (25 frames per second).
	 */
	public void useTimerMoveLeft() {
		enableButtons(false);
		timer = new Timer();
		timer.schedule(new MoveLeft(), TIMER_DELAY, TIMER_DELAY);
	}
	/**
	 * Method that disable the buttons and creates a new Timer for the 'right--> button'
	 * and starts a schedule that uses the MoveRight class every 40ms (25 frames per second).
	 */
	public void useTimerMoveRight() {
		enableButtons(false);
		timer = new Timer();
		timer.schedule(new MoveRight(), TIMER_DELAY, TIMER_DELAY);
	}

	/**
	 * Method that disable the buttons and creates a new Timer for the 'left text button'
	 * and starts a schedule that uses the MoveLeftText class every 40ms (25 frames per second).
	 */
	public void useTimerMoveLeftText() {
		enableButtons(false);
		timer = new Timer();
		timer.schedule(new MoveLeftText(), TIMER_DELAY, TIMER_DELAY);
	}
	/**
	 * Method that disable the buttons and creates a new Timer for the 'right text button'
	 * and starts a schedule that uses the MoveRightText class every 40ms (25 frames per second).
	 */
	public void useTimerMoveRightText() {
		enableButtons(false);
		timer = new Timer();
		timer.schedule(new MoveRightText(), TIMER_DELAY, TIMER_DELAY);
	}

	/**
	 * Private class MoveLeft that inheritance TimerTask that run controller.moveLeft() until
	 * the counter has reach its goal. ( scrolls through 14 7x7 arrays.).
	 * When counter is reach the timer will be canceled and buttons turned on again. 
	 */
	private class MoveLeft extends TimerTask {
		private int counter = 0;

		public void run() {
			if (counter < NUMBER_OF_COLUMNS_TO_DISPLAY) {
				counter++;
				controller.moveLeft();
			} else {
				timer.cancel();
				enableButtons(true);
			}
		}
	}
	
	/**
	 * Private class MoveRight that inheritance TimerTask that run controller.moveRight() until
	 * the counter has reach its goal. ( scrolls through 14 7x7 arrays.).
	 * When counter is reach the timer will be canceled and buttons turned on again. 
	 */
	private class MoveRight extends TimerTask {
		private int counter = 0;

		public void run() {
			if (counter < NUMBER_OF_COLUMNS_TO_DISPLAY) {
				counter++;
				controller.moveRight();
			} else {
				timer.cancel();
				enableButtons(true);
			}
		}
	}

	/**
	 * Private class MoveLeftText that inheritance TimerTask that runs controller.moveLeftText() until
	 * the end of the String in inputTextField is reached. (Length of string * number of columns in the characters).
	 * When counter is reach the timer will be canceled, and the counters in the controller class will reset 
	 * and the buttons turned on again.
	  */
	private class MoveLeftText extends TimerTask {
		private int counter = 0;

		public void run() {
			if (counter < (inputTextField.getText().length() * ARRAY_SIZE)) {
				counter++;
				controller.moveLeftText();
			} else {
				timer.cancel();
				controller.resetCounters();
				enableButtons(true);
			}
		}
	}

	/**
	 * Private class MoveRightText that inheritance TimerTask that runs controller.moveRightText() until
	 * the end of the String in the inputTextField is reached. (Length of string * number of columns in the characters).
	 * When counter is reach the timer will be canceled, and the counters in the controller-class will reset 
	 * and the buttons turned on again. 
	 */
	private class MoveRightText extends TimerTask {
		private int counter = 0;

		public void run() {
			if (counter < (inputTextField.getText().length() * ARRAY_SIZE)) {
				counter++;
				controller.moveRightText();
			} else {
				timer.cancel();
				controller.resetCounters();
				enableButtons(true);
			}
		}
	}

	/**
	 * Private class ButtonListener that implements ActionListener and handles the input from our JButtons.
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnLeft) {
				useTimerMoveLeft();
			}
			if (e.getSource() == btnRight) {
				useTimerMoveRight();
			}
			if (e.getSource() == btnLeftText) {
				useTimerMoveLeftText();
			}
			if (e.getSource() == btnRightText) {
				useTimerMoveRightText();
			}
		}
	}
}

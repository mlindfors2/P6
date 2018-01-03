package moment6;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TestUI6 extends JFrame
{

	private JPanel contentPane;
	Timer timer;
	private Controller controller;
	private Color c;

	int sum = 0;
	Random rand = new Random();
	// private Array7x7 array7x7 = new Array7x7();

	private JTextField[] jtextLeftArray = new JTextField[7];
	private JTextField[] jtextRightArray = new JTextField[7];
	private JLabel[][] lblArray = new JLabel[7][7];
	private ColorDisplay cd;

	private JButton btnLeftText = new JButton("<---Left Text");
	private JButton btnRightText = new JButton("Right Text-->");

	private JButton btnRight = new JButton("Right--->");
	private JButton btnLeft = new JButton("<---Left");
	private JPanel pnlLeft;
	private JPanel pnlRight;
	private JTextField textField = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					TestUI6 frame = new TestUI6();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestUI6()
	{
		controller = new Controller(this);
		cd = new ColorDisplay(1, 5,	Color.argb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)),
				Color.argb(255, 255, 255, 255)); // 1 Page (*7) höjd, 5 Page(s) (*7 bredd)

		// cd = new ColorDisplay(1,5,rand.nextInt()+255, rand.nextInt()+255);
		c = new Color();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		pnlLeft = new JPanel();
		contentPane.add(pnlLeft, BorderLayout.WEST);
		pnlLeft.setLayout(new GridLayout(7, 1, 0, 0));

		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter);

		pnlRight = new JPanel();
		contentPane.add(pnlRight, BorderLayout.EAST);
		pnlRight.setLayout(new GridLayout(7, 1, 0, 0));

		for (int a = 0; a < 7; a++)
		{
			jtextLeftArray[a] = new JTextField("1");
			jtextRightArray[a] = new JTextField("2");
			for (int b = 0; b < 7; b++)
			{
				lblArray[a][b] = new JLabel("x");
			}
		}
		for (int row = 0; row < 7; row++)
		{
			pnlLeft.add(jtextLeftArray[row]);
			pnlRight.add(jtextRightArray[row]);
		}
		pnlCenter.setLayout(new BorderLayout(0, 0));
		pnlCenter.add(cd);

		JPanel pnlSouth = new JPanel();
		pnlCenter.add(pnlSouth, BorderLayout.SOUTH);

		pnlSouth.add(btnLeftText);

		pnlSouth.add(btnLeft);
		pnlSouth.add(btnRight);

		pnlSouth.add(btnRightText);

		textField = new JTextField();
		pnlSouth.add(textField);
		textField.setColumns(10);

		controller.randomize();

		btnLeft.addActionListener(new ButtonListener());
		btnRight.addActionListener(new ButtonListener());
		btnLeftText.addActionListener(new ButtonListener());
		btnRightText.addActionListener(new ButtonListener());

		textField.setText("Programmering ar kul!");
	}

	public void updateScreen()
	{
		
		for (int index = 0; index < 5; index++)
		{
			
//			controller.getArray7x7(index);
			cd.setDisplay(controller.getArray7x7(index).toIntArray(), 0, index);
		}
		cd.updateDisplay();

		for (int row = 0; row < jtextLeftArray.length; row++)
		{
			jtextLeftArray[row].setText(Integer.toString(controller.getLeftColumn().getElement(row)));
			jtextRightArray[row].setText(Integer.toString(controller.getRightColumn().getElement(row)));
		}

	}

	public String getTextField()
	{
		return textField.getText();
	}

	public void writeLeftColumn(Array7 leftColumn)
	{
		for (int row = 0; row < jtextLeftArray.length; row++)
		{
			jtextLeftArray[row].setText(Integer.toString(leftColumn.getElement(row)));
		}
	}

	public void writeRightColumn(Array7 rightColumn)
	{
		for (int row = 0; row < jtextRightArray.length; row++)
		{
			jtextRightArray[row].setText(Integer.toString(rightColumn.getElement(row)));
		}
	}

	public Array7 readRightColumn()
	{
		Array7 newArray = new Array7();
		for (int row = 0; row < jtextRightArray.length; row++)
		{
			newArray.setElement(row, Integer.parseInt(jtextRightArray[row].getText()));
		}
		return newArray;
	}

	public Array7 readLeftColumn()
	{
		Array7 newArray = new Array7();
		for (int row = 0; row < jtextLeftArray.length; row++)
		{
			newArray.setElement(row, Integer.parseInt(jtextLeftArray[row].getText()));
		}
		return newArray;
	}

	public void enableButtons(boolean status)
	{
		btnLeftText.setEnabled(status);
		btnRightText.setEnabled(status);
		btnLeft.setEnabled(status);
		btnRight.setEnabled(status);
	}

	public void useTimerMoveLeft()
	{
		enableButtons(false);
		timer = new Timer();
		timer.schedule(new moveLeft(), 40, 40);
	}

	public void useTimerMoveRight()
	{
		enableButtons(false);
		timer = new Timer();
		timer.schedule(new moveRight(), 40, 40);
	}

	public void useTimerMoveLeftText()
	{
		enableButtons(false);
		timer = new Timer();
		timer.schedule(new moveLeftText(), 40, 40);
	}

	public void useTimerMoveRightText()
	{
		enableButtons(false);
		timer = new Timer();
		timer.schedule(new moveRightText(), 40, 40);
	}

	private class moveLeft extends TimerTask
	{
		private int counter = 0;
		public void run()
		{
			if (counter < 98)
			{
				counter++;
				controller.moveLeft();
			} else
			{
				timer.cancel(); // Can't use Timer-instance anymore
				enableButtons(true);
			}
		}
	}

	private class moveRight extends TimerTask
	{
		private int counter = 0;

		public void run()
		{
			if (counter < 98)
			{
				counter++;
				controller.moveRight();
			} else
			{
				timer.cancel();
				enableButtons(true);
			}
		}
	}

	private class moveLeftText extends TimerTask
	{
		private int counter = 0;

		public void run()
		{
			if (counter < (textField.getText().length() * 7))
			{
				counter++;
				controller.moveLeftText();
			} else
			{
				timer.cancel();
				controller.resetCounters();
				enableButtons(true);
			}
		}
	}

	private class moveRightText extends TimerTask
	{
		private int counter = 0;

		public void run()
		{
			if (counter < (textField.getText().length() * 7))
			{
				counter++;
				controller.moveRightText();
			} else
			{
				timer.cancel();
				controller.resetCounters();
				enableButtons(true);
			}
		}
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == btnLeft)
			{
//				controller.moveLeft();
				useTimerMoveLeft();
			}
			if (e.getSource() == btnRight)
			{
//				controller.moveRight();
				useTimerMoveRight();
			}
			if (e.getSource() == btnLeftText)
			{
				useTimerMoveLeftText();
			}
			if (e.getSource() == btnRightText)
			{
				useTimerMoveRightText();
			}
		}

	}
}

package moment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TestUI4 extends JFrame
{

	private JPanel contentPane = new JPanel();
	private Controller controller;
	protected static final int ARRAY_SIZE = 7;
	
	private JTextField[] jtextLeftArray = new JTextField[ARRAY_SIZE];
	private JTextField[] jtextRightArray = new JTextField[ARRAY_SIZE];
	private ColorDisplay cd;
	
	private JButton btnLeft = new JButton("<---Left");
	private JButton btnRight = new JButton("Right--->");
	private JPanel pnlLeft = new JPanel();
	private JPanel pnlRight = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	
	
	

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
					TestUI4 frame = new TestUI4();
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
	public TestUI4()
	{
		controller = new Controller(this);
		cd = new ColorDisplay(Color.BLACK, Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		pnlLeft.setLayout(new GridLayout(7, 1, 0, 0));
		pnlRight.setLayout(new GridLayout(7, 1, 0, 0));
		contentPane.add(pnlLeft, BorderLayout.WEST);
		contentPane.add(pnlCenter);
		contentPane.add(pnlRight, BorderLayout.EAST);
		for (int row=0;row<7;row++)
		{
			jtextLeftArray[row] = new JTextField("");
			jtextRightArray[row] =  new JTextField("");
			pnlLeft.add(jtextLeftArray[row]);
			pnlRight.add(jtextRightArray[row]);
		}
		pnlCenter.setLayout(new BorderLayout(0, 0));
		pnlCenter.add(cd);
		pnlCenter.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.add(btnLeft);
		pnlSouth.add(btnRight);
		btnLeft.addActionListener(new ButtonListener());
		btnRight.addActionListener(new ButtonListener());
		controller.randomize();
	}
	public void updateScreen()
	{
		cd.setDisplay(controller.getArray7x7().toIntArray());
		cd.updateDisplay();
		for (int row=0;row<jtextLeftArray.length;row++)
		{
			jtextLeftArray[row].setText(Integer.toString(controller.getLeftColumn().getElement(row)));
			jtextRightArray[row].setText(Integer.toString(controller.getRightColumn().getElement(row)));
		}
	}
	public void writeLeftColumn(Array7 leftColumn)
	{
		for (int row=0;row<jtextLeftArray.length;row++)
		{
			jtextLeftArray[row].setText(Integer.toString(leftColumn.getElement(row)));
		}
		
	}
	public void writeRightColumn(Array7 rightColumn)
	{
		for(int row=0;row<jtextRightArray.length;row++)
		{
			jtextRightArray[row].setText(Integer.toString(rightColumn.getElement(row)));
		}
	}
	public Array7 readRightColumn()
	{
		Array7 newArray = new Array7();
		for(int row=0;row<jtextRightArray.length;row++)
		{
			newArray.setElement(row, Integer.parseInt(jtextRightArray[row].getText()));
		}
		return newArray;
	}
	
	
	public Array7 readLeftColumn()
	{
		Array7 newArray = new Array7();
		for(int row=0;row<jtextLeftArray.length;row++)
		{
			newArray.setElement(row, Integer.parseInt(jtextLeftArray[row].getText()));
		}
		return newArray;
	}
		
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == btnLeft)
			{
				
				controller.moveLeft();
			}
			if (e.getSource() == btnRight)
			{
				controller.moveRight();
			}
			
		}
		
	}
}

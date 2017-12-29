package moment3;

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
import javax.swing.JButton;

public class TestUI3 extends JFrame
{

	private JPanel contentPane;
	//Timer timer = new Timer(100, new TimerListener());
	private Controller controller;
	int sum = 0;
	Random rand = new Random();
//	private Array7x7 array7x7 = new Array7x7(); 
	
	private JTextField[] jtextLeftArray = new JTextField[7];
	private JTextField[] jtextRightArray = new JTextField[7];
	private JLabel[][] lblArray = new JLabel[7][7];
	
	private JButton btnLeft = new JButton("<---Left");
	private JButton btnRight = new JButton("Right--->");
	
	
	
	
	

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
					TestUI3 frame = new TestUI3();
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
	public TestUI3()
	{
		controller = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.NORTH);
		pnlCenter.setLayout(new GridLayout(7, 11, 0, 0));
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		
		pnlSouth.add(btnLeft);
		pnlSouth.add(btnRight);
		
		for(int a=0;a<7;a++)
		{
			jtextLeftArray[a] = new JTextField("2");
			jtextRightArray[a] = new JTextField("1");
			
			
			
			for(int b=0;b<7;b++)
			{
				
				lblArray[a][b] = new JLabel("x");
			}
		}
		
		for (int row=0;row<7;row++)
		{
		
			pnlCenter.add(jtextLeftArray[row]);
			for (int col=0;col<7;col++)
			{					
				pnlCenter.add(lblArray[row][col]);
			}
			pnlCenter.add(new JLabel(""));
			pnlCenter.add(jtextRightArray[row]);
		}
			
		
		
		controller.Randomize();
		
		btnLeft.addActionListener(new ButtonListener());
		btnRight.addActionListener(new ButtonListener());
		
		
		
		
	}
	public void updateScreen()
	{
		for (int row=0;row<7;row++)
		{
			for( int col=0;col<7;col++)
			{
				lblArray[row][col].setText(Integer.toString(controller.getArray7x7().getElement(row, col)));
			}	
		}
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

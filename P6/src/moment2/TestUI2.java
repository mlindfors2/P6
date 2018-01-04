package moment2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;



//import moment2.Test1UI.TimerListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

public class TestUI2 extends JFrame
{

	//Timer timer = new Timer(100, new TimerListener());
	private Controller controller;
	int sum = 0;
	Random rand = new Random();
//	private Array7x7 array7x7 = new Array7x7(); 
	private JTextField[] jtextLeftArray = new JTextField[7];
	private JTextField[] jtextBottomArray = new JTextField[7];
	private JLabel[][] lblArray = new JLabel[7][7];
	
	private JTextField jTfRow = new JTextField();
	private JTextField jTfCol = new JTextField();
	
	

//	private JPanel pnlCenter = new JPanel(new GridLayout(9,9));
//	
	private JPanel pnlRight = new JPanel(new GridLayout(6,1));

	
	
	
	
	private JPanel contentPane;
	private JTextField tfRow = new JTextField();
	private JTextField tfCol = new JTextField();;
	
	JLabel lblRadNr = new JLabel("Rad nr:");
	JLabel lblKolumnNr = new JLabel("Kolumn nr:");
	JButton btnReadRow = new JButton("Läs rad:");
	JButton btnWriteRow = new JButton("Skriv rad");
	JButton btnReadCol = new JButton("Läs column");
	JButton btnWriteCol = new JButton("Skriv column");
	
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
					TestUI2 frame = new TestUI2();
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
	public TestUI2()
	{
		controller = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new GridLayout(9, 9, 0, 0));
		
		JPanel pnlRight_1 = new JPanel();
		contentPane.add(pnlRight_1, BorderLayout.EAST);
		pnlRight_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		pnlRight_1.add(panel_2);
		
		
		panel_2.add(lblRadNr);
		
		
		tfRow.setText("1");
		panel_2.add(tfRow);
		tfRow.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		pnlRight_1.add(panel_3);
		
		
		panel_3.add(btnReadRow);
		
		JPanel panel_4 = new JPanel();
		pnlRight_1.add(panel_4);
		
		
		panel_4.add(btnWriteRow);
		btnWriteRow.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		JPanel panel_5 = new JPanel();
		pnlRight_1.add(panel_5);
		
		
		panel_5.add(lblKolumnNr);
		
		
		tfCol.setText("1");
		panel_5.add(tfCol);
		tfCol.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		pnlRight_1.add(panel_6);
		
		
		panel_6.add(btnReadCol);
		
		JPanel panel_7 = new JPanel();
		pnlRight_1.add(panel_7);
		
		
		panel_7.add(btnWriteCol);
		
		for(int a=0;a<7;a++)
		{
			jtextBottomArray[a] = new JTextField("2");
			jtextLeftArray[a] = new JTextField("1");
			
			for(int b=0;b<7;b++)
			{
				
				lblArray[a][b] = new JLabel("x");
			}
		}
		
		for (int row=0;row<9;row++)
		{
			if( row <7)
			{
				pnlCenter.add(jtextLeftArray[row]);
			}
			pnlCenter.add(new JLabel(""));
			if(row<7) 
			{
				for (int col=0;col<9;col++)
				{					
					if ( col<7 )
					{
						sum++;
//						lblArray[i][j].setText(Integer.toString(sum));
						pnlCenter.add(lblArray[row][col]);
					}
				}
			}
			else 
			{
				if(row ==7)
				{
					pnlCenter.add(new JLabel(""));
					pnlCenter.add(new JLabel(""));
					for (int k=0;k<7;k++)
					{
						
						pnlCenter.add(new JLabel(""));
					}
				}
				if( row==8)
				{
					for (int m=0;m<7;m++)
					{
					pnlCenter.add(jtextBottomArray[m]);
					}
				}	
			}
		
		}
		controller.Randomize();
		updateScreen();
		btnReadRow.addActionListener(new ButtonListener());
		btnWriteRow.addActionListener(new ButtonListener());
		btnReadCol.addActionListener(new ButtonListener());
		btnWriteCol.addActionListener(new ButtonListener());
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
		for (int col=0;col<jtextBottomArray.length;col++)
		{
			String cp = jtextBottomArray[col].getText();
			jtextBottomArray[col].setText(Integer.toString(controller.getBottomRow().getElement(col)));
		}
		for (int row=0;row<jtextLeftArray.length;row++)
		{
			jtextLeftArray[row].setText(Integer.toString(controller.getLeftColumn().getElement(row)));
		}
	}
	public void writeBottomArray(Array7 array7)
	{
		for (int col=0;col<jtextBottomArray.length;col++)
		{
			
			jtextBottomArray[col].setText(Integer.toString(array7.getElement(col)));
		}
	}
	public void writeLeftArray(Array7 array7)
	{
		for (int row=0;row<jtextLeftArray.length;row++)
		{
			jtextLeftArray[row].setText(Integer.toString(array7.getElement(row)));
		}
	}
	
	public Array7 readBottomArray()
	{
		Array7 newArray = new Array7();
		for (int col = 0;col<jtextBottomArray.length;col++)
		{
			newArray.setElement(col,Integer.parseInt(jtextBottomArray[col].getText()));
		}
		return newArray;
	}
	public Array7 readLeftArray()
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
			if (e.getSource() == btnReadRow)
			{
				if (Integer.parseInt(tfRow.getText()) > 0 && Integer.parseInt(tfRow.getText()) < 8)
				{
					controller.setBottomRow(controller.getArray7x7().getRow(Integer.parseInt(tfRow.getText())-1));
					updateScreen();
						
				}
			}
			if (e.getSource() == btnWriteRow)
			{
				if (Integer.parseInt(tfRow.getText()) > 0 && Integer.parseInt(tfRow.getText())< 8)
				{
					controller.getArray7x7().setRow(Integer.parseInt(tfRow.getText())-1, controller.getBottomRow()); 
					updateScreen();
				}
			}
			if (e.getSource() == btnReadCol)
			{
				if (Integer.parseInt(tfCol.getText()) > 0 && Integer.parseInt(tfCol.getText())<8)
				{
					controller.setLeftColumn(controller.getArray7x7().getCol(Integer.parseInt(tfCol.getText())-1));
					updateScreen();
				}
			}
					
			if (e.getSource() == btnWriteCol)
			{
				if (Integer.parseInt(tfCol.getText())>0 && Integer.parseInt(tfCol.getText())<8)
				{
					//getLeftColumn ej uppdaterad från start
					controller.getArray7x7().setCol(Integer.parseInt(tfCol.getText())-1, controller.getLeftColumn());
					updateScreen();
				}
			}
			
			
		}
		
	}
	
	
	
}

package p6mikael;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test1UI extends JPanel
{
	private Controller controller;
	int sum = 0;
	private Array7x7 array7x7 = new Array7x7(); 
	private JTextField[] jtextLeftArray = new JTextField[7];
	private JTextField[] jtextBottomArray = new JTextField[7];
	private JLabel[][] lblArray = new JLabel[7][7];
	private JButton btnReadRow = new JButton("Läs rad");
	private JButton btnWriteRow = new JButton("Skriv rad");
	private JButton btnReadCol = new JButton("Läs kolumn");
	private JButton btnWriteCol = new JButton("Skriv kolumn");
	
	private JTextField jTfRow = new JTextField();
	private JTextField jTfCol = new JTextField();
	
	private JLabel lblRowNum = new JLabel("Rad nr:");
	private JLabel lblColNum = new JLabel("Col nr:");
	
	private JPanel pnlLeft = new JPanel(new GridLayout(7,1));
	private JPanel pnlBottom = new JPanel(new GridLayout(1,7));

	private JPanel pnlCenter = new JPanel(new GridLayout(9,9));
//	private JPanel pnlCenter = new JPanel(new GridLayout(9,10));
	private JPanel pnlRight = new JPanel(new GridLayout(6,1));
	private JPanel pnlRightRow = new JPanel(new GridLayout(1,2));
	private JPanel pnlRightCol = new JPanel(new GridLayout(1,2));
	
	public Test1UI()
	{
		this.setPreferredSize(new Dimension(1280,720));
		this.setLayout(new BorderLayout());
		pnlLeft.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		pnlBottom.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		pnlCenter.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		pnlRight.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		pnlLeft.setPreferredSize(new Dimension(100,500));
		pnlRight.add(pnlRightRow);
		pnlRightRow.add(lblRowNum);
		pnlRightRow.add(jTfRow);
		pnlRight.add(btnReadRow);
		pnlRight.add(btnWriteRow);
		pnlRight.add(pnlRightCol);
		pnlRightCol.add(lblColNum);
		pnlRightCol.add(jTfCol);
		pnlRight.add(btnReadCol);
		pnlRight.add(btnWriteCol);
		
		for(int a=0;a<7;a++)
		{
			jtextBottomArray[a] = new JTextField("2");
			jtextLeftArray[a] = new JTextField("1");
			
			for(int b=0;b<7;b++)
			{
				
				lblArray[a][b] = new JLabel("x");
			}
		}			
//		*************************************************************************			
		for (int i=0;i<9;i++)
		{
			if( i <7)
			{
				pnlCenter.add(jtextLeftArray[i]);
			}
			pnlCenter.add(new JLabel(""));
			if(i<7) 
			{
				for (int j=0;j<9;j++)
				{					
					if ( j<7 )
					{
						sum++;
						lblArray[i][j].setText(Integer.toString(sum));
						pnlCenter.add(lblArray[i][j]);
					}
				}
			}
			else 
			{
				
				if(i ==7)
				{
					pnlCenter.add(new JLabel(""));
					pnlCenter.add(new JLabel(""));
					for (int k=0;k<7;k++)
					{
						
						pnlCenter.add(new JLabel(""));
					}
				}
				if( i==8)
				{
//					pnlCenter.add(new JLabel("AA"));
					for (int m=0;m<7;m++)
					{
					pnlCenter.add(jtextBottomArray[m]);
					}
				}	
			}
		}
		this.add(pnlLeft, BorderLayout.WEST);
		this.add(pnlCenter,BorderLayout.CENTER);
		this.add(pnlRight,BorderLayout.EAST);
		//this.add(new JLabel("test")); //dummy empty area
		this.add(pnlBottom, BorderLayout.SOUTH);
		btnReadRow.addActionListener(new ButtonListener());
		btnReadCol.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnReadRow)
			{
				Random rand = new Random();
				int[] myarray = new int[7];
				for (int k=0;k<7;k++)
				{
					for (int l=0;l<7;l++)
					{
						array7x7.setElement(k, l, rand.nextInt(10)+1);
					}
				}
			    for (int i=0;i<7;i++)
				{
					for( int j=0;j<7;j++)
					{
						lblArray[i][j].setText(Integer.toString(array7x7.getElement(i, j)));
					}
				}
			}
			else if(e.getSource() == btnReadCol)
			{
				for (int j=1;j<7;j++)
				{
					for (int i=0;i<7;i++)
					{
						
						lblArray[i][j-1].setText(lblArray[i][j].getText());
						lblArray[i][7-j].setText("");
					}
				}
			}
		}
		
	}

}

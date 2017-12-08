package p6mikael;

import javax.swing.JFrame;

public class StartUITest
{
	public static void main(String[] args)
	{
		Controller controller = new Controller();

		Test1UI ui = new Test1UI();
		JFrame frame1 = new JFrame("TestUI");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(ui);
		frame1.pack();
		frame1.setVisible(true);
	}
}

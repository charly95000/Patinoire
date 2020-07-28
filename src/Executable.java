import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import org.eclipse.views.Fenetre;
import org.eclipse.views.Firstview;

public class Executable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			
				//On crée une nouvelle instance de notre JWindow
		JWindow load = new JWindow();
		load.setSize(500, 500);
		load.setLocationRelativeTo(null);
		
		Firstview logo= new Firstview();
		load.getContentPane().add(logo);
		load.setVisible(true);
 
		try { 
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {}
		load.setVisible(false);
		Fenetre f= new Fenetre();
		
		

	}

}

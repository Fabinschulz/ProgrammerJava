package util;


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Configura {
	
	public static void lookAndFeel(String laf) {
		if (laf != null) {
			try {
				for (LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
					if (laf.equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} catch (ClassNotFoundException | UnsupportedLookAndFeelException |
					IllegalAccessException | InstantiationException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
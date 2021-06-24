package rs.ac.uns.ftn.projekat.main;

import java.io.IOException;
import rs.ac.uns.ftn.projekat.izgled.MainFrame;
import unbbayes.io.exception.LoadException;


public class MyApp{ 

	public static void main(String[] args) throws LoadException, IOException {
		
		MainFrame mf=MainFrame.getInstance();
		mf.setVisible(true);
	}

}

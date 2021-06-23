package rs.ac.uns.ftn.projekat.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import rs.ac.uns.ftn.projekat.dialogs.BayesDialog;
import rs.ac.uns.ftn.projekat.izgled.MainFrame;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.io.XMLBIFIO;
import unbbayes.io.exception.LoadException;
import unbbayes.prs.bn.ProbabilisticNetwork;


public class MyApp { 

	public static void main(String[] args) throws LoadException, IOException {
		BaseIO io = new NetIO();
		ProbabilisticNetwork net = (ProbabilisticNetwork) io.load(new File("bayes.net"));
		System.out.println(net);
		MainFrame mf=MainFrame.getInstance();
		mf.setVisible(true);
	}

}

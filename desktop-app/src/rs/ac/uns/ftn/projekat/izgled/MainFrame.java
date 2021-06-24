package rs.ac.uns.ftn.projekat.izgled;





import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.security.DrbgParameters.Reseed;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import rs.ac.uns.ftn.projekat.database.GetAttack;
import rs.ac.uns.ftn.projekat.dialogs.AddAttackDialog;
import rs.ac.uns.ftn.projekat.dialogs.BayesDialog;
import rs.ac.uns.ftn.projekat.dialogs.EditAttack;
import rs.ac.uns.ftn.projekat.dialogs.CaseBaseReasoningDialog;
import rs.ac.uns.ftn.projekat.dialogs.Fuzzy;
import rs.ac.uns.ftn.projekat.model.Attack;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.io.exception.LoadException;



public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 2593300780354379674L;
	
	private static MainFrame instance = null;
	static JTextField search = new JTextField();
	private Attack a=new Attack();
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth *1/3, screenHeight *1/3);
		setTitle("Software attacks");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage((new ImageIcon("resources/attack.png")).getImage());
		setResizable(false);
		
		//statusBar
		this.setLayout(new BorderLayout());
		JPanel statusPanel = new JPanel();

		search.setPreferredSize(new Dimension(160,40));

		
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(this.getWidth(), 25));
		statusPanel.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel statusLabel  = new JLabel(this.getTitle());
		statusPanel.add(statusLabel,BorderLayout.CENTER);
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
	
		JButton btn1 = new JButton("Add attack");
		panel.add(btn1);
		JToggleButton btn2 = new JToggleButton("Incident classification");
		panel.add(btn2);


		JToggleButton btn3 = new JToggleButton("Fuzzy");
		panel.add(btn3);

		box.add(panel);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		statusPanel.add(statusLabel,BorderLayout.CENTER);

		Label l=new Label("Find attack by name");
		panel1.add(l);
		panel1.add(search);
		Icon icon = new ImageIcon("resources/find.png");
		JButton bsearch=new JButton(icon);
		bsearch.setSize(20, 20);
		panel1.add(bsearch);
		box.add(panel1);
		
		

		JToggleButton btn4 = new JToggleButton("Case Base Reasoning");
		panel.add(btn4);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
						
				AddAttackDialog aad=new AddAttackDialog();
				aad.setVisible(true);
					return;
				}
		});
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
						
					
				CaseBaseReasoningDialog aad=new CaseBaseReasoningDialog();
				aad.setVisible(true);
					return;
				}
		});
		
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
						try {
							Bayes();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				BayesDialog aad;
				try {
					aad = new BayesDialog();
					aad.setVisible(true);
				} catch (LoadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					return;
				}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
						
				Fuzzy f=new Fuzzy();
				f.setVisible(true);
					return;
				}
		});
		
		bsearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
						
					GetAttack ga=new GetAttack();
					a=ga.GetAttackByName(search.getText());
					EditAttack ea=new EditAttack(a);
					ea.setVisible(true);
					return;
				}
		});
		SimpleDateFormat date_format=new SimpleDateFormat("HH:mm:ss  dd.MM.yyyy.");
		JLabel timedate=new JLabel(date_format.format(new GregorianCalendar().getTime()));
		Timer timer=new Timer(500,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timedate.setText(DateFormat.getDateTimeInstance().format(new Date()));
				
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();
		statusPanel.add(timedate,BorderLayout.EAST);
		
        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			@Override
			public void windowClosing(WindowEvent e) {
				//UKOLIKO ZELIMO DA SACUVAMO KADA IZADJE
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
		
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
		
		
		
		
		
	
		
	}
	public void Bayes() throws LoadException, IOException {
		 BaseIO io = new NetIO();
//		 ProbabilisticNetwork net = (ProbabilisticNetwork)io.load(new File("bayes.net"));
	}	
	
}






package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddAttackDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		static JTextField txtIme = new JTextField();
	static JTextField txtPrezime = new JTextField();
	static JTextField txtDatumRodjenja = new JTextField();
	static JTextField txtAdresaStanovanja = new JTextField();
	static JTextField txtBrojTelefona= new JTextField();
	static JTextField txtEmailAdresa=new JTextField();
	static JTextField txtBrojIndexa = new JTextField();
	static JTextField txtGodinaStudiranja = new JTextField();
	static JTextField txtDatumUpisa = new JTextField();
	static JTextField txtProsek = new JTextField();
	static JComboBox<String> trengodstud=new JComboBox<String>();
	static JRadioButton budzet=new JRadioButton("Budzet");
	static JRadioButton samofinansiranje=new JRadioButton("Samofinansiranje");
	
	
	

	public AddAttackDialog() {

		//layout
		
		txtIme.setPreferredSize(new Dimension(160,20));
		txtPrezime.setPreferredSize(new Dimension(160,20));
		txtDatumRodjenja.setPreferredSize(new Dimension(160,20));
		txtAdresaStanovanja.setPreferredSize(new Dimension(160,20));
		txtBrojTelefona.setPreferredSize(new Dimension(160,20));
		txtBrojIndexa.setPreferredSize(new Dimension(160,20));
		txtGodinaStudiranja.setPreferredSize(new Dimension(160,20));
		txtEmailAdresa.setPreferredSize(new Dimension(160,20));
		txtProsek.setPreferredSize(new Dimension(160,20));
		txtDatumUpisa.setPreferredSize(new Dimension(160,20));
		
		
		setBackground(Color.GREEN);
		setModal(true);
		setTitle("Dodavanje studenta");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double height=screenSize.getHeight();
		double width=screenSize.getWidth();
		height=height*0.7;
		width=width*0.3;
		setBounds(150, 150, (int)width, (int)height);
		setLocationRelativeTo(null);
		
		
		JLabel ime = new JLabel("Ime*");
		JLabel prezime = new JLabel("Prezime*");
		JLabel datum_rodjenja = new JLabel("Datum rodjenja*");
		JLabel adresa_stanovanja = new JLabel("Adresa stanovanja*");
		JLabel broj_telefona = new JLabel("Broj telefona*");
		JLabel broj_indexa = new JLabel("Broj indeksa*");
		JLabel trenutna_godina_studiranja = new JLabel("Trenutna godina studiranja*");
		JLabel email = new JLabel("Email*");
		JLabel prosek = new JLabel("Prosek*");
		JLabel datum_upisa = new JLabel("Datum upisa*");
		
		
		
		
		
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBrojIndexa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelTrenutnaGodinaStudiranja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelProsek = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelDatumUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		
		
		Box box=Box.createVerticalBox();
		this.add(box,BorderLayout.CENTER);
		
		
		panelIme.add(ime);
		panelIme.add(txtIme);
		box.add(panelIme);
		
		panelPrezime.add(prezime);
		panelPrezime.add(txtPrezime);
		box.add(panelPrezime);
		
		panelDatumRodjenja.add(datum_rodjenja);
		panelDatumRodjenja.add(txtDatumRodjenja);
		box.add(panelDatumRodjenja);
		
		panelEmail.add(email);
		panelEmail.add(txtEmailAdresa);
		box.add(panelEmail);
		
		panelDatumUpisa.add(datum_upisa);
		panelDatumUpisa.add(txtDatumUpisa);
		box.add(panelDatumUpisa);
		
		panelProsek.add(prosek);
		panelProsek.add(txtProsek);
		box.add(panelProsek);
		
		
		
		panelAdresaStanovanja.add(adresa_stanovanja);
		panelAdresaStanovanja.add(txtAdresaStanovanja);
		box.add(panelAdresaStanovanja);
		
		panelBrojTelefona.add(broj_telefona);
		panelBrojTelefona.add(txtBrojTelefona);
		box.add(panelBrojTelefona);
		
		
		panelBrojIndexa.add(broj_indexa);
		panelBrojIndexa.add(txtBrojIndexa);
		box.add(panelBrojIndexa);
		
		
		
}}
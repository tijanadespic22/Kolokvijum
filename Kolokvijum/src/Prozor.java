import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Prozor extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	JFileChooser jf;

	public Prozor() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		setResizable(false);
		setTitle("Artikli");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel buttons = new JPanel(new FlowLayout());

		JButton btn1 = new JButton("Ucitaj");
		JButton btn2 = new JButton("Sacuvaj");
		JButton btn3 = new JButton("Obrisi najmanju cenu");
		JButton btn4 = new JButton("Obrisi popust");
		JButton btn5 = new JButton("Izbaci popuste");

		buttons.add(btn1);
		buttons.add(btn2);
		buttons.add(btn3);
		buttons.add(btn4);
		buttons.add(btn5);

		contentPane.add(buttons, BorderLayout.SOUTH);

		String[] header = { "Id", "Naziv", "Cena", "Na popustu", "Popust snizenje" };
		DefaultTableModel dmod = new DefaultTableModel(header, 0);
		JTable tabela = new JTable(dmod);

		contentPane.add(new JScrollPane(tabela), BorderLayout.CENTER);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try{
					
					jf = new JFileChooser(System.getProperty("user.dir"));
					int selected = jf.showOpenDialog(null);
	
					if (selected == JFileChooser.APPROVE_OPTION) {
						File izabran = jf.getSelectedFile();
	
						ArrayList<Artikal> temp = Files.load(izabran.getPath());
	
						int rowCount = dmod.getRowCount();
	
						for (int i = rowCount - 1; i >= 0; i--) {
							dmod.removeRow(i);
						}
						for (Artikal artikal : temp) {
	
							String data[] = { ((Integer) artikal.getId()).toString(), artikal.getNaziv(),
									((Integer) artikal.getCena()).toString(), ((Boolean) artikal.isPopust()).toString(),
									((Float) artikal.getPopustSnizenje()).toString() };
							dmod.addRow(data);
						}
	
					} else if (selected == JFileChooser.CANCEL_OPTION) {
						System.out.println("cancel");
					}
					
				}catch(Exception ex) {
					ex.getMessage();
				}
			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					jf = new JFileChooser(System.getProperty("user.dir"));
					int selected = jf.showOpenDialog(null);
	
					if (selected == JFileChooser.APPROVE_OPTION) {
						File izabran = jf.getSelectedFile();
	
						ArrayList<Artikal> data = new ArrayList<Artikal>();
	
						for (int i = 0; i < tabela.getRowCount(); i++) {
	
							data.add(new Artikal(Integer.parseInt(((String) tabela.getValueAt(i, 0))),
									(String) tabela.getValueAt(i, 1), Integer.parseInt(((String) tabela.getValueAt(i, 2))),
									Boolean.parseBoolean(((String) tabela.getValueAt(i, 3))),
									Float.parseFloat(((String) tabela.getValueAt(i, 4)))));
	
						}
	
						Files.save(izabran.getPath(), data);
	
					} else if (selected == JFileChooser.CANCEL_OPTION) {
						System.out.println("cancel");
					}
				}
				catch(Exception ex) {
					ex.getMessage();
				}
			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int min = Integer.MAX_VALUE;
					Integer counter = null;
					int rowCount = tabela.getRowCount();
					
					for (int i = 0; i < rowCount; i++) {
						if (Integer.parseInt(((String) tabela.getValueAt(i, 2))) < min
								&& Boolean.parseBoolean(((String) tabela.getValueAt(i, 3))) == false) {
							min = Integer.parseInt(((String) tabela.getValueAt(i, 2)));
							counter = i;
							
						}
					}
					dmod.removeRow(counter);
					
				}	
				
				catch(Exception ex) {
					ex.getMessage();
				}
				
			}
		});

		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int rowCount = tabela.getRowCount();
					Integer counter = null;
					
					for (int i = 0; i < rowCount; i++) {
						if (Boolean.parseBoolean(((String) tabela.getValueAt(i, 3))) == true && Float.parseFloat(((String) tabela.getValueAt(i, 4))) > 0.5) {
							counter = i;
							dmod.removeRow(counter);
						}
					
					}
				}		
				
				catch(Exception ex) {
					ex.getMessage();
				}
				
			}
		});

		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					File izabran = jf.getSelectedFile();

					ArrayList<Artikal> temp = Files.load(izabran.getPath());

					int rowCount = dmod.getRowCount();
					
					for (int i = rowCount - 1; i >= 0; i--) {
						dmod.removeRow(i);
					}
					for (Artikal artikal : temp) {

						String data[] = { ((Integer) artikal.getId()).toString(), artikal.getNaziv(),
								((Integer) artikal.getCena()).toString(), "false",
								((Float) artikal.getPopustSnizenje()).toString() };
						dmod.addRow(data);
					}
				}		
				
				catch(Exception ex) {
					ex.getMessage();
				}
				
			}
		});

	}

}

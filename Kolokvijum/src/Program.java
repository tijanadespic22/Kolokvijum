import java.awt.EventQueue;
//import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {

		/*ArrayList<Artikal> podaci = new ArrayList<Artikal>();
		podaci.add(new Artikal(1, "Laptop", 50000, true, (float) 0.5));
		podaci.add(new Artikal(2, "Telefon", 70000, true, (float) 0.6));
		podaci.add(new Artikal(5, "Tastatura", 15000, false, (float) 0.9));
		podaci.add(new Artikal(4, "Procesor", 35000, false, (float) 0.3));
		podaci.add(new Artikal(3, "Monitor", 20000, true, (float) 0.7));
		
		
		Files.save("podaci", podaci);*/

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prozor frame = new Prozor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

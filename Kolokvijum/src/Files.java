import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Files {

		public static void save(String file, ArrayList<Artikal> o){
			ObjectOutputStream out = null;
			try {
				out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				out.writeObject(o);
			} catch (Exception e) {
				e.printStackTrace();
	        } finally {
	            if(out != null){
	                try {
	                    out.close();
	                } catch (Exception e) {
	        			e.printStackTrace();
	                }
	            }
	        }
		}

		@SuppressWarnings("unchecked")
		public static ArrayList<Artikal> load(String file){
			ObjectInputStream in = null;
			ArrayList<Artikal> ret = null;
			try {
				in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				ret = (ArrayList<Artikal>) in.readObject();
			} catch (Exception e) {
				e.printStackTrace();
	        } finally {
	            if(in != null){
	                try {
	                    in.close();
	                } catch (Exception e) {
	        			e.printStackTrace();
	                }
	            }
	        }
			
			return ret;
		}

	
}

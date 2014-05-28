import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.JFileChooser;

public class DirectoryContents {

	public static void main(String[] args) throws IOException {

            JFileChooser s = new JFileChooser();
            s.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            s.showOpenDialog(null);
            
            
		//File f = new File("."); // current directory
		File f = s.getSelectedFile();

                
		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".wav")) {
					return true;
				} else {
					return false;
				}
			}
		};

		File[] files = f.listFiles(textFilter);
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.print("directory:");
			} else {
				System.out.print("     file:");
			}
			System.out.println(file.getCanonicalPath());
		}

	}

}   
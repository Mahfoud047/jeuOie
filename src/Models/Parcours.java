package Models;

import java.io.File;

public class Parcours extends Case  {

	static private String FILE_PATH = "assets\\Media\\caseParcour.png";

	public void jouerCase(){
	}
	public Boolean isDeplacing() {
		return false;
	}
	public int getDeplacement() {
		return 0;
	}

	@Override
	public File getFile() {
		return new File(this.FILE_PATH);
	}
}
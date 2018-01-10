package Models;

import java.io.File;
import java.util.Random;
import java.util.TreeSet;

public class Image extends Question
{
	static private String FILE_PATH = "assets\\Media\\caseImg.png";

	public String jouerCase()
	{
		return "Question de type Image \n(not implemented in this version -_- !)";
	}

	@Override
	public File getFile() {
		return new File(this.FILE_PATH);
	}

	@Override
	public Boolean bloquerPlateau() {
		return true;
	}
}
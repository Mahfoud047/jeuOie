package Models;

import java.io.File;

public class Depart extends Case
{
	static private String FILE_PATH = "assets\\Media\\caseDepart.png";

	@Override
	public String jouerCase() {
		return "";
	}

	public Boolean isDeplacing()
	{
		return false;
	}

	public int getDeplacement() 
	{
		return 0;
	}

    @Override
    public File getFile() {
        return new File(this.FILE_PATH);
    }

	@Override
	public Boolean bloquerPlateau() {
		return false;
	}
}
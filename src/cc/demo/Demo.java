package cc.demo;

import java.io.File;
import java.net.URL;
import java.util.List;

import cc.myclass.Program;
import cc.myclass.ProgramRunning;
import cc.myclass.XMLOperation;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		XMLOperation xmlOperation=new XMLOperation("." + File.separator + ".." + File.separator + ".." + File.separator + File.separator +
//				".." + File.separator + "src" + File.separator + "programPath.xml");
		
//		XMLOperation xmlOperation=new XMLOperation("." + File.separator + ".." + File.separator + File.separator +
//		".." + File.separator + "programPath.xml");
		
		XMLOperation xmlOperation=new XMLOperation("." + File.separator + "src" + File.separator + "programPath.xml");
		List<Program> programList= xmlOperation.getXMLData();
		ProgramRunning pr=new ProgramRunning();
		pr.run(programList);
		
	}

}

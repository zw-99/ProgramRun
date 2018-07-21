package cc.myclass;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;



public class XMLOperation {
	private String xmlPath;
	
	public XMLOperation() {}
	
	public XMLOperation(String xmlPath) {
		this.xmlPath=xmlPath;
	}

	public String getXmlPath() {
		return xmlPath;
	}

	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}
	
	public List<Program> getXMLData(){
		List<Program> dirList=new ArrayList<Program>();
		try {
			if (xmlPath==null) {
				return null;
			}
			File file=new File(xmlPath);
			SAXReader reader=new SAXReader();
			Document doc = reader.read(file);
			Element rootElement = doc.getRootElement();
			Iterator it = rootElement.elementIterator();
			while( it.hasNext() ) {
				Element child=(Element)it.next();
				Program program=new Program();
				program.setName(child.elementText("processName"));
				program.setPath(child.elementText("path"));
				dirList.add(program);
			}
			return dirList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
}

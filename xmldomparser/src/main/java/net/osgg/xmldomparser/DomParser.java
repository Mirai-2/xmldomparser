package net.osgg.xmldomparser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {

  private String fileName;
	
  public DomParser(String fileName) {
		this.fileName = fileName;
  }
	
  public void parse() throws Exception {

	File inputDataFile = new File(fileName);
	DocumentBuilderFactory dbldrFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = dbldrFactory.newDocumentBuilder();
	Document docmt = docBuilder.parse(inputDataFile);
	docmt.getDocumentElement().normalize();
	System.out.println("Name of the Root element:" + docmt.getDocumentElement().getNodeName());

	NodeList ndList = docmt.getElementsByTagName("employee");

	   for (int tempval = 0; tempval < ndList.getLength(); tempval++) {
	       Node nd = ndList.item(tempval);
	       System.out.println("\n Name of the current element :" + nd.getNodeName());
	       if (nd.getNodeType() == Node.ELEMENT_NODE) {
	           Element elemnt = (Element) nd;
	           System.out.println("Employee ID : " + elemnt.getAttribute("empid"));
	           System.out.println("Employee First Name: " + elemnt
	                  .getElementsByTagName("firstname").item(0).getTextContent());
	           System.out.println("Employee Last Name: " + elemnt
	                  .getElementsByTagName("lastname").item(0).getTextContent());
	           System.out.println("Employee Nick Name: " + elemnt
	                  .getElementsByTagName("nickname").item(0).getTextContent());
	           System.out.println("Employee Salary: " + elemnt
	                  .getElementsByTagName("salary").item(0).getTextContent());
	        }
       }
   }
}


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
	System.out.println("Nombre de la etiqueta raiz: " + docmt.getDocumentElement().getNodeName());
	
	System.err.println("Datos del " + docmt.getDocumentElement().getAttribute("year"));
	System.out.println("-------------------------");
	
	NodeList ndList = docmt.getElementsByTagName("pais");
	
	   for (int tempval = 0; tempval < ndList.getLength(); tempval++) {
	       Node nd = ndList.item(tempval);
	       //System.out.println("\n Name of the current element :" + nd.getNodeName());
	       if (nd.getNodeType() == Node.ELEMENT_NODE) {
	           Element elemnt = (Element) nd;
	           //System.out.println("Employee ID : " + elemnt.getAttribute("empid"));
	           String pais = elemnt.getElementsByTagName("nombre").item(0).getTextContent();
	           
	           int hombres = Integer.parseInt( elemnt.getElementsByTagName("hombres").item(0).getTextContent());
	           int mujeres = Integer.parseInt( elemnt.getElementsByTagName("mujeres").item(0).getTextContent());
	           int total = hombres + mujeres;
	           //System.out.println(mujeres);
	           System.out.println("Nombre del país: " + pais);
	           System.out.println("Población de hombres: " + hombres);
	           System.out.println("Población de mujeres: " + mujeres);
	           System.out.println("Total de población: " + total);
	           System.out.println("----------------------------");

	        }
       }
   }
}


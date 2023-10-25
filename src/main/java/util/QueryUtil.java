package util;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QueryUtil extends CommonUtil {

	 public QueryUtil() {
	    }

	    public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {
	        Element element = null;
	        //NodeList nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + File.separator + "wtpwebapps" + File.separator + "goflow" + File.separator + "WEB-INF" + File.separator + "Query.xml")).getElementsByTagName("query");
			NodeList nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("C:\\Users\\HP\\Documents\\GitHub\\goflow\\src\\main\\webapp\\WEB-INF\\Query\\Query.xml")).getElementsByTagName("query");

	        for(int value = 0; value < nodeList.getLength(); ++value) {
	            element = (Element)nodeList.item(value);
	            if (element.getAttribute("id").equals(id)) {
	                break;
	            }
	        }

	        return element.getTextContent().trim();
	    }
	    
}

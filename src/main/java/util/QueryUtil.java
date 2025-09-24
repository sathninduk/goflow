package util;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// This class is used to get the queries from the queries.xml file
public class QueryUtil extends CommonUtil {

    public QueryUtil() { // default constructor
    }

    // This method is used to get the query by id
    public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Element element = null;
        NodeList nodeList = builder.parse(new File(properties.getProperty("queryPath")))
                .getElementsByTagName("query");

        for (int value = 0; value < nodeList.getLength(); ++value) {
            element = (Element) nodeList.item(value);
            if (element.getAttribute("id").equals(id)) {
                break;
            }
        }

        return element.getTextContent().trim(); // return the query
    }

}

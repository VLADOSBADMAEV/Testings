package org.example;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;


public class XMLreader {
    final String loadFile;
    final String loadFormat;
    final boolean isLoad;

    final boolean isSave;
    final String saveFile;
    final String saveFormat;

    final boolean isLog;
    final String logFile;


    public XMLreader(File xmlFile) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document docs = builder.parse(xmlFile);


        Node root = docs.getDocumentElement();
        NodeList nodelist = root.getChildNodes();
        for(int i = 0; i < nodelist.getLength(); i++) {
               System.out.println(i + nodelist.item(i).getNodeValue());
             }

        XPath xPath = XPathFactory.newInstance().newXPath();
        isLoad = Boolean.parseBoolean(xPath.compile("/config/load/enabled").evaluate(docs));
        loadFile = xPath.compile("/config/load/enabled").evaluate(docs);
        loadFormat = xPath.compile("/config/load/enabled").evaluate(docs);

        isSave = Boolean.parseBoolean(xPath.compile("/config/load/enabled").evaluate(docs));
        saveFile = xPath.compile("/config/load/enabled").evaluate(docs);
        saveFormat = xPath.compile("/config/load/enabled").evaluate(docs);

        isLog = Boolean.parseBoolean(xPath.compile("/config/load/enabled").evaluate(docs));
        logFile = xPath.compile("/config/load/enabled").evaluate(docs);







       // Element root = docs.getDocumentElement();
       // Element loadsettings = (Element) root.getElementsByTagName("load").item(0);
       // Element savesettings = (Element) root.getElementsByTagName("save").item(0);
       // Element logsettings = (Element) root.getElementsByTagName("log").item(0);


       // loadFile = loadsettings.getElementsByTagName("fileName").item(0).getTextContent();
       // loadFormat = loadsettings.getElementsByTagName("format").item(0).getTextContent();
       // isLoad = Boolean.parseBoolean(loadsettings.getElementsByTagName("enabled").item(0).getTextContent());

       // saveFormat = savesettings.getElementsByTagName("format").item(0).getTextContent();
       // saveFile = savesettings.getElementsByTagName("fileName").item(0).getTextContent();
       // isSave = Boolean.parseBoolean(savesettings.getElementsByTagName("enabled").item(0).getTextContent());

        //isLog = Boolean.parseBoolean(logsettings.getElementsByTagName("enabled").item(0).getTextContent());
        //logFile = logsettings.getElementsByTagName("fileName").item(0).getTextContent();


    }
}
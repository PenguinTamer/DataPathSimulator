package salazar.cs3354.txstate.edu.datapathsimulator;

import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class mcQuestionParserHandler extends DefaultHandler {
    private ArrayList questions = new ArrayList();
    private Stack elementStack = new Stack();
    private Stack objectStack = new Stack();

    public void startDocument() throws SAXException {
        //System.out.println("start of the document   : ");
    }

    public void endDocument() throws SAXException {
        //System.out.println("end of the document document     : ");
    }
}

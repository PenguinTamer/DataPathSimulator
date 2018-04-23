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

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);
        if ("question".equals(qName)) {
            mcQuestion mcQuestion = new mcQuestion();
            if (attributes != null && attributes.getLength() == 1) {
                mcQuestion.setqID(Integer.parseInt(attributes.getValue(0)));
            }
            this.objectStack.push(mcQuestion);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.elementStack.pop();
        if ("question".equals(qName)) {
            Object object = this.objectStack.pop();
        }
    }
}

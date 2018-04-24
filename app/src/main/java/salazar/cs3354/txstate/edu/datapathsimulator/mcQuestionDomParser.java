package salazar.cs3354.txstate.edu.datapathsimulator;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class mcQuestionDomParser {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    ArrayList<mcQuestion> mcQuestionArrayList = new ArrayList<>();
    mcQuestion mcQuestion;

    {
        try {
            builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse("MCquestions.xml");
            NodeList questionList = document.getElementsByTagName("item");

            for (int i = 0; i < questionList.getLength(); i++) {
                mcQuestion = new mcQuestion();
                org.w3c.dom.Node n = questionList.item(i);

                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element question = (Element) n;
                    mcQuestion.setqID(Integer.parseInt(question.getAttribute("id")));
                    NodeList elementList = question.getChildNodes();

                    for (int j = 0; j < elementList.getLength(); j++) {
                        Node m = questionList.item(j);
                        if (m.getNodeType() == Node.ELEMENT_NODE) {
                            Element questionElement = (Element) n;
                            switch (questionElement.getTagName()) {
                                case "questionText":
                                    mcQuestion.setQuestion(questionElement.getTextContent());
                                case "answer":
                                    mcQuestion.setAnswer(questionElement.getTextContent());
                                case "wrongChoice":
                                    mcQuestion.untrueChoices.add(Integer.parseInt(questionElement.getAttribute("id")), questionElement.getTextContent());
                                default:
                            }
                        }
                    }
                    mcQuestionArrayList.add(mcQuestion);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<mcQuestion> getMcQuestion() {
        return mcQuestionArrayList;
    }
}

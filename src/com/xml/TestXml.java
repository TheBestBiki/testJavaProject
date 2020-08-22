package com.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TestXml {

    public static void main(String[] args) {
        String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <env:Header/>\n" +
                "  <env:Body>\n" +
                "    <OutputParameters xmlns=\"http://xmlns.oracle.com/apps/xxscm/soaprovider/plsql/xxscm_ascp_result_import_pkg/do_import/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "      <X_RETURN_TBL>\n" +
                "        <X_RETURN_TBL_ITEM>\n" +
                "          <SPCN_APPLY_NO>asddasd</SPCN_APPLY_NO>\n" +
                "          <EXPECT_FORECAST_DATE>2020/01/17</EXPECT_FORECAST_DATE>\n" +
                "          <TAG>S</TAG>\n" +
                "          <RETURN_MESSAGE xsi:nil=\"true\"/>\n" +
                "        </X_RETURN_TBL_ITEM>\n" +
                "      </X_RETURN_TBL>\n" +
                "      <X_RETURN_STATUS>S</X_RETURN_STATUS>\n" +
                "      <X_MSG_COUNT xsi:nil=\"true\"/>\n" +
                "      <X_MSG_DATA>Succeed! cuxs_session_id:=</X_MSG_DATA>\n" +
                "    </OutputParameters>\n" +
                "  </env:Body>\n" +
                "</env:Envelope>";

        //List<String> list = deptList(xml);
        xml.replaceAll("env:Envelope","Envelope").replaceAll("env:Body","Body")
                .replaceAll(" xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"","")
                .replaceAll(" xmlns=\"http://xmlns.oracle.com/apps/xxscm/soaprovider/plsql/xxscm_ascp_result_import_pkg/do_import/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"","");
        List<String> list = new ArrayList();
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            org.w3c.dom.Document doc = builder.parse(is);
            System.out.println(doc.getNodeName());
            System.out.println(doc.getDocumentElement());
            NodeList nList = doc.getElementsByTagName("OutputParameters");
            //NodeList nList = doc.getElementsByTagName("Student");
            //遍历该集合，显示结合中的元素及其子元素的名字
            for(int i = 0; i< nList.getLength() ; i ++){
                Element node = (Element)nList.item(i);
                System.out.println("Name: "+ node.getElementsByTagName("Name").item(0).getFirstChild().getNodeValue());
                System.out.println("Num: "+ node.getElementsByTagName("Num").item(0).getFirstChild().getNodeValue());
                System.out.println("Classes: "+ node.getElementsByTagName("Classes").item(0).getFirstChild().getNodeValue());
                System.out.println("Address: "+ node.getElementsByTagName("Address").item(0).getFirstChild().getNodeValue());
                System.out.println("Tel: "+ node.getElementsByTagName("Tel").item(0).getFirstChild().getNodeValue());
            }
            //System.out.println(list.get(0));
            //System.out.println(doc.getElementsByTagName("OutputParameters"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static List<String> deptList(String xml) {
        List<String> list = new ArrayList();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            org.w3c.dom.Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();
            //System.err.println("第一个标签: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("OutputParameters");
            //System.err.println("长度>>>  " + nList.getLength());
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                //System.err.println("定位到: " + node.getNodeName());
                //获取 n 节点下所有的子节点。此处值得注意，在DOM解析时会将所有回车都视为 n 节点的子节点。
                NodeList nl2 = node.getChildNodes();
                //因为上面的原因，在此例中第一个 n 节点有 2 个子节点，而第二个 n 节点则有 5 个子节点（因为多了3个回车）。
                int size2 = nl2.getLength();
                for (int j = 0; j < size2; j++) {
                    Node n2 = nl2.item(j);
                    //System.err.println("定位到2: " + n2.getNodeName());
                    NodeList nl3 = n2.getChildNodes();
                    int size3 = nl3.getLength();
                    for (int x = 0; x < size3; x++) {
                        Node n3 = nl3.item(x);
                        //System.err.println("定位到3: " + n3.getNodeName());
                        //还是因为上面的原因，故此要处判断当 n2 节点有子节点的时才输出。
                        if (n3.hasChildNodes()) {
                            // System.out.println(n3.getNodeName() + " = " + n3.getFirstChild().getNodeValue());
                            if (n3.getNodeName().equals("DESCR")) {
                                list.add(0, n3.getFirstChild().getNodeValue());
                            } else {
                                list.add(n3.getFirstChild().getNodeValue());
                            }
                        }
                    }
                }
//                Element ele = (Element)node;
//                System.err.println("----------------------------");
//                if(node.getNodeType() == Element.ELEMENT_NODE){
//                    System.err.println("title name: "+ ele.getElementsByTagName("DESCR").item(0).getTextContent());
//                    System.err.println("author name: "+ele.getElementsByTagName("DESCR1").item(0).getTextContent());
//                    System.err.println("-------------------------"+ ele.getChildNodes().getLength());
//                }
            }
        } catch (Exception ex) {

        }
        return list;
    }
}

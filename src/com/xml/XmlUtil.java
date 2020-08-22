package com.xml;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class XmlUtil {

    private String ss;

    public static Map<String, String> paraXml(String xml) {
        Map<String, String> map = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            //输入要解析的xml字符串，要带有xml的文件标识<?xml version="1.0" encoding="utf-8"/>
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            org.w3c.dom.Document doc = builder.parse(is);
            //查找带参数中名称的标签，比如一个xml里面有部分标签是
            //<student>
            //<name>zhangsan</name>
            //<age>22</age>
            //</student>
            //那么这里的参数就可以写成是student，然后得到name和age的list
            NodeList list = doc.getElementsByTagName("X_RETURN_TBL_ITEM");
            for (int i = 0; i <list.getLength() ; i++) {
                Node node = list.item(i);
                NodeList childNodes = node.getChildNodes();
                //-2是因为/n也算一个长度，这里减少2还是其它看具体情况，不减也行
                for (int j = 0; j <childNodes.getLength()-2 ; j++) {
                    //Node.ELEMENT_NODE常量，表示是个元素，即是个标签
                    if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
                        //这里的字符串是获取到的list中的标签名，如name，age
                        if("SPCN_APPLY_NO".equals(childNodes.item(j).getNodeName())){
                            //获取标签中的值
                            map.put("SPCN_APPLY_NO",childNodes.item(j).getFirstChild().getNodeValue());
                        }
                        if("EXPECT_FORECAST_DATE".equals(childNodes.item(j).getNodeName())){
                            map.put("EXPECT_FORECAST_DATE",childNodes.item(j).getFirstChild().getNodeValue());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("解析失败");
        }
        return map;
    }

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
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
        Map<String, String> map = paraXml(xml);
        System.out.println(map.get("SPCN_APPLY_NO"));
        System.out.println(map.get("EXPECT_FORECAST_DATE"));
    }


}

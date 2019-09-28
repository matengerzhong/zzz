package com.example.demo.ndc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.http.codec.multipart.SynchronossPartHttpMessageReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 @author MT
 @date 2019年9月27日 
*/
public class MyNewTest {
	public static void main(String[] args) {
		DocumentElement doc = new DocumentElement();
		doc.setDocId("1");
		doc.setDocName("验舱验价请求参数");
		doc.setDocDesc("验舱验价接口入参");
	    
		addDocument(doc,new ClassElement("IATAOfferPriceRQ","验舱验舱验价入参"),
				new FieldElement("Party","参与者","PartyType","M"),
				new FieldElement("PayloadAttributes","有效荷载属性","IATAPayloadStandardAttributesType","M"),
				new FieldElement("Request","请求","RequestType","M")
				);
		
		 addDocument(doc,new ClassElement("IATAPayloadStandardAttributesType","有效荷载属性"),
				 new FieldElement("AltLangID","语言ID","String","M"),
				 new FieldElement("CorrelationID","关联ID","String","M"),
				 new FieldElement("EchoTokenText","回声令牌","String","M"),
				 new FieldElement("PrimaryLangID","语言ID","String","M"),
				 new FieldElement("RetransmissionInd","重传标识","Boolean","M"),
				 new FieldElement("SeqNumber","事务序列号","String","M"),
				 new FieldElement("Timestamp","消息日期时间","String","M"),
				 new FieldElement("TrxID","交易ID","String","M"),
				 new FieldElement("TrxStatusCode","交易状态代码","String","M"),
				 new FieldElement("VersionNumber","版本号","BigDecimal","M")
				 );
		 
		   addDocument(doc,new ClassElement("PartyType","参与者"),new FieldElement("Recipient","接收者","RecipientType","M"),
				 new FieldElement("Sender","发送者","SenderType","M")
				 );
		  
		   String carrierTypeFiledId = UUID.randomUUID().toString();
		   addDocument(doc,new ClassElement("RecipientType","接收者"),new FieldElement(carrierTypeFiledId,"MarketingCarrier","市场方信息","CarrierType","M"),
					 new FieldElement(carrierTypeFiledId,"OperatingCarrier","承运方信息","CarrierType","M"),new FieldElement(carrierTypeFiledId,"ORA","订单责任航空公司","CarrierType","M")
			 );
		
		   addDocument(doc,new ClassElement("CarrierType","运营方"),new FieldElement("AirlineDesigCode","航空公司代码","String","M"),
					 new FieldElement("AirlineDesigCode","共享代码标识","Boolean","M")
		    );
		   
		   
		   
		   
		 
          ObjectMapper mapper = new ObjectMapper();
        
        try {
			String res = mapper.writeValueAsString(doc);
			System.out.println(res);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        //System.out.println(Arrays.asList());
	}
	
	private static void addDocument(DocumentElement doc ,ClassElement addClassElement,FieldElement ...addFieldElements) {
		
		
		String classAddId = null;
		
		List<ClassElement> classElementList = doc.getClassElementList();
		if(classElementList!=null) {
			boolean flag = false;
			for(ClassElement classElement:classElementList) {
				List<FieldElement> fieldElements = classElement.getFieldElementList();
				for(FieldElement fieldElement:fieldElements) {
					 if(fieldElement.getFieldType().equals(addClassElement.getClassName())) {
						 
						 classAddId =fieldElement.getFieldId();
						 flag = true;
					 }
					 if (flag) {
							break;
					}
				}
			}
		}else {
			doc.setClassElementList(new ArrayList<ClassElement>());
		}
		addClassElement.setClassId(Objects.isNull(classAddId)?UUID.randomUUID().toString():classAddId);
		
		if(addFieldElements.length!=0) {
			
			List<FieldElement> asList = Arrays.asList(addFieldElements);
			int seqIndex =1;
			for(FieldElement fieldElement:asList) {
				if(fieldElement.getFieldId()==null) {
					fieldElement.setFieldId(UUID.randomUUID().toString());
				}
				fieldElement.setSeqIndex(seqIndex+"");
				seqIndex++;
			}
			addClassElement.setFieldElementList(asList);
		}
		doc.getClassElementList().add(addClassElement);
	}
	
}

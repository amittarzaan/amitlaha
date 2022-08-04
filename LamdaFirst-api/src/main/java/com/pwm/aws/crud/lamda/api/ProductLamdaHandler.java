package com.pwm.aws.crud.lamda.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.pwm.aws.crud.lamda.api.model.Product;

public class ProductLamdaHandler implements RequestStreamHandler{

	private String DYNAMO_TABLE="Products";
	Logger logger;
	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
	OutputStreamWriter writer=new OutputStreamWriter(output);
	BufferedReader reader=new BufferedReader(new InputStreamReader(input));
	JSONParser parser=new JSONParser();
	JSONObject responseObject=new JSONObject();
	JSONObject jsonBody=new JSONObject();
	AmazonDynamoDB	client=AmazonDynamoDBClientBuilder.defaultClient();
	DynamoDB dynamoDB=new DynamoDB(client);
	int id;
	Item restItem=null;
	try {
		
		JSONObject reqObject=(JSONObject) parser.parse(reader);
		boolean isNull=true;
		if(reqObject.get("pathParameters")!=null) {
			JSONObject pps=(JSONObject) reqObject.get("pathParameters");
			context.getLogger().log("context  it is a pathParameters  ");
			context.getLogger().log("sysout:: pps  "+pps.toJSONString());
			context.getLogger().log("sysout:: id  "+pps.get("id").toString());
			context.getLogger().log("sysout:: id  "+pps.get("id").toString().equals(null));
			isNull=pps.get("id").toString().equals(null);
			context.getLogger().log("sysout:: isNull  "+isNull);
			if(!isNull) {
				context.getLogger().log("sysout:: it is a pathParameters and id found ");
				id=Integer.parseInt((String)pps.get("id"));
				context.getLogger().log("sysout:: Id::  "+id);
				restItem=dynamoDB.getTable(DYNAMO_TABLE).getItem("id",id);
				context.getLogger().log("sysout:: Got the DB items::  "+restItem.toJSON());
			}
			
		}else if(reqObject.get("queryStringParameters")!=null) {
			context.getLogger().log("context  it is a queryStringParameters  ");			
			JSONObject qps=(JSONObject) reqObject.get("queryStringParameters");
			context.getLogger().log("sysout:: pps  "+qps.toJSONString());
			if(qps.get("id")!=null) {
				context.getLogger().log("sysout::  it is a queryStringParameters and id found  ");
				id=Integer.parseInt((String) qps.get("id") );
				context.getLogger().log("sysout:: Id::  "+id);
				restItem=dynamoDB.getTable(DYNAMO_TABLE).getItem("id",id);
				context.getLogger().log("sysout:: Got the DB items::  "+restItem.toJSON());
			}
			
		}
		if(restItem!=null) {
			context.getLogger().log("sysout::restItem is found and not null");
			Product product=new Product(restItem.toJSON());
			jsonBody.put("product", product);
			context.getLogger().log("sysout::added product to json body" +restItem.toJSON().toString());
			responseObject.put("statusCode", 200);
		}else {
			context.getLogger().log("sysout::restItem is null");
			jsonBody.put("message", "No items found");
			responseObject.put("statusCode", 404);
		}
		responseObject.put("body", jsonBody.toJSONString());
	} catch (Exception e) {
		context.getLogger().log("Error  "+e.getMessage());
		context.getLogger().log("sysout::Exception occured "+e.getMessage());
		
		// TODO: handle exception
	}
	writer.write(responseObject.toString());
	reader.close();
	writer.close();
		
	}
}

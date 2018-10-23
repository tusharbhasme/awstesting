package com.amazonaws.samples;

import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.s3.model.Region;

public class Test {

	public static void main(String[] args) {
		AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new ProfileCredentialsProvider("tbhasme"))
                .build();
		ListTablesResult listTables = ddb.listTables();
		ResponseMetadata sdkResponseMetadata = listTables.getSdkResponseMetadata();
//		System.out.println(sdkResponseMetadata);
//		System.out.println(listTables);
		
		AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
				.withRegion(Regions.US_WEST_2)
                .withCredentials(new ProfileCredentialsProvider("tbhasme"))
                .build();
//		System.out.println(ec2.describeImages());
		System.out.println(ec2.describeInstances());
	}

}

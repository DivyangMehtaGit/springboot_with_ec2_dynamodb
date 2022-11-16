package com.learn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Configuration
public class DynamoDBConfiguration {

	@Value("${com.aws.accesskey}")
	private String accesskey;

	@Value("${com.aws.secretkey}")
	private String secretkey;

	@Bean
	public DynamoDBMapper dynamoDBMapper() {

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesskey, secretkey)))
				.withRegion(Regions.AP_SOUTH_1).build();
		
		return new DynamoDBMapper(client, DynamoDBMapperConfig.DEFAULT);
	}

//	public static void getSecret() {
//		String secretName = "iamaccess";
//		Region region = Region.of("ap-south-1");
//		// Create a Secrets Manager client
////		SecretsManagerClient client = SecretsManagerClient.builder().region(region).build();

//		GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder().secretId(secretName).build();
//
//		GetSecretValueResponse getSecretValueResponse;
//		try {
//			getSecretValueResponse = client.getSecretValue(com.amazonaws.services.secretsmanager.model.GetSecretValueRequest);
//		} catch (Exception e) {
//			throw e;
//		}
//
//		String secret = getSecretValueResponse.secretString();
//
//		// Your code goes here.
//	}
}

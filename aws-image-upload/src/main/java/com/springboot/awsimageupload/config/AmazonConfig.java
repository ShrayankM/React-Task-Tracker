package com.springboot.awsimageupload.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(
                "AKIAYC7W7RXLLM47JKNM",
                "PgSMBvNH6JaDti6RVliY4G7upw5bMWCCKff7R6md");

        return AmazonS3ClientBuilder
                .standard()
                .withRegion("us-west-1")  //This is the code i added to fix
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

}

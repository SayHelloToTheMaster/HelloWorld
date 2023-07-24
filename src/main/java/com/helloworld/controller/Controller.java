package com.helloworld.controller;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.helloworld.utils.ResponseModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class Controller {



    @Value("${my-app-secret-1}")
    private String secretValue;

    @Value("${my-app-secret-2}")
    private String secretValue2;

    @Value("${my-app-secret-3}")
    private String secretValue3;


    @Value("${my-app-secret-4}")
    private String secretValue4;

    @Value("${my-app-secret-5}")
    private String secretValue5;




    @GetMapping("/helloWorld")
    public String helloWorld() throws IOException {
        return "Hello World! We Achieved Something New!";
    }


    @GetMapping("/secreteManager")
    public ResponseEntity<ResponseModel> secreteManager(String projectId, String secreteId, String version) throws IOException {
        String secretResourceName = null,secretValue1 = null;
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            secretResourceName = String.format("projects/%s/secrets/%s/versions/%s", projectId, secreteId, version);
            AccessSecretVersionResponse response = client.accessSecretVersion(secretResourceName);
            // Get the secret value.
            secretValue1 = response.getPayload().getData().toStringUtf8();
        }
        String val = "secretValue--->   "+ this.secretValue + "   secretValue2 -->   "+this.secretValue2+"   secretValue3---->   "+secretValue3+"    secretValue4   "+secretValue4+"    secretValue5   "+ secretValue5;
        System.out.println(val);
        ResponseEntity<ResponseModel> responseEntity = ResponseEntity.status(200).body(new ResponseModel().setStatus(200).setMessage("secretResourceName "+ secretResourceName).setData("secretValue ---> "+ secretValue1));
        return responseEntity;
    }


}

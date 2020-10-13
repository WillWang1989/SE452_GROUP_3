package edu.depaul.se452.windycityflyers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.HashMap;

@Data
@Document(collection = "logs")
@NoArgsConstructor
@AllArgsConstructor
public class Logs{
    @Id
    private String id;
    private String url;
    private String body;
    private String contentType;
    private String httpMethod;
    private String statusCode;
    private String protocol;
    private String userAgent;
    private HashMap<String,String> headers;
    private HashMap<String,String> cookies;
    private LocalDateTime requestDate;
}

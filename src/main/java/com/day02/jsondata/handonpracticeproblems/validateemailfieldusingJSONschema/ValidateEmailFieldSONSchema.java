package com.day02.jsondata.handonpracticeproblems.validateemailfieldusingJSONschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class ValidateEmailFieldSONSchema {
    public static void main(String[] args) {
        String schema= """
        {
            "$schema": "http://json-schema.org/draft-07/schema#",
                "type": "object",
                "properties": {
            "name": { "type": "string" },
            "email": { "type": "string", "format": "email" }
        },
        "required": ["name", "email"]
        }
        """;
        String validJson = "{\"name\": \"Sachin\", \"email\": \"sachin@example.com\"}";
        String invalidJson = "{\"name\": \"Rahul\", \"email\": \"not-an-email\"}";
try {


    ObjectMapper mapper = new ObjectMapper();
    JsonNode schemaNode = mapper.readTree(schema);
    JsonNode validJsonNode = mapper.readTree(validJson);
    JsonNode invalidJsonNode = mapper.readTree(invalidJson);

    JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
    JsonSchema schemam = factory.getJsonSchema(schemaNode);

    // Validate valid JSON
    validateJson(schemam, validJsonNode);

    // Validate invalid JSON
    validateJson(schemam, invalidJsonNode);
}catch (Exception e){
    System.out.println("Exception occured");
}
    }

    private static void validateJson(JsonSchema schema, JsonNode jsonNode) throws Exception {
        ProcessingReport report = schema.validate(jsonNode);
        if (report.isSuccess()) {
            System.out.println("JSON is valid: " + jsonNode);
        } else {
            System.out.println(" JSON validation failed:");
            report.forEach(msg -> System.out.println("- " + msg.getMessage()));
        }

    }
}

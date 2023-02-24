package com.arthurvella.pizzachat;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WebHookRequest {
    QueryResult queryResult;
}

@Data
class QueryResult {
    String action;
    Map<String, String> parameters;

    List<OutputContext> outputContexts;
}

@Data
class OutputContext {
    String name;
    Map<String, String> parameters;
}
package com.arthurvella.pizzachat;

import lombok.Data;

import java.util.List;
@Data
public class WebHookResponse {
    private List<Message> fulfillmentMessages;
}

@Data
class Message {
    String platform;
    SimpleResponses simpleResponses;
    Suggestions suggestions;
    CarouselSelect carouselSelect;

}
@Data
class SimpleResponses {
    List<SimpleResponse> simpleResponses;
}
@Data
class SimpleResponse {
    String textToSpeech;
}

@Data
class Suggestions {
    List<Suggestion> suggestions;
}
@Data
class Suggestion {
    String title;
}

@Data
class CarouselSelect {
    List<Item> items;
}

@Data
class Item {
    String title;
    SelectItemInfo info;
    String description;
    Image image;
}

@Data
class SelectItemInfo {
    String key;
}

@Data
class Image {
    String imageUri;
    String accessibilityText;
}

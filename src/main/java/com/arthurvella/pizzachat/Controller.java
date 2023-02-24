package com.arthurvella.pizzachat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/")
    String HelloWord() {
        return "Hello World !";
    }

    @PostMapping("/chat")
    WebHookResponse Chat(@RequestBody WebHookRequest request) {
        Map<String, String> parameters = request.queryResult.parameters;

        WebHookResponse response = new WebHookResponse();

        String currentBase = parameters.get("Base");
        if (currentBase == null || currentBase == "") {
            response.setFulfillmentMessages(List.of(
                    new Message().setPlatform("ACTIONS_ON_GOOGLE").setSimpleResponses(new SimpleResponses().setSimpleResponses(List.of(
                            new SimpleResponse().setTextToSpeech("Quelle base vous intéresse")
                    ))),
                    new Message().setPlatform("ACTIONS_ON_GOOGLE").setSuggestions(new Suggestions().setSuggestions(new ArrayList<Suggestion>()))));
            for (int i = 0; i < Base.all.size(); i++) {
                response.getFulfillmentMessages().get(1).getSuggestions().getSuggestions().add(
                        new Suggestion().setTitle(String.format("Base %s", Base.all.get(i).name))
                );
            }
        } else {
            Base base = Base.all.stream().filter(b -> currentBase.equals(b.getName())).findFirst().orElse(null);
            List<Pizza> selections = Pizza.getPizzaFromBase(base);

            response.setFulfillmentMessages(List.of(
                    new Message().setPlatform("ACTIONS_ON_GOOGLE").setSimpleResponses(new SimpleResponses().setSimpleResponses(List.of(
                            new SimpleResponse().setTextToSpeech(String.format("Choisissez une pizza base %s", base.name))))),
                    new Message().setPlatform("ACTIONS_ON_GOOGLE").setCarouselSelect(new CarouselSelect().setItems(new ArrayList<Item>()))));

            for (int i = 0; i < selections.size(); i++) {
                Pizza currentPizza = selections.get(i);
                String price = String.format("%.2f€", currentPizza.price);

                response.getFulfillmentMessages().get(1).getCarouselSelect().getItems().add(
                        new Item()
                                .setTitle(currentPizza.name)
                                .setDescription(price)
                                .setInfo(new SelectItemInfo().setKey(Integer.toString(currentPizza.id)))
                                .setImage(new Image().setImageUri(currentPizza.imageUrl).setAccessibilityText("Pizza"))
                );
            }
        }

        return response;
    }
}

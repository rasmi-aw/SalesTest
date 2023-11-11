package com.rasmi.salestest.utils;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.rasmi.salestest.enums.GoodType;
import com.rasmi.salestest.model.Good;

import java.io.IOException;

public class CustomGoodDeserializer extends StdDeserializer<Good> {

    protected CustomGoodDeserializer(Class<?> vc) {
        super(vc);
    }

    public CustomGoodDeserializer() {
        this(null);
    }

    @Override
    public Good deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = deserializationContext.readTree(jsonParser);
        return new GoodsFactory().getGood(
                node.get("name").asText(),
                node.get("price").asDouble(),
                node.get("quantity").asInt(),
                node.get("imported").asBoolean(),
                GoodType.valueOf(node.get("type").asText()));
    }
}

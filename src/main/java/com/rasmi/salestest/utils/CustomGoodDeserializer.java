package com.rasmi.salestest.utils;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.rasmi.salestest.enums.GoodType;
import com.rasmi.salestest.model.Good;

import java.io.IOException;

/**
 * @author Abdeloaudoud Rasmi, this class plays the role of a json deserializer,
 * it's used to convert json object into the proper Good / Subclass instance, using
 * {@link GoodsFactory}
 */
public class CustomGoodDeserializer extends StdDeserializer<Good> {

    private GoodsFactory factory = new GoodsFactory();

    protected CustomGoodDeserializer(Class<?> vc) {
        super(vc);
    }

    public CustomGoodDeserializer() {
        this(null);
    }

    @Override
    public Good deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = deserializationContext.readTree(jsonParser);
        return factory.getGood(
                node.get("name").asText(),
                node.get("price").asDouble(),
                node.get("quantity").asInt(),
                node.get("imported").asBoolean(),
                GoodType.valueOf(node.get("type").asText()));
    }
}

package ru.cobp.backend.dto.exchange;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CustomTimestampDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        return LocalDateTime.ofInstant(
                Instant.ofEpochSecond(jsonParser.getLongValue()), ZoneId.of("Europe/Moscow")
        );
    }

}

package classy.classyapp.BackendApi.converter;

import jakarta.persistence.AttributeConverter;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(ZonedDateTime zonedDateTime) {
        return Timestamp.from(zonedDateTime.toInstant());
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp.toLocalDateTime().atZone(ZoneId.of("Asia/Bangkok"));
    }
}

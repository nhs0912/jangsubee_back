package jangsubee.domain.schedule.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ScheduleTypeEnum {
    
    VACATION("01", "휴가")
    ;

    private final String value;
    private final String description;

    public static ScheduleTypeEnum getEnum(String value) {
        return Arrays.stream(ScheduleTypeEnum.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", value)));
    }

    public static class ScheduleTypeEnumConverter implements AttributeConverter<ScheduleTypeEnum, String> {

        @Override
        public String convertToDatabaseColumn(ScheduleTypeEnum attribute) {
            return attribute==null ? null : attribute.getValue();
        }

        @Override
        public ScheduleTypeEnum convertToEntityAttribute(String dbData) {
            return dbData==null ? null : ScheduleTypeEnum.getEnum(dbData);
        }
    }
}

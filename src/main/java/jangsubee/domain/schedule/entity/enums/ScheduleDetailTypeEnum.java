package jangsubee.domain.schedule.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ScheduleDetailTypeEnum {

    VACATION("001", "연차"),
    MORNING_OFF("002", "오전반차"),
    AFTERNOON_OFF("003", "오후반차"),
    SICK_LEAVE("004", "병가")
    ;

    private final String value;
    private final String description;

    public static ScheduleDetailTypeEnum getEnum(String value) {
        return Arrays.stream(ScheduleDetailTypeEnum.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", value)));
    }

    public static class ScheduleDetailTypeEnumConverter implements AttributeConverter<ScheduleDetailTypeEnum, String> {

        @Override
        public String convertToDatabaseColumn(ScheduleDetailTypeEnum attribute) {
            return attribute==null ? null : attribute.getValue();
        }

        @Override
        public ScheduleDetailTypeEnum convertToEntityAttribute(String dbData) {
            return dbData==null ? null : ScheduleDetailTypeEnum.getEnum(dbData);
        }
    }
}

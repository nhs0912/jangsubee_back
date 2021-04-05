package jangsubee.domain.schedule.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ScheduleStatusEnum {
    
    ACTIVE("AT", "활성"),
    CLOSE("CL", "종료")
    ;

    private final String value;
    private final String description;

    public static ScheduleStatusEnum getEnum(String value) {
        return Arrays.stream(ScheduleStatusEnum.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", value)));
    }

    public static class ScheduleStatusEnumConverter implements AttributeConverter<ScheduleStatusEnum, String> {

        @Override
        public String convertToDatabaseColumn(ScheduleStatusEnum attribute) {
            return attribute==null ? null : attribute.getValue();
        }

        @Override
        public ScheduleStatusEnum convertToEntityAttribute(String dbData) {
            return dbData==null ? null : ScheduleStatusEnum.getEnum(dbData);
        }
    }
}

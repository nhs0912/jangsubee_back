package jangsubee.domain.schedule.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ScheduleMemberRelationEnum {

    MANAGER("01", "관리자"),
    PARTICIPANT("02", "참여자")
    ;

    private final String value;
    private final String description;

    public static ScheduleMemberRelationEnum getEnum(String value) {
        return Arrays.stream(ScheduleMemberRelationEnum.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", value)));
    }

    public static class ScheduleMemberRelationEnumConverter implements AttributeConverter<ScheduleMemberRelationEnum, String> {

        @Override
        public String convertToDatabaseColumn(ScheduleMemberRelationEnum attribute) {
            return attribute==null ? null : attribute.getValue();
        }

        @Override
        public ScheduleMemberRelationEnum convertToEntityAttribute(String dbData) {
            return dbData==null ? null : ScheduleMemberRelationEnum.getEnum(dbData);
        }
    }
}

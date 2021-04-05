package jangsubee.domain.member.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum VacationGrantReasonEnum {

    ANNUAL_VACATION("001", "연차휴가")
    ;

    private final String value;
    private final String description;

    public static VacationGrantReasonEnum getEnum(String value) {
        return Arrays.stream(VacationGrantReasonEnum.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", value)));
    }

    public static class VacationGrantReasonEnumConverter implements AttributeConverter<VacationGrantReasonEnum, String> {

        @Override
        public String convertToDatabaseColumn(VacationGrantReasonEnum attribute) {
            return attribute==null ? null : attribute.getValue();
        }

        @Override
        public VacationGrantReasonEnum convertToEntityAttribute(String dbData) {
            return dbData==null ? null : VacationGrantReasonEnum.getEnum(dbData);
        }
    }
}

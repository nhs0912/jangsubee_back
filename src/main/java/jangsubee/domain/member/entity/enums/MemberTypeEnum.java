package jangsubee.domain.member.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum MemberTypeEnum {

    MANAGER("01", "관리자"),
    REPRESENTATIVE("02", "현장대리인"),
    PART_LEADER("03", "파트장"),
    TEAM_MEMBER("04", "팀원")
    ;

    private final String value;
    private final String description;

    public static MemberTypeEnum getEnum(String value) {
        return Arrays.stream(MemberTypeEnum.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", value)));
    }

    public static class MemberTypeEnumConverter implements AttributeConverter<MemberTypeEnum, String> {

        @Override
        public String convertToDatabaseColumn(MemberTypeEnum attribute) {
            return attribute==null ? null : attribute.getValue();
        }

        @Override
        public MemberTypeEnum convertToEntityAttribute(String dbData) {
            return dbData==null ? null : MemberTypeEnum.getEnum(dbData);
        }
    }
}

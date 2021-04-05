package jangsubee.domain.member.entity.id;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class MemberVacationPK implements Serializable {

    private String member;
    private String year;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MemberVacationPK)) {
            return false;
        }
        MemberVacationPK targetObj = (MemberVacationPK)obj;
        return (this.member.equals(targetObj.getMember())) &&
                (this.year.equals(targetObj.getYear()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, year);
    }

}

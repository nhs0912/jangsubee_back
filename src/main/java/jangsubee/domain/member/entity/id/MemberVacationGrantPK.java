package jangsubee.domain.member.entity.id;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class MemberVacationGrantPK implements Serializable {

    private String member;
    private String grantDate;
    private int sequenceNumber;

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MemberVacationGrantPK)) {
            return false;
        }
        MemberVacationGrantPK targetObj = (MemberVacationGrantPK)obj;
        return (this.member.equals(targetObj.getMember())) &&
                (this.grantDate.equals(targetObj.getGrantDate())) &&
                (this.sequenceNumber == targetObj.getSequenceNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, grantDate, sequenceNumber);
    }
}

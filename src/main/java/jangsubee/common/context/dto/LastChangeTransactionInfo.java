package jangsubee.common.context.dto;

import lombok.AllArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@AllArgsConstructor
public class LastChangeTransactionInfo {

    private String lastChangeMemberId;
    private LocalDateTime lastChangeTimestamp;
    private String lastChangeGuid;

    protected LastChangeTransactionInfo() {}
}

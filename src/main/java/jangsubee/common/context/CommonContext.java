package jangsubee.common.context;

import jangsubee.common.context.dto.LastChangeTransactionInfo;

import java.time.LocalDateTime;

public class CommonContext {
    // TODO: 서비스 공통 속성 정의해야 함

    public static LastChangeTransactionInfo createDefaultLastChangeTransactionInfo() {
        return new LastChangeTransactionInfo("TEST_STAFF", LocalDateTime.now(), "TEST_GUID");
    }
}

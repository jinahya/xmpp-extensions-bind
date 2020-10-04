package org.jabber.protocol.muc_user;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public interface IStatus {

    int MIN_CODE = 100;

    int MAX_CODE = 999;

    @Max(MAX_CODE)
    @Min(MIN_CODE)
    int getCode();

    void setCode(int code);
}

package jabber.server;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface IStatus {

    int SIZE_MIN_VALUE = 1;

    int SIZE_MAX_VALUE = 1024;

    @Size(min = SIZE_MIN_VALUE, max = SIZE_MAX_VALUE)
    @NotNull
    String getValue();

    void setValue(String value);
}

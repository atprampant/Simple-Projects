package org.atp.sportyshoes.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.atp.sportyshoes.enums.StatusCodes;

@Getter
@NoArgsConstructor
public class EmailAlreadyExistsException extends BaseException {
    public EmailAlreadyExistsException(StatusCodes statusCodes){super(statusCodes);}
}

package org.atp.sportyshoes.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.atp.sportyshoes.enums.StatusCodes;

@Getter
@NoArgsConstructor
public class UsernameAlreadyExistsException extends BaseException{
    public UsernameAlreadyExistsException(StatusCodes statusCodes){super(statusCodes);}
}

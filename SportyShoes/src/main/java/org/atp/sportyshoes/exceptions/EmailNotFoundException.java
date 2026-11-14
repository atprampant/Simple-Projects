package org.atp.sportyshoes.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.atp.sportyshoes.enums.StatusCodes;

@NoArgsConstructor
@Getter
public class EmailNotFoundException extends BaseException{
    public EmailNotFoundException(StatusCodes statusCodes){super(statusCodes);}
}

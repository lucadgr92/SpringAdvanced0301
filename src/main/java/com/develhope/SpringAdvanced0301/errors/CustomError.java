package com.develhope.SpringAdvanced0301.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
public class CustomError extends Exception{

    public CustomError(String message) {
        super(message);
    }
}

package com.yolobyob.getthechick.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.IM_USED)
public class UserCreationException extends RuntimeException {
		public UserCreationException(String message) {
			super(message);
		}
}

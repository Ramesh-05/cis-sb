package com.orchasp.contactInformationSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNotFound extends RuntimeException{
	private String msg="user not found";
}

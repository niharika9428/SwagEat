package com.swageat.dos;

import java.util.Date;

import com.swageat.constants.UserType;

import lombok.Data;

@Data
public class User extends BaseDO{

	protected String name;
	protected String emailId;
	protected String password;
	protected Date DateOfBirth;
	protected String phoneNumber;
	protected UserType userType;
}

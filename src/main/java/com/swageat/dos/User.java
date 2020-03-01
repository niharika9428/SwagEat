package com.swageat.dos;

import com.swageat.constants.UserType;

import lombok.Data;

@Data
public class User extends BaseDO{

	protected String name;
	protected String phoneNumber;
	protected UserType userType;
}

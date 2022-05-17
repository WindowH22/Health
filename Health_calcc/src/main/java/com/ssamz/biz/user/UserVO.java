package com.ssamz.biz.user;

import java.util.Objects;

import lombok.Data;

// VO(Value Object) 클래스
@Data
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String gender;
}

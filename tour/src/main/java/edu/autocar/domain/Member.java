package edu.autocar.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String userId;
	private String password;
	private String salt;
	private String name;
	private UserLevel userLevel;
	private String email;
	private String phone;
	private String address;
	private Date regDate;
	private Date updateDate;
}

package com.spring.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PartnerVO {
	private int id;
	private String name;
	private String ceo;
	private String contact;
	private String address;
	private Date registered;
	private Date unregistered;
}

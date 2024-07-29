package com.jsp.bootemail.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Emails {
	String[] to;
	String subject;
	String body;
}

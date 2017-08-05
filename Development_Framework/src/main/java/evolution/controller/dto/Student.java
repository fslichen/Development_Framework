package evolution.controller.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseDto {
	private String name;
	private String gender;
	@JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "GMT+8")
	private Date birthday;
}
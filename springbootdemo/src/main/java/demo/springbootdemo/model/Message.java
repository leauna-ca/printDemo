package demo.springbootdemo.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@Document(collection = "message")
public class Message {

	@Id
	@ApiModelProperty(hidden = true)
	private String _id;

	@NotBlank
	@ApiModelProperty(example = "This is a test message.", required = true)
	@Field("message")
	private String message;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Halifax")
	@ApiModelProperty(example = "2020-01-06 12:00:00", required = true)
	@Field("schedule_time")
	private Date scheduleTime;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}

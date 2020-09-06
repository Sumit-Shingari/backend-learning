package exception.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {

	private String message;
	
	private Timestamp date;
	
	@JsonIgnore
	private StackTraceElement[] stackTrace;
	
	private String details;
	
}

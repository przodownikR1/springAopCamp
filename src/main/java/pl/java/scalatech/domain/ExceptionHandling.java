package pl.java.scalatech.domain;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@MappedSuperclass
@Data
@ToString(callSuper=true)
public class ExceptionHandling extends EntityCommon{
	private static final long serialVersionUID = -3520510599039979657L;


	@NotNull
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "EXCEPTION", nullable = false)
	private String exception;

	@Lob
	@Column(name = "MESSAGE")
	@Basic(fetch=FetchType.LAZY)
	private String message;
	public static final String MESSAGE_FIELD_NAME = "message";

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "DESCRIPTION")
	private String description;

	public ExceptionHandling() {
		super();
	}

	public ExceptionHandling(String exception, String message, String description) {
		super();
		this.dateAdded = new Date();
		this.exception = exception;
		this.message = message;
		this.description = description;
	}

}

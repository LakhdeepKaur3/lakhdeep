package com.fliplearn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Choices")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Choices implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1490500701396866799L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(value = "choice_id")
	@Column(name = "Choice_Id")
	private Integer optionId;
	@JsonProperty(value = "choice")
	@Column(name = "Choice")
	private String optionText;
	// private String sortOrder;
	@Column(name = "Marks")
	private String marks;
	@JsonProperty(value = "is_right")
	@Column(name = "Correct_option")
	private Boolean isCorrectOption;

	public Choices() {
		super();
	}

	public Choices(String optionText, String sortOrder, String marks, Boolean isCorrectOption) {
		super();
		this.optionText = optionText;
		this.marks = marks;
		this.isCorrectOption = isCorrectOption;
	}

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public Boolean getIsCorrectOption() {
		return isCorrectOption;
	}

	public void setIsCorrectOption(Boolean isCorrectOption) {
		this.isCorrectOption = isCorrectOption;
	}

	@Override
	public String toString() {
		return "Choices [optionId=" + optionId + ", optionText=" + optionText + ", marks=" + marks
				+ ", isCorrectOption=" + isCorrectOption + "]";
	}
}

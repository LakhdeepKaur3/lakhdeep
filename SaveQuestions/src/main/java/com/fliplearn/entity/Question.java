package com.fliplearn.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Question_Table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question implements Serializable {
	private static final long serialVersionUID = -54482465800485328L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(value = "question_id")
	@Column(name = "Question_Id")
	private Integer qid;
	@Column(name = "Class_Name")
	private String className;
	@Column(name = "Subject_Name")
	private String subjectName;
	@Column(name = "Chapter_Name")
	private String chapterName;
	@Column(name = "Topic_Name")
	private String topicName;
	@JsonProperty(value = "question")
	@Column(name = "Question_Title", columnDefinition = "TEXT")
	private String questionTitle;
	// private String questionDescription;
	@Column(name = "Marks")
	private double marks;
	// private String difficultyLevel;
	// private Integer questionTypeId;
	@Column(name = "Hint", columnDefinition = "TEXT")
	private String hint;
	@Column(name = "Question_Type")
	private String question_type;
	// private String explanations;
	@JsonProperty(value = "choices")
	@Column(name = "Options")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Question_id")
	List<Choices> optionsList;

	public Question() {
		super();
	}

	public Question(String className, String subjectName, String chapterName, String topicName, String questionTitle,
			double marks, String hint, List<Choices> optionsList) {
		super();
		this.className = className;
		this.subjectName = subjectName;
		this.chapterName = chapterName;
		this.topicName = topicName;
		this.questionTitle = questionTitle;
		this.marks = marks;
		this.hint = hint;
		this.optionsList = optionsList;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public List<Choices> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<Choices> optionsList) {
		this.optionsList = optionsList;
	}

	public String getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", className=" + className + ", subjectName=" + subjectName + ", chapterName="
				+ chapterName + ", topicName=" + topicName + ", questionTitle=" + questionTitle + ", marks=" + marks
				+ ", hint=" + hint + ", optionsList=" + optionsList + "]";
	}

}

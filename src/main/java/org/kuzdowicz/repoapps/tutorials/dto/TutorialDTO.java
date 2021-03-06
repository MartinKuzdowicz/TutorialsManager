package org.kuzdowicz.repoapps.tutorials.dto;

import java.io.Serializable;
import java.util.Date;

import org.kuzdowicz.repoapps.tutorials.models.Category;
import org.kuzdowicz.repoapps.tutorials.serilizers.JsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TutorialDTO implements Serializable {

	private static final long serialVersionUID = 2500507270557086269L;

	private Long id;

	private String title;

	private String serviceDomain;

	private String author;

	private String url;

	private Long rating;

	private Integer progress;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date startDateToDo;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date endDateToDo;

	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getServiceDomain() {
		return serviceDomain;
	}

	public void setServiceDomain(String serviceDomain) {
		this.serviceDomain = serviceDomain;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public Date getStartDateToDo() {
		return startDateToDo;
	}

	public void setStartDateToDo(Date startDateToDo) {
		this.startDateToDo = startDateToDo;
	}

	public Date getEndDateToDo() {
		return endDateToDo;
	}

	public void setEndDateToDo(Date endDateToDo) {
		this.endDateToDo = endDateToDo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}

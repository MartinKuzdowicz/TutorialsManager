package org.kuzdowicz.repoapps.tutorials.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TUTORIALS")
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TUTORIAL_ID")
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "SERVICE_DOMAIN")
	private String serviceDomain;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "URL")
	private String url;

	@Column(name = "RATING")
	private Long rating;

	@Column(name = "REWORKED_IN_PERCENTS", columnDefinition = "int default 0", length = 100)
	private Integer reworkedInPercents;

	@Column(name = "START_DATE_TO_DO")
	private Date startDateToDo;

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

	public Long getId() {
		return id;
	}

	public Integer getReworkedInPercents() {
		return reworkedInPercents;
	}

	public void setReworkedInPercents(Integer reworkedInPercents) {
		this.reworkedInPercents = reworkedInPercents;
	}

	public Date getStartDateToDo() {
		return startDateToDo;
	}

	public void setStartDateToDo(Date startDateToDo) {
		this.startDateToDo = startDateToDo;
	}

}

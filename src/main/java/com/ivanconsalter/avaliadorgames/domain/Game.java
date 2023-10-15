package com.ivanconsalter.avaliadorgames.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private LocalDate releaseDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	 @OneToMany(mappedBy = "game")
    private List<Review> reviews;

    private Double score;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.releaseDate = LocalDate.parse(releaseDate, formatter);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Double getScore() {
        return score;
    }

    public void updateScore() {
        if (reviews != null && !reviews.isEmpty()) {
            double totalScore = 0;
            for (Review review : reviews) {
                totalScore += review.getRating();
            }
            this.score = totalScore / reviews.size();
        } else {
            this.score = 0.0;
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", description=" + description + ", releaseDate=" + releaseDate
				+ ", user=" + user + "]";
	}

}

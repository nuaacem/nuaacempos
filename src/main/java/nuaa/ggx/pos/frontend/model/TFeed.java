package nuaa.ggx.pos.frontend.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TFeed entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_feed", catalog = "nuaacempos")
public class TFeed implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438636861909461108L;
	private Integer id;
	private String content;
	private Integer type;
	private Timestamp feedTime;
	private String state;
	private Timestamp version;

	// Constructors

	/** default constructor */
	public TFeed() {
	}

	/** full constructor */
	public TFeed(String content, Integer type, Timestamp feedTime, String state, Timestamp version) {
		this.content = content;
		this.type = type;
		this.feedTime = feedTime;
		this.state = state;
		this.version = version;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "feed_time")
	public Timestamp getFeedTime() {
		return feedTime;
	}

	public void setFeedTime(Timestamp feedTime) {
		this.feedTime = feedTime;
	}

	@Column(name = "state")
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "version", length = 19)
	public Timestamp getVersion() {
		return this.version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

}
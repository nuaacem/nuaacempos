package nuaa.ggx.pos.frontend.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TCollectWebsite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_collect_website", catalog = "nuaacempos", uniqueConstraints = @UniqueConstraint(columnNames = "url"))
public class TCollectWebsite implements java.io.Serializable {

	// Fields

	private Integer id;
	private String url;
	private Timestamp updateTime;
	private Integer state;
	private Boolean isPublic;
	private Set<TWebsite> TWebsites = new HashSet<TWebsite>(0);

	// Constructors

	/** default constructor */
	public TCollectWebsite() {
	}

	/** full constructor */
	public TCollectWebsite(String url) {
		this.url = url;
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

	@Column(name = "url", unique = true)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "updateTime", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "isPublic", columnDefinition = "BIT", length = 1)
	public Boolean getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCollectWebsite")
	public Set<TWebsite> getTWebsites() {
		return this.TWebsites;
	}

	public void setTWebsites(Set<TWebsite> TWebsites) {
		this.TWebsites = TWebsites;
	}

}
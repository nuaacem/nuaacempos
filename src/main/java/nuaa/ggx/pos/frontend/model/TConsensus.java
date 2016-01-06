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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * TConsensus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_consensus", catalog = "nuaacempos")
public class TConsensus implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String url;
	private String summary;
	private String fromWebsite;
	private Integer typeId;
	private Timestamp collectTime;
	private Timestamp publishTime;
	private Timestamp updateTime;
	private Integer collectWebsiteId;
	private Integer state;
	private Timestamp version;
	private Set<TKeyword> TKeywords = new HashSet<TKeyword>(0);
	private TConsensusDetail TConsensusDetail;
	private Set<TTagword> TTagwords = new HashSet<TTagword>(0);

	// Constructors

	/** default constructor */
	public TConsensus() {
	}

	/** full constructor */
	public TConsensus(String title, String url, String summary,
			String fromWebsite, Integer typeId, Timestamp collectTime,
			Timestamp publishTime, Timestamp updateTime,
			Integer collectWebsiteId, Integer state, Timestamp version,
			Set<TKeyword> TKeywords, TConsensusDetail TConsensusDetail,
			Set<TTagword> TTagwords) {
		this.title = title;
		this.url = url;
		this.summary = summary;
		this.fromWebsite = fromWebsite;
		this.typeId = typeId;
		this.collectTime = collectTime;
		this.publishTime = publishTime;
		this.updateTime = updateTime;
		this.collectWebsiteId = collectWebsiteId;
		this.state = state;
		this.version = version;
		this.TKeywords = TKeywords;
		this.TConsensusDetail = TConsensusDetail;
		this.TTagwords = TTagwords;
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

	@Column(name = "title", length = 300)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "summary", length = 500)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "from_website", length = 50)
	public String getFromWebsite() {
		return this.fromWebsite;
	}

	public void setFromWebsite(String fromWebsite) {
		this.fromWebsite = fromWebsite;
	}

	@Column(name = "type_id")
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "collect_time", length = 19)
	public Timestamp getCollectTime() {
		return this.collectTime;
	}

	public void setCollectTime(Timestamp collectTime) {
		this.collectTime = collectTime;
	}

	@Column(name = "publish_time", length = 19)
	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "collect_website_id")
	public Integer getCollectWebsiteId() {
		return this.collectWebsiteId;
	}

	public void setCollectWebsiteId(Integer collectWebsiteId) {
		this.collectWebsiteId = collectWebsiteId;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "version", length = 19)
	public Timestamp getVersion() {
		return this.version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TConsensuses")
	public Set<TKeyword> getTKeywords() {
		return this.TKeywords;
	}

	public void setTKeywords(Set<TKeyword> TKeywords) {
		this.TKeywords = TKeywords;
	}

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "TConsensus")
	public TConsensusDetail getTConsensusDetail() {
		return this.TConsensusDetail;
	}

	public void setTConsensusDetail(TConsensusDetail TConsensusDetail) {
		this.TConsensusDetail = TConsensusDetail;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TConsensuses")
	public Set<TTagword> getTTagwords() {
		return this.TTagwords;
	}

	public void setTTagwords(Set<TTagword> TTagwords) {
		this.TTagwords = TTagwords;
	}

}
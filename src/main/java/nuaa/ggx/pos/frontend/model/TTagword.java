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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * TTagword entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_tagword", catalog = "nuaacempos")
public class TTagword implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp createTime;
	private Integer delState;
	private Integer poleId;
	private Integer poleValue;
	private String word;
	private Set<TConsensus> TConsensuses = new HashSet<TConsensus>(0);

	// Constructors

	/** default constructor */
	public TTagword() {
	}

	/** full constructor */
	public TTagword(Timestamp createTime, Integer delState, Integer poleId,
			Integer poleValue, String word, Set<TConsensus> TConsensuses) {
		this.createTime = createTime;
		this.delState = delState;
		this.poleId = poleId;
		this.poleValue = poleValue;
		this.word = word;
		this.TConsensuses = TConsensuses;
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

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "del_state")
	public Integer getDelState() {
		return this.delState;
	}

	public void setDelState(Integer delState) {
		this.delState = delState;
	}

	@Column(name = "pole_id")
	public Integer getPoleId() {
		return this.poleId;
	}

	public void setPoleId(Integer poleId) {
		this.poleId = poleId;
	}

	@Column(name = "pole_value")
	public Integer getPoleValue() {
		return this.poleValue;
	}

	public void setPoleValue(Integer poleValue) {
		this.poleValue = poleValue;
	}

	@Column(name = "word", length = 20)
	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "t_consensus_tagword", catalog = "nuaacempos", joinColumns = { @JoinColumn(name = "tagword_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "consensus_id", nullable = false, updatable = false) })
	public Set<TConsensus> getTConsensuses() {
		return this.TConsensuses;
	}

	public void setTConsensuses(Set<TConsensus> TConsensuses) {
		this.TConsensuses = TConsensuses;
	}

}
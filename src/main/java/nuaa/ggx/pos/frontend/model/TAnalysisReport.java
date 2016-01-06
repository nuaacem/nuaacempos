package nuaa.ggx.pos.frontend.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TAnalysisReport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_analysis_report", catalog = "nuaacempos")
public class TAnalysisReport implements java.io.Serializable {

	// Fields

	private Integer id;
	private TKeyword TKeyword;
	private Timestamp createTime;
	private String savePath;

	// Constructors

	/** default constructor */
	public TAnalysisReport() {
	}

	/** full constructor */
	public TAnalysisReport(TKeyword TKeyword, Timestamp createTime,
			String savePath) {
		this.TKeyword = TKeyword;
		this.createTime = createTime;
		this.savePath = savePath;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "keyword_id")
	public TKeyword getTKeyword() {
		return this.TKeyword;
	}

	public void setTKeyword(TKeyword TKeyword) {
		this.TKeyword = TKeyword;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "save_path", length = 200)
	public String getSavePath() {
		return this.savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

}
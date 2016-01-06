package nuaa.ggx.pos.frontend.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_comment", catalog = "nuaacempos")
public class TComment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer agreeNum;
	private String content;
	private Integer degreeNum;
	private String nickName;
	private Timestamp publsihTime;

	// Constructors

	/** default constructor */
	public TComment() {
	}

	/** full constructor */
	public TComment(Integer agreeNum, String content, Integer degreeNum,
			String nickName, Timestamp publsihTime) {
		this.agreeNum = agreeNum;
		this.content = content;
		this.degreeNum = degreeNum;
		this.nickName = nickName;
		this.publsihTime = publsihTime;
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

	@Column(name = "agree_num")
	public Integer getAgreeNum() {
		return this.agreeNum;
	}

	public void setAgreeNum(Integer agreeNum) {
		this.agreeNum = agreeNum;
	}

	@Column(name = "content", length = 400)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "degree_num")
	public Integer getDegreeNum() {
		return this.degreeNum;
	}

	public void setDegreeNum(Integer degreeNum) {
		this.degreeNum = degreeNum;
	}

	@Column(name = "nick_name", length = 30)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "publsih_time", length = 19)
	public Timestamp getPublsihTime() {
		return this.publsihTime;
	}

	public void setPublsihTime(Timestamp publsihTime) {
		this.publsihTime = publsihTime;
	}

}
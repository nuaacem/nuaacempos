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
 * TAlarm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_alarm", catalog = "nuaacempos")
public class TAlarm implements java.io.Serializable {

	// Fields

	private Integer id;
	private TAlarmTask TAlarmTask;
	private Timestamp alarmTime;
	private Integer consensusId;
	private Timestamp sendState;
	private Integer value;

	// Constructors

	/** default constructor */
	public TAlarm() {
	}

	/** full constructor */
	public TAlarm(TAlarmTask TAlarmTask, Timestamp alarmTime,
			Integer consensusId, Timestamp sendState, Integer value) {
		this.TAlarmTask = TAlarmTask;
		this.alarmTime = alarmTime;
		this.consensusId = consensusId;
		this.sendState = sendState;
		this.value = value;
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
	@JoinColumn(name = "task_id")
	public TAlarmTask getTAlarmTask() {
		return this.TAlarmTask;
	}

	public void setTAlarmTask(TAlarmTask TAlarmTask) {
		this.TAlarmTask = TAlarmTask;
	}

	@Column(name = "alarm_time", length = 19)
	public Timestamp getAlarmTime() {
		return this.alarmTime;
	}

	public void setAlarmTime(Timestamp alarmTime) {
		this.alarmTime = alarmTime;
	}

	@Column(name = "consensus_id")
	public Integer getConsensusId() {
		return this.consensusId;
	}

	public void setConsensusId(Integer consensusId) {
		this.consensusId = consensusId;
	}

	@Column(name = "send_state", length = 19)
	public Timestamp getSendState() {
		return this.sendState;
	}

	public void setSendState(Timestamp sendState) {
		this.sendState = sendState;
	}

	@Column(name = "value")
	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
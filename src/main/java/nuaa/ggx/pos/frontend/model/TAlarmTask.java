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

/**
 * TAlarmTask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_alarm_task", catalog = "nuaacempos")
public class TAlarmTask implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer alarmCycle;
	private Timestamp createTime;
	private Integer taskState;
	private Integer thresholdValue;
	private Integer userId;
	private Set<TAlarm> TAlarms = new HashSet<TAlarm>(0);

	// Constructors

	/** default constructor */
	public TAlarmTask() {
	}

	/** full constructor */
	public TAlarmTask(Integer alarmCycle, Timestamp createTime,
			Integer taskState, Integer thresholdValue, Integer userId,
			Set<TAlarm> TAlarms) {
		this.alarmCycle = alarmCycle;
		this.createTime = createTime;
		this.taskState = taskState;
		this.thresholdValue = thresholdValue;
		this.userId = userId;
		this.TAlarms = TAlarms;
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

	@Column(name = "alarm_cycle")
	public Integer getAlarmCycle() {
		return this.alarmCycle;
	}

	public void setAlarmCycle(Integer alarmCycle) {
		this.alarmCycle = alarmCycle;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "task_state")
	public Integer getTaskState() {
		return this.taskState;
	}

	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}

	@Column(name = "threshold_value")
	public Integer getThresholdValue() {
		return this.thresholdValue;
	}

	public void setThresholdValue(Integer thresholdValue) {
		this.thresholdValue = thresholdValue;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TAlarmTask")
	public Set<TAlarm> getTAlarms() {
		return this.TAlarms;
	}

	public void setTAlarms(Set<TAlarm> TAlarms) {
		this.TAlarms = TAlarms;
	}

}
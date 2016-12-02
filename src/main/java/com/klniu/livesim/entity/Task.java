package com.klniu.livesim.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by klniu on 16-11-16.
 * @author Hugh Gao
 */
public class Task extends Action {
    public enum AlarmMethod {EMAIL, WECHAT};

    public enum TaskStatus {UNFINISHED, OVERTIME, CANCELED, FINISHED}

    private LocalDateTime dueTo;
    private LocalDateTime alarmTime;
    private AlarmMethod alarmMethod = AlarmMethod.EMAIL;
    private TaskStatus status = TaskStatus.UNFINISHED;
    private ArrayList<User> extraUsers;

    public Task(Category<Task> category, String name, String desc, int score, LocalDateTime dueTo, LocalDateTime alarmTime, AlarmMethod alarmMethod) {
        super(category, name, desc, score);
        this.dueTo = dueTo;
        this.alarmTime = alarmTime;
        this.alarmMethod = alarmMethod;
    }

    public Task(Category<Task> category, String name, String desc, int score, LocalDateTime dueTo) {
        super(category, name, desc, score);
        this.dueTo = dueTo;
    }

    public Task(Category<Task> category, String name, String desc, int score) {
        super(category, name, desc, score);
    }

    public LocalDateTime getDueTo() {
        return dueTo;
    }

    public void setDueTo(LocalDateTime dueTo) {
        this.dueTo = dueTo;
    }

    public LocalDateTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(LocalDateTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    public AlarmMethod getAlarmMethod() {
        return alarmMethod;
    }

    public void setAlarmMethod(AlarmMethod alarmMethod) {
        this.alarmMethod = alarmMethod;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public boolean addUsers(Collection<User> users) {
        return users.addAll(users);
    }

    public boolean removeUsers(Collection<User> users) {
        return users.removeAll(users);
    }
}

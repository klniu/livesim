package com.klniu.livesim.entity;

import java.time.LocalDateTime;

/**
 * Created by klniu on 16-11-17.
 * @author  Hugh Gao
 */
public class History<E extends Action> {
    public static enum ActionStatus {
        NEW(""), DELETE(""), UNFINISHED("unfinished"), OVERTIME("overtime"), CANCELED("canceled"),
        FINISHED("finished");

        private final String desc;

        ActionStatus(String desc) {
            this.desc = desc;
        }
    }
    private E action;
    private LocalDateTime time;
    private ActionStatus status;
    private String desc;

    // Make a history for operating on a action or task, you need to provide a status.
    public History(Task task, LocalDateTime time, ActionStatus status) {
        this.action = (E)task;
        this.time = time;
        this.status = status;
    }

    // Make a history for executing a com.klniu.livesim.entity.Action or finish a task.
    public History(E action, LocalDateTime time) {
        this.action = action;
        this.time = time;
        this.status = ActionStatus.FINISHED;
    }

    // Make a history for executing a com.klniu.livesim.entity.Action with a user-defined description.
    public History(E action, LocalDateTime time, String desc) {
        this.action = action;
        this.time = time;
        this.desc = desc;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Category getCategory() {
        return action.getCategory();
    }

    public String toString() {
        // return the user defined description.
        if (desc != null && !desc.isEmpty()) {
            return desc;
        }
        if (action instanceof Task) {
            switch (status) {
                case NEW:
                    return String.format("The task %s was created.", action.getName());
                case DELETE:
                    return String.format("The task %s was removed.", action.getName());
                default:
                    return String.format("The status of task %s was changed to %s.", action.getName(), status.desc);
            }
        } else if (status == ActionStatus.FINISHED) {
            // '''action''' was executed.
            return String.format("The action %s was executed.", action.getName());
        }
        throw new UnsupportedOperationException(String.format("Unknown status for action %s", action.getName()));
    }
}

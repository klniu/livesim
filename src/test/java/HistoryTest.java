import com.klniu.livesim.entity.Action;
import com.klniu.livesim.entity.Category;
import com.klniu.livesim.entity.History;
import com.klniu.livesim.entity.Task;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by klniu on 16-11-18.
 * @author Hugh Gao
 */
public class HistoryTest {
    @Test
    public void testToString() {
        Category<Action> actions = new Category<>("Default");
        Category<Task> tasks = new Category<>("Default");
        Action action = new Action(actions, "Test", "Test", 1);
        Task task = new Task(tasks, "Test1", "test1",1);

        // user defined desc
        History<Action> history = new History<Action>(action, LocalDateTime.now(), "The action is executed.");
        assertEquals(history.toString(), "The action is executed.");

        // action is executed.
        history = new History<Action>(action, LocalDateTime.now());
        assertEquals(history.toString(), "The action Test was executed.");

        // task is finished.
        history = new History<Action>(task, LocalDateTime.now());
        assertEquals(history.toString(), "The status of task Test1 was changed to finished.");

        // new task
        history = new History<Action>(task, LocalDateTime.now(), History.ActionStatus.NEW);
        assertEquals(history.toString(), "The task Test1 was created.");

        // remove task
        history = new History<Action>(task, LocalDateTime.now(), History.ActionStatus.DELETE);
        assertEquals(history.toString(), "The task Test1 was removed.");

        // other status
        history = new History<Action>(task, LocalDateTime.now(), History.ActionStatus.OVERTIME);
        assertEquals(history.toString(), "The status of task Test1 was changed to overtime.");


    }

}
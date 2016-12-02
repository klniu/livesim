import com.klniu.livesim.entity.Tree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by klniu on 16-11-13.
 */
public class TreeTest {
    @Test
    public void getLevel() {
        assertEquals(new Tree(-1).getLevel(), 1);
        assertEquals(new Tree(0).getLevel(), 1);
        assertEquals(new Tree(5000).getLevel(), 1);
        assertEquals(new Tree(5001).getLevel(), 2);
        assertEquals(new Tree(10001).getLevel(), 3);
        assertEquals(new Tree(20001).getLevel(), 4);
        assertEquals(new Tree(20480000).getLevel(), 12);
        assertEquals(new Tree(20480001).getLevel(), 12);
    }
}
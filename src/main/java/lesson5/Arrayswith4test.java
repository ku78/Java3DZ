package lesson5;

import Arrayswith4;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Arrayswith4test {
    @Parameterized.Parameters
    public static Collection<Object[][]> data(){
        return Arrays.asList(new Object[][][] {
                {{4, 2, 5, 9, 11, 23, 12, 0, 34, 3, 6},{2, 5, 9, 11, 23, 12, 0, 34, 3, 6}},
                {{1, 2, 5, 9, 11, 23, 12, 0, 34, 3, 4},{}},
                {{8, 2, 5, 9, 11, 4, 12, 0, 34, 3, 6},{12, 0, 34, 3, 6}}
        });
    }
    private Arrayswith4 arrays_with_4;
    private int[] testArray;
    private Integer[] expectArray;
    public Arrayswith4test(int[] testArray, Integer[] expectArray){
        this.testArray = testArray;
        this.expectArray = expectArray;
    }
    @Before
    public void init(){
        arrays_with_4 = new Arrayswith_4();
    }
    @Test
    public void MasstestDiffPositionFour() {
        Assert.assertArrayEquals(expectArray, arrays_with_4.getAfterLast4(testArray));
    }
}

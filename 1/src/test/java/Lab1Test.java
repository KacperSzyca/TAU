import static org.junit.Assert.*;
import org.junit.*;
import pl.edu.pjwstk.Lab1;


public class Lab1Test {

    private Lab1 lab1;

    @Before
    public void setUp(){
        lab1 = new Lab1();
        System.out.println("Before");
    }

    @After
    public void tearDown(){
        lab1 = null;
        System.out.println("After");
    }

    @Test
    public void testSum(){
        int result = lab1.sum(4,2);
        assertEquals(6,result);
    }

    @Test
    public void testSub(){
        int result = lab1.sub(5,3);
        assertEquals(2,result);
    }

    @Test
    public void testMul(){
        int result = lab1.mul(5,3);
        assertEquals(15,result);
    }

    @Test
    public void testmul2(){
        int result = lab1.mul(5,3);
        assertNotNull(result);
    }

    @Test
    public void testDiv(){
        int result = lab1.div(6,3);
        assertEquals(2,result);
    }

    @Test
    public void testMod(){
        int result = lab1.mod(5,3);
        assertEquals(2,result);
    }

    @Test
    public void testGreaterThan(){
        Boolean result = lab1.greaterThan(5,3);
        assertTrue(result);
    }

    @Test
    public void testGreaterThan2(){
        Boolean result = lab1.greaterThan(3,5);
        assertFalse(result);
    }

    @Test
    public void testGreaterThan3(){
        Boolean result = lab1.greaterThan(3,3);
        assertNull(result);
    }

    @Test
    public void stringToListTest(){
        String[] result = lab1.stringToList("test,test,test1");
        String[] expectedOutput = {"test","test","test1"};
        assertArrayEquals(expectedOutput, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumIllegalArgumentException() {
        lab1.sum(0,0);
    }
}

import io.restassured.RestAssured;
import org.joda.time.Instant;
import org.junit.After;
import org.junit.Before;
import org.junit.*;
import pl.edu.pjwstk.Lab3;
import java.util.Calendar;
import static org.junit.Assert.*;


public class Lab3Test {

    private Lab3 lab3;

    @Before
    public void setUp(){
        lab3 = new Lab3();
    }

    @After
    public void tearDown(){
        lab3 = null;
    }

    @Test
    public void sumAndDivTest(){
        int result = lab3.div(9,lab3.sum(1,2));
        assertEquals(3,result);
    }

    @Test
    public void modTest(){
        int result = lab3.mod(10,4);
        assertEquals(2,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void modIllegalExceptionTest(){
        assertEquals(0,lab3.mod(0,0));
    }

    @Test
    public void greatherThanNullTest(){
        assertNull(lab3.greaterThan(0,0));
    }

    @Test
    public void squareTest(){
        assertEquals(144,lab3.square(12));
    }

    @Test
    public void lessThanTest(){
        assertFalse(lab3.lessThan(15,12));
    }

    @Test
    public void mulNotNullTest(){
        assertNotNull(lab3.mul(2,2));
    }

    @Test
    public void jodaTimeTest(){
        // 5 sekunda możliwej różnicy (czas wykonywania danej funkcji)
        assertEquals(Instant.now().getMillis()/5000, Calendar.getInstance().getTimeInMillis()/5000);
    }

    @Test
    public void jodaYearNotNullTest(){
        assertNotNull(Instant.now().getChronology().year());
    }

    @Test
    public void websiteStatusCodeTest(){
        int result = RestAssured.get("https://gdansk.pja.edu.pl/pl/").statusCode();
        assertEquals(200, result);
    }
}

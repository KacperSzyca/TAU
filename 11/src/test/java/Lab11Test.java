import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.joda.time.Instant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pjwstk.Lab11;


import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;


public class Lab11Test {

    private Lab11 lab11;
    protected final Logger log = Logger.getLogger(Lab11Test.class);

    @Before
    public void setUp(){
        lab11 = new Lab11();
        log.debug("Test starts at: " + new Date());
    }

    @After
    public void tearDown(){
        lab11 = null;
        log.debug("Test end at: " + new Date());
    }

    @Test
    public void sumAndDivTest(){
        int result = lab11.div(9,lab11.sum(1,2));
        assertEquals(3,result);
    }

    @Test
    public void modTest(){
        int result = lab11.mod(10,4);
        assertEquals(2,result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void modIllegalExceptionTest(){
        assertEquals(0,lab11.mod(0,0));
    }

    @Test
    public void greatherThanNullTest(){
        assertNull(lab11.greaterThan(0,0));
    }

    @Test
    public void squareTest(){
        assertEquals(144,lab11.square(12));
    }

    @Test
    public void lessThanTest(){
        assertFalse(lab11.lessThan(15,12));
    }

    @Test
    public void mulNotNullTest(){
        assertNotNull(lab11.mul(2,2));
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

    @Test
    public void openFileTest(){
        assertFalse(lab11.openFile());
    }
}


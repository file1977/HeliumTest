package test;

import com.alo7.FenbyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wenjia on 5/25/2017.
 */
public class LoginTest extends FenbyTest {
    @Before
    public void setup() {
        loginPage.openPage();
    }

    @Test
    public void loginTest() {
        String phoneNum="13817900456";
        String password="123123";
        String teacher="文大头";

        loginPage.login(phoneNum, password);
        Assert.assertEquals(classHomePage.getTeacherName(), teacher + " 老师");
    }

}

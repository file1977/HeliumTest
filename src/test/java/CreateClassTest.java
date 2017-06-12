package test;

import com.alo7.FenbyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wenjia on 5/25/2017.
 */
public class CreateClassTest extends FenbyTest {

    @Before
    public void setup() {
        loginPage.openPage();
    }

    @Test
    public void createPublicClassTest() {
        String phoneNum="13817900456";
        String password="123123";
        String teacher="文大头";
        String province="上海";
        String city="上海市";
        String district="普陀区";
        String schoolLevel="小学";
        String school="新武宁小学";
        String grade="三年级";
        String className="5班";
        String category="剑桥少儿英语";
        String course="预备级B";
        String classDescription="这是测试班级";


        loginPage.login(phoneNum, password);
        Assert.assertEquals(classHomePage.getTeacherName(), teacher + " 老师");
        classHomePage.load();

        classHomePage.getpublicClazzCard().click();

        classHomePage.selectProvince(province);

        classHomePage.selectCity(city);

        classHomePage.selectDistrict(district);

        classHomePage.selectSchool(schoolLevel, school);

        classHomePage.selectClass(grade, className);

        if (classHomePage.getChooseClassExists().isDisplayed()) {
            classHomePage.selectJoinClass();
        }

        classHomePage.selectClassInfo(category, course, classDescription);

        Assert.assertTrue(homeworksPage.getClassCard(schoolLevel, school, grade, className).isDisplayed());

        homeworksPage.cleanClass(schoolLevel, school, grade, className);
    }

}

Feature: Create classes in Alo7

  Scenario: Login with phone number and password
    Given login page is open
    When Login with phone number "13817900456" and password "123123"
    Then Teacher name "文大头" displays on status bar

  Scenario Outline: Create classes
    When Create a public class of province "<province>"
    And Select the city name "<city>"
    And Select the district name "<district>"
    And Select the school level "<schoolLevel>" and school name "<school>"
    And Select the grade "<grade>" and class name "<className>"
    And Select the course category "<category>", course name "<course>" and set the class description "<classDescription>"
    Then Class "<className>" of grade "<grade>" in school "<school>" of school level "<schoolLevel>" is displayed on class card
    Then Clean class "<className>" of grade "<grade>" in school "<school>" of school level "<schoolLevel>"

    Examples:
      | province | city    | district | schoolLevel | school           | grade  | className | category     | course           | classDescription   |
      | 上海     | 上海市  | 普陀区   | 小学        | 新武宁小学       | 三年级 | 5班       | 剑桥少儿英语 | 预备级B          | 这是测试班级       |
      | 湖北省   | 十堰市  | 郧西县   | 小学        | 香口乡仓房村小学 | 一年级 | 4班       | 新概念英语   | 昂立新概念测试卷 | 这是还是测试班级   |
      | 上海     | 上海市  | 黄浦区   | 高中        | 上海市向明中学   | 三年级 | 1班       | 昂立外语3E   | 3E 二级笔试      | 这是高中测试班级   |
      | 上海     | 上海市  | 黄浦区   | 初中        | 黄浦区业余中学   | 预备班 | 5班       | Fast Phonics | Fast Phonics     | 这是预备班测试班级 |

  Scenario: Quit
    Then Close the browser

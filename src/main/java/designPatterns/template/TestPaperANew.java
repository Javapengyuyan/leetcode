package designPatterns.template;

public class TestPaperANew extends AbstractClass{

    /**
     * 抽象方法后，extends抽象方法，重写父类方法，但是还有很多重复代码
     */

    @Override
    public void testQuestion(){
        super.testQuestion();
        System.out.println("答案是a");
    }

    @Override
    public void testQuestion2() {
        super.testQuestion2();
        System.out.println("答案是b");
    }
}

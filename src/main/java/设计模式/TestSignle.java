package 设计模式;

public class TestSignle {

    private final static TestSignle INSTANCE = new TestSignle();

    private TestSignle(){};

    public TestSignle getTest(TestSignle testSignle){
        return INSTANCE;
    }


    public static void main(String[] args) {


    }

}

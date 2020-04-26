package lesson7.zd1;

public class TestClass {
    @BeforeSuite
    private static void start(){
        System.out.println("Начало");
    }
    @AfterSuite
    private static void end(){
        System.out.println("Конец");
    }

    private static void method1(){
        System.out.println("method1 без аннотации");
    }
    @Test(priority = 10)
    private static void method2(){
        System.out.println("method2  с приоритетом  10");
    }

    @Test(priority = 1)
    private static void method3(){
        System.out.println("method3  с приоритетом 1");
    }
    @Test(priority = 7)
    private static void method4(){
        System.out.println("method4  с приоритетом 7");
    }
    @Test
    private static void method5(){
        System.out.println("method5 с приоритетом по умолчанию");
    }
}

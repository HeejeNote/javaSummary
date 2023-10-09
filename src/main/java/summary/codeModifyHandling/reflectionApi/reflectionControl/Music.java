package summary.codeModifyHandling.reflectionApi.reflectionControl;


public class Music {

    public static String staticField = "staticFieldValue";

    private String instanceField = "instanceFieldValue";

    public Music(){
        System.out.println("::: defaultConstructor :::");
    }

    public Music(String instanceField) {
        this.instanceField = instanceField;
    }

    private void privateVoidMethod(){
        System.out.println("::: private void Method :::");
    }

    public int sum(int num1, int num2){
        return num1 + num2;
    }
}

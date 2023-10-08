package summary.codeModifyHandling.AnnotationExpalin;

@MyAnnotation
public class Picture {

    private static String privateStaticVariable = "privateStaticVariable";

    private static final String privateStaticFinalVariable = "privateStaticFinalVariable";

    @MyAnnotation
    private String privateVariable = "privateVariable";

    public String publicVariable = "publicVariable";

    protected String protectedVariable = "protectedVariable";

    public Picture(){
        System.out.println("::: defaultConstructor :::");
    }

    @AnotherAnnotation
    public Picture(String privateVariable, String publicVariable, String protectedVariable) {
        System.out.println("::: allFleldsConstructor :::");
        this.privateVariable = privateVariable;
        this.publicVariable = publicVariable;
        this.protectedVariable = protectedVariable;
    }

    @AnotherAnnotation
    private void privateVoidMethod(){
        System.out.println("::: privateVoidMethod :::");
    }

    public void publicVoidMethod(){
        System.out.println("::: publicVoidMethod :::");
    }

    public int publicIntMethod(){
        System.out.println("::: publicIntMethod :::");
        return 100;
    }

    public int publicIntParameterMethod(int num){
        System.out.println("::: publicIntParameterMethod :::");
        return 200;
    }


}

package summary.java8structure.defaultAndStaticMethod;

public class DefaultMethod implements IDefaultMethod {

    String name;

    public DefaultMethod(String name){
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }


}

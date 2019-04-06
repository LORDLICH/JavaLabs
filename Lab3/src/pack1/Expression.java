package pack1;
import java.util.*;

public class Expression {
    private LinkedList<Number> list = new LinkedList<>();
    private char operationType;

    public Expression(Number number1, Number number2, char operationType) {
        list.add(number1);
        list.add(number2);
        this.operationType=operationType;
    }

    public void calculate(){
        ComplexAlgebraic firstComplex = (ComplexAlgebraic)list.get(0);
        ComplexAlgebraic secondComplex = (ComplexAlgebraic)list.get(1);
        ComplexAlgebraic result = new ComplexAlgebraic(0,0);
        if(operationType == '+'){
            result = result.addFunc(firstComplex,secondComplex);
        }else if(operationType == '-'){
            result = result.subFunc(firstComplex,secondComplex);
        }

        if(result.getRealPart()!=0){
            System.out.print(result.getRealPart().toString());
        }
        if(result.getImaginaryPart()>0){
            System.out.print('+' + result.getImaginaryPart().toString() + 'i');
        } else if(result.getImaginaryPart()<0) {
            System.out.print(result.getImaginaryPart().toString() + 'i');
        }
    }
}
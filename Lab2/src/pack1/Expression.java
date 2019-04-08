package pack1;

import java.util.*;

public class Expression {
    private ArrayList<Number> list = new ArrayList<>();
    private char operationType;

    public Expression()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter operation type(+,-):");
        operationType=reader.next().charAt(0);
        list.add(new ComplexAlgebraic());
        list.add(new ComplexAlgebraic());
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

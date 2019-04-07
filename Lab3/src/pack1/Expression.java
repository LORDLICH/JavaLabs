package pack1;
import java.util.*;

public class Expression {
    private LinkedList<Number> list = new LinkedList<>();
    private char operationType;

    public Expression() {
        Scanner reader = new Scanner(System.in);
        for(int i =0;i<2;i++) {
            System.out.println("Choose the form of the complex number:\n1 - Algebraic form\n2 - Exponential form");
            char type = reader.next().charAt(0);
            switch (type) {
                case '1':{
                    list.add(new ComplexAlgebraic());
                    break;
                }
                case '2':{
                    list.add(new ComplexExponential());
                    break;
                }
            }
        }
        System.out.println("Choose operation type(+,-,*,/):");
        operationType = reader.next().charAt(0);
    }

    public void calculate(){
        if(list.get(0) instanceof ComplexAlgebraic){
            ComplexAlgebraic result = new ComplexAlgebraic(0,0);
            if(list.get(1) instanceof ComplexExponential){
                list.set(1, ((ComplexExponential) list.get(1)).toComplexAlgebraic((ComplexExponential)list.get(1)));
            }
            switch (operationType){
                case '+': result = result.addFunc((ComplexAlgebraic) list.get(0),(ComplexAlgebraic) list.get(1)); break;
                case '-': result = result.subFunc((ComplexAlgebraic) list.get(0),(ComplexAlgebraic) list.get(1)); break;
                case '*': result = result.mulFunc((ComplexAlgebraic) list.get(0),(ComplexAlgebraic) list.get(1)); break;
                case '/': result = result.divFunc((ComplexAlgebraic) list.get(0),(ComplexAlgebraic) list.get(1)); break;
            }

            if(result.getRealPart()!=0){
                System.out.print(result.getRealPart());
            }
            if(result.getImaginaryPart()>0){
                System.out.print('+' + String.valueOf(result.getImaginaryPart()) + 'i');
            } else if(result.getImaginaryPart()<0) {
                System.out.print(String.valueOf(result.getImaginaryPart()) + 'i');
            }
        }
        if(list.get(0) instanceof ComplexExponential){
            ComplexExponential result = new ComplexExponential(0,0);
            if(list.get(1) instanceof ComplexAlgebraic){
                list.set(1, ((ComplexAlgebraic) list.get(1)).toComplexExponential((ComplexAlgebraic) list.get(1)));
            }
            switch (operationType){
                case '+': result = result.addFunc((ComplexExponential) list.get(0),(ComplexExponential) list.get(1)); break;
                case '-': result = result.subFunc((ComplexExponential) list.get(0),(ComplexExponential) list.get(1)); break;
                case '*': result = result.mulFunc((ComplexExponential) list.get(0),(ComplexExponential) list.get(1)); break;
                case '/': result = result.divFunc((ComplexExponential) list.get(0),(ComplexExponential) list.get(1)); break;
            }

            if(result.getAbsValue()!=0) {
                if(result.getAngle() == 0){
                    System.out.print(result.getAbsValue());
                } else{
                    System.out.print(String.valueOf(result.getAbsValue()) + "e^");
                    if (result.getAngle() > 0) {
                        System.out.print(String.valueOf(result.getAngle()) + 'i');
                    }
                    if (result.getAngle() < 0) {
                        System.out.print(String.valueOf('-' + result.getAngle()) + 'i');
                    }
                }
            } else{
                System.out.print(0);
            }
        }
    }
}
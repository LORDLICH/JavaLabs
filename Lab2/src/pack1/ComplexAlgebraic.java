package pack1;
import  java.util.*;

public class ComplexAlgebraic extends Complex{
    private Integer realPart;
    private Integer imaginaryPart;

    public ComplexAlgebraic()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter real part:");
        realPart=reader.nextInt();
        System.out.println("Enter imaginary part:");
        imaginaryPart=reader.nextInt();
    }

    public ComplexAlgebraic(Integer realPart, Integer imaginaryPart)
    {
        this.realPart=realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Integer getRealPart()
    {
        return realPart;
    }

    public Integer getImaginaryPart()
    {
        return imaginaryPart;
    }

    public void setRealPart(Integer realPart)
    {
        this.realPart=realPart;
    }

    public  void setImaginaryPart(Integer imaginaryPart)
    {
        this.imaginaryPart=imaginaryPart;
    }

    public ComplexAlgebraic addFunc(ComplexAlgebraic number1, ComplexAlgebraic number2)
    {
        ComplexAlgebraic result = new ComplexAlgebraic(number1.realPart+number2.realPart,
                number1.imaginaryPart+number2.imaginaryPart);
        return result;
    }

    public ComplexAlgebraic subFunc(ComplexAlgebraic number1, ComplexAlgebraic number2)
    {
        ComplexAlgebraic result = new ComplexAlgebraic(number1.realPart-number2.realPart,
                number1.imaginaryPart-number2.imaginaryPart);
        return result;
    }
}
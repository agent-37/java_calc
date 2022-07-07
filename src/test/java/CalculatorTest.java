import com.company.Main;
import org.junit.jupiter.api.Test;
import sun.awt.geom.AreaOp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {
    @Test
     void addition(){
        String actual= Main.calculate("7","+","1");
        assertEquals("8",actual);
    }
    @Test
    void addition1(){
        String actual= Main.calculate("7/2","+","1");
        assertEquals("9/2",actual);
    }
    @Test
    void del0(){
        String actual= Main.calculate("1/0","+","1");
        assertEquals("Деление на 0",actual);
    }
    @Test
    void del01(){
        String actual= Main.calculate("1/1","/","0");
        assertEquals("Деление на 0",actual);
    }
    @Test
    void differ(){
        String actual= Main.calculate("2/7","-","2/5");
        assertEquals("-4/35",actual);
    }
    @Test
    void differ1(){
        String actual= Main.calculate("2","-","5");
        assertEquals("-3",actual);
    }
    @Test
    void mult1(){
        String actual= Main.calculate("2/7","*","2/5");
        assertEquals("4/35",actual);
    }
    @Test
    void mult2(){
        String actual= Main.calculate("-2","*","2/5");
        assertEquals("-4/5",actual);
    }
    @Test
    void delet(){
        String actual= Main.calculate("2/7","/","2/5");
        assertEquals("5/7",actual);
    }
    @Test
    void delet1(){
        String actual= Main.calculate("-2","/","2/5");
        assertEquals("-5",actual);
    }
}

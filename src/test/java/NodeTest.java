import com.company.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    @Test
    void createNode(){
        Node node = new Node("Корень");
        assertEquals("Корень",node.getName());
    }
    @Test
    void addNode(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        root.add(child);
        assertEquals(1,root.getChildren().size());
        assertEquals("Лист",root.getChildren().get(0).getName());
    }
}

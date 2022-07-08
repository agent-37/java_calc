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
    @Test
    void findChild(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        root.add(child);
        root.add(child1);
        root.add(child2);
        assertEquals(true,root.findChildren("Лист"));
    }
    @Test
    void delChild(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        root.add(child);
        root.add(child1);
        root.add(child2);
        root.del_child_id(child1.getId());
        assertEquals(false,root.findChildren("Лист1"));
    }
    @Test
    void rezny(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        root.add(child);
        root.add(child1);
        root.add(child2);
        root.del_all_children();
        assertEquals(0,root.getChildren().size());
    }
    @Test
    void renameChild(){
        Node root=new Node("Корень");
        Node child = new Node("Лист");
        Node child1 = new Node("Лист1");
        Node child2 = new Node("Лист2");
        root.add(child);
        root.add(child1);
        root.add(child2);
        root.change_child(child.getId(),"123");
        assertEquals(true,root.findChildren(("123")));
    }
}

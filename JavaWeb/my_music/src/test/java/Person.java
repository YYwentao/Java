import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName: Person
 * Description:
 * date: 2021/7/17 16:50
 *
 * @author wt
 * @since JDK 1.8
 */
public class Person {
    private int id;
    private String name;
    private String password;
    public Person() {
        super();
    }
    public Person(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person(1, "tom", "123");
        String jsonString = objectMapper.writeValueAsString(person);
        System.out.println("JsonString: " + jsonString);
    }

}

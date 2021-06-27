import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    FileOutputStream fileOutputStream = new FileOutputStream("12212",true);
    public Test() throws IOException {
        String str = "123456789";
        fileOutputStream.write(str.getBytes());

    }
}

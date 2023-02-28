package IOStream;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.naming.BinaryRefAddr;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/02/18/01:55
 * @Description:
 */
public class FileReaderWriterTest {

  @Test
  public void testFileReader() throws IOException {
    File file = new File("hello.txt");


    FileReader fr = new FileReader(file);

    char[] cbuf = new char[5];
    int len;
    while ((len = fr.read(cbuf)) != -1){
      for (int i = 0; i < len; i++) {
        System.out.print(cbuf[i]);
      }
    }
  }
}

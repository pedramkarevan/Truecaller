package truecaller.confige;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrefixReaderTest {


    @Test
    @DisplayName("getPrefixesFiltered")
    void getPrefixesFromFileFilterByFirstChar() throws Exception {
        PrefixReader prefixReader = new PrefixReader();
        List<String> pr = prefixReader.getPrefixesFromFileByFirstCharFilter("sampleData.txt", "20Xpld");
        boolean anyStartsWithS = pr.stream().anyMatch(
                (s) -> s.startsWith("2"));
        assertTrue(anyStartsWithS );

    }

    @Test
    @DisplayName("getAllPrefixesFiltered")
    void getAllPrefixesFromFileFilterByFirstChar() throws Exception {
        PrefixReader prefixReader = new PrefixReader();
        List<String> pr = prefixReader.getPrefixesFromFileByFirstCharFilter("sampleData.txt", "2yN");
        int anyStartsWithS = (int) pr.stream().filter((s) -> s.startsWith("2yN")).count();
        assertEquals(anyStartsWithS,86 );
    }
}

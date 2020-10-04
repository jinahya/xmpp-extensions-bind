package jabber.x.data;

import com.github.jinahya.JaxbTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ExampleTest {

    @Test
    void unmarshal_example_n_x_xml() throws JAXBException, URISyntaxException, IOException {
        final JAXBContext context = JAXBContext.newInstance(jabber.x.data.X.class);
        final Schema schema = JaxbTestUtils.schema("/xep-0004-jabber.x.data.xsd");
        for (final String line : Files.readAllLines(Paths.get(getClass().getResource("example_n_x.index").toURI()))) {
            final URL url = getClass().getResource(line);
            assertThat(url).isNotNull();
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);
            final X x = (X) unmarshaller.unmarshal(url);
            assertThat(x.getType()).isNotNull();
        }
    }
}

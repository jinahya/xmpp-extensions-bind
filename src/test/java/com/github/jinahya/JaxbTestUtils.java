package com.github.jinahya;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class JaxbTestUtils {

    // Thread-NOT-Safe
    private static final SchemaFactory SCHEMA_FACTORY = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

    private static final Map<String, Schema> SCHEMAS = new ConcurrentHashMap<>();

    public static Schema schema(final String name) {
        return SCHEMAS.computeIfAbsent(name, k -> {
            synchronized (SCHEMA_FACTORY) {
                try {
                    return SCHEMA_FACTORY.newSchema(JaxbTestUtils.class.getResource(k));
                } catch (final SAXException saxe) {
                    throw new RuntimeException(saxe);
                }
            }
        });
    }

    private JaxbTestUtils() {
        super();
    }
}

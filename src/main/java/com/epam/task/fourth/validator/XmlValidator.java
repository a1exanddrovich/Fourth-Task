package com.epam.task.fourth.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    private final static Logger LOGGER = LogManager.getLogger(XmlValidator.class);
    private String schemaName;

    public XmlValidator(String schemaName) {
        this.schemaName = schemaName;
    }

    public boolean isValid(String fileName) {
        boolean result = false;
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File(this.schemaName);
        Schema schema = null;
        try {
            schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            result = true;
            LOGGER.info("The file " + fileName + " has been validated successfully");
        } catch (SAXException | IOException e) {
            LOGGER.error("The file " + fileName + " has not been validated because of " + e.getMessage());
        }
        return result;
    }

}

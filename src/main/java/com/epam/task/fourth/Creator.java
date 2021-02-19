package com.epam.task.fourth;

import com.epam.task.fourth.factory.ParserFactory;
import com.epam.task.fourth.factory.ParserType;
import com.epam.task.fourth.parsers.DomParser;
import com.epam.task.fourth.parsers.JaxbParser;
import com.epam.task.fourth.parsers.Parser;
import com.epam.task.fourth.parsers.SaxParser;

public class Creator {

    private final ParserFactory factory = new ParserFactory();

    public Parser createParser(ParserType type) {
        switch (type) {
            case DOM_PARSER:
                return new DomParser();
            case SAX_PARSER:
                return new SaxParser();
            case JAXB_PARSER:
                return new JaxbParser();
        }
        return new SaxParser();
    }

}

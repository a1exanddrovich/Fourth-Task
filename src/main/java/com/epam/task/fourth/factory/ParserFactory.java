package com.epam.task.fourth.factory;

import com.epam.task.fourth.parsers.DomParser;
import com.epam.task.fourth.parsers.JaxbParser;
import com.epam.task.fourth.parsers.Parser;
import com.epam.task.fourth.parsers.SaxParser;

public class ParserFactory {

    public Parser createParser(ParserType parserType) {
        switch (parserType) {
            case DOM_PARSER:
                return new DomParser();
            case SAX_PARSER:
                return new SaxParser();
            case JAXB_PARSER:
                return new JaxbParser();
            default:
                return null;
        }
    }

}

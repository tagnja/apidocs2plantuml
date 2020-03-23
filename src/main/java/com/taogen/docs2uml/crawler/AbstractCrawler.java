package com.taogen.docs2uml.crawler;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author Taogen
 */
@Data
public abstract class AbstractCrawler implements Crawler {
    protected static final String NOT_FOUND_ELEMENTS_ERROR = "Not found elements form Web page. Please check your URL: %s";
    protected static final String FAIL_TO_CONNECT_URL = "Fail to connect the URL: %s";
    protected static final String GENERIC_LEFT_MARK = "<";
    protected static final String GENERIC_RIGHT_MARK = ">";
    private static final Logger logger = LogManager.getLogger();

    protected static Document getDocument(String url) {
        Document document = null;
        Connection connection = Jsoup.connect(url);
        try {
            document = connection.timeout(10 * 1000).get();
        } catch (IOException e) {
            logger.error("Fail to connect!", e);
        }
        return document;
    }
}

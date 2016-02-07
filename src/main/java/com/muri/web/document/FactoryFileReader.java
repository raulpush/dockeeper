package com.muri.web.document;


import com.muri.web.document.impl.DocReader;
import com.muri.web.document.impl.DocReaderX;
import com.muri.web.document.impl.HtmlReader;
import com.muri.web.document.impl.PDFReader;
import com.muri.web.document.impl.TextReader;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
public class FactoryFileReader {
    private static DocReader docReader = new DocReader();
    private static DocReaderX docXReader = new DocReaderX();
    private static PDFReader pdfReader = new PDFReader();
    private static HtmlReader htmlReader = new HtmlReader();
    private static TextReader textReader = new TextReader();

    public static Uploader getInstance(String ext) {
        if (ext == null || ext.trim().isEmpty()) {
            return null;
        }
        System.out.println("ext = " + ext);
        if (ext.toLowerCase().equals("pdf")) {
            return pdfReader;
        } else if (ext.toLowerCase().equals("doc")) {
            return docReader;
        } else if (ext.toLowerCase().equals("docx")) {
            return docXReader;
        } else if (ext.toLowerCase().equals("html") || ext.toLowerCase().equals("htm")
                || ext.toLowerCase().equals("xml") || ext.toLowerCase().equals("jsp")) {
            return htmlReader;
        } else if (ext.toLowerCase().equals("txt")) {
            return textReader;
        }
        return null;
    }
}

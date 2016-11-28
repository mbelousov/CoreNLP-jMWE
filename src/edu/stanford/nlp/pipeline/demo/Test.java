package edu.stanford.nlp.pipeline.demo;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;
import edu.stanford.nlp.pipeline.Annotation;

public class Test {
    public static final String index = "lib/mweindex_wordnet3.0_semcor1.6.data";

    public static void main(String[] args) {
        final String text = "She looked up the world record.";
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, jmwe");
        props.setProperty("customAnnotatorClass.jmwe", "edu.stanford.nlp.pipeline.JMWEAnnotator");
        props.setProperty("customAnnotatorClass.jmwe.verbose", "true");
        props.setProperty("customAnnotatorClass.jmwe.underscoreReplacement", "-");
        props.setProperty("customAnnotatorClass.jmwe.indexData", index);
//        props.setProperty("customAnnotatorClass.jmwe.detector", "SomeOtherText");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation document = new Annotation(text);
        pipeline.annotate(document);


    }
}

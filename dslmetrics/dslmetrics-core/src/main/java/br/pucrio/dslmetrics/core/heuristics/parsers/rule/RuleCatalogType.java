/*
 * XML Type:  ruleCatalogType
 * Namespace: RuleCatalogFile
 * Java type: br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.heuristics.parsers.rule;


/**
 * An XML ruleCatalogType(@RuleCatalogFile).
 *
 * This is a complex type.
 */
public interface RuleCatalogType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RuleCatalogType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC3948D75461ED98A4AC7327C9206E3EB").resolveHandle("rulecatalogtype8507type");
    
    /**
     * Gets array of all "rule" elements
     */
    br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType[] getRuleArray();
    
    /**
     * Gets ith "rule" element
     */
    br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType getRuleArray(int i);
    
    /**
     * Returns number of "rule" element
     */
    int sizeOfRuleArray();
    
    /**
     * Sets array of all "rule" element
     */
    void setRuleArray(br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType[] ruleArray);
    
    /**
     * Sets ith "rule" element
     */
    void setRuleArray(int i, br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType rule);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "rule" element
     */
    br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType insertNewRule(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "rule" element
     */
    br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType addNewRule();
    
    /**
     * Removes the ith "rule" element
     */
    void removeRule(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType newInstance() {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

/*
 * XML Type:  anomalyType
 * Namespace: ReferenceListFile
 * Java type: br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist;


/**
 * An XML anomalyType(@ReferenceListFile).
 *
 * This is a complex type.
 */
public interface AnomalyType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AnomalyType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC3948D75461ED98A4AC7327C9206E3EB").resolveHandle("anomalytype1119type");
    
    /**
     * Gets array of all "version" elements
     */
    br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType[] getVersionArray();
    
    /**
     * Gets ith "version" element
     */
    br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType getVersionArray(int i);
    
    /**
     * Returns number of "version" element
     */
    int sizeOfVersionArray();
    
    /**
     * Sets array of all "version" element
     */
    void setVersionArray(br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType[] versionArray);
    
    /**
     * Sets ith "version" element
     */
    void setVersionArray(int i, br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType version);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "version" element
     */
    br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType insertNewVersion(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "version" element
     */
    br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType addNewVersion();
    
    /**
     * Removes the ith "version" element
     */
    void removeVersion(int i);
    
    /**
     * Gets the "id" attribute
     */
    java.lang.String getId();
    
    /**
     * Gets (as xml) the "id" attribute
     */
    org.apache.xmlbeans.XmlString xgetId();
    
    /**
     * Sets the "id" attribute
     */
    void setId(java.lang.String id);
    
    /**
     * Sets (as xml) the "id" attribute
     */
    void xsetId(org.apache.xmlbeans.XmlString id);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType newInstance() {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

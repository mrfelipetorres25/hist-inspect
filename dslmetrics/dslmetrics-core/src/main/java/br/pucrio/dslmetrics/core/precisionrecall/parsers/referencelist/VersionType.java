/*
 * XML Type:  versionType
 * Namespace: ReferenceListFile
 * Java type: br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist;


/**
 * An XML versionType(@ReferenceListFile).
 *
 * This is a complex type.
 */
public interface VersionType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(VersionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC3948D75461ED98A4AC7327C9206E3EB").resolveHandle("versiontype312etype");
    
    /**
     * Gets array of all "entity" elements
     */
    java.lang.String[] getEntityArray();
    
    /**
     * Gets ith "entity" element
     */
    java.lang.String getEntityArray(int i);
    
    /**
     * Gets (as xml) array of all "entity" elements
     */
    org.apache.xmlbeans.XmlString[] xgetEntityArray();
    
    /**
     * Gets (as xml) ith "entity" element
     */
    org.apache.xmlbeans.XmlString xgetEntityArray(int i);
    
    /**
     * Returns number of "entity" element
     */
    int sizeOfEntityArray();
    
    /**
     * Sets array of all "entity" element
     */
    void setEntityArray(java.lang.String[] entityArray);
    
    /**
     * Sets ith "entity" element
     */
    void setEntityArray(int i, java.lang.String entity);
    
    /**
     * Sets (as xml) array of all "entity" element
     */
    void xsetEntityArray(org.apache.xmlbeans.XmlString[] entityArray);
    
    /**
     * Sets (as xml) ith "entity" element
     */
    void xsetEntityArray(int i, org.apache.xmlbeans.XmlString entity);
    
    /**
     * Inserts the value as the ith "entity" element
     */
    void insertEntity(int i, java.lang.String entity);
    
    /**
     * Appends the value as the last "entity" element
     */
    void addEntity(java.lang.String entity);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "entity" element
     */
    org.apache.xmlbeans.XmlString insertNewEntity(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "entity" element
     */
    org.apache.xmlbeans.XmlString addNewEntity();
    
    /**
     * Removes the ith "entity" element
     */
    void removeEntity(int i);
    
    /**
     * Gets the "number" attribute
     */
    int getNumber();
    
    /**
     * Gets (as xml) the "number" attribute
     */
    org.apache.xmlbeans.XmlInt xgetNumber();
    
    /**
     * Sets the "number" attribute
     */
    void setNumber(int number);
    
    /**
     * Sets (as xml) the "number" attribute
     */
    void xsetNumber(org.apache.xmlbeans.XmlInt number);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType newInstance() {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

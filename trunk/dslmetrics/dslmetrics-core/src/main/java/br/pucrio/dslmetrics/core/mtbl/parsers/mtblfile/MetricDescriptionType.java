/*
 * XML Type:  MetricDescriptionType
 * Namespace: TogetherMtbl
 * Java type: br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile;


/**
 * An XML MetricDescriptionType(@TogetherMtbl).
 *
 * This is a complex type.
 */
public interface MetricDescriptionType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(MetricDescriptionType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC3948D75461ED98A4AC7327C9206E3EB").resolveHandle("metricdescriptiontype4a6etype");
    
    /**
     * Gets array of all "Metric" elements
     */
    br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType[] getMetricArray();
    
    /**
     * Gets ith "Metric" element
     */
    br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType getMetricArray(int i);
    
    /**
     * Returns number of "Metric" element
     */
    int sizeOfMetricArray();
    
    /**
     * Sets array of all "Metric" element
     */
    void setMetricArray(br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType[] metricArray);
    
    /**
     * Sets ith "Metric" element
     */
    void setMetricArray(int i, br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType metric);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Metric" element
     */
    br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType insertNewMetric(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metric" element
     */
    br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType addNewMetric();
    
    /**
     * Removes the ith "Metric" element
     */
    void removeMetric(int i);
    
    /**
     * Gets array of all "MetricDescription" elements
     */
    br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType[] getMetricDescriptionArray();
    
    /**
     * Gets ith "MetricDescription" element
     */
    br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType getMetricDescriptionArray(int i);
    
    /**
     * Returns number of "MetricDescription" element
     */
    int sizeOfMetricDescriptionArray();
    
    /**
     * Sets array of all "MetricDescription" element
     */
    void setMetricDescriptionArray(br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType[] metricDescriptionArray);
    
    /**
     * Sets ith "MetricDescription" element
     */
    void setMetricDescriptionArray(int i, br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType metricDescription);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "MetricDescription" element
     */
    br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType insertNewMetricDescription(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "MetricDescription" element
     */
    br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType addNewMetricDescription();
    
    /**
     * Removes the ith "MetricDescription" element
     */
    void removeMetricDescription(int i);
    
    /**
     * Gets the "containerName" attribute
     */
    java.lang.String getContainerName();
    
    /**
     * Gets (as xml) the "containerName" attribute
     */
    org.apache.xmlbeans.XmlString xgetContainerName();
    
    /**
     * True if has "containerName" attribute
     */
    boolean isSetContainerName();
    
    /**
     * Sets the "containerName" attribute
     */
    void setContainerName(java.lang.String containerName);
    
    /**
     * Sets (as xml) the "containerName" attribute
     */
    void xsetContainerName(org.apache.xmlbeans.XmlString containerName);
    
    /**
     * Unsets the "containerName" attribute
     */
    void unsetContainerName();
    
    /**
     * Gets the "endOffset" attribute
     */
    int getEndOffset();
    
    /**
     * Gets (as xml) the "endOffset" attribute
     */
    org.apache.xmlbeans.XmlInt xgetEndOffset();
    
    /**
     * True if has "endOffset" attribute
     */
    boolean isSetEndOffset();
    
    /**
     * Sets the "endOffset" attribute
     */
    void setEndOffset(int endOffset);
    
    /**
     * Sets (as xml) the "endOffset" attribute
     */
    void xsetEndOffset(org.apache.xmlbeans.XmlInt endOffset);
    
    /**
     * Unsets the "endOffset" attribute
     */
    void unsetEndOffset();
    
    /**
     * Gets the "fqname" attribute
     */
    java.lang.String getFqname();
    
    /**
     * Gets (as xml) the "fqname" attribute
     */
    org.apache.xmlbeans.XmlString xgetFqname();
    
    /**
     * True if has "fqname" attribute
     */
    boolean isSetFqname();
    
    /**
     * Sets the "fqname" attribute
     */
    void setFqname(java.lang.String fqname);
    
    /**
     * Sets (as xml) the "fqname" attribute
     */
    void xsetFqname(org.apache.xmlbeans.XmlString fqname);
    
    /**
     * Unsets the "fqname" attribute
     */
    void unsetFqname();
    
    /**
     * Gets the "kind" attribute
     */
    int getKind();
    
    /**
     * Gets (as xml) the "kind" attribute
     */
    org.apache.xmlbeans.XmlInt xgetKind();
    
    /**
     * True if has "kind" attribute
     */
    boolean isSetKind();
    
    /**
     * Sets the "kind" attribute
     */
    void setKind(int kind);
    
    /**
     * Sets (as xml) the "kind" attribute
     */
    void xsetKind(org.apache.xmlbeans.XmlInt kind);
    
    /**
     * Unsets the "kind" attribute
     */
    void unsetKind();
    
    /**
     * Gets the "language" attribute
     */
    java.lang.String getLanguage();
    
    /**
     * Gets (as xml) the "language" attribute
     */
    org.apache.xmlbeans.XmlString xgetLanguage();
    
    /**
     * True if has "language" attribute
     */
    boolean isSetLanguage();
    
    /**
     * Sets the "language" attribute
     */
    void setLanguage(java.lang.String language);
    
    /**
     * Sets (as xml) the "language" attribute
     */
    void xsetLanguage(org.apache.xmlbeans.XmlString language);
    
    /**
     * Unsets the "language" attribute
     */
    void unsetLanguage();
    
    /**
     * Gets the "line" attribute
     */
    int getLine();
    
    /**
     * Gets (as xml) the "line" attribute
     */
    org.apache.xmlbeans.XmlInt xgetLine();
    
    /**
     * True if has "line" attribute
     */
    boolean isSetLine();
    
    /**
     * Sets the "line" attribute
     */
    void setLine(int line);
    
    /**
     * Sets (as xml) the "line" attribute
     */
    void xsetLine(org.apache.xmlbeans.XmlInt line);
    
    /**
     * Unsets the "line" attribute
     */
    void unsetLine();
    
    /**
     * Gets the "location" attribute
     */
    java.lang.String getLocation();
    
    /**
     * Gets (as xml) the "location" attribute
     */
    org.apache.xmlbeans.XmlString xgetLocation();
    
    /**
     * True if has "location" attribute
     */
    boolean isSetLocation();
    
    /**
     * Sets the "location" attribute
     */
    void setLocation(java.lang.String location);
    
    /**
     * Sets (as xml) the "location" attribute
     */
    void xsetLocation(org.apache.xmlbeans.XmlString location);
    
    /**
     * Unsets the "location" attribute
     */
    void unsetLocation();
    
    /**
     * Gets the "name" attribute
     */
    java.lang.String getName();
    
    /**
     * Gets (as xml) the "name" attribute
     */
    org.apache.xmlbeans.XmlString xgetName();
    
    /**
     * True if has "name" attribute
     */
    boolean isSetName();
    
    /**
     * Sets the "name" attribute
     */
    void setName(java.lang.String name);
    
    /**
     * Sets (as xml) the "name" attribute
     */
    void xsetName(org.apache.xmlbeans.XmlString name);
    
    /**
     * Unsets the "name" attribute
     */
    void unsetName();
    
    /**
     * Gets the "offset" attribute
     */
    int getOffset();
    
    /**
     * Gets (as xml) the "offset" attribute
     */
    org.apache.xmlbeans.XmlInt xgetOffset();
    
    /**
     * True if has "offset" attribute
     */
    boolean isSetOffset();
    
    /**
     * Sets the "offset" attribute
     */
    void setOffset(int offset);
    
    /**
     * Sets (as xml) the "offset" attribute
     */
    void xsetOffset(org.apache.xmlbeans.XmlInt offset);
    
    /**
     * Unsets the "offset" attribute
     */
    void unsetOffset();
    
    /**
     * Gets the "projectName" attribute
     */
    java.lang.String getProjectName();
    
    /**
     * Gets (as xml) the "projectName" attribute
     */
    org.apache.xmlbeans.XmlString xgetProjectName();
    
    /**
     * True if has "projectName" attribute
     */
    boolean isSetProjectName();
    
    /**
     * Sets the "projectName" attribute
     */
    void setProjectName(java.lang.String projectName);
    
    /**
     * Sets (as xml) the "projectName" attribute
     */
    void xsetProjectName(org.apache.xmlbeans.XmlString projectName);
    
    /**
     * Unsets the "projectName" attribute
     */
    void unsetProjectName();
    
    /**
     * Gets the "resource" attribute
     */
    java.lang.String getResource();
    
    /**
     * Gets (as xml) the "resource" attribute
     */
    org.apache.xmlbeans.XmlString xgetResource();
    
    /**
     * True if has "resource" attribute
     */
    boolean isSetResource();
    
    /**
     * Sets the "resource" attribute
     */
    void setResource(java.lang.String resource);
    
    /**
     * Sets (as xml) the "resource" attribute
     */
    void xsetResource(org.apache.xmlbeans.XmlString resource);
    
    /**
     * Unsets the "resource" attribute
     */
    void unsetResource();
    
    /**
     * Gets the "resourceName" attribute
     */
    java.lang.String getResourceName();
    
    /**
     * Gets (as xml) the "resourceName" attribute
     */
    org.apache.xmlbeans.XmlString xgetResourceName();
    
    /**
     * True if has "resourceName" attribute
     */
    boolean isSetResourceName();
    
    /**
     * Sets the "resourceName" attribute
     */
    void setResourceName(java.lang.String resourceName);
    
    /**
     * Sets (as xml) the "resourceName" attribute
     */
    void xsetResourceName(org.apache.xmlbeans.XmlString resourceName);
    
    /**
     * Unsets the "resourceName" attribute
     */
    void unsetResourceName();
    
    /**
     * Gets the "timestamp" attribute
     */
    int getTimestamp();
    
    /**
     * Gets (as xml) the "timestamp" attribute
     */
    org.apache.xmlbeans.XmlInt xgetTimestamp();
    
    /**
     * True if has "timestamp" attribute
     */
    boolean isSetTimestamp();
    
    /**
     * Sets the "timestamp" attribute
     */
    void setTimestamp(int timestamp);
    
    /**
     * Sets (as xml) the "timestamp" attribute
     */
    void xsetTimestamp(org.apache.xmlbeans.XmlInt timestamp);
    
    /**
     * Unsets the "timestamp" attribute
     */
    void unsetTimestamp();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType newInstance() {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}

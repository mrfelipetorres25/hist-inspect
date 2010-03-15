/*
 * An XML document type.
 * Localname: anomaly-catalog
 * Namespace: AnomaliesCatalogFile
 * Java type: br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomalyCatalogDocument
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.impl;
/**
 * A document containing one anomaly-catalog(@AnomaliesCatalogFile) element.
 *
 * This is a complex type.
 */
public class AnomalyCatalogDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomalyCatalogDocument
{
    private static final long serialVersionUID = 1L;
    
    public AnomalyCatalogDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANOMALYCATALOG$0 = 
        new javax.xml.namespace.QName("AnomaliesCatalogFile", "anomaly-catalog");
    
    
    /**
     * Gets the "anomaly-catalog" element
     */
    public br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType getAnomalyCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType)get_store().find_element_user(ANOMALYCATALOG$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "anomaly-catalog" element
     */
    public void setAnomalyCatalog(br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType anomalyCatalog)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType)get_store().find_element_user(ANOMALYCATALOG$0, 0);
            if (target == null)
            {
                target = (br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType)get_store().add_element_user(ANOMALYCATALOG$0);
            }
            target.set(anomalyCatalog);
        }
    }
    
    /**
     * Appends and returns a new empty "anomaly-catalog" element
     */
    public br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType addNewAnomalyCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.anomalies.AnomaliesCatalogType)get_store().add_element_user(ANOMALYCATALOG$0);
            return target;
        }
    }
}

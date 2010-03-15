/*
 * An XML document type.
 * Localname: MetricResults
 * Namespace: TogetherMtbl
 * Java type: br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsDocument
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.impl;
/**
 * A document containing one MetricResults(@TogetherMtbl) element.
 *
 * This is a complex type.
 */
public class MetricResultsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsDocument
{
    private static final long serialVersionUID = 1L;
    
    public MetricResultsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METRICRESULTS$0 = 
        new javax.xml.namespace.QName("TogetherMtbl", "MetricResults");
    
    
    /**
     * Gets the "MetricResults" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType getMetricResults()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType)get_store().find_element_user(METRICRESULTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "MetricResults" element
     */
    public void setMetricResults(br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType metricResults)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType)get_store().find_element_user(METRICRESULTS$0, 0);
            if (target == null)
            {
                target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType)get_store().add_element_user(METRICRESULTS$0);
            }
            target.set(metricResults);
        }
    }
    
    /**
     * Appends and returns a new empty "MetricResults" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType addNewMetricResults()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType)get_store().add_element_user(METRICRESULTS$0);
            return target;
        }
    }
}

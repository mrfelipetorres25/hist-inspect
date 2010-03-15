/*
 * XML Type:  referenceListCatalogType
 * Namespace: ReferenceListFile
 * Java type: br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.impl;
/**
 * An XML referenceListCatalogType(@ReferenceListFile).
 *
 * This is a complex type.
 */
public class ReferenceListCatalogTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceListCatalogTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ANOMALY$0 = 
        new javax.xml.namespace.QName("ReferenceListFile", "anomaly");
    
    
    /**
     * Gets array of all "anomaly" elements
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType[] getAnomalyArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ANOMALY$0, targetList);
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType[] result = new br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "anomaly" element
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType getAnomalyArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType)get_store().find_element_user(ANOMALY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "anomaly" element
     */
    public int sizeOfAnomalyArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ANOMALY$0);
        }
    }
    
    /**
     * Sets array of all "anomaly" element
     */
    public void setAnomalyArray(br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType[] anomalyArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(anomalyArray, ANOMALY$0);
        }
    }
    
    /**
     * Sets ith "anomaly" element
     */
    public void setAnomalyArray(int i, br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType anomaly)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType)get_store().find_element_user(ANOMALY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(anomaly);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "anomaly" element
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType insertNewAnomaly(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType)get_store().insert_element_user(ANOMALY$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "anomaly" element
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType addNewAnomaly()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType)get_store().add_element_user(ANOMALY$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "anomaly" element
     */
    public void removeAnomaly(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ANOMALY$0, i);
        }
    }
}

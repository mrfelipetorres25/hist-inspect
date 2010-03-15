/*
 * XML Type:  MetricResultsType
 * Namespace: TogetherMtbl
 * Java type: br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.impl;
/**
 * An XML MetricResultsType(@TogetherMtbl).
 *
 * This is a complex type.
 */
public class MetricResultsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricResultsType
{
    private static final long serialVersionUID = 1L;
    
    public MetricResultsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METRICDESCRIPTION$0 = 
        new javax.xml.namespace.QName("TogetherMtbl", "MetricDescription");
    private static final javax.xml.namespace.QName ISCOMPARATION$2 = 
        new javax.xml.namespace.QName("", "isComparation");
    
    
    /**
     * Gets array of all "MetricDescription" elements
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType[] getMetricDescriptionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METRICDESCRIPTION$0, targetList);
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType[] result = new br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "MetricDescription" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType getMetricDescriptionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType)get_store().find_element_user(METRICDESCRIPTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "MetricDescription" element
     */
    public int sizeOfMetricDescriptionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METRICDESCRIPTION$0);
        }
    }
    
    /**
     * Sets array of all "MetricDescription" element
     */
    public void setMetricDescriptionArray(br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType[] metricDescriptionArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metricDescriptionArray, METRICDESCRIPTION$0);
        }
    }
    
    /**
     * Sets ith "MetricDescription" element
     */
    public void setMetricDescriptionArray(int i, br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType metricDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType)get_store().find_element_user(METRICDESCRIPTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(metricDescription);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "MetricDescription" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType insertNewMetricDescription(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType)get_store().insert_element_user(METRICDESCRIPTION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "MetricDescription" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType addNewMetricDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType)get_store().add_element_user(METRICDESCRIPTION$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "MetricDescription" element
     */
    public void removeMetricDescription(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METRICDESCRIPTION$0, i);
        }
    }
    
    /**
     * Gets the "isComparation" attribute
     */
    public java.lang.String getIsComparation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ISCOMPARATION$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "isComparation" attribute
     */
    public org.apache.xmlbeans.XmlString xgetIsComparation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ISCOMPARATION$2);
            return target;
        }
    }
    
    /**
     * True if has "isComparation" attribute
     */
    public boolean isSetIsComparation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(ISCOMPARATION$2) != null;
        }
    }
    
    /**
     * Sets the "isComparation" attribute
     */
    public void setIsComparation(java.lang.String isComparation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ISCOMPARATION$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ISCOMPARATION$2);
            }
            target.setStringValue(isComparation);
        }
    }
    
    /**
     * Sets (as xml) the "isComparation" attribute
     */
    public void xsetIsComparation(org.apache.xmlbeans.XmlString isComparation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ISCOMPARATION$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ISCOMPARATION$2);
            }
            target.set(isComparation);
        }
    }
    
    /**
     * Unsets the "isComparation" attribute
     */
    public void unsetIsComparation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(ISCOMPARATION$2);
        }
    }
}

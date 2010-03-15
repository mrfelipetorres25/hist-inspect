/*
 * XML Type:  MetricDescriptionType
 * Namespace: TogetherMtbl
 * Java type: br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.impl;
/**
 * An XML MetricDescriptionType(@TogetherMtbl).
 *
 * This is a complex type.
 */
public class MetricDescriptionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType
{
    private static final long serialVersionUID = 1L;
    
    public MetricDescriptionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName METRIC$0 = 
        new javax.xml.namespace.QName("TogetherMtbl", "Metric");
    private static final javax.xml.namespace.QName METRICDESCRIPTION$2 = 
        new javax.xml.namespace.QName("TogetherMtbl", "MetricDescription");
    private static final javax.xml.namespace.QName CONTAINERNAME$4 = 
        new javax.xml.namespace.QName("", "containerName");
    private static final javax.xml.namespace.QName ENDOFFSET$6 = 
        new javax.xml.namespace.QName("", "endOffset");
    private static final javax.xml.namespace.QName FQNAME$8 = 
        new javax.xml.namespace.QName("", "fqname");
    private static final javax.xml.namespace.QName KIND$10 = 
        new javax.xml.namespace.QName("", "kind");
    private static final javax.xml.namespace.QName LANGUAGE$12 = 
        new javax.xml.namespace.QName("", "language");
    private static final javax.xml.namespace.QName LINE$14 = 
        new javax.xml.namespace.QName("", "line");
    private static final javax.xml.namespace.QName LOCATION$16 = 
        new javax.xml.namespace.QName("", "location");
    private static final javax.xml.namespace.QName NAME$18 = 
        new javax.xml.namespace.QName("", "name");
    private static final javax.xml.namespace.QName OFFSET$20 = 
        new javax.xml.namespace.QName("", "offset");
    private static final javax.xml.namespace.QName PROJECTNAME$22 = 
        new javax.xml.namespace.QName("", "projectName");
    private static final javax.xml.namespace.QName RESOURCE$24 = 
        new javax.xml.namespace.QName("", "resource");
    private static final javax.xml.namespace.QName RESOURCENAME$26 = 
        new javax.xml.namespace.QName("", "resourceName");
    private static final javax.xml.namespace.QName TIMESTAMP$28 = 
        new javax.xml.namespace.QName("", "timestamp");
    
    
    /**
     * Gets array of all "Metric" elements
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType[] getMetricArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METRIC$0, targetList);
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType[] result = new br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "Metric" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType getMetricArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType)get_store().find_element_user(METRIC$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "Metric" element
     */
    public int sizeOfMetricArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METRIC$0);
        }
    }
    
    /**
     * Sets array of all "Metric" element
     */
    public void setMetricArray(br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType[] metricArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(metricArray, METRIC$0);
        }
    }
    
    /**
     * Sets ith "Metric" element
     */
    public void setMetricArray(int i, br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType metric)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType)get_store().find_element_user(METRIC$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(metric);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Metric" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType insertNewMetric(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType)get_store().insert_element_user(METRIC$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Metric" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType addNewMetric()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricType)get_store().add_element_user(METRIC$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "Metric" element
     */
    public void removeMetric(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METRIC$0, i);
        }
    }
    
    /**
     * Gets array of all "MetricDescription" elements
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType[] getMetricDescriptionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(METRICDESCRIPTION$2, targetList);
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
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType)get_store().find_element_user(METRICDESCRIPTION$2, i);
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
            return get_store().count_elements(METRICDESCRIPTION$2);
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
            arraySetterHelper(metricDescriptionArray, METRICDESCRIPTION$2);
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
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType)get_store().find_element_user(METRICDESCRIPTION$2, i);
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
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType)get_store().insert_element_user(METRICDESCRIPTION$2, i);
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
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.mtblfile.MetricDescriptionType)get_store().add_element_user(METRICDESCRIPTION$2);
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
            get_store().remove_element(METRICDESCRIPTION$2, i);
        }
    }
    
    /**
     * Gets the "containerName" attribute
     */
    public java.lang.String getContainerName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONTAINERNAME$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "containerName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetContainerName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CONTAINERNAME$4);
            return target;
        }
    }
    
    /**
     * True if has "containerName" attribute
     */
    public boolean isSetContainerName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(CONTAINERNAME$4) != null;
        }
    }
    
    /**
     * Sets the "containerName" attribute
     */
    public void setContainerName(java.lang.String containerName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONTAINERNAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CONTAINERNAME$4);
            }
            target.setStringValue(containerName);
        }
    }
    
    /**
     * Sets (as xml) the "containerName" attribute
     */
    public void xsetContainerName(org.apache.xmlbeans.XmlString containerName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CONTAINERNAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CONTAINERNAME$4);
            }
            target.set(containerName);
        }
    }
    
    /**
     * Unsets the "containerName" attribute
     */
    public void unsetContainerName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(CONTAINERNAME$4);
        }
    }
    
    /**
     * Gets the "endOffset" attribute
     */
    public int getEndOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENDOFFSET$6);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "endOffset" attribute
     */
    public org.apache.xmlbeans.XmlInt xgetEndOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(ENDOFFSET$6);
            return target;
        }
    }
    
    /**
     * True if has "endOffset" attribute
     */
    public boolean isSetEndOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(ENDOFFSET$6) != null;
        }
    }
    
    /**
     * Sets the "endOffset" attribute
     */
    public void setEndOffset(int endOffset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENDOFFSET$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENDOFFSET$6);
            }
            target.setIntValue(endOffset);
        }
    }
    
    /**
     * Sets (as xml) the "endOffset" attribute
     */
    public void xsetEndOffset(org.apache.xmlbeans.XmlInt endOffset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(ENDOFFSET$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(ENDOFFSET$6);
            }
            target.set(endOffset);
        }
    }
    
    /**
     * Unsets the "endOffset" attribute
     */
    public void unsetEndOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(ENDOFFSET$6);
        }
    }
    
    /**
     * Gets the "fqname" attribute
     */
    public java.lang.String getFqname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FQNAME$8);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "fqname" attribute
     */
    public org.apache.xmlbeans.XmlString xgetFqname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FQNAME$8);
            return target;
        }
    }
    
    /**
     * True if has "fqname" attribute
     */
    public boolean isSetFqname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(FQNAME$8) != null;
        }
    }
    
    /**
     * Sets the "fqname" attribute
     */
    public void setFqname(java.lang.String fqname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FQNAME$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FQNAME$8);
            }
            target.setStringValue(fqname);
        }
    }
    
    /**
     * Sets (as xml) the "fqname" attribute
     */
    public void xsetFqname(org.apache.xmlbeans.XmlString fqname)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FQNAME$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(FQNAME$8);
            }
            target.set(fqname);
        }
    }
    
    /**
     * Unsets the "fqname" attribute
     */
    public void unsetFqname()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(FQNAME$8);
        }
    }
    
    /**
     * Gets the "kind" attribute
     */
    public int getKind()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(KIND$10);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "kind" attribute
     */
    public org.apache.xmlbeans.XmlInt xgetKind()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(KIND$10);
            return target;
        }
    }
    
    /**
     * True if has "kind" attribute
     */
    public boolean isSetKind()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(KIND$10) != null;
        }
    }
    
    /**
     * Sets the "kind" attribute
     */
    public void setKind(int kind)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(KIND$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(KIND$10);
            }
            target.setIntValue(kind);
        }
    }
    
    /**
     * Sets (as xml) the "kind" attribute
     */
    public void xsetKind(org.apache.xmlbeans.XmlInt kind)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(KIND$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(KIND$10);
            }
            target.set(kind);
        }
    }
    
    /**
     * Unsets the "kind" attribute
     */
    public void unsetKind()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(KIND$10);
        }
    }
    
    /**
     * Gets the "language" attribute
     */
    public java.lang.String getLanguage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANGUAGE$12);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "language" attribute
     */
    public org.apache.xmlbeans.XmlString xgetLanguage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LANGUAGE$12);
            return target;
        }
    }
    
    /**
     * True if has "language" attribute
     */
    public boolean isSetLanguage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(LANGUAGE$12) != null;
        }
    }
    
    /**
     * Sets the "language" attribute
     */
    public void setLanguage(java.lang.String language)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANGUAGE$12);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LANGUAGE$12);
            }
            target.setStringValue(language);
        }
    }
    
    /**
     * Sets (as xml) the "language" attribute
     */
    public void xsetLanguage(org.apache.xmlbeans.XmlString language)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LANGUAGE$12);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(LANGUAGE$12);
            }
            target.set(language);
        }
    }
    
    /**
     * Unsets the "language" attribute
     */
    public void unsetLanguage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(LANGUAGE$12);
        }
    }
    
    /**
     * Gets the "line" attribute
     */
    public int getLine()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LINE$14);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "line" attribute
     */
    public org.apache.xmlbeans.XmlInt xgetLine()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(LINE$14);
            return target;
        }
    }
    
    /**
     * True if has "line" attribute
     */
    public boolean isSetLine()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(LINE$14) != null;
        }
    }
    
    /**
     * Sets the "line" attribute
     */
    public void setLine(int line)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LINE$14);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LINE$14);
            }
            target.setIntValue(line);
        }
    }
    
    /**
     * Sets (as xml) the "line" attribute
     */
    public void xsetLine(org.apache.xmlbeans.XmlInt line)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(LINE$14);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(LINE$14);
            }
            target.set(line);
        }
    }
    
    /**
     * Unsets the "line" attribute
     */
    public void unsetLine()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(LINE$14);
        }
    }
    
    /**
     * Gets the "location" attribute
     */
    public java.lang.String getLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LOCATION$16);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "location" attribute
     */
    public org.apache.xmlbeans.XmlString xgetLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LOCATION$16);
            return target;
        }
    }
    
    /**
     * True if has "location" attribute
     */
    public boolean isSetLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(LOCATION$16) != null;
        }
    }
    
    /**
     * Sets the "location" attribute
     */
    public void setLocation(java.lang.String location)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LOCATION$16);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LOCATION$16);
            }
            target.setStringValue(location);
        }
    }
    
    /**
     * Sets (as xml) the "location" attribute
     */
    public void xsetLocation(org.apache.xmlbeans.XmlString location)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(LOCATION$16);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(LOCATION$16);
            }
            target.set(location);
        }
    }
    
    /**
     * Unsets the "location" attribute
     */
    public void unsetLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(LOCATION$16);
        }
    }
    
    /**
     * Gets the "name" attribute
     */
    public java.lang.String getName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$18);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "name" attribute
     */
    public org.apache.xmlbeans.XmlString xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$18);
            return target;
        }
    }
    
    /**
     * True if has "name" attribute
     */
    public boolean isSetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(NAME$18) != null;
        }
    }
    
    /**
     * Sets the "name" attribute
     */
    public void setName(java.lang.String name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$18);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$18);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" attribute
     */
    public void xsetName(org.apache.xmlbeans.XmlString name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$18);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$18);
            }
            target.set(name);
        }
    }
    
    /**
     * Unsets the "name" attribute
     */
    public void unsetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(NAME$18);
        }
    }
    
    /**
     * Gets the "offset" attribute
     */
    public int getOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(OFFSET$20);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "offset" attribute
     */
    public org.apache.xmlbeans.XmlInt xgetOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(OFFSET$20);
            return target;
        }
    }
    
    /**
     * True if has "offset" attribute
     */
    public boolean isSetOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(OFFSET$20) != null;
        }
    }
    
    /**
     * Sets the "offset" attribute
     */
    public void setOffset(int offset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(OFFSET$20);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(OFFSET$20);
            }
            target.setIntValue(offset);
        }
    }
    
    /**
     * Sets (as xml) the "offset" attribute
     */
    public void xsetOffset(org.apache.xmlbeans.XmlInt offset)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(OFFSET$20);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(OFFSET$20);
            }
            target.set(offset);
        }
    }
    
    /**
     * Unsets the "offset" attribute
     */
    public void unsetOffset()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(OFFSET$20);
        }
    }
    
    /**
     * Gets the "projectName" attribute
     */
    public java.lang.String getProjectName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROJECTNAME$22);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "projectName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetProjectName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROJECTNAME$22);
            return target;
        }
    }
    
    /**
     * True if has "projectName" attribute
     */
    public boolean isSetProjectName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PROJECTNAME$22) != null;
        }
    }
    
    /**
     * Sets the "projectName" attribute
     */
    public void setProjectName(java.lang.String projectName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PROJECTNAME$22);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PROJECTNAME$22);
            }
            target.setStringValue(projectName);
        }
    }
    
    /**
     * Sets (as xml) the "projectName" attribute
     */
    public void xsetProjectName(org.apache.xmlbeans.XmlString projectName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PROJECTNAME$22);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PROJECTNAME$22);
            }
            target.set(projectName);
        }
    }
    
    /**
     * Unsets the "projectName" attribute
     */
    public void unsetProjectName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PROJECTNAME$22);
        }
    }
    
    /**
     * Gets the "resource" attribute
     */
    public java.lang.String getResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RESOURCE$24);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "resource" attribute
     */
    public org.apache.xmlbeans.XmlString xgetResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RESOURCE$24);
            return target;
        }
    }
    
    /**
     * True if has "resource" attribute
     */
    public boolean isSetResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(RESOURCE$24) != null;
        }
    }
    
    /**
     * Sets the "resource" attribute
     */
    public void setResource(java.lang.String resource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RESOURCE$24);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RESOURCE$24);
            }
            target.setStringValue(resource);
        }
    }
    
    /**
     * Sets (as xml) the "resource" attribute
     */
    public void xsetResource(org.apache.xmlbeans.XmlString resource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RESOURCE$24);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(RESOURCE$24);
            }
            target.set(resource);
        }
    }
    
    /**
     * Unsets the "resource" attribute
     */
    public void unsetResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(RESOURCE$24);
        }
    }
    
    /**
     * Gets the "resourceName" attribute
     */
    public java.lang.String getResourceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RESOURCENAME$26);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "resourceName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetResourceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RESOURCENAME$26);
            return target;
        }
    }
    
    /**
     * True if has "resourceName" attribute
     */
    public boolean isSetResourceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(RESOURCENAME$26) != null;
        }
    }
    
    /**
     * Sets the "resourceName" attribute
     */
    public void setResourceName(java.lang.String resourceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RESOURCENAME$26);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RESOURCENAME$26);
            }
            target.setStringValue(resourceName);
        }
    }
    
    /**
     * Sets (as xml) the "resourceName" attribute
     */
    public void xsetResourceName(org.apache.xmlbeans.XmlString resourceName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RESOURCENAME$26);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(RESOURCENAME$26);
            }
            target.set(resourceName);
        }
    }
    
    /**
     * Unsets the "resourceName" attribute
     */
    public void unsetResourceName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(RESOURCENAME$26);
        }
    }
    
    /**
     * Gets the "timestamp" attribute
     */
    public int getTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TIMESTAMP$28);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "timestamp" attribute
     */
    public org.apache.xmlbeans.XmlInt xgetTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(TIMESTAMP$28);
            return target;
        }
    }
    
    /**
     * True if has "timestamp" attribute
     */
    public boolean isSetTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(TIMESTAMP$28) != null;
        }
    }
    
    /**
     * Sets the "timestamp" attribute
     */
    public void setTimestamp(int timestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TIMESTAMP$28);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TIMESTAMP$28);
            }
            target.setIntValue(timestamp);
        }
    }
    
    /**
     * Sets (as xml) the "timestamp" attribute
     */
    public void xsetTimestamp(org.apache.xmlbeans.XmlInt timestamp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(TIMESTAMP$28);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(TIMESTAMP$28);
            }
            target.set(timestamp);
        }
    }
    
    /**
     * Unsets the "timestamp" attribute
     */
    public void unsetTimestamp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(TIMESTAMP$28);
        }
    }
}

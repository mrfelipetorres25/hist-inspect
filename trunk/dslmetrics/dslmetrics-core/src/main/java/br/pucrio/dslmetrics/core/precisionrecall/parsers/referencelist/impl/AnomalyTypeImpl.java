/*
 * XML Type:  anomalyType
 * Namespace: ReferenceListFile
 * Java type: br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.impl;
/**
 * An XML anomalyType(@ReferenceListFile).
 *
 * This is a complex type.
 */
public class AnomalyTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.AnomalyType
{
    private static final long serialVersionUID = 1L;
    
    public AnomalyTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VERSION$0 = 
        new javax.xml.namespace.QName("ReferenceListFile", "version");
    private static final javax.xml.namespace.QName ID$2 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets array of all "version" elements
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType[] getVersionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VERSION$0, targetList);
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType[] result = new br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "version" element
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType getVersionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType)get_store().find_element_user(VERSION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "version" element
     */
    public int sizeOfVersionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VERSION$0);
        }
    }
    
    /**
     * Sets array of all "version" element
     */
    public void setVersionArray(br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType[] versionArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(versionArray, VERSION$0);
        }
    }
    
    /**
     * Sets ith "version" element
     */
    public void setVersionArray(int i, br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType)get_store().find_element_user(VERSION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(version);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "version" element
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType insertNewVersion(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType)get_store().insert_element_user(VERSION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "version" element
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType addNewVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType)get_store().add_element_user(VERSION$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "version" element
     */
    public void removeVersion(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VERSION$0, i);
        }
    }
    
    /**
     * Gets the "id" attribute
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" attribute
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$2);
            return target;
        }
    }
    
    /**
     * Sets the "id" attribute
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$2);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" attribute
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$2);
            }
            target.set(id);
        }
    }
}

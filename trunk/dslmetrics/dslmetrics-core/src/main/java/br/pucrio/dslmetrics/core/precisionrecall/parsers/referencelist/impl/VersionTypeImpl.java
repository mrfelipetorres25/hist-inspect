/*
 * XML Type:  versionType
 * Namespace: ReferenceListFile
 * Java type: br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.impl;
/**
 * An XML versionType(@ReferenceListFile).
 *
 * This is a complex type.
 */
public class VersionTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.VersionType
{
    private static final long serialVersionUID = 1L;
    
    public VersionTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ENTITY$0 = 
        new javax.xml.namespace.QName("ReferenceListFile", "entity");
    private static final javax.xml.namespace.QName NUMBER$2 = 
        new javax.xml.namespace.QName("", "number");
    
    
    /**
     * Gets array of all "entity" elements
     */
    public java.lang.String[] getEntityArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ENTITY$0, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "entity" element
     */
    public java.lang.String getEntityArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENTITY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "entity" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetEntityArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ENTITY$0, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "entity" element
     */
    public org.apache.xmlbeans.XmlString xgetEntityArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENTITY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "entity" element
     */
    public int sizeOfEntityArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ENTITY$0);
        }
    }
    
    /**
     * Sets array of all "entity" element
     */
    public void setEntityArray(java.lang.String[] entityArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(entityArray, ENTITY$0);
        }
    }
    
    /**
     * Sets ith "entity" element
     */
    public void setEntityArray(int i, java.lang.String entity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ENTITY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(entity);
        }
    }
    
    /**
     * Sets (as xml) array of all "entity" element
     */
    public void xsetEntityArray(org.apache.xmlbeans.XmlString[]entityArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(entityArray, ENTITY$0);
        }
    }
    
    /**
     * Sets (as xml) ith "entity" element
     */
    public void xsetEntityArray(int i, org.apache.xmlbeans.XmlString entity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ENTITY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(entity);
        }
    }
    
    /**
     * Inserts the value as the ith "entity" element
     */
    public void insertEntity(int i, java.lang.String entity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(ENTITY$0, i);
            target.setStringValue(entity);
        }
    }
    
    /**
     * Appends the value as the last "entity" element
     */
    public void addEntity(java.lang.String entity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ENTITY$0);
            target.setStringValue(entity);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "entity" element
     */
    public org.apache.xmlbeans.XmlString insertNewEntity(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(ENTITY$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "entity" element
     */
    public org.apache.xmlbeans.XmlString addNewEntity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ENTITY$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "entity" element
     */
    public void removeEntity(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ENTITY$0, i);
        }
    }
    
    /**
     * Gets the "number" attribute
     */
    public int getNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NUMBER$2);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "number" attribute
     */
    public org.apache.xmlbeans.XmlInt xgetNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(NUMBER$2);
            return target;
        }
    }
    
    /**
     * Sets the "number" attribute
     */
    public void setNumber(int number)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NUMBER$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NUMBER$2);
            }
            target.setIntValue(number);
        }
    }
    
    /**
     * Sets (as xml) the "number" attribute
     */
    public void xsetNumber(org.apache.xmlbeans.XmlInt number)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_attribute_user(NUMBER$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_attribute_user(NUMBER$2);
            }
            target.set(number);
        }
    }
}

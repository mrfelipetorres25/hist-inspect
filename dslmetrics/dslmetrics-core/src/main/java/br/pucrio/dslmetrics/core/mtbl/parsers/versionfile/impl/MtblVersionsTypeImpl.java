/*
 * XML Type:  mtblVersionsType
 * Namespace: MtblVersionsFile
 * Java type: br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.impl;
/**
 * An XML mtblVersionsType(@MtblVersionsFile).
 *
 * This is a complex type.
 */
public class MtblVersionsTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType
{
    private static final long serialVersionUID = 1L;
    
    public MtblVersionsTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VERSION$0 = 
        new javax.xml.namespace.QName("MtblVersionsFile", "version");
    
    
    /**
     * Gets array of all "version" elements
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType[] getVersionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VERSION$0, targetList);
            br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType[] result = new br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "version" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType getVersionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType)get_store().find_element_user(VERSION$0, i);
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
    public void setVersionArray(br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType[] versionArray)
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
    public void setVersionArray(int i, br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType version)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType)get_store().find_element_user(VERSION$0, i);
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
    public br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType insertNewVersion(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType)get_store().insert_element_user(VERSION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "version" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType addNewVersion()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionType)get_store().add_element_user(VERSION$0);
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
}

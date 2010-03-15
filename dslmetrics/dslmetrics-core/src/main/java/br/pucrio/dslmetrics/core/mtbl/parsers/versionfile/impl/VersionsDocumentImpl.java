/*
 * An XML document type.
 * Localname: versions
 * Namespace: MtblVersionsFile
 * Java type: br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.VersionsDocument
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.impl;
/**
 * A document containing one versions(@MtblVersionsFile) element.
 *
 * This is a complex type.
 */
public class VersionsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.VersionsDocument
{
    private static final long serialVersionUID = 1L;
    
    public VersionsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VERSIONS$0 = 
        new javax.xml.namespace.QName("MtblVersionsFile", "versions");
    
    
    /**
     * Gets the "versions" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType getVersions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType)get_store().find_element_user(VERSIONS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "versions" element
     */
    public void setVersions(br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType versions)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType)get_store().find_element_user(VERSIONS$0, 0);
            if (target == null)
            {
                target = (br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType)get_store().add_element_user(VERSIONS$0);
            }
            target.set(versions);
        }
    }
    
    /**
     * Appends and returns a new empty "versions" element
     */
    public br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType addNewVersions()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType target = null;
            target = (br.pucrio.dslmetrics.core.mtbl.parsers.versionfile.MtblVersionsType)get_store().add_element_user(VERSIONS$0);
            return target;
        }
    }
}

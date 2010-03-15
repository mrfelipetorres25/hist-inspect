/*
 * An XML document type.
 * Localname: reference-list-catalog
 * Namespace: ReferenceListFile
 * Java type: br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogDocument
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.impl;
/**
 * A document containing one reference-list-catalog(@ReferenceListFile) element.
 *
 * This is a complex type.
 */
public class ReferenceListCatalogDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogDocument
{
    private static final long serialVersionUID = 1L;
    
    public ReferenceListCatalogDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REFERENCELISTCATALOG$0 = 
        new javax.xml.namespace.QName("ReferenceListFile", "reference-list-catalog");
    
    
    /**
     * Gets the "reference-list-catalog" element
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType getReferenceListCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType)get_store().find_element_user(REFERENCELISTCATALOG$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "reference-list-catalog" element
     */
    public void setReferenceListCatalog(br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType referenceListCatalog)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType)get_store().find_element_user(REFERENCELISTCATALOG$0, 0);
            if (target == null)
            {
                target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType)get_store().add_element_user(REFERENCELISTCATALOG$0);
            }
            target.set(referenceListCatalog);
        }
    }
    
    /**
     * Appends and returns a new empty "reference-list-catalog" element
     */
    public br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType addNewReferenceListCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.precisionrecall.parsers.referencelist.ReferenceListCatalogType)get_store().add_element_user(REFERENCELISTCATALOG$0);
            return target;
        }
    }
}

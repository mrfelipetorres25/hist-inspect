/*
 * An XML document type.
 * Localname: rule-catalog
 * Namespace: RuleCatalogFile
 * Java type: br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogDocument
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.heuristics.parsers.rule.impl;
/**
 * A document containing one rule-catalog(@RuleCatalogFile) element.
 *
 * This is a complex type.
 */
public class RuleCatalogDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogDocument
{
    private static final long serialVersionUID = 1L;
    
    public RuleCatalogDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RULECATALOG$0 = 
        new javax.xml.namespace.QName("RuleCatalogFile", "rule-catalog");
    
    
    /**
     * Gets the "rule-catalog" element
     */
    public br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType getRuleCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType)get_store().find_element_user(RULECATALOG$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "rule-catalog" element
     */
    public void setRuleCatalog(br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType ruleCatalog)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType)get_store().find_element_user(RULECATALOG$0, 0);
            if (target == null)
            {
                target = (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType)get_store().add_element_user(RULECATALOG$0);
            }
            target.set(ruleCatalog);
        }
    }
    
    /**
     * Appends and returns a new empty "rule-catalog" element
     */
    public br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType addNewRuleCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType)get_store().add_element_user(RULECATALOG$0);
            return target;
        }
    }
}

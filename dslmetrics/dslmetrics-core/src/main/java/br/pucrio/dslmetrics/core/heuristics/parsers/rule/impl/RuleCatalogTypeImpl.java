/*
 * XML Type:  ruleCatalogType
 * Namespace: RuleCatalogFile
 * Java type: br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType
 *
 * Automatically generated - do not modify.
 */
package br.pucrio.dslmetrics.core.heuristics.parsers.rule.impl;
/**
 * An XML ruleCatalogType(@RuleCatalogFile).
 *
 * This is a complex type.
 */
public class RuleCatalogTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleCatalogType
{
    private static final long serialVersionUID = 1L;
    
    public RuleCatalogTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RULE$0 = 
        new javax.xml.namespace.QName("RuleCatalogFile", "rule");
    
    
    /**
     * Gets array of all "rule" elements
     */
    public br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType[] getRuleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(RULE$0, targetList);
            br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType[] result = new br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "rule" element
     */
    public br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType getRuleArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType)get_store().find_element_user(RULE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "rule" element
     */
    public int sizeOfRuleArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RULE$0);
        }
    }
    
    /**
     * Sets array of all "rule" element
     */
    public void setRuleArray(br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType[] ruleArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(ruleArray, RULE$0);
        }
    }
    
    /**
     * Sets ith "rule" element
     */
    public void setRuleArray(int i, br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType rule)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType)get_store().find_element_user(RULE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(rule);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "rule" element
     */
    public br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType insertNewRule(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType)get_store().insert_element_user(RULE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "rule" element
     */
    public br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType addNewRule()
    {
        synchronized (monitor())
        {
            check_orphaned();
            br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType target = null;
            target = (br.pucrio.dslmetrics.core.heuristics.parsers.rule.RuleType)get_store().add_element_user(RULE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "rule" element
     */
    public void removeRule(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RULE$0, i);
        }
    }
}

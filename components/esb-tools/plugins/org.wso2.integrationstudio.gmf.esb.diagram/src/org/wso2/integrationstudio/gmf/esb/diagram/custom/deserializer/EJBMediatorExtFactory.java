/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.bean.BeanConstants;
import org.apache.synapse.mediators.bean.enterprise.EJBConstants;
import org.wso2.integrationstudio.gmf.esb.internal.persistence.custom.EJBMediatorExt;

public class EJBMediatorExtFactory extends AbstractMediatorFactory {

    private static final QName EJB_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "ejb");

    public Mediator createSpecificMediator(OMElement elem, Properties properties) {

        EJBMediatorExt mediator = new EJBMediatorExt();

        String attributeValue;

        attributeValue = elem.getAttributeValue(new QName(EJBConstants.BEANSTALK));
        if (attributeValue != null) {
            mediator.setBeanstalkName(attributeValue.trim());
        }

        attributeValue = elem.getAttributeValue(new QName(BeanConstants.CLASS));
        if (attributeValue != null) {
            mediator.setClassName(attributeValue.trim());
        }

        attributeValue = elem.getAttributeValue(new QName(EJBConstants.STATEFUL));
        if (Boolean.valueOf(attributeValue)) {
            attributeValue = elem.getAttributeValue(new QName(EJBConstants.BEAN_ID));
            if (attributeValue != null) {
                mediator.setBeanId(new ValueFactoryExtended().createValue(EJBConstants.BEAN_ID, elem));
            }
        }

        boolean remove;
        attributeValue = elem.getAttributeValue(new QName(EJBConstants.REMOVE));
        remove = Boolean.valueOf(attributeValue);
        if (remove) {
            mediator.setRemove(true);
        }

        String targetValue = elem.getAttributeValue(new QName(BeanConstants.TARGET));
        if (targetValue != null) {
            mediator.setTargetValue(targetValue);
        }

        attributeValue = elem.getAttributeValue(new QName(EJBConstants.JNDI_NAME));
        if (attributeValue != null) {
            mediator.setJndiName(attributeValue);
        }

        OMElement argumentsElem = elem
                .getFirstChildWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, EJBConstants.ARGS));

        if (argumentsElem != null) {

            Iterator<?> itr = argumentsElem
                    .getChildrenWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, EJBConstants.ARG));

            while (itr.hasNext()) {
                OMElement argElem = (OMElement) itr.next();

                if (argElem.getAttributeValue(ATT_VALUE) != null) {
                    mediator.addArgument(new ValueFactoryExtended().createValue(BeanConstants.VALUE, argElem));
                }
            }
        }

        attributeValue = elem.getAttributeValue(new QName(EJBConstants.METHOD));
        if (attributeValue != null) {
            mediator.setMethodName(attributeValue);
        }
        addAllCommentChildrenToList(elem, mediator.getCommentsList());

        return mediator;
    }
    
    /**
     * This method will create a EJB mediator for the validation purposes. This will try 
     * to create the EJB mediator with the given OMElement, if it fails to create a mediator
     * this will throw synapse excpetions, otherwise this will return a valid bean mediator
     * @param elem OMElement of the mediator
     * @param properties
     * @return
     */
    public Mediator createSpecificMediatorForValidation(OMElement elem, Properties properties) {

        EJBMediatorExt mediator = new EJBMediatorExt();

        String attributeValue;

        attributeValue = elem.getAttributeValue(new QName(EJBConstants.BEANSTALK));
        if (attributeValue != null) {
            mediator.setBeanstalkName(attributeValue.trim());
        }

        attributeValue = elem.getAttributeValue(new QName(BeanConstants.CLASS));
        if (attributeValue != null) {
            mediator.setClassName(attributeValue.trim());
        }

        attributeValue = elem.getAttributeValue(new QName(EJBConstants.STATEFUL));
        if (Boolean.valueOf(attributeValue)) {
            attributeValue = elem.getAttributeValue(new QName(EJBConstants.BEAN_ID));
            if (attributeValue != null) {
                mediator.setBeanId(new ValueFactory().createValue(EJBConstants.BEAN_ID, elem));
            }
        }

        boolean remove;
        attributeValue = elem.getAttributeValue(new QName(EJBConstants.REMOVE));
        remove = Boolean.valueOf(attributeValue);
        if (remove) {
            mediator.setRemove(true);
        }

        String targetValue = elem.getAttributeValue(new QName(BeanConstants.TARGET));
        if (targetValue != null) {
            mediator.setTargetValue(targetValue);
        }

        attributeValue = elem.getAttributeValue(new QName(EJBConstants.JNDI_NAME));
        if (attributeValue != null) {
            mediator.setJndiName(attributeValue);
        }

        OMElement argumentsElem = elem
                .getFirstChildWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, EJBConstants.ARGS));

        if (argumentsElem != null) {

            @SuppressWarnings("rawtypes")
            Iterator itr = argumentsElem
                    .getChildrenWithName(new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, EJBConstants.ARG));

            while (itr.hasNext()) {
                OMElement argElem = (OMElement) itr.next();

                if (argElem.getAttributeValue(ATT_VALUE) != null) {
                    mediator.addArgument(new ValueFactory().createValue(BeanConstants.VALUE, argElem));
                }
            }
        }

        attributeValue = elem.getAttributeValue(new QName(EJBConstants.METHOD));
        if (attributeValue != null) {
            mediator.setMethodName(attributeValue);
        }

        return mediator;
    }

    public QName getTagQName() {
        return EJB_Q;
    }

}

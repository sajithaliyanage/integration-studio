/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.integrationstudio.gmf.esb.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.wso2.integrationstudio.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.TransactionAction;
import org.wso2.integrationstudio.gmf.esb.TransactionMediator;

/**
 * This is the item provider adapter for a {@link org.wso2.integrationstudio.gmf.esb.TransactionMediator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TransactionMediatorItemProvider extends MediatorItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TransactionMediatorItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */

    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors != null) {
            itemPropertyDescriptors.clear();
        }
        super.getPropertyDescriptors(object);

        addActionPropertyDescriptor(object);
        addDescriptionPropertyDescriptor(object);
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_TransactionMediator_action_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_TransactionMediator_action_feature", "_UI_TransactionMediator_type"),
                 EsbPackage.Literals.TRANSACTION_MEDIATOR__ACTION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(EsbPackage.Literals.TRANSACTION_MEDIATOR__INPUT_CONNECTOR);
            childrenFeatures.add(EsbPackage.Literals.TRANSACTION_MEDIATOR__OUTPUT_CONNECTOR);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns TransactionMediator.png.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */

    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/TransactionMediator.png"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    @Override
    public String getText(Object object) {
        String label = ((TransactionMediator)object).getDescription();
        return label == null || label.length() == 0 ?
            getString("_UI_TransactionMediator_type") :
            getString("_UI_TransactionMediator_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(TransactionMediator.class)) {
            case EsbPackage.TRANSACTION_MEDIATOR__ACTION:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case EsbPackage.TRANSACTION_MEDIATOR__INPUT_CONNECTOR:
            case EsbPackage.TRANSACTION_MEDIATOR__OUTPUT_CONNECTOR:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.TRANSACTION_MEDIATOR__INPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createTransactionMediatorInputConnector()));

        newChildDescriptors.add
            (createChildParameter
                (EsbPackage.Literals.TRANSACTION_MEDIATOR__OUTPUT_CONNECTOR,
                 EsbFactory.eINSTANCE.createTransactionMediatorOutputConnector()));
    }

}

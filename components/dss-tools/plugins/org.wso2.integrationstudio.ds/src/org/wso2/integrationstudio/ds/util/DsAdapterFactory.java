/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.integrationstudio.ds.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.wso2.integrationstudio.ds.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.wso2.integrationstudio.ds.DsPackage
 * @generated
 */
public class DsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the
	 * model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */

	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DsSwitch<Adapter> modelSwitch = new DsSwitch<Adapter>() {
			@Override
			public Adapter caseAttributeMapping(AttributeMapping object) {
				return createAttributeMappingAdapter();
			}
			@Override
			public Adapter caseCallQuery(CallQuery object) {
				return createCallQueryAdapter();
			}
			@Override
			public Adapter caseCallQueryList(CallQueryList object) {
				return createCallQueryListAdapter();
			}
			@Override
			public Adapter caseConfigurationProperty(ConfigurationProperty object) {
				return createConfigurationPropertyAdapter();
			}
			@Override
			public Adapter caseCustomValidator(CustomValidator object) {
				return createCustomValidatorAdapter();
			}
			@Override
			public Adapter caseDataService(DataService object) {
				return createDataServiceAdapter();
			}
			@Override
			public Adapter caseDataSourceConfiguration(DataSourceConfiguration object) {
				return createDataSourceConfigurationAdapter();
			}
			@Override
			public Adapter caseDescription(Description object) {
				return createDescriptionAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseDoubleRangeValidator(DoubleRangeValidator object) {
				return createDoubleRangeValidatorAdapter();
			}
			@Override
			public Adapter caseElementMapping(ElementMapping object) {
				return createElementMappingAdapter();
			}
			@Override
			public Adapter caseEventSubscriptionList(EventSubscriptionList object) {
				return createEventSubscriptionListAdapter();
			}
			@Override
			public Adapter caseEventTrigger(EventTrigger object) {
				return createEventTriggerAdapter();
			}
			@Override
			public Adapter caseExcelQuery(ExcelQuery object) {
				return createExcelQueryAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseGSpreadQuery(GSpreadQuery object) {
				return createGSpreadQueryAdapter();
			}
			@Override
			public Adapter caseHasHeader(HasHeader object) {
				return createHasHeaderAdapter();
			}
			@Override
			public Adapter caseLengthValidator(LengthValidator object) {
				return createLengthValidatorAdapter();
			}
			@Override
			public Adapter caseLongRangeValidator(LongRangeValidator object) {
				return createLongRangeValidatorAdapter();
			}
			@Override
			public Adapter caseMaxRowCount(MaxRowCount object) {
				return createMaxRowCountAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseParameterMapping(ParameterMapping object) {
				return createParameterMappingAdapter();
			}
			@Override
			public Adapter casePatternValidator(PatternValidator object) {
				return createPatternValidatorAdapter();
			}
			@Override
			public Adapter caseQuery(Query object) {
				return createQueryAdapter();
			}
			@Override
			public Adapter caseQueryParameter(QueryParameter object) {
				return createQueryParameterAdapter();
			}
			@Override
			public Adapter caseQueryProperty(QueryProperty object) {
				return createQueryPropertyAdapter();
			}
			@Override
			public Adapter caseQueryPropertyList(QueryPropertyList object) {
				return createQueryPropertyListAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseResultMapping(ResultMapping object) {
				return createResultMappingAdapter();
			}
			@Override
			public Adapter caseSparql(Sparql object) {
				return createSparqlAdapter();
			}
			@Override
			public Adapter caseSql(Sql object) {
				return createSqlAdapter();
			}
			@Override
			public Adapter caseQueryExpression(QueryExpression object) {
				return createQueryExpressionAdapter();
			}
			@Override
			public Adapter caseStartingRow(StartingRow object) {
				return createStartingRowAdapter();
			}
			@Override
			public Adapter caseSubscription(Subscription object) {
				return createSubscriptionAdapter();
			}
			@Override
			public Adapter caseTargetTopic(TargetTopic object) {
				return createTargetTopicAdapter();
			}
			@Override
			public Adapter caseWorkBookName(WorkBookName object) {
				return createWorkBookNameAdapter();
			}
			@Override
			public Adapter caseWorkSheetNumber(WorkSheetNumber object) {
				return createWorkSheetNumberAdapter();
			}
			@Override
			public Adapter casePolicy(Policy object) {
				return createPolicyAdapter();
			}
			@Override
			public Adapter caseDataServiceParameter(DataServiceParameter object) {
				return createDataServiceParameterAdapter();
			}
			@Override
			public Adapter caseRegistryKeyProperty(RegistryKeyProperty object) {
				return createRegistryKeyPropertyAdapter();
			}
			@Override
			public Adapter caseCustomValidatorProperty(CustomValidatorProperty object) {
				return createCustomValidatorPropertyAdapter();
			}
			@Override
			public Adapter caseCustomValidatorPropertyList(CustomValidatorPropertyList object) {
				return createCustomValidatorPropertyListAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */

	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.AttributeMapping
	 * @generated
	 */
	public Adapter createAttributeMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.CallQuery <em>Call Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.CallQuery
	 * @generated
	 */
	public Adapter createCallQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.CallQueryList <em>Call Query List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.CallQueryList
	 * @generated
	 */
	public Adapter createCallQueryListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.ConfigurationProperty <em>Configuration Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.ConfigurationProperty
	 * @generated
	 */
	public Adapter createConfigurationPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.CustomValidator <em>Custom Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.CustomValidator
	 * @generated
	 */
	public Adapter createCustomValidatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.DataService <em>Data Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.DataService
	 * @generated
	 */
	public Adapter createDataServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.DataSourceConfiguration <em>Data Source Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.DataSourceConfiguration
	 * @generated
	 */
	public Adapter createDataSourceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Description
	 * @generated
	 */
	public Adapter createDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.DoubleRangeValidator <em>Double Range Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.DoubleRangeValidator
	 * @generated
	 */
	public Adapter createDoubleRangeValidatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.ElementMapping <em>Element Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.ElementMapping
	 * @generated
	 */
	public Adapter createElementMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.EventSubscriptionList <em>Event Subscription List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.EventSubscriptionList
	 * @generated
	 */
	public Adapter createEventSubscriptionListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.EventTrigger <em>Event Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.EventTrigger
	 * @generated
	 */
	public Adapter createEventTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.ExcelQuery <em>Excel Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.ExcelQuery
	 * @generated
	 */
	public Adapter createExcelQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.GSpreadQuery <em>GSpread Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.GSpreadQuery
	 * @generated
	 */
	public Adapter createGSpreadQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.HasHeader <em>Has Header</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.HasHeader
	 * @generated
	 */
	public Adapter createHasHeaderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.LengthValidator <em>Length Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.LengthValidator
	 * @generated
	 */
	public Adapter createLengthValidatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.LongRangeValidator <em>Long Range Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.LongRangeValidator
	 * @generated
	 */
	public Adapter createLongRangeValidatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.MaxRowCount <em>Max Row Count</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.MaxRowCount
	 * @generated
	 */
	public Adapter createMaxRowCountAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.ParameterMapping <em>Parameter Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.ParameterMapping
	 * @generated
	 */
	public Adapter createParameterMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.PatternValidator <em>Pattern Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.PatternValidator
	 * @generated
	 */
	public Adapter createPatternValidatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Query <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Query
	 * @generated
	 */
	public Adapter createQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.QueryParameter <em>Query Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.QueryParameter
	 * @generated
	 */
	public Adapter createQueryParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.QueryProperty <em>Query Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.QueryProperty
	 * @generated
	 */
	public Adapter createQueryPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.QueryPropertyList <em>Query Property List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.QueryPropertyList
	 * @generated
	 */
	public Adapter createQueryPropertyListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.ResultMapping <em>Result Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.ResultMapping
	 * @generated
	 */
	public Adapter createResultMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Sparql <em>Sparql</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Sparql
	 * @generated
	 */
	public Adapter createSparqlAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Sql <em>Sql</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Sql
	 * @generated
	 */
	public Adapter createSqlAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.QueryExpression <em>Query Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.QueryExpression
	 * @generated
	 */
	public Adapter createQueryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.StartingRow <em>Starting Row</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.StartingRow
	 * @generated
	 */
	public Adapter createStartingRowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Subscription <em>Subscription</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Subscription
	 * @generated
	 */
	public Adapter createSubscriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.TargetTopic <em>Target Topic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.TargetTopic
	 * @generated
	 */
	public Adapter createTargetTopicAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.WorkBookName <em>Work Book Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.WorkBookName
	 * @generated
	 */
	public Adapter createWorkBookNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.WorkSheetNumber <em>Work Sheet Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore
	 * cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.WorkSheetNumber
	 * @generated
	 */
	public Adapter createWorkSheetNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.Policy
	 * @generated
	 */
	public Adapter createPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.DataServiceParameter <em>Data Service Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.DataServiceParameter
	 * @generated
	 */
	public Adapter createDataServiceParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.RegistryKeyProperty <em>Registry Key Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.RegistryKeyProperty
	 * @generated
	 */
	public Adapter createRegistryKeyPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.CustomValidatorProperty <em>Custom Validator Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.CustomValidatorProperty
	 * @generated
	 */
	public Adapter createCustomValidatorPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.integrationstudio.ds.CustomValidatorPropertyList <em>Custom Validator Property List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.integrationstudio.ds.CustomValidatorPropertyList
	 * @generated
	 */
	public Adapter createCustomValidatorPropertyListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // DsAdapterFactory

/*
 * Copyright (c) 2014-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.integrationstudio.gmf.esb.diagram.edit.parts;

import static org.wso2.integrationstudio.gmf.esb.diagram.edit.parts.EditPartConstants.DEFAULT_PROPERTY_VALUE_TEXT;
import static org.wso2.integrationstudio.gmf.esb.diagram.edit.parts.EditPartConstants.PUBLISHEVENT_MEDIATOR_ICON_PATH;

import org.apache.commons.lang.StringUtils;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSNodeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.ShowPropertyViewEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.custom.utils.CustomToolTip;
import org.wso2.integrationstudio.gmf.esb.diagram.edit.policies.PublishEventMediatorCanonicalEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.edit.policies.PublishEventMediatorItemSemanticEditPolicy;
import org.wso2.integrationstudio.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated NOT
 */
public class PublishEventMediatorEditPart extends FixedSizedAbstractMediator {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3785;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    public PublishEventMediatorEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PublishEventMediatorItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new PublishEventMediatorCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // For handle Double click Event.
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new ShowPropertyViewEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
        // editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (EsbVisualIDRegistry.getVisualID(childView)) {
                case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
                case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy();
                }
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated NOT
     */
    protected IFigure createNodeShape() {
        return primaryShape = new PublishEventMediatorFigure(new Color(null, 255, 255, 255)) {
            public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
                super.setBounds(rect);
                if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
                    connectToMostSuitableElement();
                    reAllocate(rect);
                }
            };
        };
    }

    /**
     * @generated
     */
    public PublishEventMediatorFigure getPrimaryShape() {
        return (PublishEventMediatorFigure) primaryShape;
    }

    /**
     * @generated NOT
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof PublishEventMediatorStreamNameEditPart) {
            ((PublishEventMediatorStreamNameEditPart) childEditPart)
                    .setLabel(getPrimaryShape().getFigurePublishEventMediatorDescriptionFigure());
            return true;
        }
        if (childEditPart instanceof PublishEventMediatorInputConnectorEditPart) {
            IFigure borderItemFigure = ((PublishEventMediatorInputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.WEST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        if (childEditPart instanceof PublishEventMediatorOutputConnectorEditPart) {
            IFigure borderItemFigure = ((PublishEventMediatorOutputConnectorEditPart) childEditPart).getFigure();
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.EAST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        return false;
    }

    /**
     * @generated NOT
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof PublishEventMediatorStreamNameEditPart) {
            return true;
        }
        if (childEditPart instanceof PublishEventMediatorInputConnectorEditPart) {
            getBorderedFigure().getBorderItemContainer()
                    .remove(((PublishEventMediatorInputConnectorEditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof PublishEventMediatorOutputConnectorEditPart) {
            getBorderedFigure().getBorderItemContainer()
                    .remove(((PublishEventMediatorOutputConnectorEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * @generated
     */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    /**
     * @generated
     */
    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
     * @generated
     */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof IBorderItemEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        return getContentPane();
    }

    /**
     * @generated NOT
     */
    /*
     * protected NodeFigure createNodePlate() {
     * DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
     * return result;
     * }
     */

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model
     * so you may safely remove <i>generated</i> tag and modify it.
     * 
     * @generated NOT
     */
    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new ToolbarLayout(true));
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane.
     * Respects layout one may have set for generated figure.
     * 
     * @param nodeShape instance of generated figure class
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated
     */
    public EditPart getPrimaryChildEditPart() {
        return getChildBySemanticHint(EsbVisualIDRegistry.getType(PublishEventMediatorStreamNameEditPart.VISUAL_ID));
    }

    /**
     * @generated NOT
     */
    public class PublishEventMediatorFigure extends EsbGraphicalShapeWithLabel {

        private WrappingLabel fFigurePublishEventMediatorDescriptionFigure;

        /**
         * @generated NOT
         */
        public PublishEventMediatorFigure(Color borderColor) {
            super(borderColor, false);
            this.setBackgroundColor(THIS_BACK);
            createContents();
        }

        /**
         * @generated NOT
         */
        private void createContents() {

            WrappingLabel publishEventPropertyLabel0 = new WrappingLabel();
            publishEventPropertyLabel0.setText(DEFAULT_PROPERTY_VALUE_TEXT);
            publishEventPropertyLabel0.setAlignment(SWT.CENTER);

            fFigurePublishEventMediatorDescriptionFigure = getPropertyNameLabel();
        }

        public WrappingLabel getFigurePublishEventMediatorDescriptionFigure() {
            return fFigurePublishEventMediatorDescriptionFigure;
        }

        public String getIconPath() {
            return PUBLISHEVENT_MEDIATOR_ICON_PATH;
        }

        public String getNodeName() {
            return Messages.PublishEventMediatorEditPart_NodeName;
        }

        public IFigure getToolTip() {
            if (StringUtils.isEmpty(toolTipMessage)) {
                toolTipMessage = Messages.PublishEventMediatorEditPart_ToolTipMessage;
            }
            return new CustomToolTip().getCustomToolTipShape(toolTipMessage);
        }

    }

    /**
     * @generated
     */
    static final Color THIS_BACK = new Color(null, 230, 230, 230);

}

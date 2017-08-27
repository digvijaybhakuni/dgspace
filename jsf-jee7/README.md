# JSF App

This is sample jsf app to get started with jsf 2.x

[TOC]

## JavaServer Faces Lifcycle

The JSF lifecycle is divided into two main phases:
- Execute Phase
- Render Phase

### Execute Phase
In execute phase, when first request is made, application view is built or restored. For other subsequent requests other actions are performed like request parameter values are applied, conversions and validations are performed for component values, managed beans are updated with component values and application logic is invoked.

- Restore View Phase
- Apply Request Values Phase
- Process Validations Phase
- Update Model Values Phase
- Invoke Application Phase
- Render Response Phase

#### Restore View Phase

When a client requests for a JavaServer Faces page, the JavaServer Faces implementation begins the restore view phase. In this phase, JSF builds the view of the requested page, wires event handlers and validators to components in the view and saves the view in the FacesContext instance.

If the request for the page is a postback, a view corresponding to this page already exists in the FacesContext instance. During this phase, the JavaServer Faces implementation restores the view by using the state information saved on the client or the server.

#### Apply Request Values Phase

In this phase, component tree is restored during a postback request. Component tree is a collection of form elements.Each component in the tree extracts its new value from the request parameters by using its decode (processDecodes()) method. After that value is stored locally on each component.


#### Process Validations Phase

In this phase, the JavaServer Faces processes all validators registered on the components by using its validate () method. It examines the component attributes that specify the rules for the validation and compares these rules to the local value stored for the component. The JavaServer Faces also completes conversions for input components that do not have the immediate attribute set to true.

#### Update Model Values Phase

After ensuring that the data is valid, it traverses the component tree and sets the corresponding server-side object properties to the components' local values. The JavaServer Faces implementation updates only the bean properties pointed at by an input component's value attribute. If the local data cannot be converted to the types specified by the bean properties, the lifecycle advances directly to the Render Response phase so that the page is re-rendered with errors displayed.

#### Invoke Application Phase

In this phase, JSF handles application-level events, such as submitting a form or linking to another page.

Now, if the application needs to redirect to a different web application resource or generate a response that does not contain any JSF components, it can call the FacesContext.responseComplete() method.

After that, the JavaServer Faces implementation transfers control to the Render Response phase.


#### Render Response Phase

This is last phase of JSF life cycle. In this phase, JSF builds the view and delegates authority to the appropriate resource for rendering the pages.

>- If this is an initial request, the components that are represented on the page will be added to the component tree.
>- If this is not an initial request, the components are already added to the tree and need not to be added again.
>- If the request is a postback and errors were encountered during the Apply Request Values phase, Process Validations phase, or Update Model Values phase, the original page is rendered again during this phase.
>- If the pages contain h:message or h:messages tags, any queued error messages are displayed on the page.
>- After rendering the content of the view, the state of the response is saved so that subsequent requests can access it. The saved state is available to the Restore View phase.

### Render

In this phase, the requested view is rendered as a response to the client browser. View rendering is a process in which output is generated as HTML or XHTML. So, user can see it at the browser.

The following steps are taken during the render process.

- Application is compiled, when a client makes an initial request for the index.xhtml web page.
- Application executes after compilation and a new component tree is constructed for the application and placed in a FacesContext.
- The component tree is populated with the component and the managed bean property associated with it, represented by the EL expression.
- Based on the component tree. A new view is built.
- The view is rendered to the requesting client as a response.
- The component tree is destroyed automatically.
- On subsequent requests, the component tree is rebuilt, and the saved state is applied.

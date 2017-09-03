
package org.gaurav.testmartwebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.gaurav.testmartwebservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCategory_QNAME = new QName("http://TestmartWebService.gaurav.org/", "addCategory");
    private final static QName _GetProductCategory_QNAME = new QName("http://TestmartWebService.gaurav.org/", "getProductCategory");
    private final static QName _Product_QNAME = new QName("http://TestmartWebService.gaurav.org/", "Product");
    private final static QName _AddProduct_QNAME = new QName("http://TestmartWebService.gaurav.org/", "addProduct");
    private final static QName _GetProductCategoryResponse_QNAME = new QName("http://TestmartWebService.gaurav.org/", "getProductCategoryResponse");
    private final static QName _AddCategoryResponse_QNAME = new QName("http://TestmartWebService.gaurav.org/", "addCategoryResponse");
    private final static QName _AddProductResponse_QNAME = new QName("http://TestmartWebService.gaurav.org/", "addProductResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.gaurav.testmartwebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProductCategory }
     * 
     */
    public GetProductCategory createGetProductCategory() {
        return new GetProductCategory();
    }

    /**
     * Create an instance of {@link AddCategoryResponse }
     * 
     */
    public AddCategoryResponse createAddCategoryResponse() {
        return new AddCategoryResponse();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link AddProduct }
     * 
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link AddCategory }
     * 
     */
    public AddCategory createAddCategory() {
        return new AddCategory();
    }

    /**
     * Create an instance of {@link GetProductCategoryResponse }
     * 
     */
    public GetProductCategoryResponse createGetProductCategoryResponse() {
        return new GetProductCategoryResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TestmartWebService.gaurav.org/", name = "addCategory")
    public JAXBElement<AddCategory> createAddCategory(AddCategory value) {
        return new JAXBElement<AddCategory>(_AddCategory_QNAME, AddCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TestmartWebService.gaurav.org/", name = "getProductCategory")
    public JAXBElement<GetProductCategory> createGetProductCategory(GetProductCategory value) {
        return new JAXBElement<GetProductCategory>(_GetProductCategory_QNAME, GetProductCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TestmartWebService.gaurav.org/", name = "Product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TestmartWebService.gaurav.org/", name = "addProduct")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TestmartWebService.gaurav.org/", name = "getProductCategoryResponse")
    public JAXBElement<GetProductCategoryResponse> createGetProductCategoryResponse(GetProductCategoryResponse value) {
        return new JAXBElement<GetProductCategoryResponse>(_GetProductCategoryResponse_QNAME, GetProductCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TestmartWebService.gaurav.org/", name = "addCategoryResponse")
    public JAXBElement<AddCategoryResponse> createAddCategoryResponse(AddCategoryResponse value) {
        return new JAXBElement<AddCategoryResponse>(_AddCategoryResponse_QNAME, AddCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TestmartWebService.gaurav.org/", name = "addProductResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

}

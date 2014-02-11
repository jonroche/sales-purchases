package org.jroche.persistence.model.user;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = 1539263308;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QCustomer user = new QCustomer("customer");

    public final StringPath accountType = createString("accountType");

    public final QUserBalance balance;

    public final StringPath billingAddress = createString("billingAddress");

    public final NumberPath<Integer> createadBy = createNumber("createadBy", Integer.class);

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    public final StringPath description = createString("description");

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> lastLoggedIn = createDateTime("lastLoggedIn", java.util.Date.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath mobilePhone = createString("mobilePhone");

    public final NumberPath<Integer> modifiedBy = createNumber("modifiedBy", Integer.class);

    public final DateTimePath<java.util.Date> modifiedDate = createDateTime("modifiedDate", java.util.Date.class);

    public final StringPath notes = createString("notes");

    public final StringPath officePhone = createString("officePhone");

    public final StringPath password = createString("password");

    public final SetPath<org.jroche.persistence.model.order.purchase.PurchaseOrder, org.jroche.persistence.model.order.purchase.QPurchaseOrder> purchaseOrder = this.<org.jroche.persistence.model.order.purchase.PurchaseOrder, org.jroche.persistence.model.order.purchase.QPurchaseOrder>createSet("purchaseOrder", org.jroche.persistence.model.order.purchase.PurchaseOrder.class, org.jroche.persistence.model.order.purchase.QPurchaseOrder.class);

    public final QRole role;

    public final StringPath username = createString("username");

    public final SetPath<org.jroche.persistence.model.payments.UserPayment, org.jroche.persistence.model.payments.QUserPayment> userPayments = this.<org.jroche.persistence.model.payments.UserPayment, org.jroche.persistence.model.payments.QUserPayment>createSet("userPayments", org.jroche.persistence.model.payments.UserPayment.class, org.jroche.persistence.model.payments.QUserPayment.class);

    public QCustomer(String variable) {
        this(Customer.class, forVariable(variable), INITS);
    }

    public QCustomer(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCustomer(PathMetadata<?> metadata, PathInits inits) {
        this(Customer.class, metadata, inits);
    }

    public QCustomer(Class<? extends Customer> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.balance = inits.isInitialized("balance") ? new QUserBalance(forProperty("balance"), inits.get("balance")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role"), inits.get("role")) : null;
    }

}


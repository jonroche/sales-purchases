package org.jroche.persistence.model.user;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = 1539263308;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QCompany company = new QCompany("company");

    public final StringPath companyAddress = createString("companyAddress");

    public final NumberPath<Integer> createadBy = createNumber("createadBy", Integer.class);

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    public final StringPath description = createString("description");

    public final StringPath email = createString("email");

    public final StringPath companyName = createString("companyName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> lastLoggedIn = createDateTime("lastLoggedIn", java.util.Date.class);

    public final StringPath companyPhone = createString("companyPhone");

    public final NumberPath<Integer> modifiedBy = createNumber("modifiedBy", Integer.class);

    public final DateTimePath<java.util.Date> modifiedDate = createDateTime("modifiedDate", java.util.Date.class);

    public final StringPath notes = createString("notes");

    public final StringPath password = createString("password");

    public final StringPath companyId = createString("companyId");

    public QCompany(String variable) {
        this(Company.class, forVariable(variable), INITS);
    }

    public QCompany(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCompany(PathMetadata<?> metadata, PathInits inits) {
        this(Company.class, metadata, inits);
    }

    public QCompany(Class<? extends Company> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
    }

}


package org.nkey.jpa.hibernate.branches.entities.branchable;

import com.google.common.base.Objects;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 4:42
 */
public class BranchableEntityIdType implements CompositeUserType {
    private static final String[] PROPERTY_NAMES = { "logicalId", "branchName" };
    private static final Type[] PROPERTY_TYPES = { LongType.INSTANCE, StringType.INSTANCE };
    private static final Logger LOGGER = LoggerFactory.getLogger(BranchableEntityIdType.class);

    @Override
    public Object assemble(Serializable cached, SessionImplementor session, Object owner) throws HibernateException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public Type[] getPropertyTypes() {
        return PROPERTY_TYPES;
    }

    @Override
    public Object getPropertyValue(Object component, int property) throws HibernateException {
        BranchableEntityId id = (BranchableEntityId) component;
        switch (property) {
            case 0:
                return id.getLogicalId();
            case 1:
                return id.getBranchName();
            default:
                throwUnknownPropertyIndex(property);
        }
    }

    @Override
    public void setPropertyValue(Object component, int property, Object value) throws HibernateException {
        BranchableEntityId id = (BranchableEntityId) component;
        switch (property) {
            case 0:
                id.setLogicalId((Long) value);
                break;
            case 1:
                id.setBranchName((String) value);
                break;
            default:
                throwUnknownPropertyIndex(property);
        }
    }

    private void throwUnknownPropertyIndex(int property) {
        LOGGER.error("Unknown property number {}", property);
        throw new IllegalArgumentException("Unknown property number " + property);
    }

    @Override
    public Class returnedClass() {
        return BranchableEntityId.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equal(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        if (x != null) {
            return x.hashCode();
        } else {
            return 0;
        }
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
            throws HibernateException, SQLException {

        Long logicalId = rs.getLong(0);
        String branchName = rs.getString(1);
        return logicalId == null && branchName == null ? null : new BranchableEntityId(logicalId, branchName);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
            throws HibernateException, SQLException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isMutable() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Serializable disassemble(Object value, SessionImplementor session) throws HibernateException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object replace(Object original, Object target, SessionImplementor session, Object owner)
            throws HibernateException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

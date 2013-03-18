package org.nkey.jpa.hibernate.branches.entities.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.nkey.jpa.hibernate.branches.entities.branchable.AbstractBranchableEntity;
import org.nkey.jpa.hibernate.branches.entities.branchable.BranchableEntityId;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author m.nikolaev Date: 19.03.13 Time: 0:20
 */
public class BranchableIdIdentifierGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        if (object instanceof AbstractBranchableEntity) {
            AbstractBranchableEntity entity = (AbstractBranchableEntity) object;
            BranchableEntityId id = entity.getId();
            if (id == null) {
                id = new BranchableEntityId();
            }
            if (entity.getId().getLogicalId() == null) {
                id.setLogicalId((long) getNextId(session));
            }
            return id;
        }
        return null;
    }

    private int getNextId(SessionImplementor session) {
        Connection connection = session.connection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    String.format("SELECT nextval ('%s') as nextval", GeneratorDeclareEntity.ID_GENERATOR_SEQUENCE));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("nextval");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException("Can't get id from sequence");
    }
}

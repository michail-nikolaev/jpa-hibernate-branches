package org.nkey.jpa.hibernate.branches.entities.branchable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.FieldBridge;
import org.nkey.jpa.hibernate.branches.entities.IdentifiableEntity;
import org.nkey.jpa.hibernate.branches.entities.generator.BranchableEntityIdBridge;
import org.nkey.jpa.hibernate.branches.entities.generator.GeneratorDeclareEntity;

import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * @author m.nikolaev Date: 15.03.13 Time: 2:17
 */
@MappedSuperclass
public class AbstractBranchableEntity implements IdentifiableEntity<BranchableEntityId> {
    
    public static final String GENERATOR_NAME = "seq_id";
    
    @GenericGenerator(name = GENERATOR_NAME, strategy = GeneratorDeclareEntity.GENERATOR_CLASS) 
    @GeneratedValue(generator = GENERATOR_NAME) 
    @EmbeddedId
    @DocumentId(name = "id") 
    @FieldBridge(impl = BranchableEntityIdBridge.class)
    private BranchableEntityId id = new BranchableEntityId();

    @Version
    private Long version;

    @Override
    public BranchableEntityId getId() {
        return id;
    }

    public void setId(BranchableEntityId id) {
        this.id = id;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Transient
    public String getEntityBranchName() {
        return id == null ? null : id.getBranchName();
    }

    public Long getEntityLogicalId() {
        return id == null ? null : id.getLogicalId();
    }

}

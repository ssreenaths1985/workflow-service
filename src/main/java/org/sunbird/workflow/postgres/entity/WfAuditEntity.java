package org.sunbird.workflow.postgres.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "wf_audit", schema = "wingspan")
public class WfAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "wf_id")
    private String wfId;

    @Column(name = "update_field_values")
    private String updateFieldValues;

    @Column(name = "in_workflow")
    private boolean inWorkflow;

    @Column(name = "rootOrg")
    private String rootOrg;

    @Column(name = "userId")
    private String userId;

    @Column(name = "application_id")
    private String applicationId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "comment")
    private String comment;

    @Column(name = "state")
    private String state;

    @Column(name = "action")
    private String action;

    @Column(name = "actor_uuid")
    private String actorUUID;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    
    @Column(name = "dept_name")
    private String deptName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRootOrg() {
        return rootOrg;
    }

    public void setRootOrg(String rootOrg) {
        this.rootOrg = rootOrg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getActorUUID() {
        return actorUUID;
    }

    public void setActorUUID(String actorUUID) {
        this.actorUUID = actorUUID;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getUpdateFieldValues() {
        return updateFieldValues;
    }

    public void setUpdateFieldValues(String updateFieldValues) {
        this.updateFieldValues = updateFieldValues;
    }

    public boolean isInWorkflow() {
        return inWorkflow;
    }

    public void setInWorkflow(boolean inWorkflow) {
        this.inWorkflow = inWorkflow;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}

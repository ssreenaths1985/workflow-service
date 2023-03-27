package org.sunbird.workflow.models.cassandra;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@PrimaryKeyClass
public class WfPrimaryKey implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @PrimaryKeyColumn(name = "root_org", type = PrimaryKeyType.PARTITIONED)
    private String rootOrg;

    @PrimaryKeyColumn(name = "org")
    private String org;

    @PrimaryKeyColumn(name = "service")
    private String service;

    public String getRootOrg() {
        return rootOrg;
    }

    public void setRootOrg(String rootOrg) {
        this.rootOrg = rootOrg;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public WfPrimaryKey() {
        super();
    }

    public WfPrimaryKey(String rootOrg, String org, String service) {
        super();
        this.rootOrg = rootOrg;
        this.org = org;
        this.service = service;
    }
}

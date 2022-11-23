package com.py.assignment.runner.mysql.connector;

import javax.ws.rs.Produces;

import com.mysql.cj.xdevapi.Client;
import com.mysql.cj.xdevapi.ClientFactory;
import com.mysql.cj.xdevapi.Collection;
import com.mysql.cj.xdevapi.Schema;
import com.mysql.cj.xdevapi.Session;

public class Connection {

	private Client client;
	private Session session;
	private Schema schema;
	
	private String getPoolConfig() {
		return "{\"pooling\":{\"enabled\":false, \"maxSize\":8, \"maxIdleTime\":30000, \"queueTimeout\":10000} }";
	}
	
	private Client getClient() {
		this.client = new ClientFactory().getClient("mysqlx://localhost:33060/audit?user=root&password=root", getPoolConfig());
		return this.client;
	}
	
	private Session getSession() {
		return this.session = getClient().getSession();
	}
	
	private Schema getSchema(String schemaName) {
		return this.schema = getSession().createSchema(schemaName, true);
	}
	
	public Collection getConnection(String collName) {
		return getSchema("audit").createCollection(collName, true);
	}
	
	public void closeCLient() {
		this.session.commit();
		this.session.close();
		this.client.close();
	}
}

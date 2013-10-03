package com.esri.ges.processor.defense;

import java.util.HashMap;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.core.property.PropertyException;
import com.esri.ges.manager.datastore.agsconnection.ArcGISServerConnectionManager;
import com.esri.ges.manager.geoeventdefinition.GeoEventDefinitionManager;
import com.esri.ges.messaging.Messaging;
import com.esri.ges.processor.GeoEventProcessor;
import com.esri.ges.processor.GeoEventProcessorEvent;
import com.esri.ges.processor.GeoEventProcessorEventAction;
import com.esri.ges.processor.GeoEventProcessorServiceBase;
import com.esri.ges.spatial.Spatial;

public class QueryReportProcessorService extends GeoEventProcessorServiceBase {
	public Spatial spatial;
	public GeoEventDefinitionManager manager;
	public ArcGISServerConnectionManager connectionManager;
	public Messaging messaging;
	public QueryReportProcessorService() {
		definition = new QueryReportProcessorDefinition();
	}

	@Override
	public GeoEventProcessor create() throws ComponentException {
		return new QueryReportProcessor(definition, spatial, manager, connectionManager, messaging);
	}
	
	public void setSpatial(Spatial s)
	{
		spatial = s;
	}
	
	public void setManager(GeoEventDefinitionManager m)
	{
		manager = m;
	}
	
	public void setConnectionManager(ArcGISServerConnectionManager cm)
	{
		connectionManager = cm;
	}
	
	public void setMessaging(Messaging m)
	{
		messaging = m;
	}
	public void start() throws PropertyException{
		
		QueryReportProcessorDefinition qDef = (QueryReportProcessorDefinition)definition;
		HashMap<String, String> fieldMap = new HashMap<String, String>();	qDef.setManager(manager);
		qDef.setConnectionManager(connectionManager);
	}

}
package com.google.cacheserver;

import javax.naming.OperationNotSupportedException;

import com.google.cacheserver.Operations.OPCODE;

public class Utils {

	/**
	 * Public static factories
	 * @throws OperationNotSupportedException 
	 */
	public static Serializer newSerializerFactory(String type) throws OperationNotSupportedException{
		if(type.equalsIgnoreCase("Type:BASIC")){
			return new BasicSerializer();
		}else {
			throw new OperationNotSupportedException();
		}
	}
	
	public static OPCODE newOperationsFactory(String op) throws OperationNotSupportedException{
		if(op.equalsIgnoreCase("OP:PUT")){
			return Operations.OPCODE.PUT;
		}else if(op.equalsIgnoreCase("OP:GET")){
			return Operations.OPCODE.GET;
		}else{
			throw new OperationNotSupportedException();
		}
	}
}

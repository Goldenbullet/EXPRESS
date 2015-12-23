package express.data.strategyData;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import express.data.IOHelper.IOHelper;
import express.dataService.strategyDataService.DistanceDataService;
import express.po.CityDistancePO;

public class DistanceIO extends UnicastRemoteObject implements DistanceDataService{

	String filename="SerializableData/Distance.ser";
	ArrayList<CityDistancePO> distanceStartegyList;
	
	public DistanceIO() throws RemoteException {
		super();
		IOHelper io=new IOHelper();
		distanceStartegyList=new ArrayList<CityDistancePO>();
		try {
			distanceStartegyList=(ArrayList<CityDistancePO>)io.readFromDisk(filename);
		} catch (ClassNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}

	@Override
	public boolean addDistanceStrategy(CityDistancePO po) throws RemoteException {
		distanceStartegyList.add(po);
		return true;
	}

	@Override
	public boolean deleteDistanceStrategy(String id) throws RemoteException {
		if(distanceStartegyList.size()>0){
			for(CityDistancePO distance:distanceStartegyList){
				if(distance.getID().equals(id)){
					distanceStartegyList.remove(distance);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean changeDistanceStrategy(CityDistancePO po, String id) throws RemoteException {
		if(distanceStartegyList.size()>0){
			int index=0;
			for(CityDistancePO distance:distanceStartegyList){
				if(distance.getID().equals(id)){
					distanceStartegyList.set(index, distance);
					return true;
				}
				index++;
			}
		}
		return false;
	}

	@Override
	public ArrayList<CityDistancePO> getAllDistanceStrategy() throws RemoteException {
		if(distanceStartegyList.size()>0)
			return distanceStartegyList;
		else
			return null;
	}

	@Override
	public boolean writeAllDistanceStrategy() throws RemoteException {
		IOHelper io=new IOHelper();
		try {
			io.writeToDisk(filename, distanceStartegyList);
			return true;
		} catch (IOException e) {
			
			return false;
		}
	}


}

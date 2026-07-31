package service;

import java.util.ArrayList;
import java.util.List;
import data.CustomerFileService;
import model.Custemer;

public class CustemerService {
	private ArrayList<Custemer> custemers=new ArrayList<>();	
	
	private CustomerFileService fileService;

	public CustemerService() {

	    custemers = new ArrayList<>();

	    fileService = new CustomerFileService();

	    fileService.loadCustomers(custemers);
	}
	
	public void addCustomer(int id,String name,String email,Long phoneNo) {
		if(searchCustemerById(id)!=null){
			System.out.println("Custemer is Already Exists..");
			return;
		}
		Custemer custemer =new Custemer(id,name,email,phoneNo);
		custemers.add(custemer);	
		fileService.saveCustomers(custemers);
		System.out.println("Custemer Added Successfully");
	}
	public Custemer searchCustemerById(int id) {
		for(Custemer c:custemers) {
			if(c.getCustomerId()==id) {
				return c;
			}
		}
		return null;
	}
	public List<Custemer> viewAllCustemers(){
		return custemers;
	}
	
}
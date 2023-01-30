package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("FIRST TEST: INSERTING ID");
		Department newDep = new Department(null, "Homemades");
		depDao.insert(newDep);
		System.out.println("New department created!");
		System.out.println("--------------");
		
		
		
		System.out.println("SECOND TEST: FIND BY ID");
		newDep = depDao.findById(2);
		System.out.println(newDep);
		System.out.println("--------------");
		
		
		System.out.println("THIRD TEST: FIND ALL");
		List<Department>list = depDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		System.out.println("--------------");
		
		
		
		System.out.println("FOURTH TEST: UPDATE");
		newDep = depDao.findById(2);
		newDep.setName("Design");
		depDao.update(newDep);
		System.out.println("Update completed!");
		System.out.println("--------------");
		
		System.out.println("FIFTH TEST: DELETING ID");
		System.out.print("Enter a id for delete test: ");
		int i = sc.nextInt();
		depDao.deleteById(i);
		
		
		sc.close();
		
		
		

	}

}

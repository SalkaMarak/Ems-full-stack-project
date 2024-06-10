import React, {useEffect, useState} from 'react'
import { deleteEmployee, listEmployees } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([]) //array

    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployees()
    },[]) 

    function getAllEmployees(){
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    }
    function addNewEmployee(){
        navigator("/add-employee");
    }
    function updateEmployee(id){
        navigator(`/edit-employee/${id}`);
    }
    function removeEmployee(id){
        console.log(id);

        deleteEmployee(id).then((response) => {
            getAllEmployees();
        }).catch(error => {
            console.error(error);
        })
    }

  return (
      <div className="container">
        <h1 className="text-center">List of Employees</h1>
        <button className="btn btn-primary mb-2" onClick={addNewEmployee}>Add employee</button>
        <table className="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email Id</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {   //employees state variable which holds the response of api
                    employees.map(employee => 
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update</button> <span>&nbsp;</span>
                                <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)}>Delete</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>

      </div>
  )
}

export default ListEmployeeComponent



//rfce -react functional component export (snippet)
//rafce -react arrow functn comp export

//useState hook allows us the use state variables in a functional components.
//in order to hold the response of the restapi we have to use functional components.  we use -> usestate hook
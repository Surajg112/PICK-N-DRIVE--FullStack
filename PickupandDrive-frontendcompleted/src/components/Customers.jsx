import axios from "axios";
import { useEffect, useState } from "react";
import AdminNav from "./Adminnav"

const Customers=()=>{
    const [data,setData]=useState([])
    useEffect(()=>{
        axios.get("http://localhost:8080/api/customers")
        .then(resp=>{
            console.log(resp.data)
            setData(resp.data)
        })
    },[])
    return(
        <>
        <div className="container-fluid">
            <div className="row">
                <div className="col-sm-2 bg-transparent p-0 border-right border-primary" style={{height:"calc(100vh - 80px)"}}>
                    <AdminNav />
                </div>
                <div className="col-sm-10">
                    <h4 className="p-2 mb-2 border-bottom border-success">Registers List</h4>
                     <table className="table table-bordered">
                        <thead className="table-light">
                            <tr>
                                <th>Sr.No</th>
                                <th>User Id</th>
                                <th>Customer name</th>
                                <th>Gender</th>
                                <th>Address</th>
                                <th>Phone</th>
                                <th>License</th>
                                                             
                            </tr>
                        </thead>
                        <tbody>
                    {data.map((x,index)=>(
                    <tr key={index}>   
                        <td>{index+1}</td>                     
                        <td>{x.userid}</td>
                        <td>{x.uname}</td>
                        <td>{x.gender}</td>
                        <td>{x.address}</td>                                                        
                        <td>{x.phone}</td>                                                        
                        <td>{x.license}</td>                                                      
                    </tr>
                ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        </>
    )
}

export default Customers;
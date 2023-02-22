import axios from "axios"
import { useEffect, useState } from "react"
import AdminNav from "./Adminnav"

export default function Reports(){
    const [data,setData]=useState([])
    useEffect(()=>{
        axios.get('http://localhost:8080/api/bookings/payments')
        .then(resp=>{
            setData(resp.data)
        })
    },[])
    return (
        <>
        <div className="container-fluid">
            <div className="row">
                <div className="col-sm-2 bg-transparent p-0 border-right border-primary" style={{height:"calc(100vh - 80px)"}}>
                    <AdminNav />
                </div>
                <div className="col-sm-10">
                <div>
                <h4 className="p-2" style={{borderBottom: '2px solid green'}}>Payment Reports</h4>
                <table className="table table-bordered table-sm mt-2">
                    <thead>
                    <tr>
                        <th>Payment ID</th>
                        <th>Payment Date</th>
                        <th>Booking Id</th>
                        <th>Customer Name</th>
                        <th>Remarks</th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    {data.map(x=>(
                    <tr key={x.id}>
                        <td>{x.id}</td>
                        <td>{x.pmtdate}</td>
                        <td>{x.booking.id}</td>
                        <td>{x.booking.customer.uname}</td>
                        <td>{x.remarks}</td>
                        <td>₹ {x.amount}</td>
                    </tr>
                    ))}
                    </tbody>
                </table>
                </div>

                </div>
            </div>
        </div>
        </>
    )
}
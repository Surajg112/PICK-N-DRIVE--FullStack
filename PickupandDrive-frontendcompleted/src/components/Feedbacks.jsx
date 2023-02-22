import axios from "axios"
import { useEffect, useState } from "react"
import { Rating } from "react-simple-star-rating"
import AdminNav from "./Adminnav"
import moment from "moment"

export default function Feedbacks(){
    const [data,setData]=useState([])
    useEffect(()=>{
        axios.get('http://localhost:8080/api/bookings/feedbacks')
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
                    <h4 className="p-2" style={{borderBottom: '2px solid green'}}>Feedbacks</h4>
                    <table className="table table-bordered table-sm">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Customer Name</th>
                            <th>Feedback</th>
                            <th>Ratings</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>
                            {data.map(x=>(
                        <tr key={x.id}>
                            <td>{x.id}</td>
                            <td>{x.customer.uname}</td>
                            <td>{x.descr}</td>
                            <td>
                            <Rating initialValue={x.ratings} readonly={true} size={22} />                           
                            </td>
                            <td>{moment(x.createdon).format('d-MMM-yyyy')}</td>
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
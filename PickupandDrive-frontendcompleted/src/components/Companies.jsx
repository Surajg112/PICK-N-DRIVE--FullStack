import axios from "axios"
import { useEffect, useState } from "react"
import { toast } from "react-toastify"
import AdminNav from "./Adminnav"

const Companies=()=>{ 
    const [data,setData]=useState([])
    const [company,setCompany]=useState('')
    useEffect(()=>{
        loadData()
    },[])
    const loadData=()=>{
        axios.get("http://localhost:8080/api/companies")
        .then(resp=>{
            console.log(resp.data)
            setData(resp.data)
        })
    }
    const handleDelete=(id)=>{
        const result=window.confirm('Are you sure to delete this company ?')
        if(result){
            axios.delete('http://localhost:8080/api/companies/'+id)
            .then(resp=>{
                toast.success(resp.data)
                loadData()
            })
        }
    }

    const handleSubmit=(e)=>{
        e.preventDefault()
        axios.post('http://localhost:8080/api/companies',{compname:company})
        .then(resp=>{
            setCompany('')
            toast.success(resp.data)
            loadData()
        })
        .catch(error=>{
            toast.error(error)
        })
    }
    
    return(
        <>
        <div className="container-fluid">
            <div className="row">
                <div className="col-sm-2 bg-transparent p-0 border-right border-primary" style={{height:"calc(100vh - 80px)"}}>
                    <AdminNav />
                </div>
                <div className="col-sm-10">
                    <h4 className="p-2 mb-3 border-bottom border-success">Companies</h4>
                    <div className="row">
                        <div className="col-sm-8">
                            <table className="table table-bordered table-sm">
                            <thead>
                                <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {data.map((x,index)=>(
                                <tr key={index}>
                                <td>{x.id}</td>
                                <td>{x.compname}</td>
                                <td>
                                    <a onClick={(e)=>handleDelete(x.id)} href="#" className="btn btn-outline-danger btn-sm"><i className="fa fa-trash" />Delete</a>                        
                                </td>
                                </tr>
                                ))}
                            </tbody>
                            </table>
                        </div>
                        <div className="col-sm-4">
                            <form method="post" encType="multipart/form-data" action="savecat.php">
                            <div className="form-group">
                                <label>Company Name</label>
                                <input type="text" value={company} onChange={(e)=>setCompany(e.target.value)} className="form-control" name="compname" />
                            </div>
                            <input type="submit" onClick={handleSubmit} className="btn btn-primary btn-sm" defaultValue="Save Company" />
                            </form>        
                        </div>
                        </div>

                    </div>
                </div>
            </div>
        </>
    )
}

export default Companies;
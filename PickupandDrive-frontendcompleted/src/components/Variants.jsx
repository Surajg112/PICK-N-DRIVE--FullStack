import axios from "axios"
import { useEffect, useState } from "react"
import { toast } from "react-toastify"
import AdminNav from "./Adminnav"

const Variants=()=>{
    const [data,setData]=useState([])
    const [company,setCompany]=useState([])
    const [selectedPhoto,setSelectedPhoto]=useState(null)
    const [file,setFile]=useState(null)
    const [product,setProduct]=useState({
        "title":"",
        "company_id":"",
        "price":""        
    })
    useEffect(()=>{
        loadData()
        axios.get("http://localhost:8080/api/companies")
        .then(resp=>{
            console.log(resp.data)
            setCompany(resp.data)
        })
    },[])
    const loadData=()=>{
        axios.get("http://localhost:8080/api/variants")
        .then(resp=>{
            console.log(resp.data)
            setData(resp.data)
        })
    }
    const handleInput=e=>{
        setProduct({...product,[e.target.name]:e.target.value})
    }

    const handleFileInput=e=>{
        setSelectedPhoto(e.target.files[0])
        setFile(URL.createObjectURL(e.target.files[0]))
    }

    const handleDelete=(id)=>{
        const result=window.confirm('Are you sure to delete this variant ?')
        if(result){
            axios.delete('http://localhost:8080/api/variants/'+id)
            .then(resp=>{
                toast.success(resp.data)
                loadData()
            })
        }
    }

    const handleSubmit=(e)=>{
        e.preventDefault()
        const formData=new FormData()
        formData.append("photo",selectedPhoto)
        formData.append("title",product.title)
        formData.append("company_id",product.company_id)
        formData.append("price",product.price)
        console.log(product)
        axios.post("/api/books",formData)
        axios.post('http://localhost:8080/api/variants',formData)
        .then(resp=>{
            toast.success(resp.data)
            setProduct({
                "title":"",
                "company_id":"",
                "price":"",
                "photo":""        
            })
            setSelectedPhoto(null)
            setFile(null)
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
                    <h5 className="p-2 mb-3" style={{borderBottom: '2px solid green'}}>Available Bike Variants</h5>
                        <div className="row">
                            <div className="col-sm-8">
                                
                                <table className="table table-bordered table-sm">
                                <thead>
                                    <tr>
                                    <th>Variant ID</th>
                                    <th>Variant Name</th>
                                    <th>Company</th>
                                    <th>Rental</th>
                                    <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {data.map((x,index)=>(
                                        <tr key={index}>
                                            <td>{x.id}</td>
                                            <td><img src={'http://localhost:8080/'+x.photo} style={{width:"100px"}}/> {x.title}</td>
                                            <td>{x.company.compname}</td>
                                            <td>{x.price} per day</td>
                                            <td><button onClick={(e)=>handleDelete(x.id)} className="btn btn-danger btn-sm">Delete</button></td>
                                        </tr>
                                    ))}
                                </tbody>
                                </table>
                            </div>
                            <div className="col-sm-4">
                                <h5 className="p-2">Add/Update Variant</h5>
                                <form method="post">
                                <div className="form-group">
                                    <label>Car Name *</label>
                                    <input type="text" name="title" value={product.title} onChange={handleInput} required className="form-control" />
                                </div>
                                <div className="form-group">
                                    <label>Company *</label>
                                    <select name="company_id" value={product.company_id} onChange={handleInput} required className="form-control">
                                    <option value>Select Company</option> 
                                    {company.map(x=>(
                                        <>
                                        <option value={x.id}>{x.compname}</option>
                                        </>
                                    ))}         
                                    </select>
                                </div>
                                <div className="form-group">
                                    <label>Price per day</label>
                                    <input type="text"  value={product.price} onChange={handleInput} name="price" defaultValue className="form-control" />
                                </div>
                                {selectedPhoto ? <img className="img-thumbnail float-right"  style={{height: 100, width: 100}} src={file} alt="Photo" /> : ""}
                                <div className="form-group">
                                    <label>Photo</label>
                                    <input type="file" id="photo" name="photo" value={product.photo} onChange={handleFileInput}  accept=".jpg,.png" className="form-control-file" />
                                </div>
                                <button onClick={handleSubmit} className="btn btn-primary btn-sm ml-2 float-right">Save Variant</button>
                                <a href="/variants" className="btn btn-danger btn-sm float-right">Cancel</a>
                                </form>
                            </div>
                            </div>

                </div>
                </div>
            </div>
        </>
    )
}

export default Variants;
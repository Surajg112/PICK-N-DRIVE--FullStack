import { Link,useHistory } from "react-router-dom";
import { useDispatch } from "react-redux"

const AdminNav = ()=>{
    const dispatch=useDispatch()
    const history=useHistory()
    const logout=e=>{
        dispatch({type:'LogOut'})
        sessionStorage.clear();
        history.push("/");
    }
    return(
        <>
        <div className="list-group list-group-flush">
        <Link to="/dashboard" className="list-group-item list-group-item-action p-2 text-left">Dashboard</Link>
        <Link to="/companies" className="list-group-item list-group-item-action p-2 text-left">Companies</Link>
        <Link to="/variants" className="list-group-item list-group-item-action p-2 text-left">Variants</Link>   
        <Link to="/cars" className="list-group-item list-group-item-action p-2 text-left">Cars</Link>   
        <Link to="/customers" className="list-group-item list-group-item-action p-2 text-left">Customers</Link>   
        <Link to="/bookings" className="list-group-item list-group-item-action p-2 text-left">Bookings</Link>   
        <Link to="/feedbacks" className="list-group-item list-group-item-action p-2 text-left">Feedbacks</Link>   
        <Link to="/reports" className="list-group-item list-group-item-action p-2 text-left">Reports</Link>   
        <Link className="list-group-item list-group-item-action p-2 text-left" onClick={logout} to="#">Logout</Link>  
        </div>
        </>
    )
}

export default AdminNav;
import { useSelector,useDispatch } from "react-redux";
import { Link,useHistory } from "react-router-dom";

const { Fragment } = require("react");

function NavBar(){
  const dispatch=useDispatch()
  const history=useHistory()
    const logout=e=>{
        dispatch({type:'LogOut'})
        sessionStorage.clear();
        history.push("/");
    }
    const state=useSelector((state)=>state);
    console.log("LoggedIn ",state.loggedin)
    const isadmin=state.loggedin && sessionStorage.getItem("role")==="Admin" ?true:false;
    return (
        <Fragment>
          {isadmin ? (<>
          </>) : (
            <header>
            <nav className="navbar navbar-expand-lg">
              <div className="container">
                <Link className="navbar-brand" to="/"><h2><em>Pickup</em>-N-<em>Drive</em></h2></Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                  <span className="navbar-toggler-icon" />
                </button>
                <div className="collapse navbar-collapse" id="navbarResponsive">
                  <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                      <Link className="nav-link" to="/">Home</Link>
                    </li>
                    <li className="nav-item"><Link className="nav-link" to="/products">Cars</Link></li>
                    {sessionStorage.getItem("userid")!=null && sessionStorage.getItem("role")==="Customer" ? (<>
                      <li className="nav-item"><Link className="nav-link" to="/mybookings">My Bookings</Link></li>
                    <li className="nav-item"><Link className="nav-link" to="/">Hi {sessionStorage.getItem("uname") }</Link></li>

                    <li className="nav-item"><Link className="nav-link" onClick={logout} to="#">Logout</Link></li>
                    </>
                    ) : (
                        <>
                      <li className="nav-item"><Link className="nav-link" to="/about">About Us</Link></li>
                    <li className="nav-item"><Link className="nav-link" to="/contact">Contact Us</Link></li>
                    <li className="nav-item"><Link className="nav-link" to="/register">Register</Link></li>
                    <li className="nav-item"><Link className="nav-link" to="/login">Login</Link></li>                    
                    </>
                    )}
                  </ul>
                </div>
              </div>
            </nav>
          </header>
        )}
        </Fragment>
    )
}

export default NavBar;
